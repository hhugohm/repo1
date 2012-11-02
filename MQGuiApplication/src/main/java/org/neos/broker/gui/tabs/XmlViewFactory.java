/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.tabs;

import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 * Thanks: http://groups.google.com/group/de.comp.lang.java/msg/2bbeb016abad270
 * 
 * IMPORTANT NOTE: regex should contain 1 group.
 * 
 * Using PlainView here because we don't want line wrapping to occur.
 * 
 * @author kees
 * @date 13-jan-2006
 *
 */
public class XmlViewFactory extends Object implements ViewFactory {
 
    /**
     * @see javax.swing.text.ViewFactory#create(javax.swing.text.Element)
     */
    @Override
    public View create(Element element) {
 
        return new XmlView(element);
    }
 
}