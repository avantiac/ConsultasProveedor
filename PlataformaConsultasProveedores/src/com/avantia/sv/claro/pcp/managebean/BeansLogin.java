package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.avantia.sv.claro.pcp.entidades.Usuarios;



@ManagedBean(name="beansLogin")
@ViewScoped
public class BeansLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuarios usuarios;
	
	@PostConstruct
	public void init(){
		usuarios = new  Usuarios();
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public void iniciar(){
		
		if (getUsuarios().getUsuario().equals("") ||getUsuarios().getClave().equals("")){
			
			mostrarMensajeError("Tiene que completar todos los campos");
			
		}
		
	}
	
	private void mostrarMensajeError(String msg) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"", msg));
		if (requestContext != null) {
			requestContext.update("IDGrowlErrorSistemas");
		}
	}
	
}
