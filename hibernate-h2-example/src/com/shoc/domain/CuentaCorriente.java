/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author diego
 */
@Entity
public class CuentaCorriente {

    private Long id;
    private ObraSocial obraSocial;
    private List<CuentaCorrienteMovimiento> movimientos;
    private Double balance;
    private Paciente paciente;

    public CuentaCorriente() {
    }

    public CuentaCorriente(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
        this.balance = Double.MIN_NORMAL;
    }

    public CuentaCorriente(Paciente paciente) {
        this.paciente = paciente;
        this.balance = Double.MIN_NORMAL;
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

    @OneToOne
    @JoinColumn
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @OneToMany(mappedBy = "cuenta",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "Fecha desc")
    @Fetch(FetchMode.SUBSELECT)
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

    @Column
    public Double getBalance() {
        balance = Double.parseDouble("0");

        if (movimientos != null) {
            movimientos.forEach((movimiento) -> {
                if (movimiento.getMovimiento().equals(MovimientoEnum.CREDITO)) {
                    balance += movimiento.getMonto();
                } else {
                    balance -= movimiento.getMonto();
                }
            });
        }

        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Transient
    public String getNombreDuenio() {
        return this.getObraSocial() != null ? this.getObraSocial().getRazonSocial() : this.getPaciente().getNombre();
    }

}
