/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.demos;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.util.EncodingMap;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.XNIException;

/**
 *  The DOMParserSaveEncoding class extends DOMParser. It also provides
 *  the Java Encoding of the XML document by overriding the startDocument method 
 *  and providing a way to capture the MIME encoding from the XML document which
 *  in turn is converted to the Java Encoding by the internal MIME2Java class.
 *   
 */


public class DOMParserSaveEncoding extends DOMParser {
    String _mimeEncoding = "UTF-8";//Default  MIME so we check the file.encoding
    private void setMimeEncoding( String encoding ) {
        _mimeEncoding = encoding;
    }
    private String getMimeEncoding() {
        return(_mimeEncoding);
    }
    public String getJavaEncoding() {
        String javaEncoding = null;
        String mimeEncoding = getMimeEncoding();

        if (mimeEncoding != null) {
            if (mimeEncoding.equals( "DEFAULT" ))
                javaEncoding =  "UTF8";
            else if (mimeEncoding.equalsIgnoreCase( "UTF-16" ))
                javaEncoding = "Unicode";
            else
                javaEncoding = EncodingMap.getIANA2JavaMapping( mimeEncoding );    
        } 
        if(javaEncoding == null)   // Should never return null
            javaEncoding = "UTF8";
        return(javaEncoding);
    }
    public void startGeneralEntity(String name, 
                            XMLResourceIdentifier identifier,
                            String encoding, Augmentations augs) throws XNIException {
        if( encoding != null){
            setMimeEncoding( encoding);
        }
        super.startGeneralEntity(name, identifier, encoding, augs);
    }

}
