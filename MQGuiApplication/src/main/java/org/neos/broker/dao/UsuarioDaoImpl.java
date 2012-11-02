package org.neos.broker.dao;


import org.neos.broker.domain.Usuario;

public class UsuarioDaoImpl extends GenericHibernateDAO<Usuario, Integer> implements 
        UsuarioDao {

    @Override
    protected Class<Usuario> getDomainClass() {
        return Usuario.class;
    }

	
}
