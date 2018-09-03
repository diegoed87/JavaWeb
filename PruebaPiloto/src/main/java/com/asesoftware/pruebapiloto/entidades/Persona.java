package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="persona")
	private List<Vehiculo> vehiculos;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="persona1")
	private List<Cita> citas1;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="persona2")
	private List<Cita> citas2;

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

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setPersona(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setPersona(null);

		return vehiculo;
	}

	public List<Cita> getCitas1() {
		return this.citas1;
	}

	public void setCitas1(List<Cita> citas1) {
		this.citas1 = citas1;
	}

	public Cita addCitas1(Cita citas1) {
		getCitas1().add(citas1);
		citas1.setPersona1(this);

		return citas1;
	}

	public Cita removeCitas1(Cita citas1) {
		getCitas1().remove(citas1);
		citas1.setPersona1(null);

		return citas1;
	}

	public List<Cita> getCitas2() {
		return this.citas2;
	}

	public void setCitas2(List<Cita> citas2) {
		this.citas2 = citas2;
	}

	public Cita addCitas2(Cita citas2) {
		getCitas2().add(citas2);
		citas2.setPersona2(this);

		return citas2;
	}

	public Cita removeCitas2(Cita citas2) {
		getCitas2().remove(citas2);
		citas2.setPersona2(null);

		return citas2;
	}

}