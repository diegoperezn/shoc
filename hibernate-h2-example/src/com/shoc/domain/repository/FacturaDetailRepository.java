/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.FacturaDetail;
import com.shoc.domain.Paciente;
import java.util.Date;
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

    public boolean existInDetails(Paciente paciente, String dispositivoTerapia, Date time) {
         DetachedCriteria c = this.createCriteria();

        c.add(Restrictions.eq("paciente", paciente));
        c.add(Restrictions.eq("dispositivo", dispositivoTerapia));
        c.add(Restrictions.ge("fecha", time));
        
        return !this.listByCriteria(c).isEmpty();
    }

}
