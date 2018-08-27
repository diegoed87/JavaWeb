package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PERSONAS database table.
 * 
 */
@Entity
@Table(name="PERSONAS")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	@Column(name="APELLIDO_PERSONA")
	private String apellidoPersona;

	private String contrasenia;

	private String correo;

	private String direccion;

	private BigDecimal edad;

	@Column(name="NOMBRE_PERSONA")
	private String nombrePersona;

	private String telefono;

	@Column(name="TIPO_PERSONA")
	private String tipoPersona;

	private String usuario;

	//bi-directional many-to-one association to LocalidadesGeografica
	@ManyToOne
	@JoinColumn(name="LOCGEO_CODIGO")
	private LocalidadesGeografica localidadesGeografica;

	public Persona() {
	}

	public PersonaPK getId() {
		return this.id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getApellidoPersona() {
		return this.apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getEdad() {
		return this.edad;
	}

	public void setEdad(BigDecimal edad) {
		this.edad = edad;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public LocalidadesGeografica getLocalidadesGeografica() {
		return this.localidadesGeografica;
	}

	public void setLocalidadesGeografica(LocalidadesGeografica localidadesGeografica) {
		this.localidadesGeografica = localidadesGeografica;
	}

}