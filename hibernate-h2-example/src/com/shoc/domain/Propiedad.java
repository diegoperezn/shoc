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
public class Propiedad {

    private Long id;
    private String nombre;
    private String valor;

    public Propiedad() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    public String getNombre() {
        return nombre;
    }

    @Column()
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
