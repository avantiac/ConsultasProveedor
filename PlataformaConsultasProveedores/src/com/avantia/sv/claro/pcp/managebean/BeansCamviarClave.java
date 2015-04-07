package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;





@ManagedBean(name="beansCamviarClave")
@ViewScoped
public class BeansCamviarClave extends Acciones  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuarios usuarios;
	
	
	@PostConstruct
	public void init(){
	setUsuarios(new Usuarios()) ;
	}

	public void actualizarClave(){
		
		if(getUsuarios().getUsuario().equals("")|| getUsuarios().getClave().equals("")){
			
			mostrarMensajeError("Tiene que llenar todos los campos");
			
		}else{
			
			BdEjecucion ejecucion = new BdEjecucion();
			try {
				ejecucion.updateData(getUsuarios());
				setUsuarios(new Usuarios());
				RequestContext.getCurrentInstance().update("IDFcamviarclave");
			} catch (Exception e) {
				// TODO: se debe mandar un mensaje a la pantalla diciendo que
				// existio un error al guardar
				e.printStackTrace();
			} finally {
				ejecucion = null;
			}

			
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

	/**
	 * @return the usuarios
	 */
	public Usuarios getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
