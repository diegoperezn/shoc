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
public class FacturaDetail {

    private Long id;
    private Factura factura;
    private Paciente paciente;
    private DispositivosEnum dispositivo;
    private Double costoDispositivo;
    private Integer dias;
    private Double monto;
    private Double alicuota;
    private Double montoFinal;
    private Date fecha;

    public FacturaDetail() {
    }

    public FacturaDetail(IFacturable f) {
        this.paciente = f.getPaciente();
        this.dispositivo = f.getDispositivo();
        if (f.getPaciente().getObraSocial() != null) {
            this.costoDispositivo = f.getPaciente().getObraSocial().getCosto(this.dispositivo);
        } else {
            this.costoDispositivo = Double.valueOf("0");
        }
        this.fecha = f.getFecha();
        this.alicuota = Double.valueOf("0.15");
        this.dias = 0;
        this.monto = Double.valueOf("0");
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn
    public Factura getFactura() {
        return factura;
    }

    @ManyToOne
    @JoinColumn
    public Paciente getPaciente() {
        return paciente;
    }

    @Column
    public DispositivosEnum getDispositivo() {
        return dispositivo;
    }

    @Column
    public Double getCostoDispositivo() {
        return costoDispositivo;
    }

    @Column
    public Integer getDias() {
        return dias;
    }

    @Column
    public Double getMonto() {
        return monto;
    }

    @Column
    public Date getFecha() {
        return fecha;
    }

    @Column
    public Double getAlicuota() {
        return alicuota;
    }

    @Column
    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setAlicuota(Double alicuota) {
        this.alicuota = alicuota;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setDispositivo(DispositivosEnum dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setCostoDispositivo(Double costoDispositivo) {
        this.costoDispositivo = costoDispositivo;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public void setMonto(Double monto) {
        if (monto != null) {
            this.monto = monto;
            this.montoFinal = this.monto + (this.monto * this.alicuota);
        }
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
