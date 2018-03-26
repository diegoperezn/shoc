/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.Factura;
import com.shoc.domain.service.IFaturaDetailsSearch;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author diego
 */
public class FacturaRepository extends Repository<Factura> {

    private static FacturaRepository instance;

    public static FacturaRepository getInstance() {
        if (instance == null) {
            instance = new FacturaRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return Factura.class;
    }

    public List<Factura> search(IFaturaDetailsSearch filter) {
        DetachedCriteria c = this.createCriteria();
        
        if (filter.getPaciente() != null) {
            c.add(Restrictions.eq("paciente", filter.getPaciente()));
        }
        if (filter.getObraSocial() != null) {
            c.createAlias("paciente", "paciente");
            c.add(Restrictions.eq("obraSocial", filter.getObraSocial()));
        }
        if (filter.getMes() != null) {
            c.add(Restrictions.eq("fecha", filter.getMes()));
        }

        return this.listByCriteria(c);
    }
    
}
