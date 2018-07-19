/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.h2.util.StringUtils;

/**
 *
 * @author diego
 */
public class RequiredTextfield extends JTextField implements IValidable {

    private JLabel relatedLabel = null;
    private boolean checkNumeric = false;

    public RequiredTextfield(Boolean checkNumeric) {
        this.checkNumeric = checkNumeric;
        addListener();
    }

    private void addListener() {
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

    public RequiredTextfield() {
        addListener();
    }

    public void setCheckNumeric(boolean checkNumeric) {
        this.checkNumeric = checkNumeric;
    }

    public void setLabel(JLabel label) {
        this.relatedLabel = label;
    }

    public boolean valid() {
        boolean isValid = !this.getText().isEmpty();
        isValid = isValid && checkNumeric();

        if (relatedLabel != null) {
            if (isValid) {
                relatedLabel.setForeground(Color.BLACK);
            } else {
                relatedLabel.setForeground(Color.RED);
            }
        }
        
        return isValid;
    }

    private boolean checkNumeric() {
        if (!checkNumeric) {
            return true;
        }
        Boolean valid = true;

        try {
            Double.valueOf(this.getText());
        } catch (Exception e) {
            valid = false;
        }

        return valid;
    }

}
