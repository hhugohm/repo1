/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tabs;

import javax.swing.JOptionPane;

/**
 *
 * @author 35164333
 */
public class MQTabbedMessage extends ClosableTabbedPane {

    @Override
    public boolean tabAboutToClose(int tabIndex) {
        String tab = this.getTabTitleAt(tabIndex);
        int choice = JOptionPane.showConfirmDialog(null,
                "Se cerrará el Tab:  '" + tab
                + "'\n¿Estas seguro de cerrar el Tab?",
                "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        return choice == 0; // if returned false tab closing will be			
    }
}

