/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;


/**
 *
 * @author NeosSoftware Corporation
 */
public class PopupActions extends JPopupMenu {
    
    private JMenuItem option;
    
    public PopupActions() {
    }
    
    public  void addOptionWithSeparator(JMenuItem item) {       
        addOption(item);
        super.add(new JSeparator());
    }
    
    public void addOption(JMenuItem key) {
        this.option = key;
        super.add(option);
    }
    
    
}