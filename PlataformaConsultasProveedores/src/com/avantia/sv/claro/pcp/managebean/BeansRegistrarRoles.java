package com.avantia.sv.claro.pcp.managebean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.util.Acciones;

@ManagedBean(name = "beansRegistrarRoles")
@ViewScoped
public class BeansRegistrarRoles extends Acciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Roles roles;
	private Roles selectRoles;
	private ArrayList<Roles> tablaroles;

	@PostConstruct
	public void init() {
		roles = new Roles();
		tablaroles = new ArrayList<Roles>();
		cargarLista();
	}

	@SuppressWarnings("unchecked")
	private void cargarLista() {
		BdEjecucion ejecucion = new BdEjecucion();
		try {
			setTablaroles((ArrayList<Roles>) ejecucion.listData("FROM ROLES"));
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al enlistar
			e.printStackTrace();
		} finally {
			ejecucion = null;
		}
	}

	public void ejecutarProceso() {

		if (getRoles().getId() == 0) {

			registrarRoles();
		} else {

			actualizarRoles();
		}

	}

	public void cancelar() {

		setRoles(new Roles());
		RequestContext.getCurrentInstance().update("IDFroles");
	}

	public boolean validar() {

		if (getRoles().getNombre().isEmpty()) {

			lanzarMensajeError("Error",
					"El nombre del rol tiene que ser ingresado", new Exception(
							"El nombre del rol tiene que ser ingresado"));
			return true;

		} else {

			return false;
		}
	}

	public void registrarRoles() {

		if (validar())
			return;

		try {

			getRoles().setNombre(getRoles().getNombre().toUpperCase());
			getEjecucion().createData(getRoles());
			setRoles(new Roles());
			cargarLista();

			RequestContext.getCurrentInstance().update("IDFroles");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		}

	}

	public void actualizarRoles() {
		if (validar())
			return;

		try {
			getRoles().setNombre(getRoles().getNombre().toUpperCase());
			getEjecucion().updateData(getRoles());
			setRoles(new Roles());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFroles");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			e.printStackTrace();
		} 
	}

	public void eliminarRoles() {

		if (validar())
			return;

		BdEjecucion ejecucion = new BdEjecucion();
		try {

			ejecucion.deleteData(getRoles());
			setRoles(new Roles());
			cargarLista();
			RequestContext.getCurrentInstance().update("IDFroles");
		} catch (Exception e) {
			// TODO: se debe mandar un mensaje a la pantalla diciendo que
			// existio un error al guardar
			lanzarMensajeError(
					"Error",
					"Error verifiquie que el rol no tenga asignado un usuario para poder eliminarlo",
					new Exception("Error rol no fue eliminado"));

		} finally {
			ejecucion = null;

		}
	}

	public void onRowSelect(SelectEvent event) {
		setSelectRoles(((Roles) event.getObject()));
		if (getSelectRoles() != null)
			setRoles(getSelectRoles());
		RequestContext.getCurrentInstance().update("IDFroles");

	}

	public String textoDeEstado(String in) {
		System.out.println(in);
		if (in.equals("true")) {
			return "Activo";
		} else if (in.equals("false")) {
			return "Inactivo";
		} else {
			return "basura";
		}
	}

	/**
	 * @return the roles
	 */
	public Roles getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	/**
	 * @return the tablaroles
	 */
	public ArrayList<Roles> getTablaroles() {
		return tablaroles;
	}

	/**
	 * @param tablaroles
	 *            the tablaroles to set
	 */
	public void setTablaroles(ArrayList<Roles> tablaroles) {
		this.tablaroles = tablaroles;
	}

	/**
	 * @return the selectRoles
	 */
	public Roles getSelectRoles() {
		return selectRoles;
	}

	/**
	 * @param selectRoles
	 *            the selectRoles to set
	 */
	public void setSelectRoles(Roles selectRoles) {
		this.selectRoles = selectRoles;
	}

}
