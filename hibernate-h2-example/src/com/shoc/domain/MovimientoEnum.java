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
public enum MovimientoEnum {
 
    DEBITO("Debito"), CREDITO("Credito");

    private String detail;
    
    private MovimientoEnum(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return detail; 
    }
    
    
    
}
