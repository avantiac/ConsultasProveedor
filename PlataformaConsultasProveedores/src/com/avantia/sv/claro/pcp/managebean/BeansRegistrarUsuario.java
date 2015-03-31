package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Usuarios;



@ManagedBean(name="beansRegistrarUsuario")
@ViewScoped
public class BeansRegistrarUsuario extends Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuarios usuarios;
    ArrayList<Usuarios>tablaUsuario;
	
	
	@PostConstruct
	public void init(){
		usuarios= new Usuarios();
		
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	
	
	public ArrayList<Usuarios> getTablaUsuario() {
		return tablaUsuario;
	}

	public void setTablaUsuario(ArrayList<Usuarios> tablaUsuario) {
		this.tablaUsuario = tablaUsuario;
	}

	public void registrarUsuario(){
		
		
	}
	
	public void actualizarUsuario(){
		
		
	}
	
	public void eliminarUsuario(){
		
		
	}
	
	
	
}
