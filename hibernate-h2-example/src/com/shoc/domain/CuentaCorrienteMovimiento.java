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
import javax.persistence.OneToOne;

/**
 *
 * @author diego
 */
@Entity
public class CuentaCorrienteMovimiento {

    private Long id;
    private MovimientoEnum movimiento;
    private CuentaCorriente cuenta;
    private Factura factura;
    private String detalle;
    private Double monto;

    public CuentaCorrienteMovimiento() {
    }

    public CuentaCorrienteMovimiento(String detalle, Double monto, CuentaCorriente cuenta) {
        this.detalle = detalle;
        this.monto = monto;
        this.cuenta = cuenta;
        this.movimiento = MovimientoEnum.DEBITO;
    }
    
    public CuentaCorrienteMovimiento(Factura factura, CuentaCorriente cuenta) {
        this.monto = factura.getTotal();
        this.detalle = "Movimiento por Factura Nro: " + factura.getId();
        this.factura = factura;
        this.cuenta = cuenta;
        this.movimiento = MovimientoEnum.CREDITO;
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
    public Double getMonto() {
        return monto;
    }

    @Column
    public String getDetalle() {
        return detalle;
    }

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    @OneToOne
    @JoinColumn
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setMovimiento(MovimientoEnum movimiento) {
        this.movimiento = movimiento;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

}
