package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.avantia.sv.claro.pcp.entidades.Usuarios;

public class UsuarioSessionMB  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request;
	HttpSession sesion;
	Usuarios usuario;
	
	public void crearSession(){
		
		
	}
	
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * @return the sesion
	 */
	public HttpSession getSesion() {
		return sesion;
	}
	/**
	 * @param sesion the sesion to set
	 */
	public void setSesion(HttpSession sesion) {
		this.sesion = sesion;
	}
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
