package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;



@ManagedBean(name="beansRegistrarUsuario")
@SessionScoped
public class BeansRegistrarUsuario extends Acciones implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuarios usuarios;
	private Usuarios usuariosElected;
    private ArrayList<Usuarios>tablaUsuario;
    private ArrayList<Roles>listaRoles;
    private int idRole;
	
	
	@PostConstruct
	public void init(){
		setUsuarios(new Usuarios());
		ListarRoles();
		cargarLista();
	}

	@SuppressWarnings("unchecked")
	private void ListarRoles() {
		try {
			setListaRoles((ArrayList<Roles>) getEjecucion().listData("FROM ROLES"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		try {
			setTablaUsuario((ArrayList<Usuarios>) getEjecucion().listData("FROM USUARIOS"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		}
	}
	
	
        public void ejecutarProceso(){
		
		 if(getUsuarios().getId()==0){
			
			 registrarUsuario();
			 
		  }else{
			
			  actualizarUsuario();
			
		  }
		
	   }
        
        public void cancelar(){
  		  //setUsuarioSessionMB(new UsuarioSessionMB());
  		  usuarios.setId(0);
  		  RequestContext.getCurrentInstance().update("IDFrmPrincipal:IDPnlGridTab5");
  		 }
        

	public void registrarUsuario(){
		try {
			System.out.println(getUsuarios() == null);
			
			Date date = new Date();
			getUsuarios().setFecha_creacion(date);
			Roles rol = new Roles();
			rol.setId(getIdRole());
			getUsuarios().setRoles(rol);			
			getEjecucion().createData(getUsuarios());
			cargarLista();			
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally
		{
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
	}
	
	public void actualizarUsuario(){
		try {
			getEjecucion().updateData(getUsuarios());
			cargarLista();
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} finally
		{
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
	}
	
	public void eliminarUsuario(){
		try {
			getEjecucion().deleteData(getUsuarios());
			cargarLista();
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} 		
		finally
		{
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
	}
	
	
	public void onRowSelect(SelectEvent event) 
	{

		setUsuariosElected(((Usuarios) event.getObject()));
		if(getUsuariosElected()!=null)
			setUsuarios(getUsuariosElected());
		    usuarios.setClave(usuariosElected.getClave());
		    usuarios.setUsuario(usuariosElected.getUsuario());
		    
		RequestContext.getCurrentInstance().update("IDFusuarios");
			
	}
	

	/**
	 * @return the usuarios
	 */
	public Usuarios getUsuarios() {
		if(this.usuarios== null)
			return new Usuarios();
		else
			return this.usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(Usuarios usuarios) {
		System.out.println("hey esta diciendome que lo hjaga nulo al usuario");
		this.usuarios = usuarios;
	}

	/**
	 * @return the tablaUsuario
	 */
	public ArrayList<Usuarios> getTablaUsuario() {
		return tablaUsuario;
	}

	/**
	 * @param tablaUsuario
	 *            the tablaUsuario to set
	 */
	public void setTablaUsuario(ArrayList<Usuarios> tablaUsuario) {
		this.tablaUsuario = tablaUsuario;
	}

	/**
	 * @return the listaRoles
	 */
	public ArrayList<Roles> getListaRoles() {
		return listaRoles;
	}

	/**
	 * @param listaRoles
	 *            the listaRoles to set
	 */
	public void setListaRoles(ArrayList<Roles> listaRoles) {
		this.listaRoles = listaRoles;
	}

	/**
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole
	 *            the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the usuariosElected
	 */
	public Usuarios getUsuariosElected() {
		return usuariosElected;
	}

	/**
	 * @param usuariosElected the usuariosElected to set
	 */
	public void setUsuariosElected(Usuarios usuariosElected) {
		this.usuariosElected = usuariosElected;
	}
}
