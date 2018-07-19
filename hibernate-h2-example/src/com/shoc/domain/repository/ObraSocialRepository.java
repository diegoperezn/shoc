/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.ObraSocial;
import org.hibernate.criterion.Order;

/**
 *
 * @author diego
 */
public class ObraSocialRepository extends Repository<ObraSocial> {

    private static ObraSocialRepository instance;

    public static ObraSocialRepository getInstance() {
        if (instance == null) {
            instance = new ObraSocialRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return ObraSocial.class;
    }
    
        @Override
    public Order getDefaultOrder() {
        return Order.asc("razonSocial");
    }

}
