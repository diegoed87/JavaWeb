package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSONAS database table.
 * 
 */
@Embeddable
public class PersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIPO_IDENTIFICACION")
	private String tipoIdentificacion;

	@Column(name="NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;

	public PersonaPK() {
	}
	
	
	
	public PersonaPK(String tipoIdentificacion, String numeroIdentificacion) {
		super();
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
	}



	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaPK)) {
			return false;
		}
		PersonaPK castOther = (PersonaPK)other;
		return 
			this.tipoIdentificacion.equals(castOther.tipoIdentificacion)
			&& this.numeroIdentificacion.equals(castOther.numeroIdentificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipoIdentificacion.hashCode();
		hash = hash * prime + this.numeroIdentificacion.hashCode();
		
		return hash;
	}
}