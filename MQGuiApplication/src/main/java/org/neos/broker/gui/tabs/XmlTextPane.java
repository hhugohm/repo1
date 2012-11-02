/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tabs;

import javax.swing.JTextPane;

public class XmlTextPane extends JTextPane {
 
    private static final long serialVersionUID = 6270183148379328084L;
 
    public XmlTextPane() {
         
        // Set editor kit
        this.setEditorKitForContentType("text/xml", new XmlEditorKit());
        this.setContentType("text/xml");
    }
     
}