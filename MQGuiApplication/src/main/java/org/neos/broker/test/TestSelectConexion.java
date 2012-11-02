package org.neos.broker.test;


import java.util.HashSet;
import java.util.Set;

import org.neos.broker.dao.ConexionDao;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;
import org.neos.broker.utils.SpringContextManager;

import static org.neos.broker.utils.SpringContextManager.getInstance;

public class TestSelectConexion {

    private static ConexionDao conexionDao;

    public static void main(String[] args) {
     //   ApplicationContext appContext = new ClassPathXmlApplicationContext(
       //         "mapping-spring.xml");
        
//          getInstance().getContext().getBean(null)

        conexionDao = (ConexionDao)  getInstance().getContext().getBean("conexionDao");
        
       
        Conexion conexion = new Conexion();
        Set<Mensaje> mensajes = new HashSet<Mensaje>();

        conexion = conexionDao.getByKey("CONEXION-HOGAN-HUGO1");
        if (conexion != null) {

            mensajes = conexion.getMensaje();

            System.out.println("ID CONEXION: " + conexion.getIdConexion()
                    + " QMANAGER: " + conexion.getqManager()
                    + " USUARIO: " + conexion.getUsuario().getUsuario()
                    + " FECHA ALTA: " + conexion.getFechaAlta().toString());

            for (Mensaje mensaje : mensajes) {
                System.out.println("ID MENSAJE       : " + mensaje.getIdMensaje());
                System.out.println("REQUEST MENSAJE  : " + mensaje.getRequestMensaje());
                System.out.println("RESPONSE MENSAJE : " + mensaje.getResponseMensaje());
                System.out.println("TITULO MENSAJE   : " + mensaje.getTituloMensaje());
            }

        }

    }
}
