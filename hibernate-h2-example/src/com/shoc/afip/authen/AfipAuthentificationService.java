package com.shoc.afip.authen;

// El Departamento de Seguridad Informatica de la AFIP (DeSeIn/AFIP), pone a disposicion
// el siguiente codigo para su utilizacion con el WebService de Autenticacion y Autorizacion
// de la AFIP.
//
// El mismo no puede ser re-distribuido, publicado o descargado en forma total o parcial, ya sea
// en forma electronica, mecanica u optica, sin la autorizacion de DeSeIn/AFIP. El uso no
// autorizado del mismo esta prohibido.
//
// DeSeIn/AFIP no asume ninguna responsabilidad de los errores que pueda contener el codigo ni la
// obligacion de subsanar dichos errores o informar de la existencia de los mismos.
//
// DeSeIn/AFIP no asume ninguna responsabilidad que surja de la utilizacion del codigo, ya sea por
// utilizacion ilegal de patentes, perdida de beneficios, perdida de informacion o cualquier otro
// inconveniente.
//
// Bajo ninguna circunstancia DeSeIn/AFIP podra ser indicada como responsable por consecuencias y/o
// incidentes ya sean directos o indirectos que puedan surgir de la utilizacion del codigo.
//
// DeSeIn/AFIP no da ninguna garantia, expresa o implicita, de la utilidad del codigo, si el mismo es
// correcto, o si cumple con los requerimientos de algun proposito en particular.
//
// DeSeIn/AFIP puede realizar cambios en cualquier momento en el codigo sin previo aviso.
//
// El codigo debera ser evaluado, verificado, corregido y/o adaptado por personal tecnico calificado
// de las entidades que lo utilicen.
//
// EL SIGUIENTE CODIGO ES DISTRIBUIDO PARA EVALUACION, CON TODOS SUS ERRORES Y OMISIONES. LA
// RESPONSABILIDAD DEL CORRECTO FUNCIONAMIENTO DEL MISMO YA SEA POR SI SOLO O COMO PARTE DE
// OTRA APLICACION, QUEDA A CARGO DE LAS ENTIDADES QUE LO UTILICEN. LA UTILIZACION DEL CODIGO
// SIGNIFICA LA ACEPTACION DE TODOS LOS TERMINOS Y CONDICIONES MENCIONADAS ANTERIORMENTE.
//
// Version 1.0
// gp/rg/OF.G. DeSeIn-AFIP
//
import com.shoc.domain.SociedadEnum;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class AfipAuthentificationService {

    final static Logger logger = Logger.getLogger(AfipAuthentificationService.class);

    public static AfipAuthentification autentificarAfip(SociedadEnum sociedad, String service) throws FileNotFoundException, IOException {
        String LoginTicketResponse = null;

        System.setProperty("http.proxyHost", "");
        System.setProperty("http.proxyPort", "80");

        // Read config from phile
        Properties config = new Properties();

        try {
            final FileInputStream confFile = new FileInputStream("./wsaa_client.properties");

            config.load(confFile);
        } catch (FileNotFoundException e) {
            logger.fatal("Error obteniendo el archivo de configuracion", e);

            throw e;
        }

        String endpoint = config.getProperty("endpoint", "http://wsaahomo.afip.gov.ar/ws/services/LoginCms");
        String dstDN = config.getProperty("dstdn");

        String p12file = config.getProperty(sociedad.getCuit());
        String signer = config.getProperty("keystore-signer", "diego");
        String p12pass = config.getProperty("keystore-password", "clave");

        Long TicketTime = new Long(config.getProperty("TicketTime", "36000"));

        // Create LoginTicketRequest_xml_cms
        byte[] LoginTicketRequest_xml_cms = afip_wsaa_client.create_cms(p12file, p12pass,
                signer, dstDN, service, TicketTime);

        // Invoke AFIP wsaa and get LoginTicketResponse
        try {
            LoginTicketResponse = afip_wsaa_client.invoke_wsaa(LoginTicketRequest_xml_cms, endpoint);
        } catch (Exception e) {
            logger.error("Error autentificando con AFIP", e);
        }

        logger.debug(LoginTicketResponse);

        // Get token & sign from LoginTicketResponse
        String token = null;
        String sign = null;
        try {
            Reader tokenReader = new StringReader(LoginTicketResponse);
            Document tokenDoc = new SAXReader(false).read(tokenReader);

            token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
            sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");

            logger.info("TOKEN: " + token);
            logger.info("SIGN: " + sign);
        } catch (Exception e) {
            logger.error("Error contruyendo la autentificando", e);
        }

        return new AfipAuthentification(token, sign, sociedad.getCuit());
    }

}
