package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Usuarios;





@ManagedBean(name="beansCamviarClave")
@ViewScoped
public class BeansCamviarClave  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuarios usuarios;
	
	
	@PostConstruct
	public void init(){
		usuarios = new Usuarios();
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public void actualizarClave(){
		
		
		
	}
	
	
}
