package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;

public class Proyecto extends Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProyecto;
	private String usuario;
	private String nombre_proyecto;
	private String descrip_Proy;
	private String status_Proy;
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getNombre_proyecto() {
		return nombre_proyecto;
	}
	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	public String getDescrip_Proy() {
		return descrip_Proy;
	}
	public void setDescrip_Proy(String descrip_Proy) {
		this.descrip_Proy = descrip_Proy;
	}
	public String getStatus_Proy() {
		return status_Proy;
	}
	public void setStatus_Proy(String status_Proy) {
		this.status_Proy = status_Proy;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
