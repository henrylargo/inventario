/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.controller;

import com.inventory.entity.Usuario;
import com.inventory.service.UsuarioService;
import com.inventory.util.Util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

/**
 *
 * @author hlargo
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    String usuario, clave;
    
    @EJB
    UsuarioService usuarioService;
    
    public String iniciarSesion() {
        System.out.println("iniciarSesion inventory");
        String redireccion = null;
        try {
            Map<String, Object> criterios = new HashMap<>();
            criterios.put("usuario", getUsuario());
            criterios.put("clave", getClave());
            System.out.println("Valores ingresados:  usuario:  " + getUsuario() + "     clave:   " + getClave());
            Usuario usuario = usuarioService.obtenerUsuario(criterios);
            //setUsuariologueado(usuarioService.obtenerUsuario(criterios));
            //if (!Util.esNulo(getUsuariologueado()) && !Util.esVacio(getUsuariologueado())) {
            if (!Util.esNulo(usuario) && !Util.esVacio(usuario)) {
                //setUsuarioSesion(getUsuariologueado().getUsuario());
                //setEmpresaSesion(getUsuariologueado().getCodigoEmpresa().getNombre());
                //System.out.println("usuario sesion:   " + getUsuarioSesion());
                //System.out.println("empresa sesion:   " + getEmpresaSesion());
                //System.out.println("usuario logueado:   " + getUsuariologueado().toString());
                System.out.println("usuario inicia sesion:  " + usuario.toString());
                redireccion = "/inicio/principal?faces-redirect=true";
            }
        } catch (NoResultException e) {
            System.out.println("Error:  " + e.getMessage());
        }
        return redireccion;
    }
    

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
    
    
    
    
}
