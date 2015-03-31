package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Preguntas;



@ManagedBean(name="beansChat")
@ViewScoped
public class BeansChat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Preguntas preguntas; 
    private ArrayList<Preguntas>listapreguntas;
	
	@PostConstruct
	public void init(){
		preguntas= new Preguntas();
	}

	public Preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}

	public ArrayList<Preguntas> getListapreguntas() {
		return listapreguntas;
	}

	public void setListapreguntas(ArrayList<Preguntas> listapreguntas) {
		this.listapreguntas = listapreguntas;
	}
	
	
}
