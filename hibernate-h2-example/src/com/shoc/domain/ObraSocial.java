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
import javax.persistence.OneToOne;

/**
 *
 * @author diego
 */
@Entity
public class ObraSocial implements IObraSocial {

    // General
    private Long id;
    private String razonSocial;
    private String cuit;
    private String requerimiento;
    private String responsable;

    // Contacto
    private String celular;
    private String telefono;
    private String email;
    private String emailWeb;

    // Costos
    private Double costoInternacion;
    private Double costoJornadaCompleta;
    private Double costoMediaJornada;
    private Double costoAmbulatorio;
    private Double costo5;
    private String formaDePago;
    private String categoriaIVA;
    private Boolean modulo;

    // Domicilio
    private String direccion;
    private String provincia;
    private String localidad;

    private CuentaCorriente cuenta;

    public ObraSocial() {
        // this form used by Hibernate
    }

    public ObraSocial(IObraSocial i) {
        this.id = i.getId();
        this.razonSocial = i.getRazonSocial();
        this.cuit = i.getCuit();
        this.requerimiento = i.getRequerimiento();
        this.responsable = i.getResponsable();
        this.celular = i.getCelular();
        this.telefono = i.getTelefono();
        this.email = i.getEmail();
        this.emailWeb = i.getEmailWeb();
        this.costoInternacion = i.getCostoInternacion();
        this.costoJornadaCompleta = i.getCostoJornadaCompleta();
        this.costoMediaJornada = i.getCostoMediaJornada();
        this.costoAmbulatorio = i.getCostoAmbulatorio();
        this.costo5 = i.getCosto5();
        this.formaDePago = i.getFormaDePago();
        this.categoriaIVA = i.getCategoriaIva();
        this.modulo = i.getModulo();
        this.direccion = i.getDireccion();
        this.provincia = i.getProvincia();
        this.localidad = i.getLocalidad();
    }

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Column
    @Override
    public String getRazonSocial() {
        return razonSocial;
    }

    @Column
    @Override
    public String getCuit() {
        return cuit;
    }

    @Column
    @Override
    public String getResponsable() {
        return responsable;
    }

    @Column
    @Override
    public String getRequerimiento() {
        return requerimiento;
    }

    @Column
    @Override
    public String getCelular() {
        return celular;
    }

    @Column
    @Override
    public String getTelefono() {
        return telefono;
    }

    @Column
    @Override
    public String getEmail() {
        return email;
    }

    @Column
    @Override
    public String getEmailWeb() {
        return emailWeb;
    }

    @Column
    @Override
    public Double getCostoInternacion() {
        return costoInternacion;
    }

    @Column
    @Override
    public Double getCostoJornadaCompleta() {
        return costoJornadaCompleta;
    }

    @Column
    @Override
    public Double getCostoMediaJornada() {
        return costoMediaJornada;
    }

    @Column
    @Override
    public Double getCostoAmbulatorio() {
        return costoAmbulatorio;
    }

    @Column
    @Override
    public Double getCosto5() {
        return costo5;
    }

    @Column
    @Override
    public String getFormaDePago() {
        return formaDePago;
    }

    @Column
    @Override
    public String getCategoriaIva() {
        return categoriaIVA;
    }

    @Column
    @Override
    public Boolean getModulo() {
        return modulo;
    }

    @Column
    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public String getProvincia() {
        return provincia;
    }

    @Override
    public String getLocalidad() {
        return localidad;
    }

    @OneToOne(mappedBy = "obraSocial")
    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailWeb(String emailWeb) {
        this.emailWeb = emailWeb;
    }

    public void setCostoInternacion(Double costoInternacion) {
        this.costoInternacion = costoInternacion;
    }

    public void setCostoJornadaCompleta(Double costoJornadaCompleta) {
        this.costoJornadaCompleta = costoJornadaCompleta;
    }

    public void setCostoMediaJornada(Double costoMediaJornada) {
        this.costoMediaJornada = costoMediaJornada;
    }

    public void setCostoAmbulatorio(Double costoAmbulatorio) {
        this.costoAmbulatorio = costoAmbulatorio;
    }

    public void setCosto5(Double costo5) {
        this.costo5 = costo5;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public void setCategoriaIva(String categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }

    public void setModulo(Boolean modulo) {
        this.modulo = modulo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return getRazonSocial();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((ObraSocial) obj).getId();
    }

}
