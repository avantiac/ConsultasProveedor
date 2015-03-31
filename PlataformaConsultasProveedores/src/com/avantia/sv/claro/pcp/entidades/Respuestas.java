package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;

public class Respuestas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRespuesta;
	private String usuario;
	private String proyecto;
	private String pregunta;
	private String status_pregunta;
	private String fecha_pregunta;
	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idRespuesta;
	}
	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idRespuesta = idPregunta;
	}
	
	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}
	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	/**
	 * @return the status_pregunta
	 */
	public String getStatus_pregunta() {
		return status_pregunta;
	}
	/**
	 * @param status_pregunta the status_pregunta to set
	 */
	public void setStatus_pregunta(String status_pregunta) {
		this.status_pregunta = status_pregunta;
	}
	/**
	 * @return the fecha_pregunta
	 */
	public String getFecha_pregunta() {
		return fecha_pregunta;
	}
	/**
	 * @param fecha_pregunta the fecha_pregunta to set
	 */
	public void setFecha_pregunta(String fecha_pregunta) {
		this.fecha_pregunta = fecha_pregunta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
}
