package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;
import com.avantia.sv.claro.pcp.entidades.Preguntas;
import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansPreguntasChat")
@ViewScoped
public class BeansPreguntasChat extends Acciones implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Preguntas  preguntas;
	private Preguntas selectPreguntas;
    private ArrayList<Preguntas>litaPreguntas;
	@PostConstruct
	public void init(){
		
		setPreguntas(new Preguntas());
		litaPreguntas = new ArrayList<Preguntas>();
		//cargarLista();
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setLitaPreguntas((ArrayList<Preguntas>) ejecucion.listData("FROM PREGUNTAS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}
	
	public void realizarPregunta(){
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			Asignar_Proyecto idasig = new Asignar_Proyecto();
			idasig.setId(14);
			preguntas.setAsignacion(idasig);
			preguntas.setFecha_creacion(new Date());
			ejecucion.createData(getPreguntas());
			setPreguntas(new Preguntas());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFpreguntar");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
	}

	
	public void onRowSelect(SelectEvent event) 
	{
		setSelectPreguntas(((Preguntas) event.getObject()));
		if(getSelectPreguntas()!=null)
			setPreguntas(getSelectPreguntas());
		RequestContext.getCurrentInstance().update("IDFpreguntar");
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
	 * @return the litaPreguntas
	 */
	public ArrayList<Preguntas> getLitaPreguntas() {
		return litaPreguntas;
	}

	/**
	 * @param litaPreguntas the litaPreguntas to set
	 */
	public void setLitaPreguntas(ArrayList<Preguntas> litaPreguntas) {
		this.litaPreguntas = litaPreguntas;
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
