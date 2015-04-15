package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;
import com.avantia.sv.claro.pcp.entidades.Preguntas;
import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansPreguntasChat")
@ViewScoped
public class BeansPreguntasChat extends Acciones implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Preguntas  preguntas;
    private ArrayList<Proyectos>selectProyecto;
    private ArrayList<Asignar_Proyecto>Asignacion;
    private ArrayList<Usuarios>selectUsuario;
    private int idUsuario;
    private int idProyecto;
    private Asignar_Proyecto asignar;
	
    @PostConstruct
	public void init()
    {		
		setPreguntas(new Preguntas());
		listaProyectos();
	}
	
	@SuppressWarnings("unchecked")
	private void listaProyectos() {
		try {
			setSelectProyecto((ArrayList<Proyectos>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_usuario="+getUsuarioSessionMB().getUsuario().getId()));
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de proyectos no logro ser cargada", 
					new Exception("La lista de proyectos no logro ser cargada"));
		}
	}
	
	private int tomarIdAsignacion() {
		try {
			setAsignacion((ArrayList<Asignar_Proyecto>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_proyecto="+getIdProyecto()+" and id_usuario= "+getIdUsuario()));
			
			setAsignar(getAsignacion().get(0));
			
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de proyectos no logro ser cargada", 
					new Exception("La lista de proyectos no logro ser cargada"));
		}
		return getAsignar().getId();
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
		System.out.println("se mando un id del proyecto:"+ getIdProyecto());
		try 
		{
			setSelectUsuario((ArrayList<Usuarios>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_proyecto="+getIdProyecto()));
		} 
		catch (Exception e) 
		{
			lanzarMensajeError("Error", "La lista de usuarios no logro ser cargada", new Exception("La lista de usuarios no logro ser cargadas"));
		}
	}
	
	public void realizarPregunta(){
		try {
			Asignar_Proyecto idasig = new Asignar_Proyecto();
			idasig.setId(tomarIdAsignacion());
			
			getPreguntas().setAsignacion(idasig);
			getPreguntas().setFecha_creacion(new Date());
			getPreguntas().setEstado(true);
			getEjecucion().createData(getPreguntas());
			setPreguntas(new Preguntas());
			RequestContext.getCurrentInstance().update("IDFpreguntar");
		} catch (Exception e) {
			lanzarMensajeError("Error", "No se registro la pregunta", 
					new Exception("No se registro la pregunta"));
		} finally {
			setPreguntas(new Preguntas());
			RequestContext.getCurrentInstance().update("IDFpreguntar");
		}
		
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
	 * @return the selectProyecto
	 */
	public ArrayList<Proyectos> getSelectProyecto() {
		return selectProyecto;
	}

	/**
	 * @param selectProyecto the selectProyecto to set
	 */
	public void setSelectProyecto(ArrayList<Proyectos> selectProyecto) {
		this.selectProyecto = selectProyecto;
	}

	/**
	 * @return the selectUsuario
	 */
	public ArrayList<Usuarios> getSelectUsuario() {
		return selectUsuario;
	}

	/**
	 * @param selectUsuario the selectUsuario to set
	 */
	public void setSelectUsuario(ArrayList<Usuarios> selectUsuario) {
		this.selectUsuario = selectUsuario;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idProyecto
	 */
	public int getIdProyecto() {
		return idProyecto;
	}

	/**
	 * @param idProyecto the idProyecto to set
	 */
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	/**
	 * @return the asignacion
	 */
	public ArrayList<Asignar_Proyecto> getAsignacion() {
		return Asignacion;
	}

	/**
	 * @param asignacion the asignacion to set
	 */
	public void setAsignacion(ArrayList<Asignar_Proyecto> asignacion) {
		Asignacion = asignacion;
	}

	/**
	 * @return the asignar
	 */
	public Asignar_Proyecto getAsignar() {
		return asignar;
	}

	/**
	 * @param asignar the asignar to set
	 */
	public void setAsignar(Asignar_Proyecto asignar) {
		this.asignar = asignar;
	}

	
}
