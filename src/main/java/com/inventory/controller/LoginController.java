/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author hlargo
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    String usuario, clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String iniciarSesion() {
        System.out.println("iniciarSesion inventory");
        return "/inicio/principal?faces-redirect=true";
    }
    
    
}
