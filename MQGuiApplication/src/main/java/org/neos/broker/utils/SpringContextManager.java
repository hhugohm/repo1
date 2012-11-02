/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author NeosSoftware Corporation
 */
public class SpringContextManager {
    
    
    public static final SpringContextManager contextManager = new SpringContextManager();
    
    private  ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    
    private SpringContextManager() {
      context = new ClassPathXmlApplicationContext("mapping-spring.xml");
    }
    
    
    public static SpringContextManager getInstance() {
        return contextManager;
    }
    
    
}
