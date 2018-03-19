/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.Factura;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import com.shoc.domain.repository.FacturaRepository;
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

    public void crearFactura(IFaturaDetailsSearch filter, List<FacturaDetail> details) {

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
        if (ob == null) {
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
    }

    public List<Factura> listAll() {
        return repo.listAll();
    }

    public Factura get(Long id) {
        return repo.get(id);
    }

    public void deleteById(Long selectedId) {
        this.repo.delete(selectedId);
    }

}
