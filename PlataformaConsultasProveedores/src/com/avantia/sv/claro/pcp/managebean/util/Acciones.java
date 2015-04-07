package com.avantia.sv.claro.pcp.managebean.util;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.avantia.sv.claro.pcp.jdbc.BdEjecucion;
import com.avantia.sv.claro.pcp.managebean.Ingreso;

public class Acciones {
	
	/**
	  * Instanacia de {@link BdEjecucion} para poder generar ejecuciones en la
	  * base de datos desde cualquier managebean
	  * 
	  * 
	  * @author Edwin Mejia - Avantia Consultores
	   **/
	 private BdEjecucion ejecucion = new BdEjecucion();
	 
	 /**
	  * Esta es la unica injeccion de la sesion en todos los ManageBean ya que
	  * esta clase es la heredada por todos los managebean
	  * 
	  * @author Emejia - Avantia Consultores
	   **/
	 @ManagedProperty("#{usuarioSessionMB}")
	 private Ingreso usuarioSessionMB;

	/**
	 * @return the usuarioSessionMB
	 */
	public Ingreso getUsuarioSessionMB() {
		return usuarioSessionMB;
	}

	/**
	 * @param usuarioSessionMB the usuarioSessionMB to set
	 */
	public void setUsuarioSessionMB(Ingreso usuarioSessionMB) {
		this.usuarioSessionMB = usuarioSessionMB;
	}

	/***
	 * Despliega mensajes en el FacesContext asociados a un componente
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param idComponente
	 *            (Opcional) message que se desea agregar el mensaje (Null se
	 *            enviaran al contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * @param severidad
	 *            Severidad del mensaje
	 * */
	private void lanzarMensaje(Exception e, String idComponente,
			String cabecera, String detalle, Severity severidad) {
		showFacesMsg(e, detalle, cabecera, idComponente, severidad);
	}

	/**
	 * Despliega mensajes de Información al FacesContext en el contenedor
	 * message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeInformacion(String idComponente,
			String cabecera, String detalle) {
		lanzarMensaje(null, "IDGrowlMensaje", cabecera, detalle,
				FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Despliega mensajes de Información al FacesContext en el contenedor
	 * message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeInformacion(String cabecera, String detalle) {
		lanzarMensaje(null, "IDGrowlMensaje", cabecera, detalle,
				FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Despliega mensajes de Advertencia al FacesContext en el contenedor
	 * message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeAdvertencia(String idComponente,
			String cabecera, String detalle) {
		lanzarMensaje(null, "IDGrowlMensaje", cabecera, detalle,
				FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Despliega mensajes de Advertencia al FacesContext en el contenedor
	 * message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeAdvertencia(String cabecera, String detalle) {
		lanzarMensaje(null, "IDGrowlMensaje", cabecera, detalle,
				FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Despliega mensajes de Error al FacesContext en el contenedor message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeError(String idComponente, String cabecera,
			String detalle) {
		lanzarMensaje(null, "IDGrowlErrorSistemas", cabecera, detalle,
				FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Despliega mensajes de Error al FacesContext en el contenedor message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * @param excepcion
	 *            que desencadena el mensaje de error
	 * */
	protected void lanzarMensajeError(String cabecera, String detalle,
			Exception excepcion) {
		lanzarMensaje(excepcion, "IDGrowlErrorSistemas", cabecera, detalle,
				FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Despliega mensajes de Fatal al FacesContext en el contenedor message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * */
	protected void lanzarMensajeFatal(String cabecera, String detalle) {
		lanzarMensaje(null, "IDGrowlErrorSistemas", cabecera, detalle,
				FacesMessage.SEVERITY_FATAL);
	}

	/**
	 * Despliega mensajes de Fatal al FacesContext en el contenedor message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * @param excepcion
	 *            que desencadena el mensaje de error
	 * */
	protected void lanzarMensajeFatal(String cabecera, String detalle,
			Exception excepcion) {
		lanzarMensaje(null, "IDGrowlErrorSistemas", cabecera, detalle,
				FacesMessage.SEVERITY_FATAL);
	}

	/**
	 * Despliega mensajes de Fatal al FacesContext en el contenedor message
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * 
	 * @param id
	 *            del componente que se cargara el mensaje (Null se enviaran al
	 *            contexto general de messages)
	 * @param cabecera
	 *            de mensaje
	 * @param detalle
	 *            de mensaje
	 * @param excepcion
	 *            que desencadena el mensaje de error
	 * */
	protected void lanzarMensajeFatal(Exception excepcion) {
		lanzarMensaje(null, "IDGrowlErrorSistemas", excepcion.getCause()
				.toString(), excepcion.getMessage(),
				FacesMessage.SEVERITY_FATAL);
	}
	
	/**
	 * Metodo que muestra un mensaje en pantalla
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param e
	 *            {@link Exception}
	 * @param msg
	 *            {@link String}
	 * @param cabecera
	 *            {@link String}
	 * @param componetID
	 *            {@link String}
	 * @param severityError
	 *            {@link Severity}
	 * @return void
	 * */
	private static void showFacesMsg(Exception e, String msg, String cabecera, String componetID, Severity severityError) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage(severityError, cabecera, msg));
		
		if (requestContext != null) {
			requestContext.update(componetID);
		}
		
		if (e != null) {
			loadConsoleError(e, getCauseMsgs(e.getCause()));
		}
	}
	
	/**
	 * Metodo que obtiene la causa de la excepción
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param cause
	 * @return {@link String}
	 * */	
	private static String getCauseMsgs(Throwable cause) {
		String causeMsgs = "";
		if (cause == null) {
			return "";
		} else {
			if (cause.getCause() == null) {
				causeMsgs = cause.getMessage();
			} else {
				causeMsgs = causeMsgs + getRootCauseErrMsg(cause.getCause());
			}
			return causeMsgs;
		}
	}
	
	/**
	 * Metodo que obtiene la causa de la excepción
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param cause
	 * @return {@link String}
	 * */
	private static String getRootCauseErrMsg(Throwable cause) {
		String errMsg = null;
		if (cause == null) {
			return "";
		} else {
			if (cause.getCause() == null) {
				errMsg = cause.getMessage();
			} else {
				errMsg = getRootCauseErrMsg(cause.getCause());
			}
			return errMsg;
		}
	}
	
	/**
	 * Generar el mensaje de error para la consola y responder al ibs
	 * 
	 * @author Emejia - Avantia Consultores
	 * @param excepcion
	 * @param msgError
	 * */
	public static void loadConsoleError(Exception excepcion, String msgError){
		
		
		//imprimimos el mensaje enviado a la cola en consola para quede constancia de la respuesta generada
		System.err.println("\n Mesage genareated at:" + new Date() + "for error: " + msgError);
		
		//imprimimos el error en consola para  conocer la traza del error
		System.err.println("\n  error at:" + new Date() + "mesage of error: "+ excepcion.getMessage() );
		 
        // obtener la información de rastreo de la pila
        StackTraceElement[] elementosRastreo = excepcion.getStackTrace();
          
        System.err.println( "RASTREO DEL ERROR PROVENIENTE DEL GETSTACKTRACE OBTENIDO:" );
        System.err.print( generateDataTexto("<< UBICACION >>",  80) );
        System.err.print( generateDataTexto("<< CLASE >>",	47) );
        System.err.print( generateDataTexto("<< LINEA >>",  	10) );
        System.err.print( generateDataTexto("<< METODO >>", 	50) + "\n" );
        System.err.println(generateDataTexto(
        		"--------------------------------------------------------------------------------------------------------------------------------------------------",  190));						
        // iterar a través de elementosRastreo para obtener descripción de las excepciones
        for ( int i = 0; i < elementosRastreo.length; i++ ) {
            StackTraceElement elementoActual = elementosRastreo[ i ];
            System.err.print( generateDataTexto(elementoActual.getClassName(),80) );
            System.err.print( generateDataTexto(elementoActual.getFileName(),50) );
            System.err.print( generateDataTexto(new Integer(elementoActual.getLineNumber()).toString(),10));
            System.err.print( generateDataTexto(elementoActual.getMethodName(),50) + "\n" );
          
        } // fin de la instrucción for
        
        
		excepcion.printStackTrace();
	}
	
	/**
	 * Metodo que genera el formato orenado de la salida del texto n consola
	 * 
	 * @author Edwin Mejia - Avantia Consultores
	 * @param dato
	 * @param size
	 * @return {@link String}
	 * */
	public static String generateDataTexto(String dato, Integer size){
		if(dato == null){
			dato = " ";
		}
		if(dato.length()< size){
			dato= formatoCadena(dato, "%1$-"+size+"s");
		}
		if(dato.length()== size){
			return dato;
		}
		return dato;
	}
	
	private static String formatoCadena(String dato , String format) {
		// format "%1$-10s"
		String out = String.format(format,dato);
		return out;
	}

	/**
	 * @return the ejecucion
	 */
	public BdEjecucion getEjecucion() {
		return ejecucion;
	}

	/**
	 * @param ejecucion the ejecucion to set
	 */
	public void setEjecucion(BdEjecucion ejecucion) {
		this.ejecucion = ejecucion;
	}
}
