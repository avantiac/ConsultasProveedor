package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		
		
	}
	
}
