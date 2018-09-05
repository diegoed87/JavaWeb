package com.asesoftware.pruebapiloto.manejadores;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.asesoftware.pruebapiloto.entidades.Cita;
import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.entidades.Procedimiento;
import com.asesoftware.pruebapiloto.entidades.Vehiculo;
import com.asesoftware.pruebapiloto.negocio.NegocioCitaEJB;

@ViewScoped
@ManagedBean
public class CitaMB {
	
	private List<Procedimiento> listaProcedimientos;
	private List<Persona> listaMecanicos;
	private List<Vehiculo> listaVehiculos;
	private boolean disable;
	private Date date;
	private Date dateCita;
	private String fechaRegistro;
	private BigDecimal codigoCita;
	private PersonaPK personaPk;
	private Persona personaCliente;
	private String clienteTipoIdentificacion;
	private String clienteNumeroIdentificacion;
	private String nombreCliente;
	private String telefonoCliente;
	private String direccionCLiente;
	private Cita cita;
	private String observaciones;
	private Persona mecanico;
	private String mecanicoNumeroIdentificacion;
	private PersonaPK personaMecanicoPK;
	private String codigoProcedimiento;
	private Vehiculo vehiculo;
	private String placa;
	private int auxCode; // Código de cita pasado a Entero
	
	
	@EJB
	private NegocioCitaEJB negocioCitaEJB;
	
	@PostConstruct
	public void init(){
		listaProcedimientos = new ArrayList<Procedimiento>();
		listaMecanicos = new ArrayList<>();
		consultarProcedimientos();
		consultarMecanicos();
		this.disable = true;
		this.date = new Date();
		this.dateCita = new Date();
		this.personaPk = new PersonaPK();
		this.personaCliente = new Persona();
		this.cita = new Cita();
		this.mecanico = new Persona();
		this.personaMecanicoPK = new PersonaPK();
		this.vehiculo = new Vehiculo();
		formatearFecha();
		codigoCita();
		System.out.println("Código cita: "+auxCode);
		System.out.println("Codigo CIta Aumentado : "+(auxCode+1));
		this.auxCode = auxCode+1;
	}
	
	public void guardarCita() {
		System.out.println("Código cita: "+auxCode);
		//cita.setCodigo(auxCode);
		cita = new Cita();
		cita.setFechaRegistro(date);
		cita.setPersona2(personaCliente); //CLIENTE
		cita.setVehiculo(negocioCitaEJB.consultarVehiculoPorPlaca(placa));
		cita.setFechaCita(dateCita);
		System.out.println("Numero Mecanico: "+mecanicoNumeroIdentificacion);
		personaMecanicoPK = new PersonaPK("CC", mecanicoNumeroIdentificacion);
		mecanico = negocioCitaEJB.consultarPersonaPorId(personaMecanicoPK);
		cita.setPersona1(mecanico); //MECANICO
		System.out.println("Mecanico: "+mecanico.getNombrePersona());
		cita.setProcedimiento(negocioCitaEJB.consultarProcedimientoPorCodigo(new Long(codigoProcedimiento)));
		cita.setObservaciones(observaciones);
		
		negocioCitaEJB.guardarCita(cita);;
		mostrarMensaje2("Cita Para Vehiculo "+placa+" y cliente "+personaCliente.getNombrePersona()+" Registrada!", "Info");
		limpiarCampos();
	}
	
	
	public void buscarCLiente() {
		this.personaPk = new PersonaPK(clienteTipoIdentificacion, clienteNumeroIdentificacion);
		try {
			personaCliente = negocioCitaEJB.consultarPersonaPorId(personaPk);
			nombreCliente = personaCliente.getNombrePersona()+" "+personaCliente.getApellidoPersona();
			telefonoCliente = personaCliente.getTelefono();
			direccionCLiente = personaCliente.getDireccion();
			this.disable = false;
			consultarVehiculoCLiente();
		}catch (Exception e) {
			mostrarMensaje2("El cliente no existe! "+e.getMessage(), "warn");
			this.disable = true;
			this.listaVehiculos = new ArrayList<>();
		}
	}
	
	
	public void consultarProcedimientos() {
		listaProcedimientos = negocioCitaEJB.consultarProcedimientos();
	}
	
	public void consultarMecanicos() {
		listaMecanicos = negocioCitaEJB.consultarMecanicos();
	}

	public void consultarVehiculoCLiente() {
		try {
		listaVehiculos = negocioCitaEJB.consultarVehiculoCLiente(clienteNumeroIdentificacion);
		if(listaVehiculos.size()==0) {
			mostrarMensaje2("El cliente "+ personaCliente.getNombrePersona().toUpperCase()+" no tiene vehiculos registrados! ", "warn");
			this.disable = true;
			this.listaVehiculos = new ArrayList<>();
		}
		}catch (Exception e) {
			e.printStackTrace();
			mostrarMensaje2("Ocurrio en error al consutar vehiculos de cliente "+e.getMessage(), "warn");
		}
	}
	
	public void limpiarCampos() {
		int aux = codigoCita();
		this.auxCode = aux+1;
		this.clienteTipoIdentificacion = null;
		this.clienteNumeroIdentificacion = null;
		this.nombreCliente = null;
		this.telefonoCliente = null;
		this.direccionCLiente = null;
		this.placa = null;
		this.mecanicoNumeroIdentificacion = null;
		this.codigoProcedimiento = null;
		this.observaciones = null;
		this.disable = true;
		this.auxCode = codigoCita();
		formatearFecha();
	}
	

	public List<Procedimiento> getListaProcedimientos() {
		return listaProcedimientos;
	}


	public void setListaProcedimientos(List<Procedimiento> listaProcedimientos) {
		this.listaProcedimientos = listaProcedimientos;
	}


	public List<Persona> getListaMecanicos() {
		return listaMecanicos;
	}


	public void setListaMecanicos(List<Persona> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}
	
	public void formatearFecha() {
		SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
		fechaRegistro = format.format(date);
	}
	
	public  int codigoCita() {
		codigoCita = negocioCitaEJB.secuenciaCita();
		auxCode = codigoCita.intValueExact()+1;
		return auxCode;
	}


	public boolean isDisable() {
		return disable;
	}


	public void setDisable(boolean disable) {
		this.disable = disable;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	

	public BigDecimal getCodigoCita() {
		return codigoCita;
	}

	public void setCodigoCita(BigDecimal codigoCita) {
		this.codigoCita = codigoCita;
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

	public PersonaPK getPersonaPk() {
		return personaPk;
	}

	public void setPersonaPk(PersonaPK personaPk) {
		this.personaPk = personaPk;
	}

	public Persona getPersonaCliente() {
		return personaCliente;
	}

	public void setPersonaCliente(Persona personaCliente) {
		this.personaCliente = personaCliente;
	}

	public String getClienteTipoIdentificacion() {
		return clienteTipoIdentificacion;
	}

	public void setClienteTipoIdentificacion(String clienteTipoIdentificacion) {
		this.clienteTipoIdentificacion = clienteTipoIdentificacion;
	}

	public String getClienteNumeroIdentificacion() {
		return clienteNumeroIdentificacion;
	}

	public void setClienteNumeroIdentificacion(String clienteNumeroIdentificacion) {
		this.clienteNumeroIdentificacion = clienteNumeroIdentificacion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getDireccionCLiente() {
		return direccionCLiente;
	}

	public void setDireccionCLiente(String direccionCLiente) {
		this.direccionCLiente = direccionCLiente;
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public Date getDateCita() {
		return dateCita;
	}

	public void setDateCita(Date dateCita) {
		this.dateCita = dateCita;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Persona getMecanico() {
		return mecanico;
	}

	public void setMecanico(Persona mecanico) {
		this.mecanico = mecanico;
	}

	public String getMecanicoNumeroIdentificacion() {
		return mecanicoNumeroIdentificacion;
	}

	public void setMecanicoNumeroIdentificacion(String mecanicoNumeroIdentificacion) {
		this.mecanicoNumeroIdentificacion = mecanicoNumeroIdentificacion;
	}

	public PersonaPK getPersonaMecanicoPK() {
		return personaMecanicoPK;
	}

	public void setPersonaMecanicoPK(PersonaPK personaMecanicoPK) {
		this.personaMecanicoPK = personaMecanicoPK;
	}

	public String getCodigoProcedimiento() {
		return codigoProcedimiento;
	}

	public void setCodigoProcedimiento(String codigoProcedimiento) {
		this.codigoProcedimiento = codigoProcedimiento;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAuxCode() {
		return auxCode;
	}

	public void setAuxCode(int auxCode) {
		this.auxCode = auxCode;
	}

	
	

}
