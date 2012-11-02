/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.business;

import java.util.Set;
import javax.swing.tree.DefaultTreeModel;
import org.neos.broker.constants.ConstantsBroker;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;
import org.neos.broker.gui.tree.NodeGui;
import org.neos.broker.gui.tree.NodeMQUI;
import static org.neos.broker.gui.tree.GuiUtils.createImageIcon;

/**
 *
 * @author Camus
 */
public abstract class AbtractConexion {

    protected void putConexionOnTree(Conexion conexion, NodeGui<String> raiz,
            DefaultTreeModel modelo) {

        //ponemos las conexiones del broker
        NodeMQUI<String> rama =
                new NodeMQUI<String>(conexion.getIdConexion(),
                true, createImageIcon(
                ConstantsBroker.IMAGE_PLUGIN));
        rama.setConexion(conexion);

        if (conexion.getMensaje() != null) {
            //ponemos los mensajes asociados a la conexion
            putMensajeOnRama(conexion.getMensaje(), rama);

        }
        //insertamos los nodos a la raiz
        modelo.insertNodeInto(rama, raiz, 0);

    }

    protected void putMensajeOnRama(Set<Mensaje> mapMensajes,
            NodeMQUI<String> rama) {
        for (Mensaje mensaje : mapMensajes) {
            NodeMQUI<String> nodo =
                    new NodeMQUI<String>(mensaje.getTituloMensaje(),
                    false,
                    createImageIcon(
                    ConstantsBroker.IMAGE_NEWMESAAGE));
            nodo.setMensaje(mensaje);
            rama.add(nodo);
        }
    }
}
