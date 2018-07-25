/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.afip.shoc;

/**
 *
 * @author diego
 */
public enum ServicioAfipEnum {

    WSMTXCA("Afip con detalles", "wsmtxca"), WSFEV1("Afip sin detalles", "wsfev1");

    private String detail;
    private String servicio;

    private ServicioAfipEnum(String detail, String servicio) {
        this.detail = detail;
        this.servicio = servicio;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return detail;
    }

    public String getServicio() {
        return servicio;
    }

}
