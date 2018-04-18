/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author diego
 */
public class DateUtils {

    public static Calendar getMinimaFecha() {
        Date fecha = new Date();

        return getMinimaFecha(fecha);
    }

    public static Calendar getMinimaFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);

        //cal.add(Calendar.MONTH, -2);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;
    }

    public static Calendar getMinimaFechaMesSiguiente(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);

        cal.add(Calendar.MONTH, 1);

        return cal;
    }

    public static boolean esMismoMes(Date fechaCambio, Date desde) {
        return DateUtils.getMinimaFecha(fechaCambio).equals(DateUtils.getMinimaFecha(desde));
    }

    public static Calendar getMaximaFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        
        return cal;
    }

}
