/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author diego
 */
@Entity
public class CuentaCorriente {

    private Long id;
    private ObraSocial obraSocial;
    private List<CuentaCorrienteMovimiento> movimientos;

    public CuentaCorriente() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @OneToMany(mappedBy = "cuenta",
            targetEntity = CuentaCorriente.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<CuentaCorrienteMovimiento> getMovimientos() {
        return movimientos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void setMovimientos(List<CuentaCorrienteMovimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Transient
    public Double getBalance() {
        Double balance = Double.MIN_VALUE;

        for (CuentaCorrienteMovimiento movimiento : movimientos) {
            if (movimiento.getMovimiento().equals(MovimientoEnum.CREDITO)) {
                balance += movimiento.getMonto();
            } else {
                balance -= movimiento.getMonto();
            }
        }

        return balance;
    }

}
