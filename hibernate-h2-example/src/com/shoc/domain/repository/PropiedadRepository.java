/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.CuentaCorriente;
import com.shoc.domain.Propiedad;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author diego
 */
public class PropiedadRepository extends Repository<Propiedad> {

    private static PropiedadRepository instance;

    public static PropiedadRepository getInstance() {
        if (instance == null) {
            instance = new PropiedadRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return Propiedad.class;
    }

    public Propiedad getPropertyValue(String nombre) {
        DetachedCriteria c = this.createCriteria();

        c.add(Restrictions.eq("nombre", nombre));

        List<Propiedad> result = this.listByCriteria(c);

        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }

}
