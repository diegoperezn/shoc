/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.Paciente;
import com.shoc.domain.service.ISearchPaciente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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

    public List<Paciente> search(ISearchPaciente filter) {
        DetachedCriteria c = this.createCriteria();
        Criterion crtrn;
        
        c.add(Restrictions.ilike("nombre", "%" + filter.getNombre() +  "%"));
        if (filter.getActivo()) {
            c.add(Restrictions.isNull("egreso"));
        } else {
            c.add(Restrictions.isNotNull("egreso"));
        }
        
        
        return this.listByCriteria(c);
    }

}
