package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Cita;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.integracion.GestionCitasBD;
import com.asesoftware.pruebapiloto.integracion.GestionPersonaDB;
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
	
	@EJB
	private GestionPersonaDB gestionPersonaDB;
	
	public void guardarCita(Cita cita) {
		gestionCitasBD.guardarCita(cita);
	}
	
	public Procedimiento consultarProcedimientoPorCodigo(long codigoProcedimiento) {
		return gestionProcedimientosBD.consultarProcedimientoPoCodigo(codigoProcedimiento);
	}
	
	public List<Procedimiento> consultarProcedimientos(){
		return gestionProcedimientosBD.consultarProcedimientos();
	}

	public Persona consultarPersonaPorId(PersonaPK personaPK) {
		return gestionPersonaDB.consultarPersonaPorId(personaPK);
	}
	
	public List<Persona> consultarMecanicos(){
		return gestionPersonaDB.consultarMecanicos();
	}
	
	

}
