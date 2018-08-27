package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the LOCALIDADES_GEOGRAFICAS database table.
 * 
 */
@Entity
@Table(name="LOCALIDADES_GEOGRAFICAS")
@NamedQuery(name="LocalidadesGeografica.findAll", query="SELECT l FROM LocalidadesGeografica l")
public class LocalidadesGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;

	@Column(name="LOCGEO_PADRE")
	private BigDecimal locgeoPadre;

	private String nombre;

	@Column(name="TIPO_LOC")
	private String tipoLoc;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="localidadesGeografica")
	private List<Persona> personas;

	public LocalidadesGeografica() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getLocgeoPadre() {
		return this.locgeoPadre;
	}

	public void setLocgeoPadre(BigDecimal locgeoPadre) {
		this.locgeoPadre = locgeoPadre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoLoc() {
		return this.tipoLoc;
	}

	public void setTipoLoc(String tipoLoc) {
		this.tipoLoc = tipoLoc;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setLocalidadesGeografica(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setLocalidadesGeografica(null);

		return persona;
	}

}