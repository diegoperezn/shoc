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
public enum FacturaAfipEnum {

    FACTURA_A(1, "Factura A", "fac"), FACTURA_B(6, "Factura B", "cf"), FACTURA_C(6, "Factura C", "cf");

    private Integer codigo;
    private String descripcion;
    private String tipo;

    private FacturaAfipEnum(Integer codigo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Short getCodigo() {
        return Short.valueOf(String.valueOf(codigo));
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
