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

import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansRegistrarProyecto")
@ViewScoped
public class BeansRegistrarProyecto extends Acciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Proyectos proyecto;
	private Proyectos selectProyecto;
	private ArrayList<Proyectos>listarProyecto;
	@PostConstruct
	public void init(){
		setProyecto(new Proyectos());
		listarProyecto= new ArrayList<Proyectos>();
		cargarLista();
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		try {
			setListarProyecto((ArrayList<Proyectos>) getEjecucion().listData("FROM PROYECTOS"));
		} catch (Exception e) {
			
			lanzarMensajeError("Error", "La lista proyectos no pudo ser cargada",
					new Exception("La lista proyectos no pudo ser cargada"));
		}
	}

	 public void ejecutarProceso(){
			
		 if(getProyecto().getId()==0){
			
			 registrarProyecto();
			 
		  }else{
			
			  actualizarProyecto();
			
		  }
		
	   }
	 
	 public void cancelar(){
 		 setProyecto(new Proyectos());
 		 RequestContext.getCurrentInstance().update("IDFProyectos");
 		 
 		 }
       
		public boolean validar(){
			
			 if(getProyecto().getNombre().isEmpty()  ){
					
					lanzarMensajeError("Error", "El nombre del proyecto es obligatorio",
							new Exception("Tiene que ingresar un nombre"));
					return true;
				
				}else{
					return false;
					
				}
		}
	
	public void registrarProyecto(){
		
		if(validar())
			return;
		try {
			
			proyecto.setFecha_creacion(new Date());
			proyecto.setUsuarioCreador(getUsuarioSessionMB().getUsuario());
			getProyecto().setNombre(getProyecto().getNombre().toUpperCase());
			getEjecucion().createData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			lanzarMensajeError("Error", "El proyecto no fue registrado",
					new Exception("El proyecto no fue registrado"));
		} finally {
			setProyecto(new Proyectos());
			RequestContext.getCurrentInstance().update("IDFProyectos");
		}
		
	}
		
	public void actualizarProyecto(){
		
		if(validar())
			return;
		
		try {
			getProyecto().setNombre(getProyecto().getNombre().toUpperCase());
			getEjecucion().updateData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			lanzarMensajeError("Error", "El proyecto no fue actualizado",
					new Exception("El proyecto no fue actualizado"));
		} finally {
			setProyecto(new Proyectos());
			RequestContext.getCurrentInstance().update("IDFProyectos");
		}
		
	}
	
	
	public void eliminarProyecto(){
		
		if(validar())
			return;
		
		try {
			
			getEjecucion().deleteData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			lanzarMensajeError("Error", "El proyecto no fue eliminado",
					new Exception("El proyecto no fue eliminado"));
		} finally {
			setProyecto(new Proyectos());
			RequestContext.getCurrentInstance().update("IDFProyectos");
		}
		
		
	}
	
	
	public void onRowSelect(SelectEvent event) 
	{
		setSelectProyecto(((Proyectos) event.getObject()));
		if(getSelectProyecto()!=null)
			setProyecto(getSelectProyecto());
		RequestContext.getCurrentInstance().update("IDFProyectos");
		
			
	}
	
	public String mostrarEstado(String estado){
		
		if(estado.equals("true")){
			
			return "Activo";
		}else{
			
			return "Inactivo";
		}
		
	}
	

	/**
	 * @return the proyecto
	 */
	public Proyectos getProyecto() {
		return proyecto;
	}

	/**
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return the listarProyecto
	 */
	public ArrayList<Proyectos> getListarProyecto() {
		return listarProyecto;
	}

	/**
	 * @param listarProyecto the listarProyecto to set
	 */
	public void setListarProyecto(ArrayList<Proyectos> listarProyecto) {
		this.listarProyecto = listarProyecto;
	}

	public Proyectos getSelectProyecto() {
		return selectProyecto;
	}

	public void setSelectProyecto(Proyectos selectProyecto) {
		this.selectProyecto = selectProyecto;
	}
	
	
}
