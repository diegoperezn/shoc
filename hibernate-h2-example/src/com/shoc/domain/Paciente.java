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
import javax.persistence.ManyToOne;

/**
 *
 * @author diego
 */
@Entity
public class Paciente implements IPaciente {

    // General
    private Long id;
    private String nombre;
    private String documento;
    private String observaciones;
    private Boolean gravado;

    // Contacto
    private String celular;
    private String telefono;
    private String email;
    private String responsable;

    // Costos
    private Date ingreso;
    private Date vencimientoBeca;
    private String terapista;
    private ObraSocial obraSocial;
    private String dispositivo;
    private Date cambioDispositivo;
    private DispositivosEnum dispositivoTerapia;
    private String fase;
    private Date ausencia;
    private Date egreso;
    private String causalEgreso;

    // Domicilio
    private String direccion;
    private String provincia;
    private String localidad;
    private String codigoPostal;

    public Paciente() {
        // this form used by Hibernate
    }

    public Paciente(IPaciente iPaciente) {
        this.id = iPaciente.getId();
        this.nombre = iPaciente.getNombre();
        this.documento = iPaciente.getDocumento();
        this.observaciones = iPaciente.getObservaciones();
        this.gravado = iPaciente.getGravado();
        this.celular = iPaciente.getCelular();
        this.telefono = iPaciente.getTelefono();
        this.email = iPaciente.getEmail();
        this.responsable = iPaciente.getResponsable();
        this.ingreso = iPaciente.getIngreso();
        this.vencimientoBeca = iPaciente.getVencimientoBeca();
        this.terapista = iPaciente.getTerapista();
        this.obraSocial = iPaciente.getObraSocial();
        this.dispositivo = iPaciente.getDispositivo();
        this.cambioDispositivo = iPaciente.getCambioDispositivo();
        this.dispositivoTerapia = iPaciente.getDispositivoTerapia();
        this.fase = iPaciente.getFase();
        this.ausencia = iPaciente.getAusencia();
        this.egreso = iPaciente.getEgreso();
        this.causalEgreso = iPaciente.getCausalEgreso();
        this.direccion = iPaciente.getDireccion();
        this.provincia = iPaciente.getProvincia();
        this.localidad = iPaciente.getLocalidad();
        this.codigoPostal = iPaciente.getCodigoPostal();
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setGravado(Boolean gravado) {
        this.gravado = gravado;
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

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public void setVencimientoBeca(Date vencimientoBeca) {
        this.vencimientoBeca = vencimientoBeca;
    }

    public void setTerapista(String terapista) {
        this.terapista = terapista;
    }

    public void setObraSocial(ObraSocial ObraSocial) {
        this.obraSocial = ObraSocial;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setCambioDispositivo(Date cambioDispositivo) {
        this.cambioDispositivo = cambioDispositivo;
    }

    public void setDispositivoTerapia(DispositivosEnum dispositivoTerapia) {
        this.dispositivoTerapia = dispositivoTerapia;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public void setAusencia(Date ausencia) {
        this.ausencia = ausencia;
    }

    public void setEgreso(Date egreso) {
        this.egreso = egreso;
    }

    public void setCausalEgreso(String causalEgreso) {
        this.causalEgreso = causalEgreso;
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

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }

    @Column
    @Override
    public String getNombre() {
        return nombre;
    }

    @Column
    @Override
    public String getDocumento() {
        return documento;
    }

    @Column
    @Override
    public String getObservaciones() {
        return observaciones;
    }

    @Column
    @Override
    public Boolean getGravado() {
        return gravado;
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
    public String getResponsable() {
        return responsable;
    }

    @Column
    @Override
    public Date getIngreso() {
        return ingreso;
    }

    @Column
    @Override
    public Date getVencimientoBeca() {
        return vencimientoBeca;
    }

    @Column
    @Override
    public String getTerapista() {
        return terapista;
    }

    @ManyToOne
    @Override
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @Column
    @Override
    public String getDispositivo() {
        return dispositivo;
    }
    

    @Column
    @Override
    public Date getCambioDispositivo() {
        return cambioDispositivo;
    }

    @Column
    @Override
    public DispositivosEnum getDispositivoTerapia() {
        return dispositivoTerapia;
    }

    @Column
    @Override
    public String getFase() {
        return fase;
    }

    @Column
    @Override
    public Date getAusencia() {
        return ausencia;
    }

    @Column
    @Override
    public Date getEgreso() {
        return egreso;
    }

    @Column
    @Override
    public String getCausalEgreso() {
        return causalEgreso;
    }

    @Column
    @Override
    public String getDireccion() {
        return direccion;
    }

    @Column
    @Override
    public String getProvincia() {
        return provincia;
    }

    @Column
    @Override
    public String getLocalidad() {
        return localidad;
    }

    @Column
    @Override
    public String getCodigoPostal() {
        return codigoPostal;
    }


}
