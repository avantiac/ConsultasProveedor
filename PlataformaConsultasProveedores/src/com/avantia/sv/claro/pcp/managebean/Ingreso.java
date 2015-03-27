package com.avantia.sv.claro.pcp.managebean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class Ingreso implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "admin";
	private static final String PASSWORD = "pass";
	private static final String URL_PAGINA_PRINCIPAL = "/vistas/generales/Principal.xhtml";
	private String user;
	private MenuModel model;

	/**
	 * Metodo el cual realiza la verificacion del usuario que pretende loguearse
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param contrasenia
	 *            - Contrasenia del usuario
	 * */
	public void loginUsuario(String contrasenia) {
		if (USUARIO.equals(getUser()) && PASSWORD.equals(contrasenia))
			redireccionarPagina(URL_PAGINA_PRINCIPAL);
		else
			mostrarMensajeError("Verifique los datos ingresados");
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
}