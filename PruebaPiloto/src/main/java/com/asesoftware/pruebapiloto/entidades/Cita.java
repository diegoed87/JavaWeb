package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CITAS database table.
 * 
 */
@Entity
@Table(name="CITAS")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "CODIGO")
	@SequenceGenerator(name="CODIGO" , sequenceName="SEQ_CITA",allocationSize = 1 )
	@Column(name="CODIGO")
	private long codigo;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CITA")
	private Date fechaCita;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	private String observaciones;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="MECANICO_NUMERO_IDENTIFICACION", referencedColumnName="NUMERO_IDENTIFICACION"),
		@JoinColumn(name="MECANICO_TIPO_IDENTIFICACION", referencedColumnName="TIPO_IDENTIFICACION")
		})
	private Persona persona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CLIENTE_NUMERO_IDENTIFICACION", referencedColumnName="NUMERO_IDENTIFICACION"),
		@JoinColumn(name="CLIENTE_TIPO_IDENTIFICACION", referencedColumnName="TIPO_IDENTIFICACION")
		})
	private Persona persona2;

	//bi-directional many-to-one association to Procedimiento
	@ManyToOne
	@JoinColumn(name="CODIGO_PROCEDIMIENTO")
	private Procedimiento procedimiento;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="PLACA")
	private Vehiculo vehiculo;

	public Cita() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Persona getPersona1() {
		return this.persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return this.persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

	public Procedimiento getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}