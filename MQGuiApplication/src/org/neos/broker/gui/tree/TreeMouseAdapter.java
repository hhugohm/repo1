/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import org.neos.broker.gui.conection.NewDialogConn;

/**
 * 
 * Controla los menus popup del arbol de conexiones
 *
 * @author NeosSoftware Corporation
 */
public class TreeMouseAdapter extends MouseAdapter {

    private JTree arbol;
    private NodeGui<String> raiz;
    private NodeGui<String> seleccion;
    private PopupActions popupConexion;
    private PopupActions popupInterfaz;
    private PopupActions popupMensaje;
    
    private NewDialogConn dialog;

    public TreeMouseAdapter(JTree arbol, NodeGui raiz, NewDialogConn dialog) {
        this.arbol = arbol;
        this.raiz = raiz;
        this.dialog = dialog;

    }

    @Override
    public void mousePressed(MouseEvent ev) {

        if (ev.getClickCount() == 2 && !ev.isConsumed()) {
            ev.consume();
            validateMensaje();
        }

        if (ev.getButton() == MouseEvent.BUTTON3) {
            validateNode(ev);
        }
    }

    private void validateNode(MouseEvent ev) {

        seleccion = (NodeGui) arbol.getLastSelectedPathComponent();
        //si es raiz si muestra el popup de nueva conexion
        if (seleccion == raiz) {
            popupConexion = createPopupRaiz();
            popupConexion.show(arbol, ev.getX(), ev.getY());
        } else if (seleccion.isLeaf()) {
            popupMensaje = createPopupMensaje();
            popupMensaje.show(arbol, ev.getX(), ev.getY());
        } else {
            popupInterfaz = createPopupInterfaz();
            popupInterfaz.show(arbol, ev.getX(), ev.getY());
        }
    }

    private void validateMensaje() {
        seleccion = (NodeGui) arbol.getLastSelectedPathComponent();
        if (seleccion.isLeaf()) {
            System.out.println("Abriendo mensaje");
        }

    }

    public PopupActions createPopupRaiz() {
        PopupActions popupRaiz = new PopupActions();
        JMenuItem item = new JMenuItem("Nueva Conexion");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("Hola mundo");
               dialog.setVisible(true);
               // La ventana saldrá centrada en pantalla.
               dialog.setLocationRelativeTo (null);
            }
        });
        popupRaiz.addOption(item);

        return popupRaiz;
    }

    public PopupActions createPopupInterfaz() {
        PopupActions popupinterfaz = new PopupActions();
        JMenuItem item = new JMenuItem("Modificar Conexion");
        JMenuItem item2 = new JMenuItem("Nuevo Mensaje");
        popupinterfaz.addOptionWithSeparator(item);
        popupinterfaz.addOption(item2);
        return popupinterfaz;
    }

    public PopupActions createPopupMensaje() {
        PopupActions popupmensaje = new PopupActions();
        JMenuItem item2 = new JMenuItem("Abrir Mensaje");
        popupmensaje.addOption(item2);
        return popupmensaje;
    }
}
