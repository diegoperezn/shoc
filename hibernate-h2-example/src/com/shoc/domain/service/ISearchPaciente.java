/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface ISearchPaciente {
    
    public String getNombre();
    public Boolean getActivo();
    public Date getDesdeBaja();
    public Date getHastaBaja();
            
}
