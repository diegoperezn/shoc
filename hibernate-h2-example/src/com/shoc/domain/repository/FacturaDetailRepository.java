/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.DispositivosEnum;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.Paciente;
import com.shoc.domain.service.IFaturaDetailsSearch;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author diego
 */
public class FacturaDetailRepository extends Repository<FacturaDetail> {

    private static FacturaDetailRepository instance;

    public static FacturaDetailRepository getInstance() {
        if (instance == null) {
            instance = new FacturaDetailRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return FacturaDetail.class;
    }

    public boolean existInDetails(Paciente paciente, DispositivosEnum dispositivoTerapia, Date time) {
        DetachedCriteria c = this.createCriteria();

        c.add(Restrictions.eq("paciente", paciente));
        c.add(Restrictions.eq("dispositivo", dispositivoTerapia));
        c.add(Restrictions.eq("fecha", time));

        return !this.listByCriteria(c).isEmpty();
    }

    public List<FacturaDetail> search(IFaturaDetailsSearch filter) {
        DetachedCriteria c = this.createCriteria();

        if (filter.getFacturado()) {
            c.add(Restrictions.isNotNull("factura"));
        } else {
            c.add(Restrictions.isNull("factura"));
        }
        
        if (filter.getPaciente() != null) {
            c.add(Restrictions.eq("paciente", filter.getPaciente()));
        }
        if (filter.getObraSocial() != null) {
            c.createAlias("paciente", "paciente");
            c.add(Restrictions.eq("paciente.obraSocial", filter.getObraSocial()));
        }
        if (filter.getMes() != null) {
            c.add(Restrictions.eq("fecha", filter.getMes()));
        }

        return this.listByCriteria(c);
    }

}
