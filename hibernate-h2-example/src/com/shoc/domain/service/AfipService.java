/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType;
import ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType;
import com.shoc.domain.Factura;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.AfipTiposRepository;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author diego
 */
public class AfipService {

    private static AfipService instance;

    public static AfipService getInstance() {
        if (instance == null) {
            instance = new AfipService();
        }

        return instance;
    }

    private final AfipTiposRepository repo = AfipTiposRepository.getInstance();

    public List<CodigoDescripcionType> listarTiposComprobante(SociedadEnum sociedad) throws IOException{
        return this.repo.listarTiposFactura(sociedad);
    }

    public List<PuntoVentaType> listarPuntosVenta(SociedadEnum sociedad) throws IOException {
        return this.repo.listarPuntoVenta(sociedad);
    }

    public void enviarFacturaAfip(SociedadEnum sociedadEnum, CodigoDescripcionType codigoDescripcionType, PuntoVentaType puntoVentaType, Factura f) {
        AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();
        
        ComprobanteType comprobante = new ComprobanteType();
        
        final short codigoTipoComprobante = codigoDescripcionType.getCodigo();
        final short numeroPuntoVenta = puntoVentaType.getNumeroPuntoVenta();
        final int codigoComprobante = 
                this.repo.consultarUltimoComprobante(codigoTipoComprobante, numeroPuntoVenta);
        
        comprobante.setCodigoTipoComprobante(codigoTipoComprobante);
        comprobante.setNumeroPuntoVenta(numeroPuntoVenta);
        comprobante.setNumeroComprobante(codigoComprobante);
        
        //parameters.setComprobanteCAERequest(value);
        
        
    }

    
}
