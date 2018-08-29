package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.asesoftware.pruebapiloto.entidades.LocalidadesGeografica;
import com.asesoftware.pruebapiloto.negocio.NegocioLocalidadesGeograficasEJB;

@ViewScoped
@ManagedBean
public class LocalidadGeograficaMB {

	private LocalidadesGeografica localidadesGeografica;
	private List<LocalidadesGeografica> ciudades;
	
	@EJB
	private NegocioLocalidadesGeograficasEJB negocioLocalidadesGeograficasEJB;
	
	@PostConstruct
	public void init() {
		this.localidadesGeografica = new LocalidadesGeografica();
		this.ciudades = new ArrayList<>();
		this.consultarCiudades();
	}
	
	public void consultarCiudades() {
		this.ciudades = negocioLocalidadesGeograficasEJB.consultarTodasCiudades();
	}

	public LocalidadesGeografica getLocalidadesGeografica() {
		return localidadesGeografica;
	}

	public void setLocalidadesGeografica(LocalidadesGeografica localidadesGeografica) {
		this.localidadesGeografica = localidadesGeografica;
	}

	public List<LocalidadesGeografica> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<LocalidadesGeografica> ciudades) {
		this.ciudades = ciudades;
	}
	
	
	
}
