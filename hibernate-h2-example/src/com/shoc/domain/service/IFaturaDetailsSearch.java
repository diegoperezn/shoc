/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import java.util.Date;

/**
 *
 * @author diego
 */
public interface IFaturaDetailsSearch {
    
    public Paciente getPaciente();
    
    public ObraSocial getObraSocial();
    
    public Date getMes();
    
    public Boolean getFacturado();
}
