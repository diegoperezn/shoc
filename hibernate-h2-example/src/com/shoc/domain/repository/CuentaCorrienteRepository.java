/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.CuentaCorriente;
import org.hibernate.criterion.Order;

/**
 *
 * @author diego
 */
public class CuentaCorrienteRepository extends Repository<CuentaCorriente> {

    private static CuentaCorrienteRepository instance;

    public static CuentaCorrienteRepository getInstance() {
        if (instance == null) {
            instance = new CuentaCorrienteRepository();
        }

        return instance;
    }

    @Override
    public Class getEntityClass() {
        return CuentaCorriente.class;
    }

    @Override
    public Order getDefaultOrder() {
        return Order.desc("balance");
    }
    
    
}
