/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels.componentes;

import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public interface IValidable {
    
    public boolean valid();
    
    public void setLabel(JLabel label);
    
}
