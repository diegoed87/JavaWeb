package com.asesoftware.pruebapiloto.integracion;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.Procedimiento;

@Stateless
@LocalBean
public class GestionProcedimientosBD {
	
	@PersistenceContext
	private EntityManager em;
	

	public GestionProcedimientosBD() {
		// TODO Auto-generated constructor stub
	}
	
	public Procedimiento consultarProcedimientoPorCodigo(long codigo) {
		Procedimiento procedimiento = null;
		try {
			procedimiento = em.find(Procedimiento.class, codigo);
		}catch (Exception e) {
			System.out.println("-----------ERROR AL CONSULTAR EL PROCEDIMIENTO-----------");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return procedimiento;
	}
	
	@SuppressWarnings("unchecked")
	public List<Procedimiento> consultarProcedimientos(){
		Query queryConsultarProcedimientos = em.createQuery("select p from Procedimiento p");
		return queryConsultarProcedimientos.getResultList();
	}
	
	public void editarProcedimiento(Procedimiento procedimiento) {
		em.merge(procedimiento);
	}
	
	public void eliminarProcedimiento(long codigoProcedimiento) {
		Procedimiento proced = null;
		try {
			proced =  em.find(Procedimiento.class, codigoProcedimiento);
			em.remove(proced);
	}catch (Exception e) {
		System.out.println("Error al borrar procedimiento "+ codigoProcedimiento);
	}
	
}
	
}
