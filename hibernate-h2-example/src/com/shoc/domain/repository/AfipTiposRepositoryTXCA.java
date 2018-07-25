/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.afip.wsmtxca.AuthRequestType;
import com.shoc.afip.wsmtxca.AutorizarComprobanteRequestType;
import com.shoc.afip.wsmtxca.AutorizarComprobanteResponseType;
import com.shoc.afip.wsmtxca.CodigoDescripcionType;
import com.shoc.afip.wsmtxca.ComprobanteCAEResponseType;
import com.shoc.afip.wsmtxca.ComprobanteType;
import com.shoc.afip.wsmtxca.ConsultaUltimoComprobanteAutorizadoRequestType;
import com.shoc.afip.wsmtxca.ConsultarPuntosVentaRequestType;
import com.shoc.afip.wsmtxca.ConsultarTiposComprobanteRequestType;
import com.shoc.afip.wsmtxca.ConsultarUltimoComprobanteAutorizadoRequestType;
import com.shoc.afip.wsmtxca.ConsultarUltimoComprobanteAutorizadoResponseType;
import com.shoc.afip.wsmtxca.ExceptionFaultMsg;
import com.shoc.afip.wsmtxca.MTXCAService;
import com.shoc.afip.wsmtxca.MTXCAServicePortType;
import com.shoc.afip.wsmtxca.PuntoVentaType;
import com.shoc.afip.wsmtxca.ResultadoSimpleType;
import com.shoc.afip.authen.AfipAuthentification;
import com.shoc.afip.authen.AfipAuthentificationService;
import com.shoc.afip.shoc.IPuntoDeVenta;
import com.shoc.domain.SociedadEnum;
import static com.shoc.domain.repository.AfipTiposRepositoryFE.logger;
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
public class AfipTiposRepositoryTXCA {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AfipTiposRepositoryFE.class);

    private static AfipTiposRepositoryTXCA instance;

    public static AfipTiposRepositoryTXCA getInstance() {
        if (instance == null) {
            instance = new AfipTiposRepositoryTXCA();
        }

        return instance;
    }

    public AfipTiposRepositoryTXCA() {
        setPort();
    }

    private static MTXCAServicePortType port;

    private PropiedadService pService = PropiedadService.getInstance();

    private void setPort() {
        if (port == null) {
            MTXCAService factory = new MTXCAService();
            port = factory.getMTXCAServiceHttpSoap11Endpoint();

            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService");
//            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://serviciosjava.afip.gob.ar/wsmtxca/services/MTXCAService");
        }
    }

    public List<CodigoDescripcionType> listarTiposFactura(SociedadEnum sociedad) throws IOException {
        AuthRequestType auth = buildAuth(sociedad);
        ConsultarTiposComprobanteRequestType parameters
                = new ConsultarTiposComprobanteRequestType();
        parameters.setAuthRequest(auth);

        try {
            return port.consultarTiposComprobante(parameters).getArrayTiposComprobante().getCodigoDescripcion();
        } catch (ExceptionFaultMsg ex) {
            Logger.getLogger(AfipTiposRepositoryTXCA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }

    private AuthRequestType buildAuth(SociedadEnum sociedad) throws IOException {
        AuthRequestType authResponse = new AuthRequestType();

        String servicio = "wsmtxca";

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

                pService.update("shoc.afip.auth.expiration." + servicio, String.valueOf(new Date().getTime() + 28800000));
                pService.update("shoc.afip.auth.token." + servicio, token);
                pService.update("shoc.afip.auth.sign." + servicio, sign);

            } else {
                token = pService.getPropertyValue("shoc.afip.auth.token." + servicio);
                sign = pService.getPropertyValue("shoc.afip.auth.sign." + servicio);
            }

            authResponse.setToken(token);
            authResponse.setSign(sign);
            authResponse.setCuitRepresentada(Long.valueOf(sociedad.getCuit()));

        } catch (Exception e) {
            logger.error("Error tratando de generar autentificacion", e);
        }
        
        logger.info("Autentificando con Afip afip servicio: " + authResponse.toString());

        return authResponse;
    }

    public List<IPuntoDeVenta> listarPuntoVenta(SociedadEnum sociedad) throws IOException {
        List<IPuntoDeVenta> result = new ArrayList<>();

        AuthRequestType auth = buildAuth(sociedad);
        ConsultarPuntosVentaRequestType parameters
                = new ConsultarPuntosVentaRequestType();
        parameters.setAuthRequest(auth);

        try {
            result.addAll(port.consultarPuntosVenta(parameters).getArrayPuntosVenta().getPuntoVenta());
        } catch (ExceptionFaultMsg ex) {
            Logger.getLogger(AfipTiposRepositoryTXCA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public ComprobanteCAEResponseType enviarFactura(SociedadEnum sociedadEnum, ComprobanteType comprobante)
            throws IOException, ExceptionFaultMsg, AfipException {
        AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();
        parameters.setAuthRequest(buildAuth(sociedadEnum));
        parameters.setComprobanteCAERequest(comprobante);

        AutorizarComprobanteResponseType response = port.autorizarComprobante(parameters);

        if (response.getResultado().equals(ResultadoSimpleType.R)) {
            throw new AfipException(response.getArrayErrores().getCodigoDescripcion()
                    .parallelStream().map(e -> e.getDescripcion()).collect(Collectors.toList()));
        }

        return response.getComprobanteResponse();
    }

    public int consultarUltimoComprobante(SociedadEnum sociedadEnum, short codigoTipoComprobante, short numeroPuntoVenta) throws ExceptionFaultMsg, IOException {
        ConsultarUltimoComprobanteAutorizadoRequestType parameters = new ConsultarUltimoComprobanteAutorizadoRequestType();

        parameters.setAuthRequest(buildAuth(sociedadEnum));

        ConsultaUltimoComprobanteAutorizadoRequestType value = new ConsultaUltimoComprobanteAutorizadoRequestType();
        value.setCodigoTipoComprobante(codigoTipoComprobante);
        value.setNumeroPuntoVenta(numeroPuntoVenta);

        parameters.setConsultaUltimoComprobanteAutorizadoRequest(value);

        ConsultarUltimoComprobanteAutorizadoResponseType response = port.consultarUltimoComprobanteAutorizado(parameters);

        return response.getNumeroComprobante() != null ? response.getNumeroComprobante() : 0;
    }

}
