/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.demos;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import org.neos.broker.beans.RequestBroker;
import org.neos.broker.beans.ResponseBroker;
import org.neos.broker.business.IBusinessConexion;
import org.neos.broker.constants.ConstantsBroker;
import org.neos.broker.dao.ConexionDao;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Mensaje;
import org.neos.broker.gui.tree.IconNodeRenderer;
import org.neos.broker.gui.tree.NodeGui;
import static org.neos.broker.gui.tree.GuiUtils.createImageIcon;
import org.neos.broker.gui.tree.NodeMQUI;
import org.neos.broker.gui.tree.TreeMouseAdapter;
import static org.neos.broker.utils.SpringContextManager.getInstance;

/**
 *
 * @author neossoftware
 */
public class DemoTree extends JPanel{
    
      private NodeGui<String> raiz;
      private JTree arbol;
      private DefaultTreeModel modelo;
      private IBusinessConexion businessConexion;
    
    
    public DemoTree() {
        arbol = new JTree();
        buildTreeConexion(arbol);
        super.setLayout( new BorderLayout() ); //no fijarse
        add( new JScrollPane( arbol ),BorderLayout.CENTER ); //no fijarse
       
    }
   protected  void buildTreeConexion(JTree arbol){
        
         businessConexion = (IBusinessConexion)  
                        getInstance().getContext().
                                    getBean(ConstantsBroker.BUSINESS_CONEXION);
         
        RequestBroker request = new RequestBroker();
        ResponseBroker response;
        
        putArbolRequest(request,arbol);
        response=businessConexion.getAllConexionBusiness(request);
        
        showTreeConexion(response,arbol); 

    }
    
    protected void showTreeConexion(ResponseBroker response,JTree arbol){
       arbol= response.getArbol();
       raiz=response.getRaiz();
       
       arbol.setCellRenderer(new IconNodeRenderer());
       arbol.expandRow(0);
    }
    protected void putArbolRequest(RequestBroker request,JTree arbol){
        request.setArbol(arbol);
        
    }
     public static void main( String args[] ) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new DemoTree(),BorderLayout.CENTER );
        frame.setSize( 200,500 );
        frame.setVisible( true );
    }

    public void setBusinessConexion(IBusinessConexion businessConexion) {
        this.businessConexion = businessConexion;
    }

    public IBusinessConexion getBusinessConexion() {
        return businessConexion;
    }

     
     
   
}
