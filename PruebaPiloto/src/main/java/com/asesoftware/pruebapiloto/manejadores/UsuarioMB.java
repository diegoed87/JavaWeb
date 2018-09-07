package com.asesoftware.pruebapiloto.manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.negocio.GestionUsuarioEJB;

@ViewScoped
@ManagedBean

public class UsuarioMB{
	
	private Persona user;
	private List<Persona> listaUser;
	private List<String> listanombres;
	private String usuario = "";
	private String contrasenia = "";
	
	
	@EJB
	private GestionUsuarioEJB gestionUsuarioEJB;
	
	@PostConstruct
	public void inicializar(){
		this.user= new Persona();
		this.listaUser = new ArrayList<>();
		this.listanombres = new ArrayList<>();
		this.consultarUser();
	}
	
	public void consultarUser(){
		System.out.println("contrasenia: "+contrasenia);
		Persona persona = gestionUsuarioEJB.consultarPersonaPorUsuario(usuario);
		if(persona!=null){
			if(contrasenia.equals(persona.getContrasenia())){
				System.out.println("Usuario Loggeado");	

				 String url="http://localhost:7001/PruebaPiloto/index.xhtml";
		           FacesContext fc=FacesContext.getCurrentInstance();
		           try {
					fc.getExternalContext().redirect(url);
				   }catch (IOException e) {
					e.printStackTrace();}
			}else{
				//System.out.println("No existe usuario o contraseña errada");
			}
		}else{
			System.out.println("Usuario No existe");
		}
	}
	
	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}

	public List<Persona> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<Persona> listaUser) {
		this.listaUser = listaUser;
	}

	public GestionUsuarioEJB getGestionUsuarioEJB() {
		return gestionUsuarioEJB;
	}

	public void setGestionUsuarioEJB(GestionUsuarioEJB gestionUsuarioEJB) {
		this.gestionUsuarioEJB = gestionUsuarioEJB;
	}

	public List<String> getListanombres() {
		return listanombres;
	}

	public void setListanombres(List<String> listanombres) {
		this.listanombres = listanombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	

}
