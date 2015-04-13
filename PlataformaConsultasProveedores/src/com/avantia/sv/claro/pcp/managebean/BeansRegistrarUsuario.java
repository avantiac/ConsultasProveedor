package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String clave1;
    private String clave2;
	
	
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

			
			lanzarMensajeError("Error", "Lista de roles no pudo ser cargarada", 
					new Exception("Lista de roles no pudo ser cargarada"));
		} 
	}
	
	@SuppressWarnings("unchecked")
	private void cargarLista() {
		try {
			setTablaUsuario((ArrayList<Usuarios>) getEjecucion().listData("FROM USUARIOS"));
		} catch (Exception e) {

			lanzarMensajeError("Error", "la tabla usuarios no pudo ser cargada", 
					new Exception("la tabla usuarios no pudo ser cargada"));
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
  
        	setUsuarios(new Usuarios());
        	setIdRole(0);
        	setClave1("");
        	setClave2("");
			RequestContext.getCurrentInstance().update("IDFusuarios");
  		 }
        

    private boolean validar(){
    	// validar que las dos claves vayan a coincidir
		if(!getClave1().isEmpty() || !getClave2().isEmpty()  ){
			if(!getClave1().equals(getClave2())){
				lanzarMensajeError("Error", "Las claves no coinciden", new Exception("Las claves que metieron no coinciden por eso se les dijo que no podian guardar el usuario"));
				return true;
			}
			
			if(getUsuarios().getUsuario().isEmpty() ){
				lanzarMensajeError("Error", "ingrese un usuario", new Exception("es necesario un usuario para continuar con el proceso"));
				return true;	
			}
			
			if(getUsuarios().getEmpresa().isEmpty()){
				
				return true;
			}
			
			
    
		         
			
		}else{
			lanzarMensajeError("Error", "Debe ingresar la clave", new Exception("Envio la claave 1 vacia por lo tanto no dejamos que guardara el usuario"));
			return true;
		}
		
		return false;
    }
    
    
    public boolean  mascaraTelefono(){
    	
    	if(!getUsuarios().getTelefono().isEmpty()){
			
			if (getUsuarios().getTelefono().matches("[0-9]*")){
				
				  return false;
			}
			
			else{
				 
				 lanzarMensajeError("Error", "El numero de telefono no contiene el formato correcto", new Exception("El numero de telefono no contiene el formato correcto"));
				 return true;
		   }
		
		}else{
			
			return false;
		}
    }
    
    public boolean mascaraMovil(){
    	
    	if(!getUsuarios().getMovil().isEmpty()){
			   
			if (getUsuarios().getMovil().matches("[0-9]*")){
				
				  return false;
			}
			
			 else{
				 
				 lanzarMensajeError("Error", "El numero del movil no contiene el formato correcto", new Exception("El numero del movil no contiene el formato correcto"));
				  return true;
		    }
		}else{
			
			return false;
		}
    }
    
    public boolean mascaraCorreo(){
    	
    	if(!getUsuarios().getCorreo().isEmpty()){
			
    	   Pattern Plantilla = null;
  	       Matcher Resultado = null;
  	       Plantilla = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
  	       Resultado = Plantilla.matcher(getUsuarios().getCorreo());
			if (Resultado.find()){
				
				  return false;
			}
			
			 else{
				 
				 lanzarMensajeError("Error", "El correo no contiene el formato correcto", 
						 new Exception("El correo no contiene el formato correcto"));
				  return true;
		    }
		
     }else{
    	 
    	 return false;
     }
    }
    
	public void registrarUsuario(){
		try {

			if(validar())
				return;
			if(mascaraTelefono())
				return;
			if(mascaraMovil())
				return;
			if(mascaraCorreo())
				return;
			
			getUsuarios().setClave(getClave1());
			Date date = new Date();
			getUsuarios().setFecha_creacion(date);
			Roles rol = new Roles();
			rol.setId(getIdRole());
			getUsuarios().setRoles(rol);			
			getEjecucion().createData(getUsuarios());
			cargarLista();			
		} catch (Exception e) {
			
			 lanzarMensajeError("Error", "El cusuario no fue creado", 
					 new Exception("El cusuario no fue creado"));
		} finally
		{
			setIdRole(0);
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
	}
	

	
	public void actualizarUsuario(){
		
		if(mascaraTelefono())
			return;
		if(mascaraMovil())
			return;
		if(mascaraCorreo())
			return;
		
		try {
			getEjecucion().updateData(getUsuarios());
			cargarLista();
		} catch (Exception e) {
	     
			 lanzarMensajeError("Error", "El cusuario no fue actualizado", 
					 new Exception("El cusuario no fue actualizado"));
			
		} finally
		{
			setIdRole(0);
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
		
	}

	
	public void eliminarUsuario(){

		//en este el mensaje sera el usuario a eliminar
		
		try {
			getEjecucion().deleteData(getUsuarios());
			cargarLista();
		} catch (Exception e) {
			lanzarMensajeError("Error", "El cusuario no fue eliminado", 
					 new Exception("El cusuario no fue eliminado"));
		} 		
		finally
		{
			setIdRole(0);
			setUsuarios(new Usuarios());
			RequestContext.getCurrentInstance().update("IDFusuarios");
		}
	}
	
	
	public void onRowSelect(SelectEvent event) 
	{

		setUsuariosElected(((Usuarios) event.getObject()));
		if(getUsuariosElected()!=null){
			setUsuarios(getUsuariosElected());
		    setIdRole(getUsuarios().getRoles().getId());
		    setClave1(getUsuarios().getClave());
		    setClave2(getUsuarios().getClave());
		    
		   
		}
		    
		RequestContext.getCurrentInstance().update("IDFusuarios");
			
	}
	
	public String confirmarEstado(String estado){
		
		if(estado=="true"){
			
			return "Activo";
		}else{
			
			return "Inactivo";
			
		}
		
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

	/**
	 * @return the clave1
	 */
	public String getClave1() {
		return clave1;
	}

	/**
	 * @param clave1 the clave1 to set
	 */
	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	/**
	 * @return the clave2
	 */
	public String getClave2() {
		return clave2;
	}

	/**
	 * @param clave2 the clave2 to set
	 */
	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}
}
