/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import com.shoc.domain.service.ICliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Paciente implements IPaciente, ICliente {

    // General
    private Long id;
    private Integer historiaClinica;
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
    private List<HistoricoDispositivo> historicoDispositivo = new ArrayList<>();
    private String fase;
    private Date ausencia;
    private Date egreso;
    private String causalEgreso;

    // Domicilio
    private String direccion;
    private String provincia;
    private String localidad;
    private String codigoPostal;

    private CuentaCorriente cuenta;

    public Paciente() {
        // this form used by Hibernate
    }

    /*
    public Paciente(IPaciente iPaciente) {
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
        this.changeDispositivoTerapia(iPaciente.getDispositivoTerapia());
        this.fase = iPaciente.getFase();
        this.ausencia = iPaciente.getAusencia();
        this.egreso = iPaciente.getEgreso();
        this.causalEgreso = iPaciente.getCausalEgreso();
        this.direccion = iPaciente.getDireccion();
        this.provincia = iPaciente.getProvincia();
        this.localidad = iPaciente.getLocalidad();
        this.codigoPostal = iPaciente.getCodigoPostal();
    }
     */
    public void actualizar(IPaciente iPaciente) {
        this.obraSocial = iPaciente.getObraSocial();
        if (this.obraSocial == null && this.cuenta == null) {
            this.cuenta = new CuentaCorriente(this);
        }

        this.historiaClinica = iPaciente.getHistoriaClinica();
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
        this.changeDispositivoTerapia(iPaciente.getDispositivoTerapia());
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

    public void setHistoricoDispositivo(List<HistoricoDispositivo> historicoDispositivo) {
        this.historicoDispositivo = historicoDispositivo;
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

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

    public void setHistoriaClinica(Integer historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }
    
    @Column
    @Override
    public Integer getHistoriaClinica() {
        return historiaClinica;
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

    @Override
    @Transient
    public DispositivosEnum getDispositivoTerapia() {
        return this.dispositivoActivo().getDispositivo();
    }

    @OrderBy("fechaCambio DESC")
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<HistoricoDispositivo> getHistoricoDispositivo() {
        return historicoDispositivo;
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

    private HistoricoDispositivo dispositivoActivo() {
        for (HistoricoDispositivo hist : historicoDispositivo) {
            if (hist.getFechaCambio() == null) {
                return hist;
            }
        }

        return null;
    }

    private void changeDispositivoTerapia(DispositivosEnum dispositivoTerapia) {
        if (this.historicoDispositivo.isEmpty()) {
            this.historicoDispositivo.add(new HistoricoDispositivo(
                    dispositivoTerapia, this));
        } else if (!this.historicoDispositivo.get(0).getDispositivo().equals(dispositivoTerapia)) {
            this.dispositivoActivo().setFechaCambio(new Date());
            this.historicoDispositivo.add(new HistoricoDispositivo(
                    dispositivoTerapia, this));
        }
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    @Transient
    public String getDomicilio() {
        String domicilio = new String();

        domicilio = direccion;

        if (provincia != null && !provincia.isEmpty()) {
            domicilio += " - " + provincia;
        }

        if (localidad != null && !localidad.isEmpty()) {
            domicilio += " - " + localidad;
        }

        return domicilio;
    }

    @Override
    @Transient
    public String getCategoriaIva() {
        return "Consumidor Final";
    }

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    public CuentaCorriente getCuenta() {
        return cuenta;
    }

}
