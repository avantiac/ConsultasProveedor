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
import com.avantia.sv.claro.pcp.entidades.Respuestas;
import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansRespuestaChat")
@ViewScoped
public class BeansRespuestaChat extends Acciones implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Respuestas respuestas;
    private Respuestas selectRerpuestas;
    private ArrayList<Respuestas>listaresp;
	
	
	@PostConstruct
	public void init(){

    setRespuestas(new Respuestas());
    listaresp= new ArrayList<Respuestas>();
    cargarLista();	
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setListaresp((ArrayList<Respuestas>) ejecucion.listData("FROM RESPUESTAS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}
	
	
     public void responderChat(){
    	 
    	BdEjecucion ejecucion = new BdEjecucion();
 		try {
 			
 			Preguntas pregunta = new Preguntas();
 			pregunta.setId(5);
 			Asignar_Proyecto asignacion = new Asignar_Proyecto();
 			asignacion.setId(14);
 			
 			respuestas.setAsignacion(asignacion);
 			respuestas.setPregunta(pregunta);
 			respuestas.setFecha_creacion(new Date());
 			
 			ejecucion.createData(getRespuestas());
 			setRespuestas(new Respuestas());
 			cargarLista();
 			RequestContext.getCurrentInstance().update("IDFrespuestas");
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
 		setSelectRerpuestas(((Respuestas) event.getObject()));
 		if(getSelectRerpuestas()!=null)
 			setRespuestas(getSelectRerpuestas());
 		RequestContext.getCurrentInstance().update("IDFrespuestas");
 		
 	}
 	
 	
 	
	private void mostrarMensajeError(String msg) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"", msg));
		if (requestContext != null) {
			requestContext.update("IDGrowlErrorSistemas");
		}
	}
 	
 	
	/**
	 * @return the respuestas
	 */
	public Respuestas getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(Respuestas respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * @return the listaresp
	 */
	public ArrayList<Respuestas> getListaresp() {
		return listaresp;
	}

	/**
	 * @param listaresp the listaresp to set
	 */
	public void setListaresp(ArrayList<Respuestas> listaresp) {
		this.listaresp = listaresp;
	}

	/**
	 * @return the selectRerpuestas
	 */
	public Respuestas getSelectRerpuestas() {
		return selectRerpuestas;
	}

	/**
	 * @param selectRerpuestas the selectRerpuestas to set
	 */
	public void setSelectRerpuestas(Respuestas selectRerpuestas) {
		this.selectRerpuestas = selectRerpuestas;
	}
	
	
	
}
