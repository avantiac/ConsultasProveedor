package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;

@ManagedBean(name="beansAsignarProyecto")
@ViewScoped
public class BeansAsignarProyecto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Asignar_Proyecto asignarproyecto;
	private ArrayList<Asignar_Proyecto>litasAsigProy;
	
	@PostConstruct
	public void init(){
		
		asignarproyecto = new Asignar_Proyecto();
	}

	public Asignar_Proyecto getAsignarproyecto() {
		return asignarproyecto;
	}

	public void setAsignarproyecto(Asignar_Proyecto asignarproyecto) {
		this.asignarproyecto = asignarproyecto;
	}

	public ArrayList<Asignar_Proyecto> getLitasAsigProy() {
		return litasAsigProy;
	}

	public void setLitasAsigProy(ArrayList<Asignar_Proyecto> litasAsigProy) {
		this.litasAsigProy = litasAsigProy;
	}
	
	public void asignarProyecto(){
		
		
	}
	
	public void actualizarAsignacionProyecto(){
	
		
		
		
	}
	
	public void eliminarAsignacionProyecto(){
		
		
		
	}
	
}
