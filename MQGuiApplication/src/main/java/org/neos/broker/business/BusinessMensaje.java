/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.business;

import java.util.Set;
import org.neos.broker.dao.MensajeDao;
import org.neos.broker.domain.Mensaje;

/**
 *
 * @author Camus
 */
public class BusinessMensaje implements IBusinessMensaje {
   private MensajeDao mensajeDao;

   
    
    protected Mensaje getMensagesDao(Integer key){
        
        return mensajeDao.getByKey(key);
    }
   
    public void setMensajeDao(MensajeDao mensajeDao) {
        this.mensajeDao = mensajeDao;
    }
   
    
}
