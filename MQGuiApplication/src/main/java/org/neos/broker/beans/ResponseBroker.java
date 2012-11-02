/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.beans;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import org.neos.broker.gui.tree.NodeGui;

/**
 *
 * @author 43700136
 */
public class ResponseBroker {
    private JTree arbol;
    private NodeGui<String> raiz;
    private DefaultTreeModel modelo;

    public JTree getArbol() {
        return arbol;
    }

    public void setArbol(JTree arbol) {
        this.arbol = arbol;
    }

    public NodeGui<String> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodeGui<String> raiz) {
        this.raiz = raiz;
    }
    
    public DefaultTreeModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTreeModel modelo) {
        this.modelo = modelo;
    }

}
