package GUI;

import himevico_gestion.Himevico_gestion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VgestionCentros extends javax.swing.JFrame {

    public VgestionCentros() {
        initComponents();
        jBpEdicion.setVisible(false);
    }

    public void resetearCampos() {

        jTnombreC.setText("");
        jTcalleC.setText("");
        jTnumeC.setText("");
        jTcpC.setText("");
        jTciudadC.setText("");
        jTprovC.setText("");
        jTtelfC.setText("");
    }

    public void rellenarCamposVentana(String nom, String calle, String nu, String cp, String ciu, String prov, String tlf) {

        jTnombreC.setText(nom);
        jTcalleC.setText(calle);
        jTnumeC.setText(nu);
        jTcpC.setText(cp);
        jTciudadC.setText(ciu);
        jTprovC.setText(prov);
        jTtelfC.setText(tlf);

    }
    
    public void configurarCrear(){
        
        jBpEdicion.setVisible(false);
        
        jBaceptar.setEnabled(true);
        jBborrarDefinitivo.setEnabled(false);
        jBmodificarDefinitivo.setEnabled(false);
        
        configurarPermitirEditar();
        
    }

    public void configurarBorrar(){
        
        jBpEdicion.setVisible(false);
        
        jBaceptar.setEnabled(false);
        jBborrarDefinitivo.setEnabled(true);
        jBmodificarDefinitivo.setEnabled(false);
        
        jTnombreC.setEditable(false);
        jTcalleC.setEditable(false);
        jTnumeC.setEditable(false);
        jTcpC.setEditable(false);
        jTciudadC.setEditable(false);
        jTprovC.setEditable(false);
        jTtelfC.setEditable(false);
         
    }
    
    public void configurarModificar(){
        
        jBpEdicion.setVisible(true);
        
        jBaceptar.setEnabled(false);
        jBborrarDefinitivo.setEnabled(false);
        jBmodificarDefinitivo.setEnabled(true);

        jTnombreC.setEditable(false);
        jTcalleC.setEditable(false);
        jTnumeC.setEditable(false);
        jTcpC.setEditable(false);
        jTciudadC.setEditable(false);
        jTprovC.setEditable(false);
        jTtelfC.setEditable(false);
        
        
    }
    
    public void configurarPermitirEditar(){  
        
        jTnombreC.setEditable(true);
        jTcalleC.setEditable(true);
        jTnumeC.setEditable(true);
        jTcpC.setEditable(true);
        jTciudadC.setEditable(true);
        jTprovC.setEditable(true);
        jTtelfC.setEditable(true);
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBcrear = new javax.swing.JButton();
        jBborrar = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTnombreC = new javax.swing.JTextField();
        jTcalleC = new javax.swing.JTextField();
        jTnumeC = new javax.swing.JTextField();
        jTcpC = new javax.swing.JTextField();
        jTciudadC = new javax.swing.JTextField();
        jTtelfC = new javax.swing.JTextField();
        jBaceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTprovC = new javax.swing.JTextField();
        jBborrarDefinitivo = new javax.swing.JButton();
        jBmodificarDefinitivo = new javax.swing.JButton();
        jBpEdicion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        jBcrear.setText("CREAR");
        jBcrear.setFocusable(false);
        jBcrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBcrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcrearActionPerformed(evt);
            }
        });
        jToolBar1.add(jBcrear);

        jBborrar.setText("BORRAR");
        jBborrar.setFocusable(false);
        jBborrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBborrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBborrar);

        jBmodificar.setText("MODIFICAR");
        jBmodificar.setFocusable(false);
        jBmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBmodificar);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 30));

        jLabel2.setText("NOMBRE");

        jLabel3.setText("CALLE");

        jLabel4.setText("NUMERO");

        jLabel5.setText("CODIGO POSTAL");

        jLabel6.setText("CIUDAD");

        jLabel7.setText("PROVINCIA");

        jLabel8.setText("TELEFONO");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setText("DATOS  DEL CENTRO");

        jTtelfC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTtelfCActionPerformed(evt);
            }
        });

        jBaceptar.setText("ACEPTAR");
        jBaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jBborrarDefinitivo.setText("BORRAR");
        jBborrarDefinitivo.setEnabled(false);
        jBborrarDefinitivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarDefinitivoActionPerformed(evt);
            }
        });

        jBmodificarDefinitivo.setText("MODIFICAR");
        jBmodificarDefinitivo.setEnabled(false);
        jBmodificarDefinitivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarDefinitivoActionPerformed(evt);
            }
        });

        jBpEdicion.setText("PERMITIR EDITAR");
        jBpEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpEdicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBaceptar)
                                .addGap(42, 42, 42)
                                .addComponent(jBborrarDefinitivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBmodificarDefinitivo))
                            .addComponent(jTnombreC, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(jTcalleC)
                            .addComponent(jTnumeC)
                            .addComponent(jTcpC)
                            .addComponent(jTciudadC)
                            .addComponent(jTprovC)
                            .addComponent(jTtelfC))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBpEdicion))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel9)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTnombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTcalleC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTnumeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTcpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTciudadC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTprovC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jTtelfC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBmodificarDefinitivo)
                    .addComponent(jBaceptar)
                    .addComponent(jBborrarDefinitivo)
                    .addComponent(jBpEdicion))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 1250, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/business.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTtelfCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTtelfCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTtelfCActionPerformed

    private void jBaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarActionPerformed

            // BOTON ACEPTAR DE LA VENTANA DE GESTION DE CENTROS :
        try {
            
            int fila = Himevico_gestion.crearCentro(jTnombreC.getText(), jTcalleC.getText(), jTnumeC.getText(), jTcpC.getText(), jTciudadC.getText(), jTprovC.getText(), jTtelfC.getText());

            if (fila > 0) {

                JOptionPane.showMessageDialog(this, "SE HA INSERTADO UN CENTRO CORRECTAMENTE");
                resetearCampos();
                jTnombreC.grabFocus();

            }else{
                
                JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(VgestionCentros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBaceptarActionPerformed

    private void jBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarActionPerformed
        
            // BOTON DE BORRADO EN EL MENU:
            
        configurarBorrar();
        
        try {  
            Himevico_gestion.crearVseleccionDeCentro();
        } catch (SQLException ex) {
            Logger.getLogger(VgestionCentros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBborrarActionPerformed

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
       
            // BOTON DE MODIFICAR DEL MENU:
            configurarModificar();
            
        try {

            Himevico_gestion.crearVseleccionDeCentro();
            
        } catch (SQLException ex) {
            Logger.getLogger(VgestionCentros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBmodificarActionPerformed

    private void jBborrarDefinitivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarDefinitivoActionPerformed
        // BOTON DE BORRADO DEFINITIVO DEL CENTRO SELECCIONADO:

        String respuesta = JOptionPane.showInputDialog("ESTAS SEGURO DE QUERER BORRAR EL CENTRO, ESTA ACCION ES IRREVERSIBLE(SI/NO)");

        if (respuesta.equalsIgnoreCase("si")) {

            boolean ok = false;

            try {

                ok = Himevico_gestion.borrarCentro();

            } catch (SQLException ex) {
                Logger.getLogger(VgestionCentros.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (ok == true) {

                JOptionPane.showMessageDialog(this, "EL CENTRO SE HA ELIMINADO DE LA BASE DE DATOS");

            }

        }
    }//GEN-LAST:event_jBborrarDefinitivoActionPerformed

    private void jBmodificarDefinitivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarDefinitivoActionPerformed
     
            // BOTON DE MODIFICAR CENTRO DE MANERA DEFINITVA:
            
        boolean ok=false;    
        try {
            
            ok=Himevico_gestion.modificarCentro(jTnombreC.getText(), jTcalleC.getText(), jTnumeC.getText(), jTcpC.getText(), jTciudadC.getText(), jTprovC.getText(), jTtelfC.getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(VgestionCentros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ok==true){
            
            JOptionPane.showMessageDialog(this, "LAS MODIFICACIONES SE HAN REALIZADO CORRECTAMENTE");
            
        }
        
    }//GEN-LAST:event_jBmodificarDefinitivoActionPerformed

    private void jBcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcrearActionPerformed
        // MENU BOTON CREAR CREAR:
        
        configurarCrear();
    }//GEN-LAST:event_jBcrearActionPerformed

    private void jBpEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpEdicionActionPerformed
        // BOTON QUE PERMITIRA MODIFICAR LOS DATOS DEL CENTRO:
        
        configurarPermitirEditar();
        
    }//GEN-LAST:event_jBpEdicionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VgestionCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VgestionCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VgestionCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VgestionCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VgestionCentros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBaceptar;
    private javax.swing.JButton jBborrar;
    private javax.swing.JButton jBborrarDefinitivo;
    private javax.swing.JButton jBcrear;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBmodificarDefinitivo;
    private javax.swing.JButton jBpEdicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTcalleC;
    private javax.swing.JTextField jTciudadC;
    private javax.swing.JTextField jTcpC;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTnombreC;
    private javax.swing.JTextField jTnumeC;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTprovC;
    private javax.swing.JTextField jTtelfC;
    // End of variables declaration//GEN-END:variables
}
