package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.negocio.NegocioCitaEJB;

@ViewScoped
@ManagedBean
public class CitaMB {
	
	private List<Procedimiento> listaProcedimientos;
	private List<Persona> listaMecanicos;
	private boolean disable;
	
	@EJB
	private NegocioCitaEJB negocioCitaEJB;
	
	@PostConstruct
	public void init(){
		listaProcedimientos = new ArrayList<Procedimiento>();
		listaMecanicos = new ArrayList<>();
		consultarProcedimientos();
		consultarMecanicos();
		this.disable = true;
	}
	
	
	public void consultarProcedimientos() {
		listaProcedimientos = negocioCitaEJB.consultarProcedimientos();
	}
	
	public void consultarMecanicos() {
		listaMecanicos = negocioCitaEJB.consultarMecanicos();
	}


	public List<Procedimiento> getListaProcedimientos() {
		return listaProcedimientos;
	}


	public void setListaProcedimientos(List<Procedimiento> listaProcedimientos) {
		this.listaProcedimientos = listaProcedimientos;
	}


	public List<Persona> getListaMecanicos() {
		return listaMecanicos;
	}


	public void setListaMecanicos(List<Persona> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}


	public boolean isDisable() {
		return disable;
	}


	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	
	

}
