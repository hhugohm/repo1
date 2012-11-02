package org.neos.broker.test;

import java.util.Date;

import org.neos.broker.dao.ConexionDao;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSaveConexion {
	private static ConexionDao conexionDao;

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"mapping-spring.xml");

		conexionDao = (ConexionDao) appContext.getBean("conexionDao");

		Usuario usuario = new Usuario();
		usuario.setUsuario("43700136");
		usuario.setPassword("Ibiza001");

		
		Conexion conexion = new Conexion();
		conexion.setIdConexion("CONEXION-HOGAN-HUGO1");
		conexion.setTipoAmbiente("PRODUCCION");
		conexion.setHost("http://127.0.0.1");
		conexion.setqManager("qManager");
		conexion.setqPut("qPut");
		conexion.setqGet("qGet");
		conexion.setqPort(3650);
		conexion.setqChanel("qChanel");
		conexion.setFechaAlta(new Date());
		conexion.setBndSecurity(1);
		conexion.setUsuario(usuario);
		
		conexionDao.save(conexion);
		
		System.out.println("SUCCESS SAVE CONEXION");		

	}

}
