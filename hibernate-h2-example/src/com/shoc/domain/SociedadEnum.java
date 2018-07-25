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

    CENTRO_SHOC("S.H.O.C. Centro SRL", "30712346139"), TIZZIANO("Tizziano Valentini Asociación Civil", "30714891096");

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
