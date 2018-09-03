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
	
	@SuppressWarnings("unchecked")
	public List<Procedimiento> consultarProcedimientos(){
		Query queryConsultarProcedimientos = em.createQuery("select p from Procedimiento p");
		return queryConsultarProcedimientos.getResultList();
	}
	
	public Procedimiento consultarProcedimientoPoCodigo(long codigoProcedimiento) {
		Procedimiento aux = null;
		try {
			aux = em.find(Procedimiento.class, codigoProcedimiento);
		}catch (Exception e) {
			System.out.println("Error al consultar un procedimiento por codigo");
		}
		return aux;
	}
	
}
