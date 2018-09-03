package com.asesoftware.pruebapiloto.negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.integracion.GestionCitasBD;
import com.asesoftware.pruebapiloto.integracion.GestionProcedimientosBD;

/**
* Session Bean implementation class NegocioPersonaEJB
*/
@Stateless
@LocalBean
public class NegocioCitaEJB {
	
	@EJB
	private GestionCitasBD gestionCitasBD;
	
	@EJB
	private GestionProcedimientosBD gestionProcedimientosBD;
	
	
	

}
