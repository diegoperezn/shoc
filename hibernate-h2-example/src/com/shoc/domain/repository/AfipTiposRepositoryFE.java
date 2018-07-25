/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.afip.wsmtxca.ConsultarPuntosVentaRequestType;
import com.shoc.afip.wsmtxca.ExceptionFaultMsg;
import com.shoc.afip.wsmtxca.ResultadoSimpleType;
import com.shoc.afip.authen.AfipAuthentification;
import com.shoc.afip.authen.AfipAuthentificationService;
import com.shoc.afip.shoc.IPuntoDeVenta;
import com.shoc.afip.wsve.FEAuthRequest;
import com.shoc.afip.wsve.FECAERequest;
import com.shoc.afip.wsve.FECAEResponse;
import com.shoc.afip.wsve.FERecuperaLastCbteResponse;
import com.shoc.afip.wsve.Service;
import com.shoc.afip.wsve.ServiceSoap;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.service.PropiedadService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author diego
 */
public class AfipTiposRepositoryFE {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AfipTiposRepositoryFE.class);

    private static AfipTiposRepositoryFE instance;

    public static AfipTiposRepositoryFE getInstance() {
        if (instance == null) {
            instance = new AfipTiposRepositoryFE();
        }

        return instance;
    }

    public AfipTiposRepositoryFE() {
        setPort();
    }

    private static ServiceSoap port;

    private PropiedadService pService = PropiedadService.getInstance();

    private void setPort() {
        if (port == null) {
            Service factory = new Service();
            port = factory.getServiceSoap();

            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://wswhomo.afip.gov.ar/wsfev1/service.asmx");
//            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://servicios1.afip.gov.ar/wsfev1/service.asmx");
        }
    }

//    public List<CodigoDescripcionType> listarTiposFactura(SociedadEnum sociedad) throws IOException {
//        AuthRequestType auth = buildAuth(sociedad);
//        ConsultarTiposComprobanteRequestType parameters
//                = new ConsultarTiposComprobanteRequestType();
//        parameters.setAuthRequest(auth);
//
//        try {
//            return port.consultarTiposComprobante(parameters).getArrayTiposComprobante().getCodigoDescripcion();
//        } catch (ExceptionFaultMsg ex) {
//            Logger.getLogger(AfipTiposRepositoryFE.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return new ArrayList<>();
//    }
    private FEAuthRequest buildAuth(SociedadEnum sociedad) throws IOException {
        FEAuthRequest authResponse = new FEAuthRequest();

        String servicio = "wsfe";

        logger.info("Autentificando con Afip afip servicio " + servicio);
        try {
            Date expirationDateToken = null;
            String expiration = pService.getPropertyValue("shoc.afip.auth.expiration." + servicio);
            if (!"".equals(expiration)) {
                expirationDateToken = new Date(Long.valueOf(expiration));
            }

            String token;
            String sign;

            if (expirationDateToken == null || expirationDateToken.before(new Date())) {
                AfipAuthentification auth = AfipAuthentificationService.autentificarAfip(sociedad, servicio);

                token = auth.getToken();
                sign = auth.getSign();

                if (sign != null && token != null) {
                
                    pService.update("shoc.afip.auth.expiration." + servicio, String.valueOf(new Date().getTime() + 28800000));
                    pService.update("shoc.afip.auth.token." + servicio, token);
                    pService.update("shoc.afip.auth.sign." + servicio, sign);
                }

            } else {
                token = pService.getPropertyValue("shoc.afip.auth.token." + servicio);
                sign = pService.getPropertyValue("shoc.afip.auth.sign." + servicio);
            }

            authResponse.setToken(token);
            authResponse.setSign(sign);
            authResponse.setCuit(Long.valueOf(sociedad.getCuit()));
        } catch (Exception e) {
            logger.error("Error tratando de generar autentificacion", e);
        }
        return authResponse;
    }

    public List<IPuntoDeVenta> listarPuntoVenta(SociedadEnum sociedad) throws IOException {
        List<IPuntoDeVenta> result = new ArrayList<>();

        FEAuthRequest auth = buildAuth(sociedad);
        ConsultarPuntosVentaRequestType parameters
                = new ConsultarPuntosVentaRequestType();

        try {
            result.addAll(port.feParamGetPtosVenta(auth).getResultGet().getPtoVenta());
        } catch (Exception ex) {
            Logger.getLogger(AfipTiposRepositoryFE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public FECAEResponse enviarFactura(SociedadEnum sociedadEnum, FECAERequest comprobante)
            throws IOException, ExceptionFaultMsg, AfipException {

        FEAuthRequest auth = buildAuth(sociedadEnum);

        FECAEResponse response = port.fecaeSolicitar(auth, comprobante);

        if (response.getFeCabResp().getResultado().equals(ResultadoSimpleType.R.value())
                || response.getFeDetResp().getFECAEDetResponse().get(0).getResultado().equals(ResultadoSimpleType.R.value())) {
            if (response.getErrors() != null) {
                throw new AfipException(response.getErrors().getErr()
                        .parallelStream().map(e -> e.getMsg()).collect(Collectors.toList()));
            } else {
                throw new AfipException(response.getFeDetResp().getFECAEDetResponse().get(0).getObservaciones().getObs()
                        .parallelStream().map(e -> e.getMsg()).collect(Collectors.toList()));
            }
        }

        return response;
    }

    public int consultarUltimoComprobante(SociedadEnum sociedadEnum, short codigoTipoComprobante, short numeroPuntoVenta) throws ExceptionFaultMsg, IOException {
        FEAuthRequest auth = buildAuth(sociedadEnum);

        FERecuperaLastCbteResponse response = port.feCompUltimoAutorizado(auth, numeroPuntoVenta, codigoTipoComprobante);

        return response.getCbteNro();
    }

}
