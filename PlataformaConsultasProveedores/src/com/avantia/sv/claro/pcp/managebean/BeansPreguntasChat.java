package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.avantia.sv.claro.pcp.entidades.Preguntas;



@ManagedBean(name="beansPreguntasChat")
@ViewScoped
public class BeansPreguntasChat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Preguntas  preguntas;
    private ArrayList<Preguntas>litaPreguntas;
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
	public ArrayList<Preguntas> getLitaPreguntas() {
		return litaPreguntas;
	}
	public void setLitaPreguntas(ArrayList<Preguntas> litaPreguntas) {
		this.litaPreguntas = litaPreguntas;
	}
	
	public void realizarPregunta(){
		
		
	}
	
}
