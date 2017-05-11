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
    private ArrayList <Salida> listaSalidas;
    private String cadenaSalida="";
    public ValidarPartes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public ValidarPartes(java.awt.Frame parent, boolean modal,int filasMin,int filasMax) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        rellenarTabla(filasMin,filasMax);
        if(filasMin<=0){
            bPrevious.setEnabled(false);
        }
        if(listaPartes.size()<filasMax){
            bNext.setEnabled(false);
        }
    }
    /**
     * rellenar la tabla con los partes 
     */
    private void rellenarTabla(int filasMin,int filasMax){
        
       listaPartes= main.procConsultarPartesJoin(filasMin,filasMax);
       if(listaPartes.isEmpty()){
           javax.swing.JOptionPane.showMessageDialog(null, "No se han encontrado partes en la Base de Datos.");
           G2vJovi.cerrarVentanaValidarPartes();
       }
       for(int x =0;x<listaPartes.size();x++){
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getLogistica().getDni(), x, 0); 
          tTablaParte.getModel().setValueAt("KM Inicio: "+listaPartes.get(x).getKmInicio()+" KM Fin: "+listaPartes.get(x).getKmFinal(), x, 1); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getTipoParte(), x, 2); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getVehiculoDelParte().getMatricula(), x, 3); 
          tTablaParte.getModel().setValueAt("Gasto Gasoil: " +listaPartes.get(x).getGastoDelParte().getGastoGasoil()+"\nGasto Peajes: "+listaPartes.get(x).getGastoDelParte().getGastoPeaje()+"\nGasto Dietas: "+listaPartes.get(x).getGastoDelParte().getGastoDietas()+"\nOtros Gastos: "+listaPartes.get(x).getGastoDelParte().getOtrosGastos(), x, 5); 
          tTablaParte.getModel().setValueAt(listaPartes.get(x).getAvisoDelParte().getDescripcion(), x, 6);
       }
       disableBotones();
       disableBotonSalidas();
    }
    /**
     * deshabilita la opcion de salidas
     */
    private void disableBotonSalidas(){
        if(listaPartes.size()>0){
            bVerSalidas0.setEnabled(true);
        }
        if(listaPartes.size()>1){
            bVerSalidas1.setEnabled(true);
        }
        if(listaPartes.size()>2){
            bVerSalidas2.setEnabled(true);
        }
        if(listaPartes.size()>3){
            bVerSalidas3.setEnabled(true);
        }
        if(listaPartes.size()>4){
            bVerSalidas4.setEnabled(true);
        }
        if(listaPartes.size()>4){
            bVerSalidas4.setEnabled(true);
        }
        if(listaPartes.size()>5){
            bVerSalidas5.setEnabled(true);
        }
        if(listaPartes.size()>6){
            bVerSalidas6.setEnabled(true);
        }
        if(listaPartes.size()>7){
            bVerSalidas7.setEnabled(true);
        }
        if(listaPartes.size()>8){
            bVerSalidas8.setEnabled(true);
        }
        if(listaPartes.size()>9){
            bVerSalidas9.setEnabled(true);
        }
    }
    /**
     * deshabilitar los botones
     */
    private void disableBotones(){
        
        if(listaPartes.size()>0){
            if(listaPartes.get(0).getTipoParte().compareToIgnoreCase("C")==0 ){
                bModificar0.setEnabled(false);
                bEliminar0.setEnabled(true);
                bValidar0.setEnabled(true);
            }
            if(listaPartes.size()>1){
                if(listaPartes.get(1).getTipoParte().compareToIgnoreCase("C")==0){
                    bModificar1.setEnabled(false);
                    bEliminar1.setEnabled(true);
                    bValidar1.setEnabled(true);
                    }
                if(listaPartes.size()>2){
                    if(listaPartes.get(2).getTipoParte().compareToIgnoreCase("C")==0){
                        bModificar2.setEnabled(false);
                        bEliminar2.setEnabled(true);
                        bValidar2.setEnabled(true);
                    }
                    if(listaPartes.size()>3){
                        if(listaPartes.get(3).getTipoParte().compareToIgnoreCase("C")==0){
                            bModificar3.setEnabled(false);
                            bEliminar3.setEnabled(true);
                            bValidar3.setEnabled(true);
                        }
                        if(listaPartes.size()>4){
                            if(listaPartes.get(4).getTipoParte().compareToIgnoreCase("C")==0){
                                bModificar4.setEnabled(false);
                                bEliminar4.setEnabled(true);
                                bValidar4.setEnabled(true);
                            }
                            if(listaPartes.size()>5){
                                if(listaPartes.get(5).getTipoParte().compareToIgnoreCase("C")==0){
                                    bModificar5.setEnabled(false);
                                    bEliminar5.setEnabled(true);
                                    bValidar5.setEnabled(true);
                                }
                                if(listaPartes.size()>6){
                                    if(listaPartes.get(6).getTipoParte().compareToIgnoreCase("C")==0){
                                        bModificar6.setEnabled(false);
                                        bEliminar6.setEnabled(true);
                                        bValidar6.setEnabled(true);
                                    }
                                    if(listaPartes.size()>7){
                                        if(listaPartes.get(7).getTipoParte().compareToIgnoreCase("C")==0){
                                            bModificar7.setEnabled(false);
                                            bEliminar7.setEnabled(true);
                                            bValidar7.setEnabled(true);
                                        }
                                        if(listaPartes.size()>8){
                                            if(listaPartes.get(8).getTipoParte().compareToIgnoreCase("C")==0){
                                                bModificar8.setEnabled(false);
                                                bEliminar8.setEnabled(true);
                                                bValidar8.setEnabled(true);
                                            }
                                            if(listaPartes.size()>9){
                                                if(listaPartes.get(9).getTipoParte().compareToIgnoreCase("C")==0){
                                                    bModificar9.setEnabled(false);
                                                    bEliminar9.setEnabled(true);
                                                    bValidar9.setEnabled(true);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
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

        bValidar7 = new javax.swing.JButton();
        bValidar0 = new javax.swing.JButton();
        bValidar1 = new javax.swing.JButton();
        bValidar2 = new javax.swing.JButton();
        bValidar3 = new javax.swing.JButton();
        bValidar4 = new javax.swing.JButton();
        bValidar5 = new javax.swing.JButton();
        bValidar6 = new javax.swing.JButton();
        bValidar8 = new javax.swing.JButton();
        bValidar9 = new javax.swing.JButton();
        bNext = new javax.swing.JButton();
        bPrevious = new javax.swing.JButton();
        bModificar0 = new javax.swing.JButton();
        bModificar1 = new javax.swing.JButton();
        bModificar2 = new javax.swing.JButton();
        bModificar3 = new javax.swing.JButton();
        bModificar4 = new javax.swing.JButton();
        bModificar5 = new javax.swing.JButton();
        bModificar6 = new javax.swing.JButton();
        bModificar7 = new javax.swing.JButton();
        bModificar8 = new javax.swing.JButton();
        bModificar9 = new javax.swing.JButton();
        bEliminar0 = new javax.swing.JButton();
        bEliminar1 = new javax.swing.JButton();
        bEliminar2 = new javax.swing.JButton();
        bEliminar3 = new javax.swing.JButton();
        bEliminar4 = new javax.swing.JButton();
        bEliminar5 = new javax.swing.JButton();
        bEliminar6 = new javax.swing.JButton();
        bEliminar7 = new javax.swing.JButton();
        bEliminar8 = new javax.swing.JButton();
        bEliminar9 = new javax.swing.JButton();
        bVerSalidas0 = new javax.swing.JButton();
        bVerSalidas1 = new javax.swing.JButton();
        bVerSalidas2 = new javax.swing.JButton();
        bVerSalidas3 = new javax.swing.JButton();
        bVerSalidas4 = new javax.swing.JButton();
        bVerSalidas5 = new javax.swing.JButton();
        bVerSalidas6 = new javax.swing.JButton();
        bVerSalidas7 = new javax.swing.JButton();
        bVerSalidas8 = new javax.swing.JButton();
        bVerSalidas9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTablaParte = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bValidar7.setBackground(new java.awt.Color(255, 255, 255));
        bValidar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar7.setEnabled(false);
        bValidar7.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar7.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar7.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar7.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar7ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 168, 20, 20));

        bValidar0.setBackground(new java.awt.Color(255, 255, 255));
        bValidar0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar0.setEnabled(false);
        bValidar0.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar0.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar0.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar0.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar0ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar0, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 21, 20, 20));

        bValidar1.setBackground(new java.awt.Color(255, 255, 255));
        bValidar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar1.setEnabled(false);
        bValidar1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar1.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar1.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar1.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar1ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 42, 20, 20));

        bValidar2.setBackground(new java.awt.Color(255, 255, 255));
        bValidar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar2.setEnabled(false);
        bValidar2.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar2.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar2.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar2.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar2ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 63, 20, 20));

        bValidar3.setBackground(new java.awt.Color(255, 255, 255));
        bValidar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar3.setEnabled(false);
        bValidar3.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar3.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar3.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar3.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar3ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 84, 20, 20));

        bValidar4.setBackground(new java.awt.Color(255, 255, 255));
        bValidar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar4.setEnabled(false);
        bValidar4.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar4.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar4.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar4.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar4ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 105, 20, 20));

        bValidar5.setBackground(new java.awt.Color(255, 255, 255));
        bValidar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar5.setEnabled(false);
        bValidar5.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar5.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar5.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar5.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar5ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 126, 20, 20));

        bValidar6.setBackground(new java.awt.Color(255, 255, 255));
        bValidar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar6.setEnabled(false);
        bValidar6.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar6.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar6.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar6.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar6ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 147, 20, 20));

        bValidar8.setBackground(new java.awt.Color(255, 255, 255));
        bValidar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar8.setEnabled(false);
        bValidar8.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar8.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar8.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar8.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar8ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 189, 20, 20));

        bValidar9.setBackground(new java.awt.Color(255, 255, 255));
        bValidar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/checkmark-16.png"))); // NOI18N
        bValidar9.setEnabled(false);
        bValidar9.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bValidar9.setMaximumSize(new java.awt.Dimension(40, 22));
        bValidar9.setMinimumSize(new java.awt.Dimension(40, 22));
        bValidar9.setPreferredSize(new java.awt.Dimension(40, 22));
        bValidar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidar9ActionPerformed(evt);
            }
        });
        getContentPane().add(bValidar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 20, 20));

        bNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arrow_right.png"))); // NOI18N
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });
        getContentPane().add(bNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 20, 20));

        bPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arrow_left.png"))); // NOI18N
        bPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(bPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 20, 20));

        bModificar0.setBackground(new java.awt.Color(255, 255, 255));
        bModificar0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar0.setEnabled(false);
        bModificar0.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar0.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar0.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar0.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar0ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar0, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 21, 20, 20));

        bModificar1.setBackground(new java.awt.Color(255, 255, 255));
        bModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar1.setEnabled(false);
        bModificar1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar1.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar1.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar1.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar1ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 42, 20, 20));

        bModificar2.setBackground(new java.awt.Color(255, 255, 255));
        bModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar2.setEnabled(false);
        bModificar2.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar2.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar2.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar2.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar2ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 63, 20, 20));

        bModificar3.setBackground(new java.awt.Color(255, 255, 255));
        bModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar3.setEnabled(false);
        bModificar3.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar3.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar3.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar3.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar3ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 84, 20, 20));

        bModificar4.setBackground(new java.awt.Color(255, 255, 255));
        bModificar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar4.setEnabled(false);
        bModificar4.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar4.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar4.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar4.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar4ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 105, 20, 20));

        bModificar5.setBackground(new java.awt.Color(255, 255, 255));
        bModificar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar5.setEnabled(false);
        bModificar5.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar5.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar5.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar5.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar5ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 126, 20, 20));

        bModificar6.setBackground(new java.awt.Color(255, 255, 255));
        bModificar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar6.setEnabled(false);
        bModificar6.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar6.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar6.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar6.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar6ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 147, 20, 20));

        bModificar7.setBackground(new java.awt.Color(255, 255, 255));
        bModificar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar7.setEnabled(false);
        bModificar7.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar7.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar7.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar7.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar7ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 168, 20, 20));

        bModificar8.setBackground(new java.awt.Color(255, 255, 255));
        bModificar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar8.setEnabled(false);
        bModificar8.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar8.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar8.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar8.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar8ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 189, 20, 20));

        bModificar9.setBackground(new java.awt.Color(255, 255, 255));
        bModificar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modifyIcon.png"))); // NOI18N
        bModificar9.setEnabled(false);
        bModificar9.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bModificar9.setMaximumSize(new java.awt.Dimension(40, 22));
        bModificar9.setMinimumSize(new java.awt.Dimension(40, 22));
        bModificar9.setPreferredSize(new java.awt.Dimension(40, 22));
        bModificar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificar9ActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 210, 20, 20));

        bEliminar0.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar0.setEnabled(false);
        bEliminar0.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar0.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar0.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar0.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar0ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar0, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 21, 20, 20));

        bEliminar1.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar1.setEnabled(false);
        bEliminar1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar1.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar1.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar1.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 42, 20, 20));

        bEliminar2.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar2.setEnabled(false);
        bEliminar2.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar2.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar2.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar2.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar2ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 63, 20, 20));

        bEliminar3.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar3.setEnabled(false);
        bEliminar3.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar3.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar3.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar3.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar3ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 84, 20, 20));

        bEliminar4.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar4.setEnabled(false);
        bEliminar4.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar4.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar4.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar4.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar4ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 105, 20, 20));

        bEliminar5.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar5.setEnabled(false);
        bEliminar5.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar5.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar5.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar5.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar5ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 126, 20, 20));

        bEliminar6.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar6.setEnabled(false);
        bEliminar6.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar6.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar6.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar6.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar6ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 147, 20, 20));

        bEliminar7.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar7.setEnabled(false);
        bEliminar7.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar7.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar7.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar7.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar7ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 168, 20, 20));

        bEliminar8.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar8.setEnabled(false);
        bEliminar8.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar8.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar8.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar8.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar8ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 189, 20, 20));

        bEliminar9.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteIcon.png"))); // NOI18N
        bEliminar9.setEnabled(false);
        bEliminar9.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bEliminar9.setMaximumSize(new java.awt.Dimension(40, 22));
        bEliminar9.setMinimumSize(new java.awt.Dimension(40, 22));
        bEliminar9.setPreferredSize(new java.awt.Dimension(40, 22));
        bEliminar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar9ActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 20, 20));

        bVerSalidas0.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas0.setEnabled(false);
        bVerSalidas0.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas0.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas0.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas0.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas0ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas0, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 21, 20, 20));

        bVerSalidas1.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas1.setEnabled(false);
        bVerSalidas1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas1.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas1.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas1.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas1ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 42, 20, 20));

        bVerSalidas2.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas2.setEnabled(false);
        bVerSalidas2.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas2.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas2.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas2.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas2ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 63, 20, 20));

        bVerSalidas3.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas3.setEnabled(false);
        bVerSalidas3.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas3.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas3.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas3.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas3ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 84, 20, 20));

        bVerSalidas4.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas4.setEnabled(false);
        bVerSalidas4.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas4.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas4.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas4.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas4ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 105, 20, 20));

        bVerSalidas5.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas5.setEnabled(false);
        bVerSalidas5.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas5.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas5.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas5.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas5ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 126, 20, 20));

        bVerSalidas6.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas6.setEnabled(false);
        bVerSalidas6.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas6.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas6.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas6.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas6ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 147, 20, 20));

        bVerSalidas7.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas7.setEnabled(false);
        bVerSalidas7.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas7.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas7.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas7.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas7ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 168, 20, 20));

        bVerSalidas8.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas8.setEnabled(false);
        bVerSalidas8.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas8.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas8.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas8.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas8ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 189, 20, 20));

        bVerSalidas9.setBackground(new java.awt.Color(255, 255, 255));
        bVerSalidas9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/eye.png"))); // NOI18N
        bVerSalidas9.setEnabled(false);
        bVerSalidas9.setMargin(new java.awt.Insets(1, 10, 1, 10));
        bVerSalidas9.setMaximumSize(new java.awt.Dimension(40, 22));
        bVerSalidas9.setMinimumSize(new java.awt.Dimension(40, 22));
        bVerSalidas9.setPreferredSize(new java.awt.Dimension(40, 22));
        bVerSalidas9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerSalidas9ActionPerformed(evt);
            }
        });
        getContentPane().add(bVerSalidas9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 20, 20));

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
        tTablaParte.setRowHeight(21);
        jScrollPane1.setViewportView(tTablaParte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bValidar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar7ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(7).getID());
    }//GEN-LAST:event_bValidar7ActionPerformed

    private void bValidar0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar0ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(0).getID());
    }//GEN-LAST:event_bValidar0ActionPerformed

    private void bValidar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar1ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(1).getID());
    }//GEN-LAST:event_bValidar1ActionPerformed

    private void bValidar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar2ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(2).getID());
    }//GEN-LAST:event_bValidar2ActionPerformed

    private void bValidar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar3ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(3).getID());
    }//GEN-LAST:event_bValidar3ActionPerformed

    private void bValidar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar4ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(4).getID());
    }//GEN-LAST:event_bValidar4ActionPerformed

    private void bValidar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar5ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(5).getID());
    }//GEN-LAST:event_bValidar5ActionPerformed

    private void bValidar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar6ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(6).getID());
    }//GEN-LAST:event_bValidar6ActionPerformed

    private void bValidar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar8ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(8).getID());
    }//GEN-LAST:event_bValidar8ActionPerformed

    private void bValidar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidar9ActionPerformed
        main.procUpdateParteRevisado(listaPartes.get(9).getID());
    }//GEN-LAST:event_bValidar9ActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        G2vJovi.abrirVentanaValidarPartesSiguiente();
    }//GEN-LAST:event_bNextActionPerformed

    private void bPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviousActionPerformed
        G2vJovi.abrirVentanaValidarPartesAnterior();
    }//GEN-LAST:event_bPreviousActionPerformed

    private void bModificar0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar0ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(0).getID());
        listaPartes.get(0).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(0));
    }//GEN-LAST:event_bModificar0ActionPerformed

    private void bModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar1ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(1).getID());
        listaPartes.get(1).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(1));
    }//GEN-LAST:event_bModificar1ActionPerformed

    private void bModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar2ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(2).getID());
        listaPartes.get(2).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(2));
    }//GEN-LAST:event_bModificar2ActionPerformed

    private void bModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar3ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(3).getID());
        listaPartes.get(3).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(3));
    }//GEN-LAST:event_bModificar3ActionPerformed

    private void bModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar4ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(4).getID());
        listaPartes.get(4).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(4));
    }//GEN-LAST:event_bModificar4ActionPerformed

    private void bModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar5ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(5).getID());
        listaPartes.get(5).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(5));
    }//GEN-LAST:event_bModificar5ActionPerformed

    private void bModificar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar6ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(6).getID());
        listaPartes.get(6).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(6));
    }//GEN-LAST:event_bModificar6ActionPerformed

    private void bModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar7ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(7).getID());
        listaPartes.get(7).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(7));
    }//GEN-LAST:event_bModificar7ActionPerformed

    private void bModificar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar8ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(8).getID());
        listaPartes.get(8).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(8));
    }//GEN-LAST:event_bModificar8ActionPerformed

    private void bModificar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificar9ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(9).getID());
        listaPartes.get(9).setSalidasDelParte(listaSalidas);
        main.abrirVentanaModificarParte(listaPartes.get(9));
    }//GEN-LAST:event_bModificar9ActionPerformed

    private void bEliminar0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar0ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(0).getID());
    }//GEN-LAST:event_bEliminar0ActionPerformed

    private void bEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar1ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(1).getID());
    }//GEN-LAST:event_bEliminar1ActionPerformed

    private void bEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar2ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(2).getID());
    }//GEN-LAST:event_bEliminar2ActionPerformed

    private void bEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar3ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(3).getID());
    }//GEN-LAST:event_bEliminar3ActionPerformed

    private void bEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar4ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(4).getID());
    }//GEN-LAST:event_bEliminar4ActionPerformed

    private void bEliminar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar5ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(5).getID());
    }//GEN-LAST:event_bEliminar5ActionPerformed

    private void bEliminar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar6ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(6).getID());
    }//GEN-LAST:event_bEliminar6ActionPerformed

    private void bEliminar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar7ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(7).getID());
    }//GEN-LAST:event_bEliminar7ActionPerformed

    private void bEliminar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar8ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(8).getID());
    }//GEN-LAST:event_bEliminar8ActionPerformed

    private void bEliminar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar9ActionPerformed
        main.procDeleteParteSinRevisar(listaPartes.get(9).getID());
    }//GEN-LAST:event_bEliminar9ActionPerformed
    private void sacarSalidasPantalla(){
        cadenaSalida="";
        for(int x=0;x<listaSalidas.size();x++){
            cadenaSalida+="Hora salida: "+listaSalidas.get(x).getHoraSalida()+"\nHora llegada: "+listaSalidas.get(x).getHoraLLegada()+"\nAlbaran: "+listaSalidas.get(x).getAlbaran()+"\n------------\n";
        }
        javax.swing.JOptionPane.showMessageDialog(null, cadenaSalida);
    }
    private void bVerSalidas0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas0ActionPerformed
        listaSalidas =main.procConsultarSalidasParte(listaPartes.get(0).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas0ActionPerformed

    private void bVerSalidas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas1ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(1).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas1ActionPerformed

    private void bVerSalidas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas2ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(2).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas2ActionPerformed

    private void bVerSalidas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas3ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(3).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas3ActionPerformed

    private void bVerSalidas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas4ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(4).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas4ActionPerformed

    private void bVerSalidas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas5ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(5).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas5ActionPerformed

    private void bVerSalidas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas6ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(6).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas6ActionPerformed

    private void bVerSalidas7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas7ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(7).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas7ActionPerformed

    private void bVerSalidas8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas8ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(8).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas8ActionPerformed

    private void bVerSalidas9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerSalidas9ActionPerformed
        listaSalidas=main.procConsultarSalidasParte(listaPartes.get(9).getID());
        sacarSalidasPantalla();
    }//GEN-LAST:event_bVerSalidas9ActionPerformed

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
    private javax.swing.JButton bEliminar0;
    private javax.swing.JButton bEliminar1;
    private javax.swing.JButton bEliminar2;
    private javax.swing.JButton bEliminar3;
    private javax.swing.JButton bEliminar4;
    private javax.swing.JButton bEliminar5;
    private javax.swing.JButton bEliminar6;
    private javax.swing.JButton bEliminar7;
    private javax.swing.JButton bEliminar8;
    private javax.swing.JButton bEliminar9;
    private javax.swing.JButton bModificar0;
    private javax.swing.JButton bModificar1;
    private javax.swing.JButton bModificar2;
    private javax.swing.JButton bModificar3;
    private javax.swing.JButton bModificar4;
    private javax.swing.JButton bModificar5;
    private javax.swing.JButton bModificar6;
    private javax.swing.JButton bModificar7;
    private javax.swing.JButton bModificar8;
    private javax.swing.JButton bModificar9;
    private javax.swing.JButton bNext;
    private javax.swing.JButton bPrevious;
    private javax.swing.JButton bValidar0;
    private javax.swing.JButton bValidar1;
    private javax.swing.JButton bValidar2;
    private javax.swing.JButton bValidar3;
    private javax.swing.JButton bValidar4;
    private javax.swing.JButton bValidar5;
    private javax.swing.JButton bValidar6;
    private javax.swing.JButton bValidar7;
    private javax.swing.JButton bValidar8;
    private javax.swing.JButton bValidar9;
    private javax.swing.JButton bVerSalidas0;
    private javax.swing.JButton bVerSalidas1;
    private javax.swing.JButton bVerSalidas2;
    private javax.swing.JButton bVerSalidas3;
    private javax.swing.JButton bVerSalidas4;
    private javax.swing.JButton bVerSalidas5;
    private javax.swing.JButton bVerSalidas6;
    private javax.swing.JButton bVerSalidas7;
    private javax.swing.JButton bVerSalidas8;
    private javax.swing.JButton bVerSalidas9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTablaParte;
    // End of variables declaration//GEN-END:variables
}
