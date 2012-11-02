/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.demos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author 35164333
 */

// Esta clase coge un array de Strings, haciendo que el primer elemento
// del array sea un nodo y el resto sean ramas de ese nodo
// Con ello se consiguen las ramas del árbol general cuando se pulsa
// el botón de test
class Rama {
    DefaultMutableTreeNode r;
    //crea una Rama usando un Array de String 
    public Rama( String datos[] ) {
        r = new DefaultMutableTreeNode( datos[0] );
        System.out.print ( "Agregando " + datos[0] + ": " );
        for ( int i=1; i < datos.length; i++ ) {
            r.add( new DefaultMutableTreeNode( datos[i] ) );
            System.out.print ( " " + datos[i] );
        }
        System.out.print ( "\n" );
    }

    public DefaultMutableTreeNode node() {
        return( this.r );
    }
}


public class JtreeeDemo  extends JPanel {
    
    static int i=0;
    private DefaultMutableTreeNode raiz,rama,seleccion;
    private JTree arbol;
    private DefaultTreeModel modelo;

    private JButton botonPrueba = new JButton( "Púlsame" );
    
     String datos[][] = {
        { "Colores","Rojo","Verde","Azul"},
        { "Sabores","Salado","Dulce","Amargo"},
        { "Longitud","Corta","Media","Larga"},
        { "Intensidad","Alta","Media","Baja"},
        { "Temperatura","Alta","Media","Baja"},
        { "Volumen","Alto","Medio","Bajo"},
    };
     
     public JtreeeDemo() {
         
         super.setLayout( new BorderLayout() );
        raiz = new DefaultMutableTreeNode( "raíz" );
        arbol = new JTree( raiz );
        // Se añade el árbol y se hace sobre un ScrollPane, para
        // que se controle automáticamente la longitud del árbol
        // cuando está desplegado, de forma que aparecerá una
        // barra de desplazamiento para poder visualizarlo en su
        // totalidad
        add( new JScrollPane( arbol ),BorderLayout.CENTER );
        // Se obtiene el modelo del árbol
        modelo =(DefaultTreeModel)arbol.getModel();
        // Y se añade el botón que va a ir incorporando ramas
        // cada vez que se pulse
        botonPrueba.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                if( i < datos.length ) {
                    rama = new Rama( datos[i++] ).node();
                    // Control de la útlima selección realizada
                    seleccion = (DefaultMutableTreeNode)
                    arbol.getLastSelectedPathComponent();
                    if( seleccion == null ) {
                        seleccion = raiz;
                    }
                    System.out.println(seleccion.getUserObject());
                    printPath(seleccion.getUserObjectPath());
                    
                    // El modelo creará el evento adecuado, y en respuesta
                    // a él, el árbol se actualizará automáticamente
                    modelo.insertNodeInto( rama,seleccion,0 );
                    if ( i == datos.length ) {
                        botonPrueba.setEnabled( false );
                    }
                }
            }

             public void printPath(Object[] userObjectPath) {                    
                    for (int i=0;i<userObjectPath.length;i++) {
                          System.out.print("Path: " + ((String)userObjectPath[i]));
                    }
                    
             }
        } );

        // Cambio del color del botón
        botonPrueba.setBackground( Color.blue );
        botonPrueba.setForeground( Color.white );
        // Se crea un panel para contener al botón
        JPanel panel = new JPanel();
        panel.add( botonPrueba );
        super.add( panel,BorderLayout.SOUTH );
     }
     
     
      public static void main( String args[] ) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new JtreeeDemo(),BorderLayout.CENTER );
        frame.setSize( 200,500 );
        frame.setVisible( true );
    }
    
}
