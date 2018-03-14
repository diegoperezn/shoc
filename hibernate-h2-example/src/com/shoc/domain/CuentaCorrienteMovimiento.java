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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author diego
 */
@Entity
class CuentaCorrienteMovimiento {

    private Long id;
    private MovimientoEnum movimiento;
    private CuentaCorriente cuenta;
    private double monto;

    public CuentaCorrienteMovimiento() {
    }

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

    @ManyToOne
    @JoinColumn(name="cuenta_id", nullable=false)
    public CuentaCorriente getCuenta() {
        return cuenta;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setMovimiento(MovimientoEnum movimiento) {
        this.movimiento = movimiento;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }
    
}
