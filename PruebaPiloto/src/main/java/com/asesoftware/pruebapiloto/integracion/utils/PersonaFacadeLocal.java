package com.asesoftware.pruebapiloto.integracion.utils;

import java.util.List;

import javax.ejb.Local;

import com.asesoftware.pruebapiloto.entidades.Persona;



@Local
public interface PersonaFacadeLocal {
	
	void create(Persona persona);
	
	void edit(Persona persona);
	
	void remove(Persona persona);
	
	Persona find(Object id);
	
	List<Persona> findAll();
	
	List<Persona> findRange(int [] rangs);
	
	int count();

}
