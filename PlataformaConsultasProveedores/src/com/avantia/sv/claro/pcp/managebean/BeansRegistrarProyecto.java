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
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setListarProyecto((ArrayList<Proyectos>) ejecucion.listData("FROM PROYECTOS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
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
 		  //setUsuarioSessionMB(new UsuarioSessionMB());
 		  proyecto.setId(0);
 		  RequestContext.getCurrentInstance().update("IDFrmPrincipal:IDPnlGridTab5");
 		 }
       
		public boolean validar(){
			
			 if(getProyecto().getNombre().isEmpty()  ){
					
					lanzarMensajeError("Error", "El nombre del proyecto es obligatorio", new Exception("Tiene que ingresar un nombre"));
					return true;
				
				}else{
					return false;
					
				}
		}
	
	public void registrarProyecto(){
		
		if(validar())
			return;
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			
			proyecto.setFecha_creacion(new Date());
			proyecto.setUsuarioCreador(getUsuarioSessionMB().getUsuario());
			ejecucion.createData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
	}
		
	public void actualizarProyecto(){
		
		if(validar())
			return;
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			ejecucion.updateData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
	}
	
	
	public void eliminarProyecto(){
		
		if(validar())
			return;
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			ejecucion.deleteData(getProyecto());
			setProyecto(new Proyectos());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFProyectos");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
		
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
	
	public void onRowSelect(SelectEvent event) 
	{
		setSelectProyecto(((Proyectos) event.getObject()));
		if(getSelectProyecto()!=null)
			setProyecto(getSelectProyecto());
		RequestContext.getCurrentInstance().update("IDFProyectos");
		
			
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
