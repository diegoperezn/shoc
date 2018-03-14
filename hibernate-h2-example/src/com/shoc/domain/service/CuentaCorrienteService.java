/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.CuentaCorriente;
import com.shoc.domain.CuentaCorrienteMovimiento;
import com.shoc.domain.repository.CuentaCorrienteRepository;
import java.util.List;

/**
 *
 * @author diego
 */
public class CuentaCorrienteService {

    private static CuentaCorrienteService instance;

    public static CuentaCorrienteService getInstance() {
        if (instance == null) {
            instance = new CuentaCorrienteService();
        }

        return instance;
    }

    private final CuentaCorrienteRepository repo = CuentaCorrienteRepository.getInstance();
    
    /*
    public void createPaciente(IPaciente iPaciente) {
        Paciente paciente = new Paciente(iPaciente);

        repo.save(paciente);
    }
    */
    
    public List<CuentaCorriente> listAll() {
        return repo.listAll();
    }
    
    public CuentaCorriente get(Long id) {
        return repo.get(id);
    }

    public void deleteById(Long selectedId) {
        this.repo.delete(selectedId);
    }

    /*
    public List<CuentaCorriente> search(ISearchPaciente filter) {
        return this.repo.search(filter);
    }
    */

    public void addMovimiento( IMovimiento movimiento) {
        CuentaCorriente cuenta = this.repo.get(movimiento.getCuenta());
        
        cuenta.getMovimientos().add(new CuentaCorrienteMovimiento(movimiento.getDetalle(), movimiento.getMonto(), cuenta));
        
        this.repo.save(cuenta);
    }
    
}
