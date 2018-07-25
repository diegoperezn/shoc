/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;


import java.util.Date;
import java.util.List;

import com.shoc.controller.Panels.FacturaList;
import com.shoc.domain.Factura;
import com.shoc.domain.FacturaAfipEnum;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.FacturaRepository;

import com.shoc.afip.wsmtxca.ComprobanteCAEResponseType;
import com.shoc.afip.wsve.FECAEDetResponse;
import com.shoc.afip.wsve.FECAEResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class FacturaService {

    private static FacturaService instance;

    public static FacturaService getInstance() {
        if (instance == null) {
            instance = new FacturaService();
        }

        return instance;
    }

    private final FacturaRepository repo = FacturaRepository.getInstance();

    public Factura crearFactura(IFaturaDetailsSearch filter, List<FacturaDetail> details) {

        Paciente p = filter.getPaciente();
        if (p == null) {
            p = details.get(0).getPaciente();
            for (FacturaDetail detail : details) {
                if (!detail.getPaciente().equals(p)) {
                    p = null;
                    break;
                }
            }
        }
        
        ObraSocial ob = filter.getObraSocial();
        if (ob == null 
                && details.get(0).getPaciente().getObraSocial() != null) {
            ob = details.get(0).getPaciente().getObraSocial();
            for (FacturaDetail detail : details) {
                if (!detail.getPaciente().getObraSocial().equals(ob)) {
                    ob = null;
                    break;
                }
            }
        }

        Factura factura = new Factura(p, ob, details);
        
        repo.save(factura);
        
        return factura;
    }
    
    
    public void marcarFacturaComoEnviadaAfip(Factura f, ComprobanteCAEResponseType response, 
            FacturaAfipEnum codigoDescripcionType, SociedadEnum sociedadEnum) {
        f.setCae(String.valueOf(response.getCAE()));
        f.setNumeroComprobante(response.getNumeroComprobante());
        f.setFechaEmision(response.getFechaEmision().toGregorianCalendar().getTime());
        f.setFechaVencimiento(response.getFechaVencimientoCAE().toGregorianCalendar().getTime());
        f.setTipoComprobante(codigoDescripcionType.getDescripcion());
        //f.setPuntoDeVenta(puntoVentaType.toString());
        f.setPuntoDeVenta(String.valueOf(response.getNumeroPuntoVenta()));
        f.setSociedad(sociedadEnum);
        
        repo.save(f);
    }
    
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    
    void marcarFacturaComoEnviadaAfip(Factura f, FECAEResponse response, FacturaAfipEnum codigoDescripcionType, 
            SociedadEnum sociedadEnum) {
        FECAEDetResponse detailsResponse = response.getFeDetResp().getFECAEDetResponse().get(0);
        
        try {
            f.setFechaEmision(formatter.parse(detailsResponse.getCbteFch()));
            f.setFechaVencimiento(formatter.parse(detailsResponse.getCAEFchVto()));
        } catch (ParseException ex) {
            Logger.getLogger(FacturaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        f.setCae(String.valueOf(detailsResponse.getCAE()));
        f.setNumeroComprobante((int) detailsResponse.getCbteDesde());
        f.setTipoComprobante(codigoDescripcionType.getDescripcion());
        //f.setPuntoDeVenta(puntoVentaType.toString());
        f.setPuntoDeVenta(String.valueOf(response.getFeCabResp().getPtoVta()));
        f.setSociedad(sociedadEnum);
        
        repo.save(f);
    }

    public List<Factura> listAll() {
        return repo.listAll();
    }

    public Factura get(Long id) {
        return repo.get(id);
    }

     public void delete(Factura f) {
        
    }
    
    public void deleteById(Long selectedId) {
        Factura f = this.get(selectedId);
        
        f.getMovimiento().getCuenta().getMovimientos().remove(f.getMovimiento());
        
        this.repo.delete(f);
    }

    public List<Factura> search(FacturaList filter) {
        return this.repo.search(filter);
    }

    

}
