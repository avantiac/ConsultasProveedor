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

@Entity(name = "PROYECTOS")
@Table(name = "PROYECTOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_PROYECTO" }) })
public class Proyectos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Proyectos")
	@SequenceGenerator(name = "Seq_Gen_Proyectos", sequenceName = "SQ_PROYECTOS")
	@Id
	
	@Column(name = "ID_PROYECTO", nullable = false)
	private int id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;
	
	
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fecha_creacion;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "ID_USUARIO")
	private Usuarios usuarioCreador;
	
    @OneToMany(fetch=FetchType.EAGER,mappedBy="proyecto",cascade={CascadeType.ALL}) 
	private Set<Asignar_Proyecto>asignar_proyecto;
	

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
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
	 * @return the asignar_proyecto
	 */
	public Set<Asignar_Proyecto> getAsignar_proyecto() {
		return asignar_proyecto;
	}

	/**
	 * @param asignar_proyecto the asignar_proyecto to set
	 */
	public void setAsignar_proyecto(Set<Asignar_Proyecto> asignar_proyecto) {
		this.asignar_proyecto = asignar_proyecto;
	}

	/**
	 * @return the usuarioCreador
	 */
	public Usuarios getUsuarioCreador() {
		return usuarioCreador;
	}

	/**
	 * @param usuarioCreador the usuarioCreador to set
	 */
	public void setUsuarioCreador(Usuarios usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
}
