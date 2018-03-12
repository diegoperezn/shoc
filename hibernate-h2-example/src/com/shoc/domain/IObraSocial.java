/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

/**
 *
 * @author diego
 */
public interface IObraSocial {

    Long getId();

    String getRazonSocial();

    String getCuit();
    
    String getResponsable();
    
    String getRequerimiento();
    
    String getCelular();
    
    String getTelefono();
    
    String getEmail();
    
    String getEmailWeb();
    
    Double getCostoInternacion();
    
    Double getCostoJornadaCompleta();
    
    Double getCostoMediaJornada();
    
    Double getCostoAmbulatorio();
    
    Double getCosto5();
    
    String getFormaDePago();
    
    String getCategoriaIva();
    
    Boolean getModulo();
    
    String getDireccion();
    
    String getProvincia();
    
    String getLocalidad();
}
