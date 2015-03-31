package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;





public class Roles implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRol;
	private String nombre_rol;
	private String status_rol;
	/**
	 * @return the nombre_rol
	 */
	public String getNombre_rol() {
		return nombre_rol;
	}
	/**
	 * @param nombre_rol the nombre_rol to set
	 */
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
	/**
	 * @return the status_Rol
	 */
	/**
	 * @return the idRol
	 */
	public int getIdRol() {
		return idRol;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	/**
	 * @return the status_Rol
	 */
	public String getStatus_Rol() {
		return status_rol;
	}
	/**
	 * @param status_Rol the status_Rol to set
	 */
	public void setStatus_Rol(String status_Rol) {
		this.status_rol = status_Rol;
	}
	
	
	
	

}
