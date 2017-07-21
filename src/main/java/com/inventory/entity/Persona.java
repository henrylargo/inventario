package com.inventory.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "persona", schema="desarrollo")
public class Persona implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionRegistra")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionUsuario")
    private Collection<Usuario> usuarioCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacion")
    private Collection<Empresa> empresaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono_domicilio")
    private String telefonoDomicilio;
    @Column(name = "telefono_celular")
    private String telefonoCelular;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "codigo_ubicacion", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Ubicacion codigoUbicacion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "estado")
    private String estado;

    public Persona() {
    }

    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ubicacion getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(Ubicacion codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefonoDomicilio=" + telefonoDomicilio + ", telefonoCelular=" + telefonoCelular + ", fechaNacimiento=" + fechaNacimiento + ", codigoUbicacion=" + codigoUbicacion + ", direccion=" + direccion + ", correo=" + correo + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + '}';
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection1() {
        return usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

}