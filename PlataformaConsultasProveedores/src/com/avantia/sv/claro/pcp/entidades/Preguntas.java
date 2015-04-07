package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

@Entity(name = "PREGUNTAS")
@Table(name = "PREGUNTAS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_PREGUNTA" }) })
public class Preguntas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Preguntas")
	@SequenceGenerator(name = "Seq_Gen_Preguntas", sequenceName = "SQ_PREGUNTAS")
	@Id
	@Column(name = "ID_PREGUNTA", nullable = false)
	private int id;
	
	@Column(name = "PREGUNTA", nullable = false)
	private String pregunta;
	
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;
	
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fecha_creacion;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "ID_ASIGNACION")
	private Asignar_Proyecto asignacion;
	
	@OneToOne(fetch=FetchType.EAGER,mappedBy="pregunta",cascade={CascadeType.ALL}) 
	private Respuestas respuesta;

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
	 * @return the estado
	 */
	public boolean getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
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
	 * @return the respuesta
	 */
	public Respuestas getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Respuestas respuesta) {
		this.respuesta = respuesta;
	}
	
	
	

}
