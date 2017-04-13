
package GUI;

import himevico_gestion.Himevico_gestion;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VgestionTrabajadores extends javax.swing.JFrame {

    public VgestionTrabajadores() {
        initComponents();
        jBpermitirEditarTrab.setVisible(false);
    }
    
    public void formatoCrearTrabajador(){
        
        jTdni.setEditable(true);
        jTnombreT.setEditable(true);      
        jTape1T.setEditable(true);
        jTape2T.setEditable(true);
        jTcalle.setEditable(true);
        jTpiso.setEditable(true);
        jDatefn.setEnabled(true);
        jTportal.setEditable(true);
        jTmano.setEditable(true);
        jTtlfp.setEditable(true);
        jTtlfe.setEditable(true);
        jTsalario.setEditable(true);
        jCtipo.setEnabled(true);
        jCcentroDndTrab.setEnabled(true);
        jTdni.grabFocus();
        
        jBaceptar.setEnabled(true);
        jBborrarTrab.setEnabled(false);
        jBmodificarTrab.setEnabled(false);
        jBpermitirEditarTrab.setVisible(false);
    }
    
    public void formatoBorrarTrabajador(){
       
        jTdni.setEditable(true);
        jTnombreT.setEditable(false);      
        jTape1T.setEditable(false);
        jTape2T.setEditable(false);
        jTcalle.setEditable(false);
        jTpiso.setEditable(false);
        jDatefn.setEnabled(false);
        jTportal.setEditable(false);
        jTmano.setEditable(false);
        jTtlfp.setEditable(false);
        jTtlfe.setEditable(false);
        jTsalario.setEditable(false);
        jCtipo.setEnabled(false);
        jCcentroDndTrab.setEnabled(false);
        jTdni.grabFocus();
        
        jBaceptar.setEnabled(false);
        jBborrarTrab.setEnabled(true);
        jBmodificarTrab.setEnabled(false);
        jBpermitirEditarTrab.setVisible(false);
        

    }
    
    public void formatoModificarTrabajador(){
        
        
        jTdni.setEditable(true);
        jTnombreT.setEditable(false);      
        jTape1T.setEditable(false);
        jTape2T.setEditable(false);
        jTcalle.setEditable(false);
        jTpiso.setEditable(false);
        jDatefn.setEnabled(false);
        jTportal.setEditable(false);
        jTmano.setEditable(false);
        jTtlfp.setEditable(false);
        jTtlfe.setEditable(false);
        jTsalario.setEditable(false);
        jCtipo.setEnabled(false);
        jCcentroDndTrab.setEnabled(false);
        jTdni.grabFocus();
        
        jBaceptar.setEnabled(false);
        jBborrarTrab.setEnabled(false);
        jBmodificarTrab.setEnabled(true);
        jBpermitirEditarTrab.setVisible(true);
        
    }
    
    public void permitirEditarTrabajador(){
        
        jTdni.setEditable(true);
        jTnombreT.setEditable(true);      
        jTape1T.setEditable(true);
        jTape2T.setEditable(true);
        jTcalle.setEditable(true);
        jTpiso.setEditable(true);
        jDatefn.setEnabled(true);
        jTportal.setEditable(true);
        jTmano.setEditable(true);
        jTtlfp.setEditable(true);
        jTtlfe.setEditable(true);
        jTsalario.setEditable(true);
        jCtipo.setEnabled(true);
        jCcentroDndTrab.setEnabled(true);
        
        jBaceptar.setEnabled(false);
        jBborrarTrab.setEnabled(false);
        jBmodificarTrab.setEnabled(true);
        jBpermitirEditarTrab.setVisible(true);
          
    }
    
    public void rellenarCamposTrabajador(String dni, String nom, String ap1, String ap2, String calle, String portal, String piso, String mano,String tlPers, String tlEmpre, String sala, Date fnac){
        
        jTdni.setText(dni);
        jTnombreT.setText(nom);    
        jTape1T.setText(ap1);
        jTape2T.setText(ap2);
        jTcalle.setText(calle);
        jTpiso.setText(piso);;
        jDatefn.setDate(fnac);
        jTportal.setText(portal);
        jTmano.setText(mano);
        jTtlfp.setText(tlPers);
        jTtlfe.setText(tlEmpre);
        jTsalario.setText(sala);
        //falta indicar tipo y el centro en los combos, le dare una vuelta
        

    }
    
    public void resetearCampos(){
        
        jTdni.setText("");
        jTnombreT.setText("");      
        jTape1T.setText("");
        jTape2T.setText("");
        jTcalle.setText("");
        jTpiso.setText("");
        jDatefn.setEnabled(false);
        jTportal.setText("");
        jTmano.setText("");
        jTtlfp.setText("");
        jTtlfe.setText("");
        jTsalario.setText("");
        jCtipo.setEditable(false);
        jCcentroDndTrab.setEditable(false);
        
  
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTportal = new javax.swing.JTextField();
        jTpiso = new javax.swing.JTextField();
        jTcalle = new javax.swing.JTextField();
        jTmano = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTtlfp = new javax.swing.JTextField();
        jTtlfe = new javax.swing.JTextField();
        jTdni = new javax.swing.JTextField();
        jTnombreT = new javax.swing.JTextField();
        jTape1T = new javax.swing.JTextField();
        jTape2T = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTsalario = new javax.swing.JTextField();
        jCtipo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCcentroDndTrab = new javax.swing.JComboBox<>();
        jDatefn = new com.toedter.calendar.JDateChooser();
        jBaceptar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jBborrarTrab = new javax.swing.JButton();
        jBmodificarTrab = new javax.swing.JButton();
        jBpermitirEditarTrab = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        jButton1.setText("AÑADIR");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("BORRAR");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("MODIFICAR");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel3.setText("DNI");

        jLabel4.setText("NOMBRE");

        jLabel5.setText("PRIMER APELLIDO");

        jLabel6.setText("SEGUNDO APELLIDO");

        jLabel7.setText("FECHA NACIMIENTO");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion"));

        jLabel8.setText("CALLE");

        jLabel9.setText("PISO");

        jLabel10.setText("PORTAL");

        jLabel11.setText("MANO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTpiso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTcalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTmano, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jTportal))
                .addGap(51, 51, 51))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jTportal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jTpiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTmano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contacto"));

        jLabel1.setText("TELEFONO PERSONAL");

        jLabel2.setText("TELEFONO EMPRESA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTtlfp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtlfe, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTtlfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTtlfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTdniKeyPressed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Otros Datos"));

        jLabel12.setText("SALARIO");

        jCtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOGISTICA", "ADMINISTRACION" }));

        jLabel14.setText("TIPO");

        jLabel15.setText("CENTRO ACTUAL");

        jCcentroDndTrab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCcentroDndTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jCtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jCcentroDndTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 86, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTnombreT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTdni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTape1T, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTape2T, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDatefn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTnombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTape1T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTape2T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDatefn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jBaceptar.setText("ACEPTAR");
        jBaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setText("FICHA TRABAJADOR");

        jBborrarTrab.setText("BORRAR");
        jBborrarTrab.setEnabled(false);
        jBborrarTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarTrabActionPerformed(evt);
            }
        });

        jBmodificarTrab.setText("MODIFICAR");
        jBmodificarTrab.setEnabled(false);
        jBmodificarTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarTrabActionPerformed(evt);
            }
        });

        jBpermitirEditarTrab.setText("PERMITIR EDITAR");
        jBpermitirEditarTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpermitirEditarTrabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jBaceptar)
                        .addGap(83, 83, 83)
                        .addComponent(jBborrarTrab)
                        .addGap(89, 89, 89)
                        .addComponent(jBmodificarTrab)
                        .addGap(57, 57, 57)
                        .addComponent(jBpermitirEditarTrab)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBaceptar)
                    .addComponent(jBborrarTrab)
                    .addComponent(jBpermitirEditarTrab)
                    .addComponent(jBmodificarTrab))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 890, 880));

        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/business.jpg"))); // NOI18N
        getContentPane().add(jLfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarActionPerformed
        
            // BOTON DE ACEPTAR:
            
        boolean ok=false;    
        try {
            
            ok=Himevico_gestion.registrartrabajador(jTdni.getText(),jTnombreT.getText(),jTape1T.getText(),jTape2T.getText(),jTcalle.getText(),jTpiso.getText()
                    ,jTportal.getText(),jTmano.getText(),jTtlfp.getText(),jTtlfe.getText(),jTsalario.getText(),jDatefn.getDate(),
                    jCtipo.getSelectedItem().toString(),jCcentroDndTrab.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(VgestionTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ok==true){
            
            JOptionPane.showMessageDialog(this,"SE HA REGISTRADO CORRECTAMENTE EN LA BASE DE DATOS");   
        }
        
    }//GEN-LAST:event_jBaceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTON AÑADIR TRABAJADOR DEL MENU :
        formatoCrearTrabajador();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTON BORRAR DEL MENU:
        formatoBorrarTrabajador();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // BOTON MODIFICAR DEL MENU:
        formatoModificarTrabajador();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBpermitirEditarTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpermitirEditarTrabActionPerformed
        // BOTON PARA PERMITIR EDITAR CAMPOS:
        permitirEditarTrabajador();
    }//GEN-LAST:event_jBpermitirEditarTrabActionPerformed

    private void jBborrarTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarTrabActionPerformed
        
        // BOTON DE BORRAR:

        String resp=JOptionPane.showInputDialog("ESTAS SEGURO QUE DESEAS ELIMINARLO DE LA BASE DE DATOS(SI/NO)");
        
        
        if(resp.equalsIgnoreCase("si")){
            
             try {
 
                    Himevico_gestion.borrarTrabajadorDelaBD(jTdni.getText());
             } catch (SQLException ex) {
                    Logger.getLogger(VgestionTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        
 
    }//GEN-LAST:event_jBborrarTrabActionPerformed

    private void jBmodificarTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarTrabActionPerformed
       
        // BOTON DE MODIFICAR:
            
         boolean ok=false;
        
        try {
            
         
            ok=Himevico_gestion.modificarDatosTrabajador(jTdni.getText(),jTnombreT.getText(),jTape1T.getText(),jTape2T.getText(),jTcalle.getText(),jTpiso.getText()
                    ,jTportal.getText(),jTmano.getText(),jTtlfp.getText(),jTtlfe.getText(),jTsalario.getText(),jDatefn.getDate(),
                    jCtipo.getSelectedItem().toString(),jCcentroDndTrab.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(VgestionTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ok==true){
            
            JOptionPane.showMessageDialog(this, "SA HA ACTUALIZADO CORRECTAMENTE LOS DATOS DEL TRABAJADOR");
            resetearCampos();
            formatoModificarTrabajador();
            
        }
        
        
    }//GEN-LAST:event_jBmodificarTrabActionPerformed

    private void jTdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdniKeyPressed
        // EVENTO KESSPREY:
          try {
            // FOCUS LOST DEL DNI:
            Himevico_gestion.buscarTrabajadorEnBD(jTdni.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VgestionTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTdniKeyPressed

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
            java.util.logging.Logger.getLogger(VgestionTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VgestionTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VgestionTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VgestionTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VgestionTrabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBaceptar;
    private javax.swing.JButton jBborrarTrab;
    private javax.swing.JButton jBmodificarTrab;
    private javax.swing.JButton jBpermitirEditarTrab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCcentroDndTrab;
    private javax.swing.JComboBox<String> jCtipo;
    private com.toedter.calendar.JDateChooser jDatefn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTape1T;
    private javax.swing.JTextField jTape2T;
    private javax.swing.JTextField jTcalle;
    private javax.swing.JTextField jTdni;
    private javax.swing.JTextField jTmano;
    private javax.swing.JTextField jTnombreT;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTpiso;
    private javax.swing.JTextField jTportal;
    private javax.swing.JTextField jTsalario;
    private javax.swing.JTextField jTtlfe;
    private javax.swing.JTextField jTtlfp;
    // End of variables declaration//GEN-END:variables
}
