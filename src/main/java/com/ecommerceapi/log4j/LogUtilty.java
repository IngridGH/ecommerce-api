package com.ecommerceapi.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogUtilty {
	private static Logger log = Logger.getLogger(LogUtilty.class); 

	@SuppressWarnings("rawtypes")
	public static void registrarInfo(Class clase, TypeLog tipo, String mensaje)
	{
	 log = LogManager.getLogger(clase);
	 
	 switch (tipo) 
	 {
	  case DEBUG:
	   log.debug(mensaje);
	   break;
	  case ERROR:
	   log.error(mensaje);
	   break;
	  case FATAL:
	   log.fatal(mensaje);
	   break;
	  case INFO:
	   log.info(mensaje);
	   break;
	  case WARNING:
	   log.warn(mensaje);
	 }
	}
}
