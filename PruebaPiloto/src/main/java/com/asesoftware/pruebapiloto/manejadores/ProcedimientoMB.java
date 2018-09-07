package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.negocio.NegocioProcedimientoEJB;

@ViewScoped
@ManagedBean
public class ProcedimientoMB {
	
	@EJB
	private NegocioProcedimientoEJB negocioProcedimientoEJB;
	
	private List<Procedimiento> listaProcedimientos;
	
	
	@PostConstruct
	public void init() {
		listaProcedimientos = new ArrayList<>();
		consultarProcedimientos();
	}
	
	public void consultarProcedimientos() {
		listaProcedimientos = negocioProcedimientoEJB.consultarProcedimientos();
	}

	public List<Procedimiento> getListaProcedimientos() {
		return listaProcedimientos;
	}

	public void setListaProcedimientos(List<Procedimiento> listaProcedimientos) {
		this.listaProcedimientos = listaProcedimientos;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Procedimiento aux = ((Procedimiento)event.getObject());
        try {
        	 negocioProcedimientoEJB.editarProcedimiento(aux);
        	 FacesMessage msg = new FacesMessage("Procedimiento Editado",  aux.getNombreProcedimiento());
             FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch (Exception e) {
        	mostrarMensaje2("No se puede eliminar el procedimiento " +aux.getNombreProcedimiento() +" por que se encuentra asgnado a una Cita", "warn");	
		}
    }
	
	
	
	public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Procedimiento) event.getObject()).getNombreProcedimiento()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	public void mostrarMensaje2(String textoMensaje, String severidad){
		switch (severidad) {
		case "Info":
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", textoMensaje));
			break;
		case "warn":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", textoMensaje));
		break;
		case "Error":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", textoMensaje));
			break;
		case "Fatal":
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", textoMensaje));
		break;
		default:
			break;
		}
	}

}
