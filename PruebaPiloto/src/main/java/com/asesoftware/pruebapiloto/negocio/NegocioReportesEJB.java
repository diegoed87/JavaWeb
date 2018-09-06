package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.integracion.GestionCitasBD;

/**
* Session Bean implementation class NegocioPersonaEJB
*/
@Stateless
@LocalBean
public class NegocioReportesEJB {
	
	@EJB
	private GestionCitasBD gestionCitasBD;
	
	/**
     * Default constructor. 
     */
	public NegocioReportesEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Object[]> reporteCitasPorProcedimiento(){
		return gestionCitasBD.reporteCitasPorProcedimiento();
	}

}
