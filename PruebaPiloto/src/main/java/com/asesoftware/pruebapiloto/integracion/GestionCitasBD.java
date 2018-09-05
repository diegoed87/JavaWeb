package com.asesoftware.pruebapiloto.integracion;


import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.Cita;

@Stateless
@LocalBean
public class GestionCitasBD {
	
	@PersistenceContext
	private EntityManager em;

	public GestionCitasBD() {
		// TODO Auto-generated constructor stub
	}
	
	public void guardarCita(Cita cita) {
		em.persist(cita);
	}
	
	public BigDecimal secuenciaCita() {		
		  return (BigDecimal) em.createNativeQuery("select seq_cita.nextval from dual").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cita> consultarCitas(){
		Query queryConsultarCitas = em.createQuery("select c from Cita c");
		return queryConsultarCitas.getResultList();
	}
	
}
