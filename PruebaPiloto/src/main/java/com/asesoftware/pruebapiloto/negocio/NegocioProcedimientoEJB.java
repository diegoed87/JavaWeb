package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.integracion.GestionProcedimientosBD;

/**
* Session Bean implementation class NegocioPersonaEJB
*/
@Stateless
@LocalBean
public class NegocioProcedimientoEJB {
	
	@EJB
	private GestionProcedimientosBD gestionProcedimientosBD;

	/**
     * Default constructor. 
     */
	public NegocioProcedimientoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Procedimiento> consultarProcedimientos(){
		return gestionProcedimientosBD.consultarProcedimientos();
	}
	
}
