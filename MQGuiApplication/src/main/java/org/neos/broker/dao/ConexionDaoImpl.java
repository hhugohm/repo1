package org.neos.broker.dao;



import org.neos.broker.domain.Conexion;

public class ConexionDaoImpl extends GenericHibernateDAO<Conexion, String> implements ConexionDao{

    @Override
    protected Class<Conexion> getDomainClass() {
       return Conexion.class;
    }


	
}
