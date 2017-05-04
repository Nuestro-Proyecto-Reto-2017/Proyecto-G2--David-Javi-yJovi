/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanasAdmin;


import ModeloUML.*;
import g2vjovi.*;
import java.util.ArrayList;

/**
 *
 * @author Jovi
 */
public class ValidarPartes extends javax.swing.JDialog {
    private G2vJovi main = new G2vJovi();
    private ArrayList <Parte> listaPartes;

    public ValidarPartes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public ValidarPartes(java.awt.Frame parent, boolean modal,int filasMin,int filasMax) {
        super(parent, modal);
        initComponents();
        rellenarTabla(filasMin,filasMax);
    }
    private void rellenarTabla(int filasMin,int filasMax){
        
       listaPartes= main.procConsultarPartesJoin(filasMin,filasMax);
       for(int x =0;x<listaPartes.size();x++){
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getLogistica().getDni(), x, 0); 
          tTablaParte.getModel().setValueAt("KM Inicio: "+listaPartes.get(x).getKmInicio()+" KM Fin: "+listaPartes.get(x).getKmFinal(), x, 1); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getTipoParte(), x, 2); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getVehiculoDelParte().getMatricula(), x, 3); 
          tTablaParte.getModel().setValueAt("Aqui va un boton para ver las salidas", x, 4); 
          tTablaParte.getModel().setValueAt("Gasto Gasoil: " +listaPartes.get(x).getGastoDelParte().getGastoGasoil()+"\nGasto Peajes: "+listaPartes.get(x).getGastoDelParte().getGastoPeaje()+"\nGasto Dietas: "+listaPartes.get(x).getGastoDelParte().getGastoDietas()+"\nOtros Gastos: "+listaPartes.get(x).getGastoDelParte().getOtrosGastos(), x, 5); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getAvisosDelParte().getDescripcion(), x, 6);
          tTablaParte.getModel().setValueAt("Boton validar aqui", x, 7);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTablaParte = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        tTablaParte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Datos Parte", "Estado", "Vehiculo", "Salidas", "Gastos", "Aviso", ""
            }
        ));
        jScrollPane1.setViewportView(tTablaParte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 676, 219));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ValidarPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidarPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidarPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidarPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ValidarPartes dialog = new ValidarPartes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTablaParte;
    // End of variables declaration//GEN-END:variables
}
