/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.afip.authen.AfipAuthentification;
import fev1.dif.afip.gov.ar.CbteTipo;
import fev1.dif.afip.gov.ar.FEAuthRequest;
import fev1.dif.afip.gov.ar.Service;
import fev1.dif.afip.gov.ar.ServiceSoap;
import java.util.List;
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

    
    private static ServiceSoap port;

    private void setPort() {
        if (port == null) {
            Service factory = new Service();
            port = factory.getServiceSoap();

            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://wswhomo.afip.gov.ar/wsfev1/service.asmx");
        }
    }

    public List<CbteTipo> listarTiposFactura() {
        FEAuthRequest auth = buildAuth();

        return port.feParamGetTiposCbte(auth).getResultGet().getCbteTipo();
    }

    private FEAuthRequest buildAuth() {
        FEAuthRequest auth = new FEAuthRequest();

        auth.setToken(System.getProperty("shoc.afip.auth.token"));
        auth.setSign(System.getProperty("shoc.afip.auth.sign"));
        auth.setCuit(Long.valueOf(System.getProperty("shoc.afip.auth.cuit")));

        return auth;
    }

}
