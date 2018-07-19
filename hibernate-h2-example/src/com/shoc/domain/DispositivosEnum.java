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
public enum DispositivosEnum {

    INTERNACION("Internacion"), HDJC("htal. de día jor. comp."), HDMC("Hosp. dia media jornada"), AMBULATORIO("Ambulatorio"), DISPOSITIVO("Consultorios externos");

    private String detail;

    private DispositivosEnum(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return detail;
    }

}
