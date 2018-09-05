package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.Persona;

	@Stateless
	@LocalBean
	public class GestionUsuarioBD {
	    public void GestionUserBD() {
	        // TODO Auto-generated constructor stub
	    }
	    @PersistenceContext
	    private EntityManager entityManager;
	    	        
	    public List<Persona> consultarUser(){
	    	Query queryConsultaUser = entityManager.createQuery("select p from Persona p");
	    	return queryConsultaUser.getResultList();
	    }    
	    
	    public Persona consultarPersonaPorUsuario(String usuario){
	    	Persona persona = null;
	    	try{
	    		persona = (Persona) entityManager.createQuery("select p from Persona p where p.usuario = '"+usuario+"'").getSingleResult();
	    		System.out.println("-----> "+persona.getNombrePersona()+" "+persona.getContrasenia());
	    	}catch (Exception e) {
				System.out.println("Ocurrio un error "+e.getMessage());
			}
	    	return persona;
	    }
	   
	   
}