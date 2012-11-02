/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.business;


import org.neos.broker.beans.RequestBroker;
import org.neos.broker.beans.ResponseBroker;
import org.neos.broker.domain.Conexion;

/**
 *
 * @author camus
 */
public interface IBusinessConexion {
    
    public ResponseBroker getAllConexionBusiness(RequestBroker request);
    
    public void saveOrUpdate(Conexion conexion);
    
    public void update(Conexion conexion);
    
}
