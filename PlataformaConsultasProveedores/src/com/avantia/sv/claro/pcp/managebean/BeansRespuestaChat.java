package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Respuestas;



@ManagedBean(name="beansRespuestaChat")
@ViewScoped
public class BeansRespuestaChat implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Respuestas respuestas;
    private ArrayList<Respuestas>listaresp;
	
	
	@PostConstruct
	public void init(){

    respuestas = new Respuestas();
		
	}


	public Respuestas getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(Respuestas respuestas) {
		this.respuestas = respuestas;
	}


	public ArrayList<Respuestas> getListaresp() {
		return listaresp;
	}


	public void setListaresp(ArrayList<Respuestas> listaresp) {
		this.listaresp = listaresp;
	}
   
	
     public void responderChat(){
    	 
    	 
    	 
     }
	
	
}
