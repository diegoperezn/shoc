///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.shoc.domain.repository;
//
//import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType;
//import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
//import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEResponseType;
//import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType;
//import ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoRequestType;
//import ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType;
//import ar.gov.afip.wsmtxca.service.impl.service.ExceptionFaultMsg;
//import ar.gov.afip.wsmtxca.service.impl.service.MTXCAService;
//import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
//import ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType;
//import ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType;
//import com.shoc.afip.authen.AfipAuthentification;
//import com.shoc.afip.authen.AfipAuthentificationService;
//import com.shoc.domain.SociedadEnum;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.xml.ws.BindingProvider;
//
///**
// *
// * @author diego
// */
//public class AfipTiposRepositoryConDetalles {
//
//    private static AfipTiposRepositoryConDetalles instance;
//
//    public static AfipTiposRepositoryConDetalles getInstance() {
//        if (instance == null) {
//            instance = new AfipTiposRepositoryConDetalles();
//        }
//
//        return instance;
//    }
//
//    public AfipTiposRepositoryConDetalles() {
//        setPort();
//    }
//
//    private static MTXCAServicePortType port;
//
//    private void setPort() {
//        if (port == null) {
//            MTXCAService factory = new MTXCAService();
//            port = factory.getMTXCAServiceHttpSoap11Endpoint();
//
//            BindingProvider prov = (BindingProvider) port;
//            prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService");
//        }
//    }
//
//    public List<CodigoDescripcionType> listarTiposFactura(SociedadEnum sociedad) throws IOException {
//        AuthRequestType auth = buildAuth(sociedad);
//        ConsultarTiposComprobanteRequestType parameters
//                = new ConsultarTiposComprobanteRequestType();
//        parameters.setAuthRequest(auth);
//
//        try {
//            return port.consultarTiposComprobante(parameters).getArrayTiposComprobante().getCodigoDescripcion();
//        } catch (ExceptionFaultMsg ex) {
//            Logger.getLogger(AfipTiposRepositoryConDetalles.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return new ArrayList<>();
//    }
//
//    private AuthRequestType buildAuth(SociedadEnum sociedad) throws IOException {
//        AuthRequestType authResponse = new AuthRequestType();
//
//        if (!System.getProperties().containsKey("shoc.afip.auth.token")) {
//            AfipAuthentification auth = AfipAuthentificationService.autentificarAfip(sociedad, "wsmtxca");
//
//            System.setProperty("shoc.afip.auth.token", auth.getToken());
//            System.setProperty("shoc.afip.auth.sign", auth.getSign());
//            
//        }
//
//        authResponse.setToken(System.getProperty("shoc.afip.auth.token"));
//        authResponse.setSign(System.getProperty("shoc.afip.auth.sign"));
//        authResponse.setCuitRepresentada(Long.valueOf(sociedad.getCuit()));
//
//        return authResponse;
//    }
//
//    public List<PuntoVentaType> listarPuntoVenta(SociedadEnum sociedad) throws IOException {
//        AuthRequestType auth = buildAuth(sociedad);
//        ConsultarPuntosVentaRequestType parameters
//                = new ConsultarPuntosVentaRequestType();
//        parameters.setAuthRequest(auth);
//
//        try {
//            return port.consultarPuntosVenta(parameters).getArrayPuntosVenta().getPuntoVenta();
//        } catch (ExceptionFaultMsg ex) {
//            Logger.getLogger(AfipTiposRepositoryConDetalles.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return new ArrayList<>();
//    }
//    
//    public ComprobanteCAEResponseType enviarFactura(SociedadEnum sociedadEnum, ComprobanteType comprobante) 
//            throws IOException, ExceptionFaultMsg, AfipException {
//        AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();
//        parameters.setAuthRequest(buildAuth(sociedadEnum));
//        parameters.setComprobanteCAERequest(comprobante);
//        
//        AutorizarComprobanteResponseType response = port.autorizarComprobante(parameters);
//        
//        if (response.getResultado().equals(ResultadoSimpleType.R)) {
//            throw new AfipException(response.getArrayErrores().getCodigoDescripcion());
//        }
//        
//        return response.getComprobanteResponse();
//    }
//
//    public int consultarUltimoComprobante(SociedadEnum sociedadEnum, short codigoTipoComprobante, short numeroPuntoVenta) throws ExceptionFaultMsg, IOException {
//        ConsultarUltimoComprobanteAutorizadoRequestType parameters = new ConsultarUltimoComprobanteAutorizadoRequestType();
//        
//        parameters.setAuthRequest(buildAuth(sociedadEnum));
//        
//        ConsultaUltimoComprobanteAutorizadoRequestType value = new ConsultaUltimoComprobanteAutorizadoRequestType();
//        value.setCodigoTipoComprobante(codigoTipoComprobante);
//        value.setNumeroPuntoVenta(numeroPuntoVenta);
//        
//        parameters.setConsultaUltimoComprobanteAutorizadoRequest(value);
//        
//        ConsultarUltimoComprobanteAutorizadoResponseType response = port.consultarUltimoComprobanteAutorizado(parameters);
//        
//        return response.getNumeroComprobante() != null ? response.getNumeroComprobante() : 0;
//    }
//
//
//}
