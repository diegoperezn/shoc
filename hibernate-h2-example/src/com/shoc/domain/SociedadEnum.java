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
public enum SociedadEnum {

    CENTRO_SHOC("Centro Shoc", "20103962545"), TIZZIANO("Tizziano", "20103962545");

    private String detail;
    private String cuit;

    private SociedadEnum(String detail, String cuit) {
        this.detail = detail;
        this.cuit = cuit;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return detail;
    }

    public String getCuit() {
        return cuit;
    }

}
