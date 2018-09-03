package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.Vehiculo;

@Stateless
@LocalBean
public class GestionVehiculosDB {
	
	@PersistenceContext
	private EntityManager em;
	
	public GestionVehiculosDB() {
		// TODO Auto-generated constructor stub
	}
	
	public void guardarVehiculo(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehiculo> consultarVehiculoPorCliente(String numCliente){
		Query consulta = em.createQuery("select v from Vehiculo v where v.persona.id.numeroIdentificacion =  '"+numCliente+"'");
		System.out.println(consulta.toString());
		return consulta.getResultList();
	}

}
