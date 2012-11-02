/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;


import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * Clase que representa un nodo en un  Jtree
 *  cada nodo puede tener una Icon asociado
 * en dado caso de no enviar ningun Icon coloca
 * el default de swing
 *
 * @author NeosSoftware Corporation
 */
public class NodeGui<T> extends  DefaultMutableTreeNode  {
    
    private Icon icon;
    
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    public Icon getIcon() {
      return this.icon;
    }
          
    /* Agrega un nuevo nodo hoja con un icono
     */
    public NodeGui(T object, Icon icon) {
        this(object);
        this.icon = icon;
    }
    
    public NodeGui(T object) {        
        super(object, false);        
    }
    
    public NodeGui(T object, boolean allowChildren, Icon icon) {
       this(object, allowChildren);
       this.icon = icon;
    }
    
    /**
     Constructor de Branch el cual recibe la raiz de la rama
     * apartir de este se pueden agregar mas ramas o bien hojas
     */
    public NodeGui(T object, boolean allowChildren) {
        super(object,allowChildren);
    }
    
    public NodeGui() {
        super(null);
    }
   
   
    
    public void add(NodeGui<T> branch) {
      super.add(branch);
   }
    
    @Override
    public boolean isLeaf() {
        if (!allowsChildren) {
           return true;
        }
        else {
            return false;
        }
    }
        
}
