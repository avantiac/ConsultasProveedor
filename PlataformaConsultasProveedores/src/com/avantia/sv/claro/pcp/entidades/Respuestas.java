package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "RESPUESTAS")
@Table(name = "RESPUESTAS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_RESPUESTA" }) })
public class Respuestas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Respuestas")
	@SequenceGenerator(name = "Seq_Gen_Respuestas", sequenceName = "SQ_RESPUESTAS")
	@Id
	
	@Column(name = "ID_RESPUESTA", nullable = false)
	private int id;
			
	@Column(name = "RESPUESTA", nullable = false)
	private String respuesta;
	

	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fecha_creacion;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "ID_ASIGNACION")
	private Asignar_Proyecto asignacion;
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "ID_PREGUNTA")
	private Preguntas pregunta;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the fecha_creacion
	 */
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the asignacion
	 */
	public Asignar_Proyecto getAsignacion() {
		return asignacion;
	}

	/**
	 * @param asignacion the asignacion to set
	 */
	public void setAsignacion(Asignar_Proyecto asignacion) {
		this.asignacion = asignacion;
	}

	/**
	 * @return the pregunta
	 */
	public Preguntas getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Preguntas pregunta) {
		this.pregunta = pregunta;
	}

	
}
