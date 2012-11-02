package org.neos.broker.test;


import org.neos.broker.dao.UsuarioDao;
import org.neos.broker.domain.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSaveUser {

private static UsuarioDao usuarioDao;
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"mapping-spring.xml");

		usuarioDao = (UsuarioDao) appContext.getBean("usuarioDao");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("43700136");
		usuario.setPassword("Ibiza001");
		
		usuarioDao.save(usuario);
	
		
		System.out.println("SUCCESS SAVE USUARIO");
		
		
	}

}
