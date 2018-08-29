package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;

@Stateless
@LocalBean
public class GestionPersonaDB {

	@PersistenceContext
	private EntityManager em;
	
	public GestionPersonaDB() {
		// TODO Auto-generated constructor stub
	}
	
	public void guardarPerson(Persona persona) {
		em.persist(persona);		
	}
	
	public void eliminarPersona(PersonaPK personaPK) {
		try {
			Persona persona = em.find(Persona.class, personaPK);
			em.remove(persona);
		}catch (Exception e) {
			System.out.println("Ocurrio un error al eliminar la persona");
			e.getMessage();
			e.getCause();
		}
	}
	
	/**
	 * MÉTODO QUE DEVUELVE LA LISTA DE TODAS LAS PERSONAS
	 * @return LISTA DE PERSONAS
	 */
	@SuppressWarnings("unchecked")
	public List<Persona> consultarPersonas(){
		Query queryConsultarPersonas = em.createQuery("select p from Persona p");
		return queryConsultarPersonas.getResultList();
	}
	
	public Persona consultarPersonaPorId(PersonaPK personaPK) {
		Persona persona = null;
		try {
			persona = em.find(Persona.class, personaPK);
		}catch (Exception e) {
			System.out.println("Ocurrio un error al consultar la persona ");
		}
		return persona;
	}
	
	

}
