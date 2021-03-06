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
	
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		Vehiculo vehiculo = null;
		try {
			vehiculo = em.find(Vehiculo.class, placa);
		}catch (Exception e) {
			System.out.println("Ocurro un error al consultar el vehiculo de placa "+placa);
		}
		return vehiculo;
	}
	
	
	public void eliminarVehiculo(String placa) {
		try {
			Vehiculo vehiculo = em.find(Vehiculo.class, placa);
			em.remove(vehiculo);
		}catch (Exception e) {
			System.out.println("Ocurrio un error al eliminar el vehiculo"+e.getMessage()+" || " +e.getCause());
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
	}

}
