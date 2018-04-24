/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEResponseType;
import com.shoc.controller.Panels.FacturaList;
import com.shoc.domain.Factura;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.FacturaRepository;
import java.util.Date;
import java.util.List;

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
    
    
    public void marcarFacturaComoEnviadaAfip(Factura f, ComprobanteCAEResponseType response, CodigoDescripcionType codigoDescripcionType, SociedadEnum sociedadEnum) {
        f.setCae(String.valueOf(response.getCAE()));
        f.setNumeroComprobante(response.getNumeroComprobante());
        f.setFechaEmision(new Date(response.getFechaEmision().getMillisecond()));
        f.setFechaVencimiento(new Date(response.getFechaVencimientoCAE().getMillisecond()));
        f.setTipoComprobante(codigoDescripcionType.getDescripcion());
        //f.setPuntoDeVenta(puntoVentaType.toString());
        f.setPuntoDeVenta("0001");
        f.setSociedad(sociedadEnum.toString());
        
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
