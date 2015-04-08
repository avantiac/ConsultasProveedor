package com.avantia.sv.claro.pcp.managebean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.MenuModel;

import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;

@ManagedBean(name="usuarioSessionMB")
@SessionScoped
public class Ingreso  implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String URL_PAGINA_PRINCIPAL = "/vistas/generales/Principal.xhtml";
	private String user;
	private MenuModel model;
	private Usuarios usuario;
	

	@PostConstruct
	public void inicio(){
		
	}
	/**
	 * Metodo el cual realiza la verificacion del usuario que pretende loguearse
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param contrasenia
	 *            - Contrasenia del usuario
	 * */
	public void loginUsuario(String contrasenia) {
		BdEjecucion ejecucion = new BdEjecucion();
		
		try{
			@SuppressWarnings("unchecked")
			List<Usuarios> usuarios = (ArrayList<Usuarios>) ejecucion.listData("FROM USUARIOS where clave = '" + contrasenia + "' and usuario = '" + getUser() + "'") ;
			
			  
			if (!usuarios.isEmpty()){
				setUsuario(usuarios.get(0));
				redireccionarPagina(URL_PAGINA_PRINCIPAL);
			}
			else {
				mostrarMensajeError("Verifique los datos ingresados");
			}
			
		}catch(Exception exp){
			exp.printStackTrace();
			mostrarMensajeError("No se encontro usuario con esas credenciales");
		}
	}

	/**
	 * Mostrar algun mensaje de error este metodo es unicamente para session
	 * bean ya que no se puede heredar de un ManejadorAccion
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param msg
	 *            - es el mensaje que se quiere enviar a pantalla
	 * */
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
	 * Redireccion de una pagina.
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * */
	public void redireccionarPagina(String url) {
		try {
			
			
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/PlataformaConsultasProveedores" + url);
		} catch (IOException exception) {
			mostrarMensajeError("No es posible re-direccionar a la página "
					+ url);
		}
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @return the model
	 */
	public MenuModel getModel() {
		return model;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @param model
	 *            the model to set
	 */
	public void setModel(MenuModel model) {
		this.model = model;
	}
	/**
	 * @return the request
	 */




	/**
	 * @return the usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}




	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}