package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.negocio.NegocioPersonaEJB;

@ViewScoped
@ManagedBean
public class PersonaMB {

	private Persona persona;
	private List<Persona> personas;
	
	
	@EJB
	private NegocioPersonaEJB negocioPersonaEJB;
	
	@PostConstruct
	public void init() {
		this.persona = new Persona();
		this.personas = new ArrayList<>();
		this.consultarPersonas();
	}
	
	public void eliminarPersona(PersonaPK personaPk) {
		System.out.println("Eliminando Persona");
		Persona aux =  this.negocioPersonaEJB.consultarPersonaPorId(personaPk);
		this.negocioPersonaEJB.eliminarPersona(personaPk);
		this.consultarPersonas();
		mostrarMensaje(aux.getNombrePersona()+ " Eliminado");
		aux = null;
	}
	
	
	
	public void consultarPersonas() {
		this.personas = negocioPersonaEJB.consultarPersonas();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public void mostrarMensaje(String textoMensaje){
		FacesMessage mensajeApp = new FacesMessage(textoMensaje);
		FacesContext.getCurrentInstance().addMessage(null, mensajeApp);
	}
	
	public void mensaje() {
		System.out.println("Boton sirviendo....");
	}
	
	
	
}
