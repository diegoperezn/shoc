/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import java.util.List;

/**
 *
 * @author diego
 */
public class AfipException extends Exception {

    private final List<String> errores;

    public AfipException(List<String> codigoDescripcion) {
        this.errores = codigoDescripcion;
    }

    public List<String> getErrores() {
        return errores;
    }

}
