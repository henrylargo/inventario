/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "usuario", schema="desarrollo")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    @Column(name = "clave_modificada")
    private String claveModificada;
    
    @Column(name = "estado")
    private String estado;
    
    @JoinColumn(name = "codigo_empresa", referencedColumnName = "codigo")
    @OneToOne(optional = false)
    private Empresa codigoEmpresa;
    
    @JoinColumn(name = "identificacion_registra", referencedColumnName = "identificacion")
    @OneToOne(optional = false)
    private Persona identificacionRegistra;
    
    @JoinColumn(name = "identificacion_usuario", referencedColumnName = "identificacion")
    @OneToOne(optional = false)
    private Persona identificacionUsuario;

    public Usuario() {
        
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getClaveModificada() {
        return claveModificada;
    }

    public void setClaveModificada(String claveModificada) {
        this.claveModificada = claveModificada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Empresa codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Persona getIdentificacionRegistra() {
        return identificacionRegistra;
    }

    public void setIdentificacionRegistra(Persona identificacionRegistra) {
        this.identificacionRegistra = identificacionRegistra;
    }

    public Persona getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(Persona identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", usuario=" + usuario + ", clave=" + clave + ", fechaRegistro=" + fechaRegistro + ", claveModificada=" + claveModificada + ", estado=" + estado + ", codigoEmpresa=" + codigoEmpresa + ", identificacionRegistra=" + identificacionRegistra + ", identificacionUsuario=" + identificacionUsuario + '}';
    }

}