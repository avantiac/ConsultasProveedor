package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;
import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;

@ManagedBean(name="beansAsignarProyecto")
@ViewScoped
public class BeansAsignarProyecto extends Acciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Asignar_Proyecto validarAsignacion;
	private Asignar_Proyecto asignarproyecto;
	private Asignar_Proyecto selectAsignar;
	private ArrayList<Asignar_Proyecto>litasAsigProy;
	private ArrayList<Usuarios>litarUsuarios;
	private ArrayList<Proyectos>litarProyectos;
	private int idUsuario;
	private int idProyecto;
	@PostConstruct
	public void init(){
		
		setAsignarproyecto(new Asignar_Proyecto());
		listaUsuarios();
		cargarLista();
		listaProyectos();
		
	}

	@SuppressWarnings("unchecked")
	private void cargarLista() {
		
		try {
			setLitasAsigProy((ArrayList<Asignar_Proyecto>) getEjecucion().listData("FROM ASIGNAR_PROYECTO"));
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de asignaciones no se logro cargar", 
					new Exception("La lista de asignaciones no se logro cargar"));
		} 
	}
	
	@SuppressWarnings("unchecked")
	private void listaProyectos() {
		try {
			setLitarProyectos((ArrayList<Proyectos>) getEjecucion().listData("FROM PROYECTOS"));
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de proyectos no pudo ser cargada", 
					new Exception("La lista de proyectos no pudo ser cargada"));
		} 
	}
	
	@SuppressWarnings("unchecked")
	private void listaUsuarios() {
		
		try {
			setLitarUsuarios((ArrayList<Usuarios>) getEjecucion().listData("FROM USUARIOS"));
		} catch (Exception e) {
			lanzarMensajeError("Error", "La lista de usuarios no fue cargadada", 
					new Exception("La lista de usuarios no fue cargadada"));
		} 
	}
	
	 public void ejecutarProceso(){
			
		 if(getAsignarproyecto().getId()==0){
			
			 asignarProyecto();
			 
		  }else{
			
			  actualizarAsignacionProyecto();
			
		  }
		
	   }
	 
	 public void cancelar(){
		 
		 setIdUsuario(0);
		 setIdProyecto(0);
		 setAsignarproyecto(new Asignar_Proyecto());
 		 RequestContext.getCurrentInstance().update("IDFasignarproyecto");
 		 }
	 
	 public boolean validar(){
		 
		 if(getIdUsuario()==0){
				
				lanzarMensajeError("Error", "Tiene que seleccionar un usuario", new Exception("Es obligatorio que el usuario sea seleccionado"));
				return true;
			}
		 
		    
		    if(getIdProyecto()==0){
				
				lanzarMensajeError("Error", "Tiene que seleccionar un proyecto", 
						new Exception("Es obligatorio que el proyecto sea seleccionado"));
				return true;
			}else {
				
				return false;
			}
	 }
	
	public void asignarProyecto(){
	
		if(validar())
			return;
		
		if(validarAsignacionProyecto())
			return;
		
		try {
			
			asignarproyecto.setFecha_cracion(new Date());
			Usuarios usuario = new Usuarios();
			usuario.setId(idUsuario);
		    System.out.println("Hola soy el id de usuario"+idUsuario);
			Proyectos proyecto = new Proyectos();
			proyecto.setId(idProyecto);
			System.out.println("Hola soy el id del proyecto"+idUsuario);
			getAsignarproyecto().setUsuario(usuario);
			getAsignarproyecto().setProyecto(proyecto);
			getEjecucion().createData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		} catch (Exception e) {
			lanzarMensajeError("Error", "No se pudo asignar el proyecto", 
					new Exception("No se pudo asignar el proyecto"));
		} finally {
			setIdProyecto(0);
			setIdUsuario(0);
			setAsignarproyecto(new Asignar_Proyecto());
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		}
		
	}
	
	public void actualizarAsignacionProyecto(){
		if(validar())
			return;
		if(validarAsignacionProyecto())
			return;
		
		try {
			
			asignarproyecto.setFecha_cracion(new Date());
			Usuarios usuario = new Usuarios();
			usuario.setId(idUsuario);
		    System.out.println("Hola soy el id de usuario"+idUsuario);
			Proyectos proyecto = new Proyectos();
			proyecto.setId(idProyecto);
			System.out.println("Hola soy el id del proyecto"+idUsuario);
			getAsignarproyecto().setUsuario(usuario);
			getAsignarproyecto().setProyecto(proyecto);
			getEjecucion().updateData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		} catch (Exception e) {
			lanzarMensajeError("Error", "No se pudo actualizar el cambio", 
					new Exception("No se pudo actualizar el cambio"));
		} finally {
			setIdProyecto(0);
			setIdUsuario(0);
			setAsignarproyecto(new Asignar_Proyecto());
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		}
		
		
		
	}
	
	public void eliminarAsignacionProyecto(){
		
		if(validar())
			return;
		
		
		try {
			getEjecucion().deleteData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		} catch (Exception e) {
			lanzarMensajeError("Error", "No se pudo eliminar la asignacion", 
					new Exception("No se pudo eliminar la asignacion"));
		} finally {
			setIdProyecto(0);
			setIdUsuario(0);
			setAsignarproyecto(new Asignar_Proyecto());
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		}
		
	}


	
	public void onRowSelect(SelectEvent event) 
	{
		setSelectAsignar(((Asignar_Proyecto) event.getObject()));
		if(getSelectAsignar()!=null)
			setAsignarproyecto(getSelectAsignar());
		    setIdUsuario(getAsignarproyecto().getUsuario().getId());
		    setIdProyecto(getAsignarproyecto().getProyecto().getId());
		RequestContext.getCurrentInstance().update("IDFasignarproyecto");
				
	}
	
	public boolean validarAsignacionProyecto() {
		
		List<Asignar_Proyecto> confirmar=null;
		try{
			@SuppressWarnings("unchecked")
			List<Asignar_Proyecto> confirmarAsignacion = (ArrayList<Asignar_Proyecto>) getEjecucion().listData("FROM ASIGNAR_PROYECTO where id_usuario = " + getIdUsuario() + " and id_proyecto = " + getIdProyecto()) ;
			
			  confirmar= confirmarAsignacion;

		}catch(Exception exp){
			exp.printStackTrace();
			
		}
		
		if (!confirmar.isEmpty()){
			lanzarMensajeError("Error", "El proyecto y el usuario ya se encuentran asignados", 
					new Exception("El proyecto y el usuario ya se encuentran asignados"));
            return true;
			}
			else {
				return false;
			}
	}


	/**
	 * @return the asignarproyecto
	 */
	public Asignar_Proyecto getAsignarproyecto() {
		if(this.asignarproyecto==null)
			return new Asignar_Proyecto();
		return asignarproyecto;
	}


	/**
	 * @param asignarproyecto the asignarproyecto to set
	 */
	public void setAsignarproyecto(Asignar_Proyecto asignarproyecto) {
		
			
		this.asignarproyecto = asignarproyecto;
	}


	/**
	 * @return the litasAsigProy
	 */
	public ArrayList<Asignar_Proyecto> getLitasAsigProy() {
		return litasAsigProy;
	}


	/**
	 * @param litasAsigProy the litasAsigProy to set
	 */
	public void setLitasAsigProy(ArrayList<Asignar_Proyecto> litasAsigProy) {
		this.litasAsigProy = litasAsigProy;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public ArrayList<Usuarios> getLitarUsuarios() {
		return litarUsuarios;
	}

	public void setLitarUsuarios(ArrayList<Usuarios> litarUsuarios) {
		this.litarUsuarios = litarUsuarios;
	}

	public ArrayList<Proyectos> getLitarProyectos() {
		return litarProyectos;
	}

	public void setLitarProyectos(ArrayList<Proyectos> litarProyectos) {
		this.litarProyectos = litarProyectos;
	}

	public Asignar_Proyecto getSelectAsignar() {
		return selectAsignar;
	}

	public void setSelectAsignar(Asignar_Proyecto selectAsignar) {
		this.selectAsignar = selectAsignar;
	}

	/**
	 * @return the validarAsignacion
	 */
	public Asignar_Proyecto getValidarAsignacion() {
		return validarAsignacion;
	}

	/**
	 * @param validarAsignacion the validarAsignacion to set
	 */
	public void setValidarAsignacion(Asignar_Proyecto validarAsignacion) {
		this.validarAsignacion = validarAsignacion;
	}
	
	
	
}
