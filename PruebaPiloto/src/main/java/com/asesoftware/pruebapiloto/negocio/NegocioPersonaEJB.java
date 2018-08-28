package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.integracion.GestionPersonaDB;

/**
* Session Bean implementation class NegocioPersonaEJB
*/
@Stateless
@LocalBean
public class NegocioPersonaEJB {

	@EJB
	private GestionPersonaDB gestionPersonaDB;
	
	/**
     * Default constructor. 
     */
	public NegocioPersonaEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona  consultarPersonaPorId(PersonaPK personaPK) {
		return gestionPersonaDB.consultarPersonaPorId(personaPK);
	}
	
	public List<Persona> consultarPersonas(){
		return gestionPersonaDB.consultarPersonas();
	}
	
	public void eliminarPersona(PersonaPK personaPK) {
		gestionPersonaDB.eliminarPersona(personaPK);
	}
}
