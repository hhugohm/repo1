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
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;
import org.neos.broker.gui.MQApplicationJdesk;
import org.neos.broker.gui.conection.NewDialogConn;
import org.neos.broker.gui.conection.NewDialogMessage;
import org.neos.broker.gui.tabs.MQTabbedMessage;
import org.neos.broker.gui.conection.PanelSplitMessage;
import org.neos.broker.gui.conection.UpdateDialogConn;
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
    
    private MQApplicationJdesk mqapp;

    public TreeMouseAdapter(NodeGui raiz, MQApplicationJdesk mqapp) {
        this.mqapp = mqapp;
        this.arbol = mqapp.getJtreeConnections();
        this.raiz = raiz;
        this.dialog = mqapp.getNewConnectionUI();

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
        if (seleccion!=null) {                
            if( seleccion == raiz) {
            popupConexion = createPopupRaiz();
            popupConexion.show(arbol, ev.getX(), ev.getY());
        } else if (seleccion.isLeaf()) {
            popupMensaje = createPopupMensaje();
            popupMensaje.show(arbol, ev.getX(), ev.getY());
        } else {
            popupInterfaz = createPopupInterfaz();
            popupInterfaz.show(arbol, ev.getX(), ev.getY());
        }
      } else  {
            popupConexion = createPopupRaiz();
            popupConexion.show(arbol, ev.getX(), ev.getY());
        
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
               dialog = new NewDialogConn(mqapp, true);
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
        JMenuItem itemModificar = new JMenuItem("Modificar Conexion");
        JMenuItem item2 = new JMenuItem("Nuevo Mensaje");
        item2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                NewDialogMessage message = new NewDialogMessage(mqapp, true,seleccion);
                message.setVisible(true);
               // La ventana saldrá centrada en pantalla.
                 message.setLocationRelativeTo (null);
            }
        });
        
        itemModificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                UpdateDialogConn updateDialog = new UpdateDialogConn(mqapp, true,(NodeMQUI<String>)seleccion);
                updateDialog.setVisible(true);
               // La ventana saldrá centrada en pantalla.
                 updateDialog.setLocationRelativeTo (null);
            }
        });
        
        popupinterfaz.addOptionWithSeparator(itemModificar);
        popupinterfaz.addOption(item2);
        return popupinterfaz;
    }
     /**
      * Metodo que es invocado al dar click en la opcion abrir mensajes
      */
    public PopupActions createPopupMensaje() {
        PopupActions popupmensaje = new PopupActions();
        JMenuItem item2 = new JMenuItem("Abrir Mensaje");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NodeMQUI<String> nodeMessage  =   (NodeMQUI<String>) seleccion;
                Mensaje mensaje = nodeMessage.getMensaje();
                Conexion conexion = mensaje.getConexion();
                MQTabbedMessage tabs=mqapp.getTabMessages();
                //no hay pestañas                
                     mqapp.getJpanelRight().add(tabs);
                     
                     tabs.addTab(conexion.getIdConexion() +  "," +
                    mensaje.getTituloMensaje()
                             ,GuiUtils.createImageIcon("/icons/plugin.gif")
						,new PanelSplitMessage((NodeMQUI<String>)seleccion));                
            }
        });
        
        popupmensaje.addOption(item2);
        return popupmensaje;
    }
}
