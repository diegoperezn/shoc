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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author diego
 */
public class RequiredComboBox<T extends Object> extends JComboBox<T> implements IValidable {

    private JLabel relatedLabel;

    public RequiredComboBox() {
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
        boolean isEmpty = this.getSelectedItem() == null;

        if (isEmpty) {
            relatedLabel.setForeground(Color.RED);
        } else {
            relatedLabel.setForeground(Color.BLACK);
        }

        return !isEmpty;
    }

}
