/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author diego
 */
@Entity
public class CuentaCorriente {
    
    private Long id;
    private ObraSocial obraSocial;
    private List<CuentaCorrienteMovimiento> movimientos;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @OneToMany
    public List<CuentaCorrienteMovimiento> getMovimientos() {
        return movimientos;
    }
    
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
