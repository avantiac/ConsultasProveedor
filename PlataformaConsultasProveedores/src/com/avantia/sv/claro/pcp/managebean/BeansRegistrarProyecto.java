package com.avantia.sv.claro.pcp.managebean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Proyecto;



@ManagedBean(name="beansRegistrarProyecto")
@ViewScoped
public class BeansRegistrarProyecto {

	private Proyecto proyecto;
	private ArrayList<Proyecto>listarProyecto;
	@PostConstruct
	public void init(){
		proyecto= new Proyecto();
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public ArrayList<Proyecto> getListarProyecto() {
		return listarProyecto;
	}
	public void setListarProyecto(ArrayList<Proyecto> listarProyecto) {
		this.listarProyecto = listarProyecto;
	}
	
	public void registrarProyecto(){
		
		
	}
	
	public void actualizarProyecto(){
		
		
		
	}
	
	
	public void eliminarProyecto(){
		
		
		
	}
}
