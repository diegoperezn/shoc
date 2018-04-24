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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
    private Double subtotal;
    private Double importeNoGravado;
    private Double importeGravado;
    private String cae;
    private String tipoComprobante;
    private Integer numeroComprobante;
    private String puntoDeVenta;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String sociedad;
    private Double montoIva;

    public Factura() {
    }

    public Factura(Paciente p, ObraSocial ob, List<FacturaDetail> details) {
        this.details = details;
        this.details.forEach(d -> d.setFactura(this));
        this.paciente = p;
        this.fecha = new Date();

        this.subtotal = details.stream().mapToDouble(d -> d.getMonto()).sum();
        this.importeNoGravado = details.stream().mapToDouble(d -> d.isGravado() ? 0 : d.getMonto()).sum();
        this.importeGravado = details.stream().mapToDouble(d -> d.isGravado() ? d.getMonto() : 0).sum();
        this.montoIva = details.stream().mapToDouble(d -> d.isGravado() ? d.getMontoAlicuota() : 0).sum();
        this.total = details.stream().mapToDouble(d -> d.getMontoFinal()).sum();

        this.obraSocial = ob;
        if (ob != null) {
            this.movimiento = new CuentaCorrienteMovimiento(this, ob.getCuenta());
        } else {
            this.movimiento = new CuentaCorrienteMovimiento(this, p.getCuenta());
        }
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
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

    @OneToOne(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    public CuentaCorrienteMovimiento getMovimiento() {
        return movimiento;
    }

    @Column
    public Double getTotal() {
        return total;
    }

    @Column
    public String getTipoComprobante() {
        return tipoComprobante;
    }

    @Column
    public Date getFechaEmision() {
        return fechaEmision;
    }

    @Column
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Column
    public Integer getNumeroComprobante() {
        return numeroComprobante;
    }

    @Column
    public Double getMontoIva() {
        return montoIva;
    }

    
    
    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
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

    @Column
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Column
    public Double getImporteNoGravado() {
        return importeNoGravado;
    }

    public void setImporteNoGravado(Double importeNoGravado) {
        this.importeNoGravado = importeNoGravado;
    }

    @Column
    public Double getImporteGravado() {
        return importeGravado;
    }

    public void setImporteGravado(Double importeGravado) {
        this.importeGravado = importeGravado;
    }

    @Column
    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    /**
     * @param tipoComprobante the tipoComprobante to set
     */
    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Column
    public String getPuntoDeVenta() {
        return puntoDeVenta;
    }
    
    public void setPuntoDeVenta(String puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    } 
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Column
    public String getSociedad() {
        return sociedad;
    }

    public void setSociedad(String sociedad) {
        this.sociedad = sociedad;
    }

    public boolean eviadaAfip() {
        return this.cae != null;
    }

    /**
     * @param montoIva the montoIva to set
     */
    public void setMontoIva(Double montoIva) {
        this.montoIva = montoIva;
    }

    @Transient
    public String getNumeroComprobanteFactura() {
        return String.format("%08d", numeroComprobante);
    }
    
}
