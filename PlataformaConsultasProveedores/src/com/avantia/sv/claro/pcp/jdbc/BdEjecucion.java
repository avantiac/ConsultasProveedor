package com.avantia.sv.claro.pcp.jdbc;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Clase encargada de poder realizar las operaciones en la base de datos dentro
 * de la ejecuci�n del flujo
 * 
 * @author Edwin Mejia - Avantia Consultores
 * @version 1.0
 * */
public class BdEjecucion implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Obtener el appender para la impresi�n en un archivo de LOG
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * */
	public static Logger logger = Logger.getLogger("avantiaLogger");
	

	/**Metodo que nos servira para realizar cualquier consulta dentro de la
	 * base de datos
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param query
	 *            {String} dato de insumo para obtener un listado desde la BD
	 * @return {java.util.List}
	 * */
	public List<?> listData(String query) 
	{
		
		Session session = SessionFactoryUtil.getSessionAnnotationFactory().openSession();;
		List<?> objs = null;
		try 
		{
			session.beginTransaction();
			objs = session.createQuery(query).list();
			session.getTransaction().commit();
			session.flush();
            session.clear();
            session.close();
			return objs;
		} 
		catch (RuntimeException e) 
		{
			logger.error("Error al querer realizar una consulta en la base de datos", e);
			
			if(session!=null)
				if(session.isOpen())
					if (session.getTransaction() != null && session.getTransaction().isActive()) 
					{
						try 
						{
							// Second try catch as the rollback could fail as well
							session.getTransaction().rollback();
							session.flush();
				            session.clear();
				            session.close();
						} 
						catch (HibernateException e1) 
						{
							logger.error("Error al querer realizar rolback a la base de datos", e1);
						}
						// throw again the first exception
						throw e;
					}
		}
		return objs;

	}

	/**
	 * Metodo que nos servira para realizar cualquier eliminaci�n dentro de la
	 * base de datos
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param obj
	 *            {java.lang.Object} return void
	 * */
	public void deleteData(Object obj) 
	{
		Session session = SessionFactoryUtil.getSessionAnnotationFactory().openSession();
		try 
		{
			
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
			session.flush();
            session.clear();
            session.close();
		} 
		catch (RuntimeException e) 
		{
			logger.error("Error al querer realizar una eliminaci�n en la base de datos", e);
			
			if(session!=null)
				if(session.isOpen())
					if (session.getTransaction() != null && session.getTransaction().isActive()) {
						try 
						{
							// Second try catch as the rollback could fail as well
							session.getTransaction().rollback();
							session.flush();
				            session.clear();
				            session.close();
						} 
						catch (HibernateException e1) 
						{
							logger.error("Error al querer realizar rolback a la base de datos", e1);
						}
						// throw again the first exception
						throw e;
					}
		}
	}

	/**
	 * Metodo que nos servira para realizar cualquier inserci�n dentro de la
	 * base de datos
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param obj
	 *            {java.lang.Object} return void
	 * */
	public Object createData(Object obj) 
	{
		Session session = SessionFactoryUtil.getSessionAnnotationFactory().openSession();
		try 
		{
			session.beginTransaction();
			obj = session.save(obj);
			session.getTransaction().commit();
			session.flush();
            session.clear();
            session.close();
		} 
		catch (RuntimeException e) 
		{
			logger.error("Error al querer realizar una insercion a la base de datos", e);

			if(session!=null)
				if(session.isOpen())
					if (session.getTransaction() != null && session.getTransaction().isActive()) {
						try 
						{
							// Second try catch as the rollback could fail as well
							session.getTransaction().rollback();
							session.flush();
				            session.clear();
				            session.close();
						} 
						catch (HibernateException e1) 
						{
							logger.error("Error al querer realizar rolback a la base de datos", e1);
						}
						// throw again the first exception
						throw e;
					}
		}
		return obj;
	}

	/**
	 * Metodo que nos servira para realizar cualquier actualizaci�n dentro de la
	 * base de datos
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param obj
	 *            {java.lang.Object} return void
	 * */
	public void updateData(Object obj) 
	{
		Session session = SessionFactoryUtil.getSessionAnnotationFactory().openSession();
		try 
		{
			
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
			session.flush();
            session.clear();
            session.close();
		
		} 
		catch (RuntimeException e) 
		{
			logger.error("Error al querer realizar una actualizaci�n a la base de datos", e);
			
			if(session!=null)
				if(session.isOpen())
					if (session.getTransaction() != null && session.getTransaction().isActive()) 
					{
						try 
						{
							// Second try catch as the rollback could fail as well
							session.getTransaction().rollback();
							session.flush();
				            session.clear();
				            session.close();
						} 
						catch (HibernateException e1) 
						{
							logger.error("Error al querer realizar rolback a la base de datos", e1);
						}
						// throw again the first exception
						throw e;
					}
		}
	}
	
	/**
	 * Metodo que devolvera un dato especifico de un query especifico
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param obj
	 *            {java.lang.Object} return void
	 * */
	public Object obtenerDato(String queryCompleto) 
	{
		Object out = null;
		Session session = SessionFactoryUtil.getSessionAnnotationFactory().openSession();
		try 
		{
			session.beginTransaction();
			Query query = session.createQuery(queryCompleto);
			out = query.uniqueResult();
            session.getTransaction().commit();
            session.clear();
            session.close();
		} 
		catch (RuntimeException e) 
		{
			logger.error("Error al querer consultar un valor de la base de datos", e);
			if(session!=null)
				if(session.isOpen())
					if (session.getTransaction() != null && session.getTransaction().isActive()) 
					{
						try 
						{
							// Second try catch as the rollback could fail as well
							session.getTransaction().rollback();
							session.flush();
				            session.clear();
				            session.close();
						} 
						catch (HibernateException e1) 
						{
							logger.error("Error al querer realizar rolback a la base de datos", e1);
						}
						// throw again the first exception
						throw e;
					}
		}
		return out;
	}
}