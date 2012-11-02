package org.neos.broker.dao;


import org.neos.broker.domain.Mensaje;

public class MensajeDaoImpl extends GenericHibernateDAO<Mensaje, Integer> implements MensajeDao {

    @Override
    protected Class<Mensaje> getDomainClass() {
        return Mensaje.class;
    }

	
}
