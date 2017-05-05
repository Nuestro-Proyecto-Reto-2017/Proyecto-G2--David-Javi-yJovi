/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasAdmin;

import ModeloUML.Usuario;
import g2vjovi.G2vJovi;


public class ModificarUsuario extends  javax.swing.JDialog{
private G2vJovi main = new G2vJovi();
    /**
     * Creates new form pu
     */
    public ModificarUsuario(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
         Usuario u =new Usuario();
        
        
        
     String  dni=  javax.swing.JOptionPane.showInputDialog(null, "dni (esto se supone que hay que quitarlo cuando implementemos la ventan de login)");
     
     
     try{
     u=g2vjovi.G2vJovi.buscarUsuario(dni);
     
     if(u.getUsuario().isEmpty()||u.getPassword().isEmpty()){
      javax.swing.JOptionPane.showMessageDialog(null,"no hay datos de esta cuenta");//esto lo pongo para tener controlado si hay usuario o no aunque esto deberia ir en el login
      bcancelar.doClick();
     }
     
     tfusername.setText(u.getUsuario());
     tfpassw.setText(u.getPassword());
     }catch(java.sql.SQLException x){
          javax.swing.JOptionPane.showMessageDialog(null,"error relacionado con la base de datos "+x.getMessage());
     }
     catch(java.lang.NullPointerException j){
          javax.swing.JOptionPane.showMessageDialog(null,"no se han encontrado datos ");
          bcancelar.doClick();
     }
     catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null,"error desconocido: "+e);
     }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bcancelar = new javax.swing.JButton();
        tfusername = new javax.swing.JTextField();
        tfpassw = new javax.swing.JTextField();
        baceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Perfil");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user.png"))); // NOI18N

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        bcancelar.setText("Cancelar");
        bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelarActionPerformed(evt);
            }
        });

        baceptar.setText("Aceptr");
        baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfpassw, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bcancelar)
                                .addGap(18, 18, 18)
                                .addComponent(baceptar)
                                .addGap(18, 18, 18)))))
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfpassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(baceptar)
                            .addComponent(bcancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelarActionPerformed
        G2vJovi.cerrarventanaUsuario();
    }//GEN-LAST:event_bcancelarActionPerformed

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        String usuario=tfusername.getText();
        String contraseña= tfpassw.getText();
        if(usuario.isEmpty() || contraseña.isEmpty() ){
            javax.swing.JOptionPane.showMessageDialog(null,"todos los campos son obligatorios");
        }
        else{
            try{
                int x =g2vjovi.G2vJovi.generarUsuario(usuario, contraseña);

                if(x>=2){
                    x=2;
                }

                switch(x){
                    case 1: javax.swing.JOptionPane.showMessageDialog(null,"se ha actualizado el perfil correctamente");
                    break;
                    case 0:javax.swing.JOptionPane.showMessageDialog(null,"no se ha podido actualizar ningún perfil de usuario");
                    break;
                    case 2:javax.swing.JOptionPane.showMessageDialog(null,"ERROR: Se ha modificado mas de una fila");//en ningun caso deberia meterse por esta rama pero la meto por si acaso
                }

            }catch(java.sql.SQLIntegrityConstraintViolationException r){
                javax.swing.JOptionPane.showMessageDialog(null,"el usuario ya existe");
            }
            catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null,"error en la actualizacion del usuario "+ e);
            }
        }

    }//GEN-LAST:event_baceptarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarUsuario dialog = new ModificarUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfpassw;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
