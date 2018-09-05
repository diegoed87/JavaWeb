package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the VEHICULOS database table.
 * 
 */
@Entity
@Table(name="VEHICULOS")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String placa;

	private BigDecimal año;

	private String color;

	private BigDecimal kilometraje;

	private String marca;

	private String modelo;

	@Column(name="TIPO_VEHICULO")
	private String tipoVehiculo;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="vehiculo")
	private List<Cita> citas;

	//bi-directional many-to-one association to LocalidadesGeografica
	@ManyToOne
	@JoinColumn(name="CIUDAD")
	private LocalidadesGeografica localidadesGeografica;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CLIENTE_NUMERO_IDENTIFICACION", referencedColumnName="NUMERO_IDENTIFICACION"),
		@JoinColumn(name="CLIENTE_TIPO_IDENTIFICACION", referencedColumnName="TIPO_IDENTIFICACION")
		})
	private Persona persona;

	public Vehiculo() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getAño() {
		return this.año;
	}

	public void setAño(BigDecimal año) {
		this.año = año;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(BigDecimal kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setVehiculo(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setVehiculo(null);

		return cita;
	}

	public LocalidadesGeografica getLocalidadesGeografica() {
		return this.localidadesGeografica;
	}

	public void setLocalidadesGeografica(LocalidadesGeografica localidadesGeografica) {
		this.localidadesGeografica = localidadesGeografica;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}