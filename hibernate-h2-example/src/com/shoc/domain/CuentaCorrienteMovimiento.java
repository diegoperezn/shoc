/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author diego
 */
@Entity
class CuentaCorrienteMovimiento {

    private Long id;
    private MovimientoEnum movimiento;
    private double monto;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    public MovimientoEnum getMovimiento() {
        return movimiento;
    }

    @Column
    public double getMonto() {
        return monto;
    }

}
