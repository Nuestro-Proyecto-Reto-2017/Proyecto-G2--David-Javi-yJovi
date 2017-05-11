/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasAdmin;

import g2vjovi.G2vJovi;

public class VentanaLogistica extends javax.swing.JFrame {
private G2vJovi main = new G2vJovi();
    /**
     * Constructor de la ventana (es una ventana abierta a pantalla completa)
     * Esta ventana es la ventana principal del trabajador de Logistica y contiene los menus de las acciones que este puede realizar
     */
    public VentanaLogistica() {
        initComponents();
    }

    /**
     * Codigo autogenerado, no tocar.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLfondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mPerfil = new javax.swing.JMenu();
        mModificarPerfil = new javax.swing.JMenuItem();
        mParte = new javax.swing.JMenu();
        mNuevoParte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Himevico.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/business.jpg"))); // NOI18N
        getContentPane().add(jLfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mPerfil.setText("Perfil");

        mModificarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        mModificarPerfil.setText("Modificar Perfil");
        mModificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mModificarPerfilActionPerformed(evt);
            }
        });
        mPerfil.add(mModificarPerfil);

        jMenuBar1.add(mPerfil);

        mParte.setText("Parte");

        mNuevoParte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/newIcon.png"))); // NOI18N
        mNuevoParte.setText("Nuevo Parte");
        mNuevoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNuevoParteActionPerformed(evt);
            }
        });
        mParte.add(mNuevoParte);

        jMenuBar1.add(mParte);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Metodo que abre la ventana de crear partes
 */
    private void mNuevoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoParteActionPerformed
       try{
            main.abrirVentanaCreacionPartes();
       }
       catch(Exception e){
           javax.swing.JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_mNuevoParteActionPerformed
/**
 * Metodo que abre la ventana de modificar contraseña del perfil
 */
    private void mModificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mModificarPerfilActionPerformed
        // MODIFICAR PERFIL:
        g2vjovi.G2vJovi.abrirventanaUsuario();
        
    }//GEN-LAST:event_mModificarPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogistica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mModificarPerfil;
    private javax.swing.JMenuItem mNuevoParte;
    private javax.swing.JMenu mParte;
    private javax.swing.JMenu mPerfil;
    // End of variables declaration//GEN-END:variables
}
