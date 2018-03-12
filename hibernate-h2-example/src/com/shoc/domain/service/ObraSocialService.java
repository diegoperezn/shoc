/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.IObraSocial;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.repository.ObraSocialRepository;
import java.util.List;

/**
 *
 * @author diego
 */
public class ObraSocialService {

    private static ObraSocialService instance;

    public static ObraSocialService getInstance() {
        if (instance == null) {
            instance = new ObraSocialService();
        }

        return instance;
    }

    private final ObraSocialRepository repo = ObraSocialRepository.getInstance();
    
    public void createObraSocial(IObraSocial iob) {
        ObraSocial ob = new ObraSocial(iob);

        repo.save(ob);
    }
    
    public List<ObraSocial> listAll() {
        return repo.listAll();
    }
    
    public ObraSocial get(Long id) {
        return repo.get(id);
    }

    public void deleteById(Long selectedId) {
        this.repo.delete(selectedId);
    }

}
