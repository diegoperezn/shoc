/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author diego
 */
@Entity
public class Factura {

    private Long id;
    private List<FacturaDetail> details;
    private Paciente paciente;
    private ObraSocial obraSocial;
    private CuentaCorrienteMovimiento movimiento;
    private Date fecha;
    private Double total;

    public Factura() {
    }

    public Factura(Paciente p, ObraSocial ob, List<FacturaDetail> details) {
        this.details = details;
        this.details.forEach(d -> d.setFactura(this));
        this.paciente = p;
        this.obraSocial = ob;
        this.fecha = new Date();
        this.total = details.stream().mapToDouble(d -> d.getMonto()).sum();
        this.movimiento = new CuentaCorrienteMovimiento(this, ob.getCuenta());
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "factura")
    public List<FacturaDetail> getDetails() {
        return details;
    }

    @ManyToOne
    @JoinColumn
    public Paciente getPaciente() {
        return paciente;
    }

    @ManyToOne
    @JoinColumn
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @Column
    @Type(type = "date")
    @Temporal(TemporalType.DATE)
    public Date getFecha() {
        return fecha;
    }

    @OneToOne(mappedBy = "factura", cascade = CascadeType.ALL)
    public CuentaCorrienteMovimiento getMovimiento() {
        return movimiento;
    }

    @Column
    public Double getTotal() {
        return total;
    }

    public void setMovimiento(CuentaCorrienteMovimiento movimiento) {
        this.movimiento = movimiento;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDetails(List<FacturaDetail> details) {
        this.details = details;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
