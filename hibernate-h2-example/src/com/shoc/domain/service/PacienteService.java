/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.IPaciente;
import com.shoc.domain.Paciente;
import com.shoc.domain.repository.PacienteRepository;
import java.util.List;

/**
 *
 * @author diego
 */
public class PacienteService {

    private static PacienteService instance;

    public static PacienteService getInstance() {
        if (instance == null) {
            instance = new PacienteService();
        }

        return instance;
    }

    private final PacienteRepository repo = PacienteRepository.getInstance();
    
    public void createPaciente(IPaciente iPaciente) {
        Paciente paciente = new Paciente(iPaciente);

        repo.save(paciente);
    }
    
    public List<Paciente> listAll() {
        return repo.listAll();
    }
    
    public Paciente get(Long id) {
        return repo.get(id);
    }

    public void deleteById(Long selectedId) {
        this.repo.delete(selectedId);
    }

}
