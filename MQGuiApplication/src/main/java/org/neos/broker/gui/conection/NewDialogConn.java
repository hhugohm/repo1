/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neos.broker.gui.conection;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import org.apache.commons.lang.StringUtils;
import org.neos.broker.business.IBusinessConexion;
import org.neos.broker.constants.ConstantsBroker;
import org.neos.broker.domain.Conexion;
import org.neos.broker.domain.Usuario;
import org.neos.broker.gui.MQApplicationJdesk;
import org.neos.broker.gui.tree.NodeMQUI;
import static org.neos.broker.gui.tree.GuiUtils.createImageIcon;
import org.neos.broker.gui.tree.NodeGui;
import org.neos.broker.utils.SpringContextManager;


/**
 * 
 * Clase encargada de generar una nueva conexion en el pool de MQ
 *
 * @author NeosSoftware Corporation
 */
public class NewDialogConn extends javax.swing.JDialog {
    
    private MQApplicationJdesk mqdesk;
    private DefaultTreeModel modelo;
    

    /**
     * Creates new form NewDialogConn
     */
    public NewDialogConn(MQApplicationJdesk mqdesk, boolean modal) {
        super(mqdesk, modal);
        this.mqdesk = mqdesk; 
        initComponents();
        // Se obtienen las dimensiones en pixels de la pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Se obtienen las dimensiones en pixels de la ventana.
        Dimension ventana = this.getSize();
        
        // Una cuenta para situar la ventana en el centro de la pantalla.
        this.setLocation(
            (pantalla.width - ventana.width) / 2,
            (pantalla.height - ventana.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        txtHostName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQueManager = new javax.swing.JTextField();
        lblQManager = new javax.swing.JLabel();
        txtQuePut = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQueGet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCanal = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        radioSi = new javax.swing.JRadioButton();
        radioNo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Conexion");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Conexión"));

        jLabel1.setText("Nombre:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Host:");

        jLabel3.setText("Tipo:");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DESARROLLO", "UAT", "PRODUCCION" }));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        txtHostName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHostNameActionPerformed(evt);
            }
        });

        jLabel4.setText("QManager:");

        lblQManager.setText("Que Put:");

        jLabel5.setText("Que Get:");

        jLabel6.setText("Canal:");

        jLabel7.setText("Puerto:");

        jLabel8.setText("Seguridad");

        buttonGroup1.add(radioSi);
        radioSi.setText("Si");
        radioSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSiActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNo);
        radioNo.setText("No");
        radioNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoActionPerformed(evt);
            }
        });

        jLabel9.setText("Usuario");

        jLabel10.setText("Password");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblQManager)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQueManager, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQuePut, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQueGet, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCanal, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioNo))
                            .addComponent(txtUsuario)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtQueManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQManager)
                    .addComponent(txtQuePut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQueGet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(radioSi)
                    .addComponent(radioNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void txtHostNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHostNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHostNameActionPerformed

    private void radioSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSiActionPerformed
      this.txtUsuario.setEnabled(true);
      this.txtPassword.setEnabled(true);
    }//GEN-LAST:event_radioSiActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validateFeed()) {
            //obtiene el modelo del arbol de la ventana principal
            this.modelo = (DefaultTreeModel) mqdesk.getJtreeConnections().getModel();
            Conexion conexion= createConexion(); 
            
            NodeMQUI rama = new NodeMQUI<String>(conexion.getIdConexion(), true,createImageIcon("/icons/plugin.gif"));
        
            rama.setConexion(conexion);
            
            NodeGui<String> raiz =  (NodeGui<String>) modelo.getRoot();
                        
             modelo.insertNodeInto(rama, raiz, 0);
            //agrega una nueva rama
              this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
   
    
    
    /**
    * Metodo que a partir de los campos de la vista obtiene 
    * el objeto para poderlo salvar en la base de datos.
    */
    public Conexion createConexion() {
        
        Conexion conexion = new Conexion();
        conexion.setIdConexion(this.txtName.getText());
        //conexion.setTipoAmbiente(this.cmbType.g);
        conexion.setHost(this.txtHostName.getText());
        conexion.setqManager(this.txtQueManager.getText());
        conexion.setqPut(this.txtQuePut.getText());
        conexion.setqGet(this.txtQueGet.getText());
        conexion.setqChanel(this.txtCanal.getText());
        conexion.setqPort(Integer.parseInt(this.txtPuerto.getText()));
        conexion.setTipoAmbiente((String)this.cmbType.getSelectedItem());
        conexion.setFechaAlta(new Date());
        
        if (this.radioSi.isSelected()) {
           //coloca la informacion de seguridad
            Usuario usuario = new Usuario();
            usuario.setUsuario(this.txtUsuario.getText());
            usuario.setPassword(new String(this.txtPassword.getPassword()));
            conexion.setUsuario(usuario);            
            conexion.setBndSecurity(1);
        } else {
             conexion.setBndSecurity(0);
        }
        
        IBusinessConexion business = (IBusinessConexion) SpringContextManager.getInstance()
                .getContext().getBean(ConstantsBroker.BUSINESS_CONEXION);
        business.saveOrUpdate(conexion);
        
        //salva la conexion en la base de datos
               
        return conexion;
    
    }
    
     private boolean validateFeed() {
         boolean valid = true;
         String messageError = "";
         if (StringUtils.isEmpty(this.txtName.getText())) {
              valid = false;
              messageError = "-Ingrese un nombre a la conexion \n";
         }
         if (StringUtils.isEmpty(this.txtHostName.getText())) {
              valid=false;
              messageError = messageError + "-Ingrese el host de la conexion \n";
         }
         
         //el que manager no necesariamente es un dato de entrada
         if (StringUtils.isEmpty(this.txtQuePut.getText())) {
             valid=false;
              messageError = messageError + "-Ingrese la Queue de Put \n";
         }
         
         if (StringUtils.isEmpty(this.txtQueGet.getText())) {
             valid=false;
              messageError = messageError + "-Ingrese la Queue de Get \n";
         }
         
         if (StringUtils.isEmpty(this.txtCanal.getText())) {
             valid=false;
              messageError = messageError + "-Ingrese el Canal de la conexion \n";
         }
         
          if (StringUtils.isEmpty(this.txtPuerto.getText())) {
             valid=false;
              messageError = messageError + "-Ingrese el Puerto de la conexion \n";
         }
         //si selecciono
         if (!radioSi.isSelected() && !radioNo.isSelected()) {
             valid=false;
              messageError = messageError + "-Seleccione una opcion de la seguridad de la conexión \n";
         } else {         
             if (radioSi.isSelected()) {
                 if (StringUtils.isEmpty(txtUsuario.getText())) {
                     valid=false;
              messageError = messageError + "-Ingrese el Usuario de la Conexión \n";
                     
                 } 
                 
                 if (txtPassword.getPassword().length==0){
                   valid=false;
                   messageError = messageError + "-Ingrese el Password de la Conexión \n";
                 }
                 
             }
             
         }
         
         
         
         if (!valid) {
               JOptionPane.showMessageDialog(this, messageError, "Error", JOptionPane.ERROR_MESSAGE);        
         }
     
         
         return valid;
     }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radioNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoActionPerformed
       this.txtUsuario.setEnabled(false);
       this.txtPassword.setEnabled(false);
    }//GEN-LAST:event_radioNoActionPerformed

   public MQApplicationJdesk getMqdesk() {
        return mqdesk;
    }

    public void setMqdesk(MQApplicationJdesk mqdesk) {
        this.mqdesk = mqdesk;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblQManager;
    private javax.swing.JRadioButton radioNo;
    private javax.swing.JRadioButton radioSi;
    private javax.swing.JTextField txtCanal;
    private javax.swing.JTextField txtHostName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtQueGet;
    private javax.swing.JTextField txtQueManager;
    private javax.swing.JTextField txtQuePut;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
