package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.LocalidadesGeografica;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.integracion.GestionLocalidadesGeograficasBD;

@Stateless
@LocalBean
public class NegocioLocalidadesGeograficasEJB {

	@EJB
	private GestionLocalidadesGeograficasBD gestionLocalidadesGeograficasBD;
	

	/**
     * Default constructor. 
     */
	public NegocioLocalidadesGeograficasEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public LocalidadesGeografica consultarLocalidadPorId(Long codigo) {
		return gestionLocalidadesGeograficasBD.consultarLocalidadPorId(codigo);
	}
	
	public List<LocalidadesGeografica> consultarTodasCiudades(){
		return gestionLocalidadesGeograficasBD.consultarTodasCiudades();
	}
	
	
}
