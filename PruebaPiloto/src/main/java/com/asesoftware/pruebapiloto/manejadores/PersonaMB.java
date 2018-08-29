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
	
	@EJB
	private NegocioPersonaEJB negocioPersonaEJB;
	
	
	@PostConstruct
	public void init() {
		this.persona = new Persona();
		this.personas = new ArrayList<>();
		this.consultarPersonas();
	}
	
	public void guardarPersona() {
		persona = new Persona();
		personaPK = new PersonaPK(tipoIdentificacion,Long.parseLong(numeroIdentificacion));
		
		persona.setId(personaPK);
		persona.setNombrePersona(nombrePersona);
		persona.setApellidoPersona(apellidoPersona);
		persona.setEdad(new BigDecimal(edad));
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setDireccion(direccion);
		try {
		persona.setLocalidadesGeografica(negocioPersonaEJB.consultarLocalidadPorId(codigoCiudad));
		}catch (Exception e) {
			mostrarMensaje2("Error al consultar Ciudad", "Error");
		}
		persona.setTipoPersona(tipoPersona);
		persona.setUsuario(usuario);
		persona.setContrasenia(contrasenia);

		this.negocioPersonaEJB.guardarPersona(persona);
		mostrarMensaje(this.persona.getNombrePersona()+"  Registrada");
		this.consultarPersonas();
	}
	
	public void eliminarPersona(PersonaPK personaPk) {
		System.out.println("Eliminando Persona");
		Persona aux =  this.negocioPersonaEJB.consultarPersonaPorId(personaPk);
		this.negocioPersonaEJB.eliminarPersona(personaPk);
		this.consultarPersonas();
		mostrarMensaje(aux.getNombrePersona()+ " Eliminado");
		aux = null;
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
	
	
}