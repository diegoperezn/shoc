/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.repository.AfipTiposRepository;
import fev1.dif.afip.gov.ar.CbteTipo;
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

    public List<CbteTipo> listarTiposComprobante(){
        return this.repo.listarTiposFactura();
    }
    
}
