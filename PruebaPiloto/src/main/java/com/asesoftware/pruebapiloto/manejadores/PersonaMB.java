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

import com.asesoftware.pruebapiloto.negocio.NegocioPersonaEJB;

@ViewScoped
@ManagedBean
public class PersonaMB {

	private Persona persona;
	private PersonaPK personaPK;
	private List<Persona> personas;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombrePersona;
	private String apellidoPersona;
	private String edad;
	private String correo;
	private String telefono;
	private String direccion;
	private String codigoCiudad;
	private String tipoPersona;
	private String usuario;
	private String contrasenia;
	private Persona personaSeleccionada;
	private DataTable tabla;
	private boolean disable;
	
	@EJB
	private NegocioPersonaEJB negocioPersonaEJB;
	
	
	@PostConstruct
	public void init() {
		this.disable = true;
		this.persona = new Persona();
		this.personaSeleccionada = new Persona();
		this.personas = new ArrayList<>();
		this.consultarPersonas();
	}
	
	public void guardarPersona() {
		System.out.println("Funcionando!!...........");
		System.out.println("Código ciudad: "+codigoCiudad);
		persona = new Persona();
		personaPK = new PersonaPK(tipoIdentificacion,numeroIdentificacion);
		
		persona.setId(personaPK);
		persona.setNombrePersona(nombrePersona);
		persona.setApellidoPersona(apellidoPersona);
		persona.setEdad(new BigDecimal(edad));
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setDireccion(direccion);
		try {
		persona.setLocalidadesGeografica(negocioPersonaEJB.consultarLocalidadPorId(new Long(codigoCiudad)));
		}catch (Exception e) {
			mostrarMensaje2("Error al consultar Ciudad", "Error");
		}
		persona.setTipoPersona(tipoPersona);
		persona.setUsuario(usuario);
		persona.setContrasenia(contrasenia);

		this.negocioPersonaEJB.guardarPersona(persona);
		mostrarMensaje(this.persona.getNombrePersona()+"  Registrada");
		this.consultarPersonas();
		this.limpiarCampos();
	}
	
	public void limpiarCampos() {
		this.tipoIdentificacion=null;
		this.numeroIdentificacion = null;
		this.nombrePersona = null;
		this.apellidoPersona = null;
		this.edad = null;
		this.correo = null;
		this.telefono = null;
		this.telefono = null;
		this.direccion = null;
		this.codigoCiudad = null;
		this.tipoPersona = null;
		this.usuario = null;
		this.contrasenia = null;
		this.disable = true;
	}
	
	public void eliminarPersona(PersonaPK personaPk) {
		System.out.println("Eliminando Persona");
		Persona aux =  this.negocioPersonaEJB.consultarPersonaPorId(personaPk);
		this.negocioPersonaEJB.eliminarPersona(personaPk);
		this.consultarPersonas();
		mostrarMensaje(aux.getNombrePersona()+ " Eliminado");
		aux = null;
	}
	
	public void editarPersona() {
		personaSeleccionada.setNombrePersona(nombrePersona);
		personaSeleccionada.setApellidoPersona(apellidoPersona);
		personaSeleccionada.setEdad(new BigDecimal(edad));
		personaSeleccionada.setCorreo(correo);
		personaSeleccionada.setTelefono(telefono);
		personaSeleccionada.setDireccion(direccion);
		try {
			personaSeleccionada.setLocalidadesGeografica(negocioPersonaEJB.consultarLocalidadPorId(new Long(codigoCiudad)));
			}catch (Exception e) {
				mostrarMensaje2("Error al consultar Ciudad", "Error");
			}
		personaSeleccionada.setTipoPersona(tipoPersona);
		personaSeleccionada.setUsuario(usuario);
		personaSeleccionada.setContrasenia(contrasenia);
		try{
		this.negocioPersonaEJB.editarPersona(personaSeleccionada);
		mostrarMensaje(this.personaSeleccionada.getNombrePersona()+"  Modificada");
		this.consultarPersonas();
		this.limpiarCampos();
		}catch (Exception e) {
			mostrarMensaje2("Error al editar la Persona", "Error");
		}
		
	}
	
	public void consultarPersonas() {
		this.personas = negocioPersonaEJB.consultarPersonas();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public void mostrarMensaje(String textoMensaje){
		FacesMessage mensajeApp = new FacesMessage(textoMensaje);
		FacesContext.getCurrentInstance().addMessage(null, mensajeApp);
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
	
	
	public void cargarPersonaEditar() {
		limpiarCampos();
		personaSeleccionada =(Persona) tabla.getRowData();
		String aux = personaSeleccionada.getNombrePersona();
		System.out.println("Persona Seleccionada : "+aux);
		this.tipoIdentificacion = personaSeleccionada.getId().getTipoIdentificacion();
		this.numeroIdentificacion =String.valueOf(personaSeleccionada.getId().getNumeroIdentificacion());
		this.nombrePersona = personaSeleccionada.getNombrePersona();
		this.apellidoPersona = personaSeleccionada.getApellidoPersona();
		this.edad = String.valueOf(personaSeleccionada.getEdad());
		this.correo =personaSeleccionada.getCorreo();
		this.telefono = personaSeleccionada.getTelefono();
		this.direccion = personaSeleccionada.getDireccion();
		this.codigoCiudad = String.valueOf(personaSeleccionada.getLocalidadesGeografica().getCodigo());
		this.tipoPersona = personaSeleccionada.getTipoPersona();
		this.usuario = personaSeleccionada.getUsuario();
		this.contrasenia = personaSeleccionada.getContrasenia();
		this.disable = false;
	}

	
	
	public void mensaje() {
		System.out.println("Boton sirviendo....");
	}

	public PersonaPK getPersonaPK() {
		return personaPK;
	}

	public void setPersonaPK(PersonaPK personaPK) {
		this.personaPK = personaPK;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}

	public DataTable getTabla() {
		return tabla;
	}

	public void setTabla(DataTable tabla) {
		this.tabla = tabla;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	
	
	
	}
