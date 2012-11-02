/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.business;

import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import org.neos.broker.beans.RequestBroker;
import org.neos.broker.beans.ResponseBroker;
import org.neos.broker.constants.ConstantsBroker;
import org.neos.broker.dao.ConexionDao;
import org.neos.broker.domain.Conexion;
import org.neos.broker.gui.tree.NodeGui;
import static org.neos.broker.gui.tree.GuiUtils.createImageIcon;

/**
 *
 * NeosSoftware Corporation 2012
 * 
 * @author Camus
 * 
 */
public class BusinessConexion extends AbtractConexion 
                                                implements IBusinessConexion {
    
    private ConexionDao conexionDao;
    private List<Conexion> lstConexion;
    
    /**
     *
     * @param conexion
     */
    public void saveOrUpdate(Conexion conexion) {
        conexionDao.saveOrUpdate(conexion);
    }
  
    
    public ResponseBroker getAllConexionBusiness(RequestBroker request) {
        ResponseBroker response = new ResponseBroker();
        JTree arbol= request.getArbol();
        
        DefaultTreeModel modelo =(DefaultTreeModel)arbol.getModel();
        NodeGui raiz = new NodeGui<String>(ConstantsBroker.TITLE_RAIZ, true, 
                                   createImageIcon(ConstantsBroker.IMAGE_RAIZ));
        modelo.setRoot(raiz);     
       
        lstConexion= getAllConexionDao();
        
        for(Conexion conexion:lstConexion){
            conexion = getConexionByKeyDao(conexion.getIdConexion());
            putConexionOnTree(conexion,raiz,modelo);  
        }
        response.setArbol(arbol);
        response.setRaiz(raiz);
        
        return response; 
    }
    
    protected Conexion getConexionByKeyDao(String key){
        
        return conexionDao.getByKey(key);
    }
    
    protected List<Conexion> getAllConexionDao(){
        
        return conexionDao.getAll();
    }
    public void setConexionDao(ConexionDao conexionDao) {
        this.conexionDao = conexionDao;
    }

    public ConexionDao getConexionDao() {
        return conexionDao;
    }

    public void update(Conexion conexion) {
       conexionDao.update(conexion);
    }
    
    
}
