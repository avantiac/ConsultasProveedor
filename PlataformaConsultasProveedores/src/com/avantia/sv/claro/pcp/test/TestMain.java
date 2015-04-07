package com.avantia.sv.claro.pcp.test;

import java.util.Date;
import java.util.List;

import com.avantia.sv.claro.pcp.entidades.Asignar_Proyecto;
import com.avantia.sv.claro.pcp.entidades.Preguntas;
import com.avantia.sv.claro.pcp.entidades.Proyectos;
import com.avantia.sv.claro.pcp.entidades.Respuestas;
import com.avantia.sv.claro.pcp.entidades.Roles;
import com.avantia.sv.claro.pcp.entidades.Usuarios;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.jdbc.SessionFactoryUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/*Roles roles = new Roles();
			roles.setEstado(true);
			roles.setNombre("Administrador");
			
			create(roles);*/
			
			/*Date dia= new Date();
				
			Usuarios usuarios = new Usuarios();
			Roles rol = new Roles();
			rol.setId(1);
			usuarios.setRoles(rol);
			usuarios.setUsuario("admin");
			usuarios.setClave("admin");
			usuarios.setEmpresa("avantia");
			usuarios.setContacto("1234");
			usuarios.setCorreo("uo@mail");
			usuarios.setTelefono("12345");
			usuarios.setMovil("12345");
			usuarios.setEstado(true);
			usuarios.setFecha_creacion(dia);
			
			create(usuarios);*/
			
			
			
			
			/*Usuarios usuarioAdmin = new Usuarios();
			usuarioAdmin.setId(3);
			
			Proyectos proyectos = new Proyectos();
			proyectos.setDescripcion("Proyecto Prueba");
			proyectos.setEstado(true);
			proyectos.setFecha_creacion(new Date());
			proyectos.setNombre("Proy prueba");
			proyectos.setUsuarioCreador(usuarioAdmin);
			
			create(proyectos);*/
			
			
		/*	 Roles roles = new Roles();
				roles.setEstado(true);
				roles.setNombre("Comun");
				
				create(roles);
				
				Usuarios usuarios = new Usuarios();
				Roles rol = new Roles();
				rol.setId(2);
				usuarios.setRoles(rol);
				usuarios.setUsuario("jose");
				usuarios.setClave("admin");
				usuarios.setEmpresa("avantia");
				usuarios.setContacto("1234");
				usuarios.setCorreo("uo@mail");
				usuarios.setTelefono("12345");
				usuarios.setMovil("12345");
				usuarios.setEstado(true);
				usuarios.setFecha_creacion(new Date());
				
				create(usuarios);*/
			
			/*Asignar_Proyecto asignar = new Asignar_Proyecto();
			Proyectos proy = new Proyectos();
			proy.setId(1);
			Usuarios usuario = new Usuarios();
			usuario.setId(4);
			
			
			asignar.setProyecto(proy);
			asignar.setUsuario(usuario);
			asignar.setFecha_cracion(new Date());
			create(asignar);*/
			
			Proyectos proyectos = new Proyectos();
			Usuarios usu = new Usuarios();
			usu.setId(4);
			proyectos.setNombre("Proyecto1");
			proyectos.setDescripcion("Avantia proy");
			proyectos.setUsuarioCreador(usu);
			proyectos.setEstado(true);
			proyectos.setFecha_creacion(new Date());
			create(proyectos);
			
			/*
			 Asignar_Proyecto asignado = new Asignar_Proyecto();
				asignado.setId(2);
				Preguntas preguntar = new Preguntas();
				
				preguntar.setAsignacion(asignado);
				preguntar.setPregunta("te ago una pregunta");
				preguntar.setEstado(true);
				preguntar.setFecha_creacion(new Date());
				create(preguntar);*/
			
			
		/*	Preguntas pregunta = new Preguntas();
			pregunta.setId(2);
			Asignar_Proyecto asignado = new Asignar_Proyecto();
			asignado.setId(2);
			Respuestas responder = new Respuestas();
			responder.setPregunta(pregunta);
			responder.setAsignacion(asignado);
			responder.setRespuesta("si podes preguntar");
			responder.setFecha_creacion(new Date());
			create(responder);*/
			
			
			
			
		
			/*@SuppressWarnings("unchecked")
			List<Proyectos> list = (List<Proyectos>) obtenerData("FROM PROYECTOS");
			for (Proyectos proy : list) {
				System.out.println(proy.getId());
				System.out.println(proy.getUsuarioCreador().getUsuario());
				System.out.println(proy.getUsuarioCreador().getRoles().getNombre());
			}
			*/
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally
		{
			if(SessionFactoryUtil.getSessionAnnotationFactory().getCurrentSession().isOpen())
				SessionFactoryUtil.getSessionAnnotationFactory().getCurrentSession().close();
	        	
	        if(!SessionFactoryUtil.getSessionAnnotationFactory().isClosed())
	        	SessionFactoryUtil.getSessionAnnotationFactory().close();
		}
		
	}

	public static List<?> obtenerData(String query)
	{
		try {
			BdEjecucion ejecucion = new BdEjecucion();
			return ejecucion.listData(query);
		} catch (Exception e) 
		{
			throw e;
		}
		
	}
	
	public static void create(Object obj)
	{
		try {
			BdEjecucion ejecucion = new BdEjecucion();
			ejecucion.createData(obj);
		} catch (Exception e) {
			throw e;
		}
				
	}
}
