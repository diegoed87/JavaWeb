package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROCEDIMIENTOS database table.
 * 
 */
@Entity
@Table(name="PROCEDIMIENTOS")
@NamedQuery(name="Procedimiento.findAll", query="SELECT p FROM Procedimiento p")
public class Procedimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_PROCEDIMIENTO")
	private long codigoProcedimiento;

	private String descripcion;

	@Column(name="NOMBRE_PROCEDIMIENTO")
	private String nombreProcedimiento;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="procedimiento")
	private List<Cita> citas;

	public Procedimiento() {
	}

	public long getCodigoProcedimiento() {
		return this.codigoProcedimiento;
	}

	public void setCodigoProcedimiento(long codigoProcedimiento) {
		this.codigoProcedimiento = codigoProcedimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreProcedimiento() {
		return this.nombreProcedimiento;
	}

	public void setNombreProcedimiento(String nombreProcedimiento) {
		this.nombreProcedimiento = nombreProcedimiento;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setProcedimiento(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setProcedimiento(null);

		return cita;
	}

}