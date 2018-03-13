/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.Paciente;

/**
 *
 * @author diego
 */
public class PacienteRepository extends Repository<Paciente> {

    private static PacienteRepository instance;

    public static PacienteRepository getInstance() {
        if (instance == null) {
            instance = new PacienteRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return Paciente.class;
    }

}
