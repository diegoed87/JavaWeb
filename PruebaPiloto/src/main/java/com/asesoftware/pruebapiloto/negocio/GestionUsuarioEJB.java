package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.integracion.GestionUsuarioBD;

@Stateless
@LocalBean

public class GestionUsuarioEJB {
	
	public GestionUsuarioEJB(){
		
	}
	
	@EJB
    private GestionUsuarioBD gestionUsuarioBD;

	public List<Persona> consultarUser(){
	    	 return gestionUsuarioBD.consultarUser();
	}
	
	public Persona consultarPersonaPorUsuario(String usuario){
		return gestionUsuarioBD.consultarPersonaPorUsuario(usuario);
	}
	
}
