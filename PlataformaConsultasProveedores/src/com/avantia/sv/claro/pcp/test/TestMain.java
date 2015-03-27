package com.avantia.sv.claro.pcp.test;

import java.util.List;

import com.avantia.sv.claro.pcp.entidades.Prueba;
import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.jdbc.SessionFactoryUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			create();
			obtenerData();
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

	public static void obtenerData(){
		BdEjecucion ejecucion = new BdEjecucion();
		@SuppressWarnings("unchecked")
		List<Prueba> datos = (List<Prueba>) ejecucion.listData("FROM PRUEBA");
		
		for (int i = 0; i < datos.size(); i++) {
			System.out.println(datos.get(i).getDescripcion());
		}
	}
	
	public static void create()
	{
		BdEjecucion ejecucion = new BdEjecucion();
		Prueba obj = new Prueba();
		obj.setDescripcion("prueba de insercion muestra para jose");
		ejecucion.createData(obj);		
	}
}
