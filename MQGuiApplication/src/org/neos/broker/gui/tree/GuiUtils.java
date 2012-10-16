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

    public static ImageIcon createImageIcon(String path,
            String description, Class clas) {
        java.net.URL imgURL = clas.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
