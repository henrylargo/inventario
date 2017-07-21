/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "ubicacion", schema="desarrollo")
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel")
    private long nivel;
    @Column(name = "estado")
    private String estado;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="codigo_ubicacion")
    private Ubicacion codigoUbicacion;

    public Ubicacion() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    public Ubicacion getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(Ubicacion codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Ubicacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", nivel=" + nivel + ", codigoUbicacion=" + codigoUbicacion + "'}'";
    }

}