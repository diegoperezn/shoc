/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.Paciente;
import com.shoc.domain.service.IFaturaDetailsSearch;
import com.shoc.domain.service.ISearchPaciente;
import com.shoc.domain.utils.DateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
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

        Criterion egresoDates = null;
        if (filter.getDesdeBaja() != null
                || filter.getHastaBaja() != null) {
            if (filter.getDesdeBaja() != null && filter.getHastaBaja() != null) {
                egresoDates
                        = Restrictions.between("egreso", filter.getDesdeBaja(), filter.getHastaBaja());
            } else if (filter.getDesdeBaja() != null) {
                egresoDates
                        = Restrictions.ge("egreso", filter.getDesdeBaja());
            } else if (filter.getHastaBaja() != null) {
                egresoDates
                        = Restrictions.le("egreso", filter.getHastaBaja());
            }
        }

        c.add(Restrictions.ilike("nombre", "%" + filter.getNombre() + "%"));
        if (filter.getActivo()) {
            if (egresoDates != null) {
                c.add(Restrictions.or(Restrictions.isNull("egreso"), egresoDates));
            } else {
                c.add(Restrictions.isNull("egreso"));
            }
        } else {
            c.add(Restrictions.isNotNull("egreso"));
            if (egresoDates != null) {
                c.add(egresoDates);
            }
        }

        return this.listByCriteria(c);
    }

    public List<Paciente> listarPacientesActivos(Date desde) {
        DetachedCriteria c = this.createCriteria();

        Conjunction fechas = contruirCriteriaActivoEnFecha(desde);

        c.add(fechas);

        return this.listByCriteria(c);
    }

    private Conjunction contruirCriteriaActivoEnFecha(Date desde) {
        desde = DateUtils.getMinimaFecha(desde).getTime();
        Date hasta = DateUtils.getMinimaFechaMesSiguiente(desde).getTime();

        Conjunction fechas = Restrictions.conjunction();
        Conjunction ingreso = Restrictions.conjunction();

        ingreso.add(Restrictions.lt("ingreso", hasta));

        Disjunction egreso = Restrictions.disjunction();

        Conjunction fechaEgreso = Restrictions.conjunction();
        fechaEgreso.add(Restrictions.ge("egreso", desde));
        egreso.add(Restrictions.isNull("egreso"));

        egreso.add(fechaEgreso);

        fechas.add(ingreso);
        fechas.add(egreso);

        return fechas;
    }

    public List<Paciente> listarPacientesActivos(IFaturaDetailsSearch filter) {
        DetachedCriteria c = this.createCriteria();

        Date fecha;
        if (filter.getMes() != null) {
            fecha = filter.getMes();
        } else {
            fecha = new Date();
        }

        Conjunction fechas = contruirCriteriaActivoEnFecha(fecha);
        c.add(fechas);

        if (filter.getPaciente() != null) {
            c.add(Restrictions.eq("id", filter.getPaciente().getId()));
        }

        if (filter.getObraSocial() != null) {
            c.add(Restrictions.eq("obraSocial", filter.getObraSocial()));
        }

        return this.listByCriteria(c);
    }

}
