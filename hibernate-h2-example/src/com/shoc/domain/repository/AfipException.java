/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import java.util.List;

/**
 *
 * @author diego
 */
public class AfipException extends Exception {

    private final List<CodigoDescripcionType> errores;

    public AfipException(List<CodigoDescripcionType> codigoDescripcion) {
        this.errores = codigoDescripcion;
    }

    public List<CodigoDescripcionType> getErrores() {
        return errores;
    }

}
