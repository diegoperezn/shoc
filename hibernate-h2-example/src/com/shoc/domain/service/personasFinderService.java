/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.afip.authen.AfipAuthentification;
import com.shoc.afip.authen.AfipAuthentificationService;
import com.shoc.controller.Panels.mainFrame;
import com.shoc.domain.SociedadEnum;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.ws.BindingProvider;
import org.apache.log4j.Logger;
import src.sr.puc.server.ws.soap.a5.PersonaReturn;
import src.sr.puc.server.ws.soap.a5.PersonaServiceA5;
import src.sr.puc.server.ws.soap.a5.PersonaServiceA5_Service;

/**
 *
 * @author diego
 */
public class personasFinderService {

    private static PersonaServiceA5 port;

    final static Logger logger = Logger.getLogger(personasFinderService.class);
    
    private static personasFinderService instance;

    public static personasFinderService getInstance() {
        if (instance == null) {
            instance = new personasFinderService();
        }

        return instance;
    }
    
    private void setPort() {
        if (port == null) {
            PersonaServiceA5_Service factory = new PersonaServiceA5_Service();
            port = factory.getPersonaServiceA5Port();

            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://awshomo.afip.gov.ar/sr-padron/webservices/personaServiceA5");
        }
    }
    
    private AfipAuthentification conectarAfip() throws FileNotFoundException, IOException {
        return AfipAuthentificationService.autentificarAfip(SociedadEnum.TIZZIANO, "ws_sr_padron_a5");
    }

    public PersonaReturn buscarPersona(Long documento) throws IOException {
        setPort();
        
        AfipAuthentification auth = conectarAfip();
        Long cuitRepresentada = new Long(20103962545l);
        Long cuitConsultada = new Long(20103962545l);
        
        final PersonaReturn persona = port.getPersona(auth.getToken(), auth.getSign(), cuitRepresentada , cuitConsultada);
        
        logger.info(persona);
        
        return persona;
    }
}
