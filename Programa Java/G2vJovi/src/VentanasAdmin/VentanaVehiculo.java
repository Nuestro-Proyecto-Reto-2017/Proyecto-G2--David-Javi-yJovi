/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasAdmin;
import excepciones.sinDatos;
import ModeloUML.Vehiculo;
import ModeloBD.*;
import ModeloBD.VehiculoBD;
import java.sql.*;
/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 */
public class VentanaVehiculo extends javax.swing.JDialog {
private char opt;
 private String matriculaID;
    /**
     * Constructor de la Ventana
     */
    public VentanaVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          setLocationRelativeTo(null);
       prepararVentana();
    }

    /**
     * Codigo autogenerado, no tocar.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bcancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbmodificar = new javax.swing.JRadioButton();
        tfmatricula = new javax.swing.JTextField();
        rbaltav = new javax.swing.JRadioButton();
        rbbajav = new javax.swing.JRadioButton();
        bgenerico = new javax.swing.JButton();
        tfmodelo = new javax.swing.JTextField();
        marca = new javax.swing.JLabel();
        tfmarca = new javax.swing.JTextField();
        modleo = new javax.swing.JLabel();
        baceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bcancelar.setText("Cancelar");
        bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricula");

        buttonGroup1.add(rbmodificar);
        rbmodificar.setText("Modificar");
        rbmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmodificarActionPerformed(evt);
            }
        });

        tfmatricula.setEnabled(false);
        tfmatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmatriculaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbaltav);
        rbaltav.setText("Vehiculo Nuevo");
        rbaltav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbaltavActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbbajav);
        rbbajav.setText("Eliminar vehiculo");
        rbbajav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbajavActionPerformed(evt);
            }
        });

        bgenerico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Vehiculo.jpg"))); // NOI18N
        bgenerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgenericoActionPerformed(evt);
            }
        });

        tfmodelo.setEnabled(false);
        tfmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmodeloActionPerformed(evt);
            }
        });

        marca.setText("Marca");

        tfmarca.setEnabled(false);
        tfmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmarcaActionPerformed(evt);
            }
        });

        modleo.setText("Modelo");

        baceptar.setText("Aceptar");
        baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Vehiculos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbaltav)
                        .addGap(18, 18, 18)
                        .addComponent(rbbajav)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbmodificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(baceptar)
                            .addGap(18, 18, 18)
                            .addComponent(bcancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(marca, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(49, 49, 49)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(modleo)
                                    .addGap(49, 49, 49)
                                    .addComponent(tfmodelo))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgenerico, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbaltav)
                            .addComponent(rbbajav)
                            .addComponent(rbmodificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marca))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modleo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bcancelar)
                            .addComponent(baceptar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bgenerico)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Cerrar ventana.
     */
    private void bcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelarActionPerformed

        this.dispose();

    }//GEN-LAST:event_bcancelarActionPerformed
    /**
     * Cambiar ventana para modificar.
     */
    private void rbmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmodificarActionPerformed
        opt='u';
        prepararVentana();
         
        tfmatricula.setEditable(true);
        tfmarca.setVisible(true);
        tfmodelo.setVisible(true);
        marca.setVisible(true);
        modleo.setVisible(true);

        tfmatricula.setEnabled(true);
        tfmarca.setEnabled(false);
        tfmodelo.setEnabled(false);

        baceptar.setEnabled(false);

    }//GEN-LAST:event_rbmodificarActionPerformed
    /**
     * Metodo para asegurar que esta metiendo la matricula para poder modificar los valores,
     */
    private void tfmatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmatriculaActionPerformed
        try{
            if(tfmatricula.getText().isEmpty()){ javax.swing.JOptionPane.showMessageDialog(null, "no se pueden realizar operaciones si el campo de la matricula esta vacío");}
            else{
                if(opt=='u'){
                    Vehiculo v =new Vehiculo();
                    v= g2vjovi.G2vJovi.consultarVehiculo(tfmatricula.getText());
                    matriculaID=tfmatricula.getText();
                    tfmatricula.setText(v.getMatricula());
                    tfmarca.setText(v.getMarca());
                    tfmodelo.setText(v.getModelo());
                    
                    tfmarca.requestFocus();
                    tfmatricula.setEditable(false);
                    
                    tfmarca.setEnabled(true);
                    tfmodelo.setEnabled(true);
                    baceptar.setEnabled(true);
                }

            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tfmatriculaActionPerformed
    /**
     * Cambiar ventana para el alta.
     */
    private void rbaltavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbaltavActionPerformed
        opt='c';
        prepararVentana();
        tfmatricula.setEnabled(true);
        tfmatricula.setEditable(true);
        tfmarca.setVisible(true);
        tfmodelo.setVisible(true);
        marca.setVisible(true);
        modleo.setVisible(true);

        tfmatricula.setEnabled(true);
        tfmarca.setEnabled(true);
        tfmodelo.setEnabled(true);

        baceptar.setEnabled(true);
    }//GEN-LAST:event_rbaltavActionPerformed
    /**
     * Cambiar ventana para la baja.
     */
    private void rbbajavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbajavActionPerformed
        opt='d';
        prepararVentana();

        tfmatricula.setEditable(true);
        tfmatricula.setEnabled(true);
        tfmarca.setVisible(false);
        tfmodelo.setVisible(false);
        marca.setVisible(false);
        modleo.setVisible(false);

        baceptar.setEnabled(true);
    }//GEN-LAST:event_rbbajavActionPerformed
    /**
     * Consultar lista de vehiculos en la BD.
     */
    private void bgenericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgenericoActionPerformed

        try{
            String vehiculos=g2vjovi.G2vJovi.consultarVehiculos();
            javax.swing.JOptionPane.showMessageDialog(null, vehiculos);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage()+e.getClass());
        }
    }//GEN-LAST:event_bgenericoActionPerformed

    private void tfmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmarcaActionPerformed
    /**
     * Boton aceptar con un switch para que en cada caso llame a un metodo o a otro.
     */
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
                    g2vjovi.G2vJovi.generarVehiculo(matricula,marca,modelo);}
                break;
                case'd':g2vjovi.G2vJovi.borrarVehiculo(matricula);
                break;
                case'u':  if(matricula.isEmpty()||marca.isEmpty()||modelo.isEmpty())
                {
                    javax.swing.JOptionPane.showMessageDialog(null,"todos los campos son obligatorios");
                }else{
                    g2vjovi.G2vJovi.actualizarVehiculo(matricula, marca, modelo,matriculaID);
                }
                break;
            }

        }catch(java.sql.SQLIntegrityConstraintViolationException  a){
            javax.swing.JOptionPane.showMessageDialog(null, "violacion de integridad de las tablas puede que el vehiculo ya exista ");}
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error al realizar la operacion: "+e.getMessage() +e.getClass());
        }
    }//GEN-LAST:event_baceptarActionPerformed
    /**
     * Action performed para cuando estas situado en el último TextField realiza un doClick al boton aceptar
     */
    private void tfmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmodeloActionPerformed
        baceptar.doClick();
    }//GEN-LAST:event_tfmodeloActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaVehiculo dialog = new VentanaVehiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baceptar;
    private javax.swing.JButton bcancelar;
    private javax.swing.JButton bgenerico;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modleo;
    private javax.swing.JRadioButton rbaltav;
    private javax.swing.JRadioButton rbbajav;
    private javax.swing.JRadioButton rbmodificar;
    private javax.swing.JTextField tfmarca;
    private javax.swing.JTextField tfmatricula;
    private javax.swing.JTextField tfmodelo;
    // End of variables declaration//GEN-END:variables
    /**
     * Metodo que limpia los textfields.
     */
    private void prepararVentana() {
         tfmatricula.setText("");
        tfmarca.setText("");
        tfmodelo.setText("");
        
        baceptar.setEnabled(true);
        
    }
}
