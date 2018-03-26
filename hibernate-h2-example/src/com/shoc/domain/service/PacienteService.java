/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.IPaciente;
import com.shoc.domain.Paciente;
import com.shoc.domain.repository.PacienteRepository;
import java.util.Date;
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
        Paciente paciente = null;

        if (iPaciente.getId() == null) {
            paciente = new Paciente();
        } else {
            paciente = this.get(iPaciente.getId());
        }
        
        paciente.actualizar(iPaciente);

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

    public List<Paciente> search(ISearchPaciente filter) {
        return this.repo.search(filter);
    }

    // Lista los pacientes activos o dados de baja en el transcurso del mes
    public List<Paciente> listarPacientesActivos(Date fecha) {
        return this.repo.listarPacientesActivos(fecha);
    }

    // Lista los pacientes activos o dados de baja en el transcurso del mes
    public List<Paciente> listarPacientesActivos(IFaturaDetailsSearch filter) {
        return this.repo.listarPacientesActivos(filter);
    }

}
