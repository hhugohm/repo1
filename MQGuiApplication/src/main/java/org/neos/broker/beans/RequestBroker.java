/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.beans;

import java.io.Serializable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import org.neos.broker.gui.tree.NodeGui;

/**
 *
 * @author 43700136
 */
public class RequestBroker implements  Serializable {
    private JTree arbol;
    
    public JTree getArbol() {
        return arbol;
    }
    public void setArbol(JTree arbol) {
        this.arbol = arbol;
    }
    
}
