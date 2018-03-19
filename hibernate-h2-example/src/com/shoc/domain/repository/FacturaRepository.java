/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import com.shoc.domain.Factura;
import com.shoc.domain.ObraSocial;

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

}
