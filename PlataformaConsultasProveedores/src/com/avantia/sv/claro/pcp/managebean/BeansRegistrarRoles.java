package com.avantia.sv.claro.pcp.managebean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Roles;



@ManagedBean(name="beansRegistrarRoles")
@ViewScoped
public class BeansRegistrarRoles {

	private Roles roles; 
	private ArrayList<Roles>tablaroles;
	
	@PostConstruct
	public void init(){
		roles= new Roles();
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public ArrayList<Roles> getTablaroles() {
		return tablaroles;
	}

	public void setTablaroles(ArrayList<Roles> tablaroles) {
		this.tablaroles = tablaroles;
	}
	
	public void registrarRoles(){
		
		
	}
	
	public void actualizarRoles(){
		
		
		
	}
	
	public void eliminarRoles(){
		
		
	}
	
}
