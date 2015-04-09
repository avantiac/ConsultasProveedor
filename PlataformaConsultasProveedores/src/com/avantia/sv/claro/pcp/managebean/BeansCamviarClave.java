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
	private String clave1;
	private String clave2;
	
	
	 private boolean validar(){
	    	// validar que las dos claves vayan a coincidir
			if(!getClave1().isEmpty() || !getClave2().isEmpty()  ){
				if(!getClave1().equals(getClave2())){
					lanzarMensajeError("Error", "Las claves no coinciden", new Exception("Las claves que metieron no coinciden por eso se les dijo que no podian guardar el usuario"));
					return true;
				}
				
				
			}else{
				lanzarMensajeError("Error", "Debe ingresar la clave", new Exception("Envio la claave 1 vacia por lo tanto no dejamos que guardara el usuario"));
				return true;
			}
			
			return false;
	    }
	
	public void actualizarClave()
	{
		if(validar())
			return;
				
		Usuarios clave = new Usuarios();
		try 
		{
			clave = getUsuarioSessionMB().getUsuario();
			clave.setClave(getClave1());
			getEjecucion().updateData(clave);
			RequestContext.getCurrentInstance().update("IDFcamviarclave");
		} catch (Exception e) 
		{
			lanzarMensajeError("Error", "No se puede actualiza en este momento", e);
		} finally
		{
			clave = null;
		}
	}
						
	/**
	 * @return the clave1
	 */
	public String getClave1() {
		return clave1;
	}

	/**
	 * @param clave1 the clave1 to set
	 */
	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	/**
	 * @return the clave2
	 */
	public String getClave2() {
		return clave2;
	}

	/**
	 * @param clave2 the clave2 to set
	 */
	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}
	
	
	
}
