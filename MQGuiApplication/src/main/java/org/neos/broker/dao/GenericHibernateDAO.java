/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Neossoftware
 */
public abstract class GenericHibernateDAO<DomainObject extends Serializable, KeyType extends Serializable> 
implements GenericDAO<DomainObject, KeyType>{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Class<DomainObject> domainClass = getDomainClass();
    protected abstract Class<DomainObject> getDomainClass();
    
     
    public DomainObject getByKey(KeyType id) {        
         DomainObject obj=null;
        Session session =  getSessionFactory().openSession();
         obj=(DomainObject) session.get(getDomainClass(), id);        
         session.close();
         
        return obj;
    }
    
   
   public void save(DomainObject object) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
	session.save(object);
        tx.commit();
        session.close();
    }

    public void saveOrUpdate(DomainObject object){
         Session session = getSessionFactory().openSession();
         Transaction tx = session.getTransaction();
        tx.begin();
          session.saveOrUpdate(object);
          tx.commit();
          session.close();
    }
    
	public void update(DomainObject object) {
         Session session = getSessionFactory().openSession();
         Transaction tx = session.getTransaction();
        tx.begin();
	  session.update(object);
          tx.commit();
           session.close();     

	}
    
     
    public void delete(DomainObject object) {
         Session session = getSessionFactory().openSession();
         Transaction tx = session.getTransaction();
        tx.begin();
 	session.delete(object);
        tx.commit();        
        session.close();
     }
    
    
    
     @SuppressWarnings("unchecked")       
	public List<DomainObject> getAll() {
         Session session = getSessionFactory().openSession();
          List<DomainObject> list = session.createQuery("from " + domainClass.getName()
				+ " o").list();
          session.close();
          return list;
                
                
	}
    
    
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

        
        public final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    
    
    
   
    
}
