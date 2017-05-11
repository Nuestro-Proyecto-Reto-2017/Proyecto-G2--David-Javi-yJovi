package VentanasAdmin;

import ModeloUML.*;
import g2vjovi.*;
import java.util.ArrayList;

/**
 *
 * @author Jovi
 */
public class BuscarCentroPK extends javax.swing.JDialog {
    private String tipoVentana;
    private G2vJovi main = new G2vJovi();
    /**
     * crea el form form para buscar el centro por PK
     */
    public BuscarCentroPK(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    public BuscarCentroPK(java.awt.Frame parent, boolean modal,String tipoVentana) {
        super(parent, modal);
        initComponents();
        this.tipoVentana=tipoVentana;
        setLocationRelativeTo(null);
    }

    /**
     * codigo autogenerado no borrar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNombreCentro = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Nombre centro:");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Centros.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Himevico2.png"))); // NOI18N

        bAyuda.setText("?");
        bAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bBuscar)
                                .addGap(32, 32, 32)
                                .addComponent(bSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(bAyuda)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAyuda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBuscar)
                    .addComponent(bSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        G2vJovi.cerrarAltaBajaModificacionCentro(tipoVentana);
    }//GEN-LAST:event_bSalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        G2vJovi.cerrarAltaBajaModificacionCentro(tipoVentana);
    }//GEN-LAST:event_formWindowClosed
/**
 * mostrara el panel de ayuda
 */
    private void bAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAyudaActionPerformed
        javax.swing.JOptionPane.showMessageDialog(null, "Si no conoces el nombre del centro quizas deberias consultarlo primero en el menu de busqueda");
    }//GEN-LAST:event_bAyudaActionPerformed
/**
 * boton para buscar
 */
    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        ArrayList <Centro> listaCentro=new ArrayList();
        listaCentro=main.ejecutarconsultasPkc(tfNombreCentro.getText().toUpperCase());
        switch(tipoVentana){
            case "altac":{
                
                if(listaCentro.size()>0&&listaCentro.get(0).getEncontrado()){
                    javax.swing.JOptionPane.showMessageDialog(null, "El nombre insertado ya esta en la Base de datos, asegurate de introducir bien el nombre del centro ");
                }
                else {
                    G2vJovi.disposeBuscarCentroPk(tipoVentana,listaCentro,tfNombreCentro.getText());
                }
                break;
            }
            case "modc":{
                if(listaCentro.size()>0&&listaCentro.get(0).getEncontrado()){
                    G2vJovi.disposeBuscarCentroPk(tipoVentana,listaCentro,tfNombreCentro.getText());
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(null, "El nombre insertado NO esta en la Base de datos, asegurate de introducir bien el nombre del centro ");
                }
                break;
            }
            case "bajac":{
                if(listaCentro.size()>0&&listaCentro.get(0).getEncontrado()){
                    main.ProcEliminarCentro(tfNombreCentro.getText().toUpperCase());
                    javax.swing.JOptionPane.showMessageDialog(null,"Ha sido eliminado con exito el centro con nombre: "+tfNombreCentro.getText() );
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(null, "El nombre insertado NO esta en la Base de datos, asegurate de introducir bien el nombre del centro ");
                }
                break;
            }
        }
    }//GEN-LAST:event_bBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarCentroPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCentroPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCentroPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCentroPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarCentroPK dialog = new BuscarCentroPK(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAyuda;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfNombreCentro;
    // End of variables declaration//GEN-END:variables
}
