/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.afip.authen;

/**
 *
 * @author diego
 */
public class AfipAuthentification {
    
    private String token;
    private String sign;
    private String cuit;

    public AfipAuthentification(String token, String sign, String cuit) {
        this.token = token;
        this.sign = sign;
        this.cuit = cuit;
    }
    
    public AfipAuthentification(String token, String sign) {
        this.token = token;
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public String getToken() {
        return token;
    }

    public String getCuit() {
        return cuit;
    }
    
}
