package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "ASIGNAR_PROYECTO")
@Table(name = "ASIGNAR_PROYECTO", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_ASIGNACION" }) })
public class Asignar_Proyecto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Asignar_proyecto")
	@SequenceGenerator(name = "Seq_Gen_Asignar_proyecto", sequenceName = "SQ_ASIGNAR_PROYECTO")
	@Id
	
	@Column(name = "ID_ASIGNACION", nullable = false)
	private int id;

	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fecha_cracion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USUARIO")
	private Usuarios usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROYECTO")
	private Proyectos proyecto;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="asignacion",cascade={CascadeType.ALL}) 
	private Set<Preguntas>preguntas;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="asignacion",cascade={CascadeType.ALL}) 
	private Set<Respuestas>respuestas;
	
	

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
	 * @return the fecha_cracion
	 */
	public Date getFecha_cracion() {
		return fecha_cracion;
	}

	/**
	 * @param fecha_cracion the fecha_cracion to set
	 */
	public void setFecha_cracion(Date fecha_cracion) {
		this.fecha_cracion = fecha_cracion;
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

	/**
	 * @return the proyecto
	 */
	public Proyectos getProyecto() {
		return proyecto;
	}

	/**
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return the preguntas
	 */
	public Set<Preguntas> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(Set<Preguntas> preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * @return the respuestas
	 */
	public Set<Respuestas> getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(Set<Respuestas> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
	
}
