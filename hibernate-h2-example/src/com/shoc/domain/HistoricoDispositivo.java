/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.Date;
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
public class HistoricoDispositivo {

    private Long id;
    private Date fechaCambio;
    private DispositivosEnum dispositivo;
    private Paciente paciente;

    public HistoricoDispositivo() {
    }

    public HistoricoDispositivo(DispositivosEnum dispositivo, Paciente paciente) {
        this.dispositivo = dispositivo;
        this.paciente = paciente;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    public Date getFechaCambio() {
        return fechaCambio;
    }

    @Column
    public DispositivosEnum getDispositivo() {
        return dispositivo;
    }

    @ManyToOne
    @JoinColumn
    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public void setDispositivo(DispositivosEnum dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
