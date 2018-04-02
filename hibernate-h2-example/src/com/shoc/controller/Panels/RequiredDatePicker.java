/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author diego
 */
public class RequiredDatePicker extends JXDatePicker implements IValidable {

    public RequiredDatePicker() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                valid();
            }
        }) ;
    
    }

    public boolean valid() {
        boolean isEmpty = this.getDate() == null;

        if (isEmpty) {
            Border border = BorderFactory.createLineBorder(Color.red);
            this.setBorder(border);
        } else {
            this.setBorder(null);
        }

        return !isEmpty;
    }

    
    
}
