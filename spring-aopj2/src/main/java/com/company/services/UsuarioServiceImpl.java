package com.company.services;

import com.mycompany.modelo.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	public Usuario consultaUsuario( Usuario usuario ) {
        System.out.println( "Consultando el Usuario : " + usuario.getNombre() + " " + usuario.getApellidos());
        return usuario;
    }
	
	public Usuario consultaUsuario_alternativo( Usuario usuario ) {
        System.out.println( "Consultando el Usuario alternativo : " + usuario.getNombre() + " " + usuario.getApellidos());
        return usuario;
    }

    public boolean agregarUsuario( Usuario usuario ) {
        System.out.println( "Insertando Usuario : " + usuario );
        return true;
    }

    public int actualizarUsuario( Usuario usuario ) {
        System.out.println( "Actualizando Usuario : " + usuario.getNombre() );
        return 1;
    }

    public boolean borrarUsuario( Usuario usuario ) {
        System.out.println( "Borrando Usuario : " + usuario.getNombre() );
        return true;
    }

    public void ProbarThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running ");
		throw new Exception("Generic Error");
	}
    
    @SuppressWarnings("static-access")
	public void procesarInformacion() {

        try {

            Thread tarea = new Thread( new Runnable() {
                public void run() {}
            }
            );
            tarea.start();
            tarea.sleep( 5000 );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }

    }

}
