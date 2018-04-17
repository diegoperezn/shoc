/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ExceptionFaultMsg;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAService;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType;
import com.shoc.afip.authen.AfipAuthentification;
import com.shoc.afip.authen.AfipAuthentificationService;
import com.shoc.domain.SociedadEnum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author diego
 */
public class AfipTiposRepository {

    private static AfipTiposRepository instance;

    public static AfipTiposRepository getInstance() {
        if (instance == null) {
            instance = new AfipTiposRepository();
        }

        return instance;
    }

    public AfipTiposRepository() {
        setPort();
    }

    private static MTXCAServicePortType port;

    private void setPort() {
        if (port == null) {
            MTXCAService factory = new MTXCAService();
            port = factory.getMTXCAServiceHttpSoap11Endpoint();

            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService");
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
            Logger.getLogger(AfipTiposRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }

    private AuthRequestType buildAuth(SociedadEnum sociedad) throws IOException {
        AuthRequestType authResponse = new AuthRequestType();

        if (!System.getProperties().containsKey("shoc.afip.auth.token." + sociedad)) {
            AfipAuthentification auth = AfipAuthentificationService.autentificarAfip(sociedad, "wsmtxca");

            System.setProperty("shoc.afip.auth.token." + sociedad, auth.getToken());
            System.setProperty("shoc.afip.auth.sign." + sociedad, auth.getSign());
            System.setProperty("shoc.afip.auth.cuit." + sociedad, sociedad.getCuit());
        }

        authResponse.setToken(System.getProperty("shoc.afip.auth.token." + sociedad));
        authResponse.setSign(System.getProperty("shoc.afip.auth.sign." + sociedad));
        authResponse.setCuitRepresentada(Long.valueOf(System.getProperty("shoc.afip.auth.cuit." + sociedad)));

        return authResponse;
    }

    public List<PuntoVentaType> listarPuntoVenta(SociedadEnum sociedad) throws IOException {
        AuthRequestType auth = buildAuth(sociedad);
        ConsultarPuntosVentaRequestType parameters
                = new ConsultarPuntosVentaRequestType();
        parameters.setAuthRequest(auth);

        try {
            return port.consultarPuntosVenta(parameters).getArrayPuntosVenta().getPuntoVenta();
        } catch (ExceptionFaultMsg ex) {
            Logger.getLogger(AfipTiposRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ArrayList<>();
    }
    
    public void enviarFactura() {
        
        //port.autorizarComprobante(parameters);
    }

    public int consultarUltimoComprobante(short codigoTipoComprobante, short numeroPuntoVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
