/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author diego
 */
public class RequiredDatePicker extends JXDatePicker implements IValidable {

    private JLabel relatedLabel;

    public RequiredDatePicker() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                valid();
            }
        });

    }

    public void setLabel(JLabel label) {
        this.relatedLabel = label;
    }

    public boolean valid() {
        boolean isEmpty = this.getDate() == null;

        if (isEmpty) {
            relatedLabel.setForeground(Color.RED);
        } else {
            relatedLabel.setForeground(Color.BLACK);
        }

        return !isEmpty;
    }

}
