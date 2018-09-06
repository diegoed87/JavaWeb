package com.asesoftware.pruebapiloto.manejadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;

import com.asesoftware.pruebapiloto.entidades.Persona;
import com.asesoftware.pruebapiloto.entidades.PersonaPK;
import com.asesoftware.pruebapiloto.entidades.Vehiculo;
import com.asesoftware.pruebapiloto.negocio.NegocioVehiculoEJB;

@ViewScoped
@ManagedBean
public class VehiculoMB {
	
	private List<Vehiculo> listaVehiculos;
	private String nombreCliente;
	private String telefonoCliente;
	private String direccionCliente;
	private String clienteTipoIdentificacion;
	private String clienteNumeroIdentificacion;
	private Persona personaCliente;
	private PersonaPK personaPk;
	
	private Vehiculo vehiculo;
	private String placa;
	private String codigoCiudad;
	private String tipoVehiculo;
	private String marca;
	private String modelo;
	private String color;
	private String anio;
	private String kilometraje;
	private boolean disable;
	private DataTable tabla;
	private Vehiculo vehiculoSeleccionado;
	
	
	@EJB
	private NegocioVehiculoEJB negocioVehiculoEJB;
	
	@PostConstruct
	public void init() {
		this.listaVehiculos = new ArrayList<>();
		this.personaCliente = new Persona();
		this.personaPk = new PersonaPK();
		this.vehiculo = new Vehiculo();
		this.disable = true;
		this.vehiculoSeleccionado = new Vehiculo();
		}
	
	//falta buscar cliente por ID y sus vehiculos
	public void buscarCliente() {
		this.personaPk = new PersonaPK(clienteTipoIdentificacion, clienteNumeroIdentificacion);
		try {
		personaCliente = negocioVehiculoEJB.consultarPersonaPorID(personaPk);
		nombreCliente = personaCliente.getNombrePersona()+" "+personaCliente.getApellidoPersona();
		telefonoCliente = personaCliente.getTelefono();
		direccionCliente = personaCliente.getDireccion();	
		consultarVehiculoCLiente();
		this.disable = false;
		}catch (Exception e) {
			mostrarMensaje2("El cliente no existe! "+e.getMessage(), "warn");
		}
	}
	
	public void eliminarVehiculo() {
		System.out.println("Eliminando Vehiculo......");
		vehiculoSeleccionado = (Vehiculo)tabla.getRowData();
		System.out.println("Placa vehiculo seleccionado: "+vehiculoSeleccionado.getPlaca());
		try {
			this.negocioVehiculoEJB.eliminarVehiculo(vehiculoSeleccionado.getPlaca());
			mostrarMensaje2("Vehiculo de placas "+vehiculoSeleccionado.getPlaca()+" Elimando correctamente!", "Info");
		}catch (Exception e) {
			mostrarMensaje2("No es posible eliminar el vehiculo por que se encuentra asignado a una cita!", "warn");
		}
		this.consultarVehiculoCLiente();
	}
	
	
	public void consultarVehiculoCLiente() {
		try {
		listaVehiculos = negocioVehiculoEJB.consultarVehiculoPorCliente(clienteNumeroIdentificacion);
		if(listaVehiculos.size()==0) {
			mostrarMensaje2("El cliente "+ personaCliente.getNombrePersona().toUpperCase()+" no tiene vehiculos registrados! ", "warn");
		}
		}catch (Exception e) {
			e.printStackTrace();
			mostrarMensaje2("Ocurrio en error al consutar vehiculos de cliente "+e.getMessage(), "warn");
		}
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	
	public void guardarVehiculo() {
		vehiculo = new Vehiculo();
		vehiculo.setPlaca(placa);
		System.out.println("Placa: "+placa);
		try {
			vehiculo.setLocalidadesGeografica(negocioVehiculoEJB.consultarLocalidadPorId(new Long(codigoCiudad)));
			}catch (Exception e) {
				mostrarMensaje2("Error al consultar Ciudad", "Error");
			}
		vehiculo.setTipoVehiculo(tipoVehiculo);
		vehiculo.setMarca(marca);
		System.out.println("Marca: "+marca);
		vehiculo.setModelo(modelo);
		System.out.println("Anio: "+anio);
		BigDecimal auxAnio = new BigDecimal(anio);
		vehiculo.setAño(auxAnio);
		vehiculo.setColor(color);
		BigDecimal auxKm = new BigDecimal(kilometraje);
		vehiculo.setKilometraje(auxKm);
		vehiculo.setPersona(personaCliente);
		this.negocioVehiculoEJB.guardarVehiculo(vehiculo);
		mostrarMensaje2("Vehiculo de placas "+placa+" Registrado!", "Info");
		this.consultarVehiculoCLiente();
		this.limpiarCampos();
	}
	
	public void limpiarCampos() {
		this.placa = null;
		this.codigoCiudad = null;
		this.tipoVehiculo = null;
		this.marca = null;
		this.modelo = null;
		this.color = null;
		this.kilometraje = null;
		this.anio = null;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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

	public PersonaPK getPersonaPk() {
		return personaPk;
	}

	public void setPersonaPk(PersonaPK personaPk) {
		this.personaPk = personaPk;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public DataTable getTabla() {
		return tabla;
	}

	public void setTabla(DataTable tabla) {
		this.tabla = tabla;
	}
	
	
	
	
	
	
}
