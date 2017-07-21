package com.inventory.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author Hp
 */
@Entity
@Table(name = "empresa", schema="desarrollo")
public class Empresa implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEmpresa")
    private Collection<Usuario> usuarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
//    @SequenceGenerator(name="EMPRESA_CODIGO_GENERATOR", sequenceName="SEQ_EMPRESA")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPRESA_CODIGO_GENERATOR")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Persona identificacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "estado")
    private String estado;

    public Empresa() {
    }

    public Empresa(Long codigo) {
        this.codigo = codigo;
    }

    public Empresa(Long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Persona getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Persona identificacion) {
        this.identificacion = identificacion;
    }
    
    

    @Override
    public String toString() {
        return "Empresa{" + "codigo=" + codigo + ", nombre=" + nombre + ", fechaRegistro=" + fechaRegistro + ", fechaActualizacion=" + fechaActualizacion + ", estado=" + estado + '}';
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }
    
}