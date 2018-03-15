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
public class Dispositivo {

    private Long id;
    private ObraSocial obraSocial;
    private Double costo;
    private DispositivosEnum dispositivo;

    public Dispositivo() {
    }

    public Dispositivo(ObraSocial obraSocial, Double costo, DispositivosEnum dispositivo) {
        this.obraSocial = obraSocial;
        this.costo = costo;
        this.dispositivo = dispositivo;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @Column
    public Double getCosto() {
        return costo;
    }

    @Column
    public DispositivosEnum getDispositivo() {
        return dispositivo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setDispositivo(DispositivosEnum dispositivo) {
        this.dispositivo = dispositivo;
    }

}
