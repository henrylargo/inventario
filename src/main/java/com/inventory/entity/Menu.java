/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Hp
 */
@Entity
@Table(name = "menu", schema="desarrollo")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_menu")
    private String tipoMenu;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @JoinColumn(name = "codigo_menu")
    @ManyToOne
    private Menu codigoMenu;
    @Column(name = "estado")
    private String estado;
    @Column(name = "url")
    private String url;
    @Column(name = "icono")
    private String icono;
    @Column(name = "administrador")
    private String administrador;
    
    

    public Menu() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public Menu getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(Menu codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    
    
}
