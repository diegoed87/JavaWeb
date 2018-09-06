package com.asesoftware.pruebapiloto.negocio;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.Cita;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.entidades.Vehiculo;
import com.asesoftware.pruebapiloto.integracion.GestionCitasBD;
import com.asesoftware.pruebapiloto.integracion.GestionPersonaDB;
import com.asesoftware.pruebapiloto.integracion.GestionProcedimientosBD;
import com.asesoftware.pruebapiloto.integracion.GestionVehiculosDB;

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
	
	@EJB
	private GestionVehiculosDB gestionVehiculosDB;
	
	public void guardarCita(Cita cita) {
		gestionCitasBD.guardarCita(cita);
	}
	
	public List<Cita> consultarCitas(){
		return gestionCitasBD.consultarCitas();
	}
	
	public Procedimiento consultarProcedimientoPorCodigo(long codigo) {
		return gestionProcedimientosBD.consultarProcedimientoPorCodigo(codigo);
	}
	
	public List<Procedimiento> consultarProcedimientos(){
		return gestionProcedimientosBD.consultarProcedimientos();
	}
	
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		return gestionVehiculosDB.consultarVehiculoPorPlaca(placa);
	}


	public Persona consultarPersonaPorId(PersonaPK personaPK) {
		return gestionPersonaDB.consultarPersonaPorId(personaPK);
	}
	
	public List<Vehiculo> consultarVehiculoCLiente(String numCliente){
		return gestionVehiculosDB.consultarVehiculoPorCliente(numCliente);
	}
	
	public List<Persona> consultarMecanicos(){
		return gestionPersonaDB.consultarMecanicos();
	}
	
	public BigDecimal secuenciaCita() {
		return gestionCitasBD.secuenciaCita();
	}
	
	public List<Object[]> reporteCitasPorProcedimiento(){
		return gestionCitasBD.reporteCitasPorProcedimiento();
	}
	
	

}
