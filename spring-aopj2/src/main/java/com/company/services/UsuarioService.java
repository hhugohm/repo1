package com.company.services;

import com.mycompany.modelo.Usuario;

public interface UsuarioService {
	public Usuario consultaUsuario( Usuario usuario );
	public Usuario consultaUsuario_alternativo( Usuario usuario );
    public boolean agregarUsuario( Usuario usuario );
    public int actualizarUsuario( Usuario usuario );
    public boolean borrarUsuario( Usuario usuario );
    public void procesarInformacion();
    public void ProbarThrowException() throws Exception;
}
