package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.avantia.sv.claro.pcp.entidades.Preguntas;
import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansChat")
@ViewScoped
public class BeansChat extends Acciones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Preguntas preguntas; 
    private Preguntas selectPreguntas;
    private ArrayList<Preguntas>listapreguntas;
	
	@PostConstruct
	public void init(){
		preguntas= new Preguntas();
		listapreguntas= new ArrayList<Preguntas>();
		cargarLista();
	}
	
	public void onRowSelect(SelectEvent event) 
	{
		setSelectPreguntas(((Preguntas) event.getObject()));
		if(getSelectPreguntas()!=null)
			setPreguntas(getSelectPreguntas());
		RequestContext.getCurrentInstance().update("IDFchat");
		
			
	}
	
	public String confirmarEstado(String estado){
		
		if(estado.equals("true")){
			
			return "Pendiente";
		}else{
			
			return "Contestado";
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setListapreguntas((ArrayList<Preguntas>) ejecucion.listData("FROM PREGUNTAS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}
	
	
	public void preguntar(){
		
		
	}
	
	public void responder(){
		
		
		
	}
	

	/**
	 * @return the preguntas
	 */
	public Preguntas getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * @return the listapreguntas
	 */
	public ArrayList<Preguntas> getListapreguntas() {
		return listapreguntas;
	}

	/**
	 * @param listapreguntas the listapreguntas to set
	 */
	public void setListapreguntas(ArrayList<Preguntas> listapreguntas) {
		this.listapreguntas = listapreguntas;
	}

	/**
	 * @return the selectPreguntas
	 */
	public Preguntas getSelectPreguntas() {
		return selectPreguntas;
	}

	/**
	 * @param selectPreguntas the selectPreguntas to set
	 */
	public void setSelectPreguntas(Preguntas selectPreguntas) {
		this.selectPreguntas = selectPreguntas;
	}

	
	
	
}
