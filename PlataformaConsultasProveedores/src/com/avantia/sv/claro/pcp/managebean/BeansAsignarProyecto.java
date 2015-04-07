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
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setLitasAsigProy((ArrayList<Asignar_Proyecto>) ejecucion.listData("FROM ASIGNAR_PROYECTO"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void listaProyectos() {
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setLitarProyectos((ArrayList<Proyectos>) ejecucion.listData("FROM PROYECTOS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void listaUsuarios() {
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setLitarUsuarios((ArrayList<Usuarios>) ejecucion.listData("FROM USUARIOS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
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
 		  //setUsuarioSessionMB(new UsuarioSessionMB());
 		  asignarproyecto.setId(0);
 		  RequestContext.getCurrentInstance().update("IDFrmPrincipal:IDPnlGridTab5");
 		 }
	
	public void asignarProyecto(){
	
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			
			asignarproyecto.setFecha_cracion(new Date());
			Usuarios usuario = new Usuarios();
			usuario.setId(idUsuario);
			Proyectos proyecto = new Proyectos();
			proyecto.setId(getIdProyecto());
			getAsignarproyecto().setUsuario(usuario);
			getAsignarproyecto().setProyecto(proyecto);
			ejecucion.createData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
	}
	
	public void actualizarAsignacionProyecto(){
	
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			ejecucion.updateData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
		
		
		
	}
	
	public void eliminarAsignacionProyecto(){
		
		
		
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			ejecucion.deleteData(getAsignarproyecto());
			setAsignarproyecto(new Asignar_Proyecto());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFasignarproyecto");
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
		setSelectAsignar(((Asignar_Proyecto) event.getObject()));
		if(getSelectAsignar()!=null)
			setAsignarproyecto(getSelectAsignar());
		RequestContext.getCurrentInstance().update("IDFasignarproyecto");
				
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
	
	
	
}
