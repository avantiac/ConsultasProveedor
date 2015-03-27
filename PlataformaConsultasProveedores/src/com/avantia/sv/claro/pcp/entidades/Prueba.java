/**
 * 
 */
package com.avantia.sv.claro.pcp.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Edwin Mejia - Avantia Consultores
 * 
 */
@Entity(name = "PRUEBA")
@Table(name = "PRUEBA", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Prueba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Seq_Gen_Prueba")
	@SequenceGenerator(name = "Seq_Gen_Prueba", sequenceName = "SQ_PRUEBA")
	@Id
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @author Edwin Mejia - Avantia Consultores
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Prueba " + this.id;
	}
}
