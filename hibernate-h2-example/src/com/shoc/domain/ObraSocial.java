/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author diego
 */
@Entity
public class ObraSocial {

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
    /*
    private Double costoInternacion;
    private Double costoJornadaCompleta;
    private Double costoMediaJornada;
    private Double costoAmbulatorio;
    private Double costo5;
     */
    private List<Dispositivo> dispositivos = new ArrayList<>();

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

    public void actualizar(IObraSocial i) {
        if (this.cuenta == null) {
            this.cuenta = new CuentaCorriente(this);
        }

        this.id = i.getId();
        this.razonSocial = i.getRazonSocial();
        this.cuit = i.getCuit();
        this.requerimiento = i.getRequerimiento();
        this.responsable = i.getResponsable();
        this.celular = i.getCelular();
        this.telefono = i.getTelefono();
        this.email = i.getEmail();
        this.emailWeb = i.getEmailWeb();

        this.setCosto(DispositivosEnum.INTERNACION, i.getCostoInternacion());
        this.setCosto(DispositivosEnum.HDJC, i.getCostoJornadaCompleta());
        this.setCosto(DispositivosEnum.HDMC, i.getCostoMediaJornada());
        this.setCosto(DispositivosEnum.AMBULATORIO, i.getCostoAmbulatorio());
        this.setCosto(DispositivosEnum.DISPOSITIVO, i.getCosto5());

        this.formaDePago = i.getFormaDePago();
        this.categoriaIVA = i.getCategoriaIva();
        this.modulo = i.getModulo();
        this.direccion = i.getDireccion();
        this.provincia = i.getProvincia();
        this.localidad = i.getLocalidad();
    }

    @Id
    @GeneratedValue

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

    @OneToMany(mappedBy = "obraSocial", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Column
    public String getRazonSocial() {
        return razonSocial;
    }

    @Column
    public String getCuit() {
        return cuit;
    }

    @Column
    public String getResponsable() {
        return responsable;
    }

    @Column
    public String getRequerimiento() {
        return requerimiento;
    }

    @Column
    public String getCelular() {
        return celular;
    }

    @Column
    public String getTelefono() {
        return telefono;
    }

    @Column
    public String getEmail() {
        return email;
    }

    @Column
    public String getEmailWeb() {
        return emailWeb;
    }

    @Column
    public String getFormaDePago() {
        return formaDePago;
    }

    @Column
    public String getCategoriaIva() {
        return categoriaIVA;
    }

    @Column
    public Boolean getModulo() {
        return modulo;
    }

    @Column
    public String getDireccion() {
        return direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    @OneToOne(mappedBy = "obraSocial", cascade = CascadeType.ALL)
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

    public Double getCosto(DispositivosEnum dispositivo) {
        for (Dispositivo disp : dispositivos) {
            if (dispositivo.equals(disp.getDispositivo())) {
                return disp.getCosto();
            }
        }

        return Double.valueOf("0");
    }

    public void setCosto(DispositivosEnum dispositivo, Double costo) {
        Boolean edited = false;

        for (Dispositivo disp : dispositivos) {
            if (dispositivo.equals(disp.getDispositivo())) {
                disp.setCosto(costo);
                edited = true;

                break;
            }
        }

        if (!edited) {
            dispositivos.add(new Dispositivo(this, costo, dispositivo));
        }
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
        if (obj == null) {
            return false;
        }
        
        return this.getId() == ((ObraSocial) obj).getId();
    }

}
