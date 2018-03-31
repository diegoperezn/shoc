/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.Propiedad;
import com.shoc.domain.repository.PropiedadRepository;
import java.util.List;

/**
 *
 * @author diego
 */
public class PropiedadService {

    private static PropiedadService instance;

    public static PropiedadService getInstance() {
        if (instance == null) {
            instance = new PropiedadService();
        }

        return instance;
    }

    private final PropiedadRepository repo = PropiedadRepository.getInstance();
    
    public void update(Long id, String value) {
        
        Propiedad p = this.get(id);
        p.setValor(value);

        repo.save(p);
    }
    
    public List<Propiedad> listAll() {
        return repo.listAll();
    }
    
    public Propiedad get(Long id) {
        return repo.get(id);
    }
    
    public String getPropertyValue(String nombre) {
        return this.repo.getPropertyValue(nombre).getValor();
    }

}
