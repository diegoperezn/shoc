/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface IPaciente {

    Date getAusencia();

    Date getCambioDispositivo();

    String getCausalEgreso();

    String getCelular();

    String getCodigoPostal();

    String getDireccion();

    String getDispositivo();

    DispositivosEnum getDispositivoTerapia();

    String getDocumento();

    Date getEgreso();

    String getEmail();

    String getFase();

    Boolean getGravado();

    Long getId();
    
    Integer getHistoriaClinica();

    Date getIngreso();

    String getLocalidad();

    String getNombre();

    ObraSocial getObraSocial();

    String getObservaciones();

    String getProvincia();

    String getResponsable();

    String getTelefono();

    String getTerapista();

    Date getVencimientoBeca();

}
