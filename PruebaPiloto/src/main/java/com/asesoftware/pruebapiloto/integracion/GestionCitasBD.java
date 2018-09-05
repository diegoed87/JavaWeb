package com.asesoftware.pruebapiloto.integracion;


import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		  return (BigDecimal) em.createNativeQuery("select seq_cita.currval+1 from dual").getSingleResult();
	}
	
}
