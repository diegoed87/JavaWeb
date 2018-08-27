package com.asesoftware.pruebapiloto.controlador;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.integracion.utils.PersonaFacadeLocal;

@Named
@ViewScoped
public class PersonaController {

	@EJB
	private PersonaFacadeLocal personaEJB;

	private Persona persona;
	
	@PostConstruct
	public void init() {
		persona = new Persona();
	}
	
	public void registrar() {
		try {
			personaEJB.create(persona);
		}catch (Exception e) {
			// Mensaje usando growl
		}
	}
	
}
