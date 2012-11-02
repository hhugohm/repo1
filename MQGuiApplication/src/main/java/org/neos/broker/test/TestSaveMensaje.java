package org.neos.broker.test;

import java.util.HashSet;
import java.util.Set;
import org.neos.broker.dao.ConexionDao;
import org.neos.broker.dao.MensajeDao;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSaveMensaje {
	
	private static MensajeDao mensajeDao;
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"mapping-spring.xml");

		mensajeDao = (MensajeDao) appContext.getBean("mensajeDao");
                
                ConexionDao conexionDaoo = (ConexionDao) appContext.getBean("conexionDao");
                
                Conexion conexion = conexionDaoo.getByKey("CONEXION-HOGAN-HUGO1");
                
		
		Mensaje mensaje1= new Mensaje();
		Mensaje mensaje2= new Mensaje();
                
                 Set<Mensaje> set= new  HashSet<Mensaje>();
                 
		
		//Conexion conexion = new Conexion();
		//conexion.setIdConexion("CONEXION-HOGAN-HUGO1");
		
		/*mensaje1.setRequestMensaje("requestMensaje1");
		mensaje1.setResponseMensaje("responseMensaje1");
		mensaje1.setTituloMensaje("tituloMensaje1");
		mensaje1.setConexion(conexion);
		*/
		mensaje2.setRequestMensaje("requestMensaje3");
		mensaje2.setResponseMensaje("responseMensaje3");
		mensaje2.setTituloMensaje("tituloMensaje3");
		mensaje2.setConexion(conexion);
		
		//mensajeDao.saveMensage(mensaje1);
		mensajeDao.save(mensaje2);
		
		System.out.println("SUCCESS SAVE MENSAJES");
		
		
	}

}
