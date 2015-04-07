package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "USUARIOS")
@Table(name = "USUARIOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_USUARIO" }) })
public class Usuarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Usuarios")
	@SequenceGenerator(name = "Seq_Gen_Usuarios", sequenceName = "SQ_USUARIOS")
	@Id
	@Column(name = "ID_USUARIO", nullable = false)
	private int id;
		
	@Column(name = "USUARIO", nullable = false)
	private String usuario;
	
	@Column(name = "CLAVE", nullable = false)
	private String clave;
	
	@Column(name = "EMPRESA", nullable = false)
	private String empresa;
	
	@Column(name = "CONTACTO", nullable = false)
	private String contacto;
	
	@Column(name = "CORREO", nullable = false)
	private String correo;
	
	@Column(name = "TELEFONO", nullable = false)
	private String telefono;
	
	@Column(name = "MOVIL", nullable = false)
	private String movil;
	
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;
	
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fecha_creacion;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_ROL")
	private Roles roles;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="usuarioCreador",cascade={CascadeType.ALL})
	private Set<Proyectos>proyectos;
	
    @OneToMany(fetch=FetchType.EAGER,mappedBy="usuario",cascade={CascadeType.ALL}) 
	private Set<Asignar_Proyecto>asignar_proyecto;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto
	 *            the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo
	 *            the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the movil
	 */
	public String getMovil() {
		return movil;
	}

	/**
	 * @param movil
	 *            the movil to set
	 */
	public void setMovil(String movil) {
		this.movil = movil;
	}

	/**
	 * @return the fecha_creacion
	 */
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * @param fecha_creacion
	 *            the fecha_creacion to set
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the roles
	 */
	public Roles getRoles() {
		if (this.roles == null)
			return new Roles();
		else
			return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return the proyectos
	 */
	public Set<Proyectos> getProyectos() {
		if (this.proyectos == null)
			return new HashSet<Proyectos>();
		else
			return proyectos;
	}

	/**
	 * @param proyectos
	 *            the proyectos to set
	 */
	public void setProyectos(Set<Proyectos> proyectos) {
		this.proyectos = proyectos;
	}

	/**
	 * @return the asignar_proyecto
	 */
	public Set<Asignar_Proyecto> getAsignar_proyecto() {
		if (this.asignar_proyecto == null)
			return new HashSet<Asignar_Proyecto>();
		return asignar_proyecto;
	}

	/**
	 * @param asignar_proyecto
	 *            the asignar_proyecto to set
	 */
	public void setAsignar_proyecto(Set<Asignar_Proyecto> asignar_proyecto) {
		this.asignar_proyecto = asignar_proyecto;
	}

	@Override
	public String toString() {
		return "Usuarios " + this.id;
	}
}
