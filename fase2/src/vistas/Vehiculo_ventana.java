/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import excepciones.sinDatos;
import uml.Vehiculo;
import umlBD.AdministracionBD;
import umlBD.VehiculoBD;
import java.sql.*;

/**
 *
 * @author 1GLM07
 */
public class Vehiculo_ventana extends javax.swing.JFrame {
 private char opt;
 private String matriculaID;
    /**
     * Creates new form Vehiculo
     */
    public Vehiculo_ventana() {
        initComponents();
       setLocationRelativeTo(null);
       prepararVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgaltabaja = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfmatricula = new javax.swing.JTextField();
        rbaltav = new javax.swing.JRadioButton();
        rbbajav = new javax.swing.JRadioButton();
        bgenerico = new javax.swing.JButton();
        tfmodelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfmarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        baceptar = new javax.swing.JButton();
        bcancelar = new javax.swing.JButton();
        rbmodificar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matricula");

        tfmatricula.setEnabled(false);
        tfmatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmatriculaActionPerformed(evt);
            }
        });

        bgaltabaja.add(rbaltav);
        rbaltav.setText("Vehiculo Nuevo");
        rbaltav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbaltavActionPerformed(evt);
            }
        });

        bgaltabaja.add(rbbajav);
        rbbajav.setText("Eliminar vehiculo");
        rbbajav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbajavActionPerformed(evt);
            }
        });

        bgenerico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vehiculo.jpg"))); // NOI18N
        bgenerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgenericoActionPerformed(evt);
            }
        });

        tfmodelo.setEnabled(false);

        jLabel2.setText("Marca");

        tfmarca.setEnabled(false);
        tfmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo");

        baceptar.setText("Aceptar");
        baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baceptarActionPerformed(evt);
            }
        });

        bcancelar.setText("Cancelar");
        bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelarActionPerformed(evt);
            }
        });

        bgaltabaja.add(rbmodificar);
        rbmodificar.setText("Modificar");
        rbmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bcancelar)
                        .addGap(18, 18, 18)
                        .addComponent(baceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(rbaltav)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbmodificar)
                            .addComponent(rbbajav))))
                .addGap(44, 44, 44)
                .addComponent(bgenerico, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bgenerico, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbaltav)
                            .addComponent(rbbajav))
                        .addGap(9, 9, 9)
                        .addComponent(rbmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(baceptar)
                            .addComponent(bcancelar))
                        .addGap(9, 9, 9))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfmatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmatriculaActionPerformed
      try{
          if(tfmatricula.getText().isEmpty()){ javax.swing.JOptionPane.showMessageDialog(null, "no se pueden realizar operaciones si el campo de la matricula esta vacío");}
          else{
        if(opt=='u'){
            Vehiculo v =new Vehiculo();
          v= fase2.Fase2.consultarVehiculo(tfmatricula.getText());
         matriculaID=tfmatricula.getText();
          tfmatricula.setText(v.getMatricula());
          tfmarca.setText(v.getMarca());
          tfmodelo.setText(v.getModelo());
          
          
          tfmarca.setEnabled(true);
          tfmodelo.setEnabled(true);
          baceptar.setEnabled(true);
        }
          
       }
      }catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_tfmatriculaActionPerformed

    private void tfmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmarcaActionPerformed

    private void rbaltavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbaltavActionPerformed
     opt='c';
        prepararVentana();
        
        tfmatricula.setEnabled(true);
        tfmarca.setEnabled(true);
        tfmodelo.setEnabled(true);
        
        baceptar.setEnabled(true);
    }//GEN-LAST:event_rbaltavActionPerformed

    private void rbbajavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbajavActionPerformed
    opt='d';
        prepararVentana();
        
        tfmatricula.setEnabled(true);
        tfmarca.setEnabled(false);
        tfmodelo.setEnabled(false);
        
         baceptar.setEnabled(true);
    }//GEN-LAST:event_rbbajavActionPerformed

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        try{
             
            String matricula= tfmatricula.getText();
            String marca= tfmarca.getText();
             String modelo= tfmodelo.getText();
             
          
           switch(opt){
              case'c':   if(matricula.isEmpty()||marca.isEmpty()||modelo.isEmpty())
              {
                 javax.swing.JOptionPane.showMessageDialog(null,"todos los campos son obligatorios");
              }else{            
                  fase2.Fase2.generarVehiculo(matricula,marca,modelo);}                       
                break;
              case'd':fase2.Fase2.borrarVehiculo(matricula);
                break;
              case'u':  if(matricula.isEmpty()||marca.isEmpty()||modelo.isEmpty())
              {
                 javax.swing.JOptionPane.showMessageDialog(null,"todos los campos son obligatorios");
              }else{ 
                  fase2.Fase2.actualizarVehiculo(matricula, marca, modelo,matriculaID);
              }
                  break;
              

           }
              
        }catch(java.sql.SQLIntegrityConstraintViolationException  a){
        javax.swing.JOptionPane.showMessageDialog(null, "violacion de integridad de las tablas puede que el vehiculo ya exista ");}
        catch(Exception e){
               javax.swing.JOptionPane.showMessageDialog(null,"error al realizar la operacion: "+e.getMessage() +e.getClass());
                }
    }//GEN-LAST:event_baceptarActionPerformed

    private void bcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelarActionPerformed
       
        prepararVentana();
        
        
    }//GEN-LAST:event_bcancelarActionPerformed

    private void bgenericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgenericoActionPerformed
             
        
        try{
        String vehiculos=fase2.Fase2.consultarVehiculos();
         javax.swing.JOptionPane.showMessageDialog(null, vehiculos);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage()+e.getClass());
        }
    }//GEN-LAST:event_bgenericoActionPerformed

    private void rbmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmodificarActionPerformed
        opt='u';
        prepararVentana();
        
        tfmatricula.setEnabled(true);
        tfmarca.setEnabled(false);
        tfmodelo.setEnabled(false);
        
        baceptar.setEnabled(false);
        
        
        
    }//GEN-LAST:event_rbmodificarActionPerformed

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
            java.util.logging.Logger.getLogger(Vehiculo_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehiculo_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehiculo_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehiculo_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehiculo_ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baceptar;
    private javax.swing.JButton bcancelar;
    private javax.swing.ButtonGroup bgaltabaja;
    private javax.swing.JButton bgenerico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rbaltav;
    private javax.swing.JRadioButton rbbajav;
    private javax.swing.JRadioButton rbmodificar;
    private javax.swing.JTextField tfmarca;
    private javax.swing.JTextField tfmatricula;
    private javax.swing.JTextField tfmodelo;
    // End of variables declaration//GEN-END:variables

    private void prepararVentana() {
         tfmatricula.setText("");
        tfmarca.setText("");
        tfmodelo.setText("");
        
        baceptar.setEnabled(true);
        
    }
}
