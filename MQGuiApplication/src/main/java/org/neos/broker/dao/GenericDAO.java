/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NeosSoftware 
 */
public interface GenericDAO <DomainObject extends Serializable, KeyType extends Serializable> {
    
     /**
     *
     * @param id
     * @return
     */
    public DomainObject getByKey(KeyType id);
    
    
    /**
     *
     * @param conexion
     */
    public void update(DomainObject object);
    
     /**
     *
     * @param object
     */
    public void save(DomainObject object);
    
    
      /**
     *
     * @param object
     */
    public void saveOrUpdate(DomainObject object);
    
    
    
     /**
     *
     * @param object
     */
    public void delete(DomainObject object);
    
    /**
     *
     * @return
     */
    public List<DomainObject> getAll();
}
