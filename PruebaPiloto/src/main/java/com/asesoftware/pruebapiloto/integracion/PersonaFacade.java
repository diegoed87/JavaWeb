package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.integracion.utils.PersonaFacadeLocal;
import com.asesoftware.pruebapiloto.integracion.utils.ManejadorCrud;

@Stateless
public class PersonaFacade extends ManejadorCrud<Persona> implements PersonaFacadeLocal{

	@PersistenceContext(unitName="PruebaPiloto")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public PersonaFacade() {
		super(Persona.class);
	}

	@Override
	public List<Persona> findRange(int[] range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
