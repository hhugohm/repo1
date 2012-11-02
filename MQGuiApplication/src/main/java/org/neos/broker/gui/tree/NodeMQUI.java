/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;

import javax.swing.Icon;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;

/**
 *Representa un nodo en el arbol de conexiones
 * 
 * 
 * @author NeosSoftware Corporation
 */
public class NodeMQUI<T> extends NodeGui {
    
    private Conexion conexion;
 
    private Mensaje mensaje;
    
      
    /* Agrega un nuevo nodo hoja con un icono
     */
    public NodeMQUI(T object, Icon icon) {
       super(object, icon);
    }
    
    public NodeMQUI(T object) {        
        super(object, false);        
    }
    
    public NodeMQUI(T object, boolean allowChildren, Icon icon) {
      super(object, allowChildren, icon);
    }
    
    /**
     Constructor de Branch el cual recibe la raiz de la rama
     * apartir de este se pueden agregar mas ramas o bien hojas
     */
    public NodeMQUI(T object, boolean allowChildren) {
        super(object,allowChildren);
    }
    
    public NodeMQUI() {
        super(null);
    }
    
    
    
    
     public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    
}
