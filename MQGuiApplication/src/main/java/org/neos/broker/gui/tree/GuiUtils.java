/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tree;

import javax.swing.ImageIcon;

/**
 *
 * @author NeosSoftware Corporation
 */
public class GuiUtils {

    public static ImageIcon createImageIcon(String path ) {
        java.net.URL imgURL = GuiUtils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
