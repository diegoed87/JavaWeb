package com.asesoftware.pruebapiloto.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.asesoftware.pruebapiloto.entidades.LocalidadesGeografica;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.entidades.Vehiculo;
import com.asesoftware.pruebapiloto.integracion.GestionLocalidadesGeograficasBD;
import com.asesoftware.pruebapiloto.integracion.GestionPersonaDB;
import com.asesoftware.pruebapiloto.integracion.GestionVehiculosDB;

/**
* Session Bean implementation class NegocioPersonaEJB
*/
@Stateless
@LocalBean
public class NegocioVehiculoEJB {
	
	@EJB
	private GestionVehiculosDB gestionVehiculosDB;
	
	@EJB
	private GestionPersonaDB gestionPersonaDB;
	
	@EJB
	private GestionLocalidadesGeograficasBD gestionLocalidadesGeograficasBD;
	
	public LocalidadesGeografica consultarLocalidadPorId(Long codigo) {
		return gestionLocalidadesGeograficasBD.consultarLocalidadPorId(codigo);
	}
	
	public NegocioVehiculoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public void guardarVehiculo(Vehiculo vehiculo) {
		gestionVehiculosDB.guardarVehiculo(vehiculo);
	}
	
	public List<Vehiculo> consultarVehiculoPorCliente(String numCliente){
		return gestionVehiculosDB.consultarVehiculoPorCliente(numCliente);
	}
	
	public Persona consultarPersonaPorID(PersonaPK personaPK) {
		Persona persona = null;
		try {
			persona = gestionPersonaDB.consultarPersonaPorId(personaPK);
		}catch (Exception e) {
			System.out.println("Ocurrio un error al consultar la persona ");
		}
		return persona;
	}

}
