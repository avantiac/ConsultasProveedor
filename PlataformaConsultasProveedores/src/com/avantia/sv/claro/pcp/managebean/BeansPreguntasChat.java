package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;
import com.avantia.sv.claro.pcp.entidades.Preguntas;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;

@ManagedBean(name="beansPreguntasChat")
@ViewScoped
public class BeansPreguntasChat extends Acciones implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idProyecto;
	private Preguntas  preguntas;
	private List<Asignar_Proyecto> proyectos;
    private List<Asignar_Proyecto>usuariosResponder;
    private Asignar_Proyecto paraPreguntar;
    
    @PostConstruct
	public void init()
    {		
		setPreguntas(new Preguntas());
		listaProyectos();
	}
    
    /**
     * Obtenemos todos los proyectos para el usuario logueado
     * */
	@SuppressWarnings("unchecked")
	private void listaProyectos() {
		try {
			setProyectos((ArrayList<Asignar_Proyecto>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_usuario="+getUsuarioSessionMB().getUsuario().getId()));
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de proyectos no logro ser cargada", 
					new Exception("La lista de proyectos no logro ser cargada"));
		}
	}
	
	/**
	 * Metodo que debe enlistar a los usuarios de acuerdo al id de proyecto
	 * seleccionado
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @return {@link Void}
	 * */
	@SuppressWarnings("unchecked")
	public void listaUsuarios() {
		try 
		{
			setUsuariosResponder((ArrayList<Asignar_Proyecto>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_proyecto = '"+getIdProyecto() + "' and id_usuario != " + getUsuarioSessionMB().getUsuario().getId() ));
		} 
		catch (Exception e) 
		{
			lanzarMensajeError("Error", "La lista de usuarios no logro ser cargada", new Exception("La lista de usuarios no logro ser cargadas"));
		}
	}
	
	/**
	 * Metodo para generar el guardar del objeto pregunta
	 * */
	public void realizarPregunta(){
		try {
			System.out.println("Guardar Pregunta");
			getPreguntas().setAsignacion(getParaPreguntar());
			getPreguntas().setFecha_creacion(new Date());
			getPreguntas().setEstado(true);//es para que en el momento de crearse se conozca  como pendiente de preguntar
			System.out.println("en este momento");
			getEjecucion().createData(getPreguntas());
			System.out.println("yaaaaa");
		} catch (Exception e) {
			lanzarMensajeError("Error", "No se registro la pregunta", 
					new Exception("No se registro la pregunta"));
		} finally {
			setPreguntas(new Preguntas());
			RequestContext.getCurrentInstance().update("IDFpreguntar");
			RequestContext.getCurrentInstance().execute("IDDialogPreguntas.hide()");
		}		
	}
	

	/**
	 * @return the preguntas
	 */
	public Preguntas getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas
	 *            the preguntas to set
	 */
	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * @return the idProyecto
	 */
	public int getIdProyecto() {
		return idProyecto;
	}

	/**
	 * @param idProyecto
	 *            the idProyecto to set
	 */
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	/**
	 * @return the paraPreguntar
	 */
	public Asignar_Proyecto getParaPreguntar() {
		return paraPreguntar;
	}

	/**
	 * @param paraPreguntar
	 *            the paraPreguntar to set
	 */
	public void setParaPreguntar(Asignar_Proyecto paraPreguntar) {
		this.paraPreguntar = paraPreguntar;
	}

	/**
	 * @return the proyectos
	 */
	public List<Asignar_Proyecto> getProyectos() {
		return proyectos;
	}

	/**
	 * @param proyectos
	 *            the proyectos to set
	 */
	public void setProyectos(List<Asignar_Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	/**
	 * @return the usuariosResponder
	 */
	public List<Asignar_Proyecto> getUsuariosResponder() {
		return usuariosResponder;
	}

	/**
	 * @param usuariosResponder
	 *            the usuariosResponder to set
	 */
	public void setUsuariosResponder(List<Asignar_Proyecto> usuariosResponder) {
		this.usuariosResponder = usuariosResponder;
	}	
}
