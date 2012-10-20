/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import static org.neos.broker.gui.tree.GuiUtils.createImageIcon;

/**
 *
 * @author neossoftware
 */
public class DemoTree extends JPanel {
    
      private NodeGui<String> raiz,rama,seleccion;
      private JTree arbol;
      private DefaultTreeModel modelo;
    
    
    public DemoTree() {
        
        
        raiz = new NodeGui<String>("Conexiones", true, createImageIcon("discovery.gif", "", DemoTree.class));
        arbol = new JTree( raiz );        
        super.setLayout( new BorderLayout() );
         add( new JScrollPane( arbol ),BorderLayout.CENTER );
        
        modelo =(DefaultTreeModel)arbol.getModel();
        
        NodeGui<String> rama = new NodeGui<String>("interfaz Hogan", true,createImageIcon("discovery.gif", "", DemoTree.class) );
        
        //se crean nodos
        NodeGui<String> nodo1 = new NodeGui<String>("Mensaje1",false); 
        NodeGui<String> nodo2 = new NodeGui<String>("Mensaje2",false); 
        rama.add(nodo1);
        rama.add(nodo2);
        
        modelo.insertNodeInto(rama, raiz, 0);
        arbol.setCellRenderer(new IconNodeRenderer());
                 
         arbol.expandRow(0);
       
    }
    
     public static void main( String args[] ) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new DemoTree(),BorderLayout.CENTER );
        frame.setSize( 200,500 );
        frame.setVisible( true );
    }
}
