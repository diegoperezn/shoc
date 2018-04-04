/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ExceptionFaultMsg;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAService;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
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
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://wswhomo.afip.gov.ar/wsfev1/service.asmx");
        }
    }

    public List<CodigoDescripcionType> listarTiposFactura() {
        AuthRequestType auth = buildAuth();
        ConsultarTiposComprobanteRequestType parameters
                = new ConsultarTiposComprobanteRequestType();
        parameters.setAuthRequest(auth);

        /*
        try {
            return port.consultarTiposComprobante(parameters).getArrayTiposComprobante().getCodigoDescripcion();
        } catch (ExceptionFaultMsg ex) {
            Logger.getLogger(AfipTiposRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
        
        return new ArrayList<>();
    }

    private AuthRequestType buildAuth() {
        AuthRequestType auth = new AuthRequestType();

        auth.setToken(System.getProperty("shoc.afip.auth.token"));
        auth.setSign(System.getProperty("shoc.afip.auth.sign"));
        auth.setCuitRepresentada(Long.valueOf(System.getProperty("shoc.afip.auth.cuit")));

        return auth;
    }

}
