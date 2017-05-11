package VentanasAdmin;

import ModeloUML.*;
import g2vjovi.G2vJovi;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class NuevoParte extends javax.swing.JDialog {

    private String tipo;
    private G2vJovi main = new G2vJovi();
    private ArrayList <Vehiculo> listaV;
    private Parte objetoP;
    
    
    /**
     * crear el form NuevoParte
     */
    public NuevoParte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public NuevoParte(java.awt.Frame parent, boolean modal,Parte p,ArrayList listaVe) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.listaV=listaVe;
        this.objetoP=p;
        for(int i=0;i<listaV.size();i++){
             jCBvehiculos.insertItemAt(listaV.get(i).getMatricula(), i);
        }
        rellenarVentana();
        jBmodificar.setVisible(true);
        jBcerrar.setVisible(false);
        jBaceptar.setVisible(false);
        jBpermitirEditar.setVisible(false);
        jPeliminarSalida.setVisible(false);
       
       
    }
    public NuevoParte(java.awt.Frame parent, boolean modal,ArrayList listaVe) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.listaV=listaVe;
        for(int i=0;i<listaV.size();i++){
             jCBvehiculos.insertItemAt(listaV.get(i).getMatricula(), i);
        }
        jBmodificar.setVisible(false);
        jBpermitirEditar.setVisible(false);
        jPeliminarSalida.setVisible(false);
       
       
    }/**
     * rellenar los campos
     */
    private void rellenarVentana(){
        for(int i=0;i<jCBvehiculos.getItemCount();i++){
             if(objetoP.getVehiculoDelParte().getMatricula().compareToIgnoreCase(jCBvehiculos.getItemAt(i))==0){
                 jCBvehiculos.setSelectedIndex(i);
             }
        }
        jTkini.setText(String.valueOf(objetoP.getKmInicio()));
        jTkfinal.setText(String.valueOf(objetoP.getKmFinal()));
        jTAincidencias.setText(objetoP.getIncidencias());
        jTggasoil.setText(String.valueOf(objetoP.getGastoDelParte().getGastoGasoil()));
        jTgdietas.setText(String.valueOf(objetoP.getGastoDelParte().getGastoDietas()));
        jTgpeajes.setText(String.valueOf(objetoP.getGastoDelParte().getGastoPeaje()));
        jTotros.setText(String.valueOf(objetoP.getGastoDelParte().getOtrosGastos()));
        G2vJovi.registrarSalidasVentanaModificar(objetoP);
        jBmostrar.setEnabled(true);

    }
    private void actualizarDatosParte(){
        
    }
    /**
     * limpiar los daots de la ventana
     */

    public void limpiarCamposDeSalidas(){
        
        jTalbaran.setText("");
        jFThsalida.setText("");
        jFThllegada.setText("");
        
        
    }
    /*public void rellenarComboBoxMatriculas(){
        try{
            ArrayList <String> matriculas = new ArrayList();
            matriculas=main.obtenerMatricukas();

            for(int i=0;i<matriculas.size();i++){

                 jCBsalidas.insertItemAt(matriculas.get(i), i);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }
        
        
    }*/
    public void rellenarComboBoxSalidas(Integer num){
        
        Integer cont =0;
        
        for(int i=0;i<num;i++){
             cont++;
             jCBsalidas.insertItemAt(cont.toString(), i);
        }

    }
    
    /**
     * ajusta la ventana para modificar
     */
    public void formatoVentanaModificar(){
        
        jCBvehiculos.setEditable(false);
        jTkini.setEditable(false);
        jTkfinal.setEditable(false);
        jTAincidencias.setEditable(false);
        jTggasoil.setEditable(false);
        jTgpeajes.setEditable(false);
        jTgdietas.setEditable(false);
        jTotros.setEditable(false);
        jTalbaran.setEditable(false);
        jFThsalida.setEditable(false);
        jFThllegada.setEditable(false);
        jBañadirSalidas.setEnabled(false);
        

    }
 
    
    public void crearParte(String tipo){
        G2vJovi.registarAviso();
        //Gasto gast=G2vJovi.registrarGastos(jTggasoil.getText(), jTgpeajes.getText(), jTgdietas.getText(), jTotros.getText());
        G2vJovi.registrarParte(Double.parseDouble(jTkini.getText()),Double.parseDouble(jTkfinal.getText()),tipo,jCBvehiculos.getSelectedItem().toString(),jTAincidencias.getText(),
                               Double.parseDouble(jTggasoil.getText()),Double.parseDouble(jTgpeajes.getText()),Double.parseDouble(jTgdietas.getText()),Double.parseDouble(jTotros.getText()));
        G2vJovi.registrarSalidas();

    }
    /**
     * metodo autogenerado
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField9 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCBvehiculos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTkini = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTkfinal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAincidencias = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTggasoil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTgdietas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTgpeajes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTotros = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTalbaran = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFThsalida = new javax.swing.JFormattedTextField();
        jFThllegada = new javax.swing.JFormattedTextField();
        jBañadirSalidas = new javax.swing.JButton();
        jBaceptar = new javax.swing.JButton();
        jBcerrar = new javax.swing.JButton();
        jBmostrar = new javax.swing.JButton();
        jPsalidas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAsalidas = new javax.swing.JTextArea();
        jPeliminarSalida = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jCBsalidas = new javax.swing.JComboBox<>();
        jBeliminarSalida = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBpermitirEditar = new javax.swing.JButton();

        jTextField9.setText("jTextField9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("PARTE DIARIO");

        jLabel2.setText("KM INICIAL");

        jLabel3.setText("KM FINAL");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INCIDENCIAS"));

        jTAincidencias.setColumns(20);
        jTAincidencias.setRows(5);
        jScrollPane1.setViewportView(jTAincidencias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("GASTOS"));

        jLabel4.setText("DE GASOIL");

        jLabel5.setText("DIETAS");

        jLabel6.setText("DE PEAJES");

        jLabel7.setText("OTROS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTggasoil)
                    .addComponent(jTgpeajes, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTgdietas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTotros)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTggasoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTgdietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTgpeajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("SALIDAS"));

        jLabel8.setText("ALBARAN");

        jLabel9.setText("HORA SALIDA");

        jLabel10.setText("HORA LLEGADA");

        jFThsalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        jFThllegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTalbaran, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFThsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFThllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTalbaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jFThsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFThllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jBañadirSalidas.setText("AÑADIR");
        jBañadirSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBañadirSalidasActionPerformed(evt);
            }
        });

        jBaceptar.setText("ACEPTAR");
        jBaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaceptarActionPerformed(evt);
            }
        });

        jBcerrar.setText("X");
        jBcerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcerrarActionPerformed(evt);
            }
        });

        jBmostrar.setText("MOSTRAR");
        jBmostrar.setEnabled(false);
        jBmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmostrarActionPerformed(evt);
            }
        });

        jPsalidas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBorder(null);

        jTAsalidas.setEditable(false);
        jTAsalidas.setColumns(20);
        jTAsalidas.setRows(5);
        jScrollPane2.setViewportView(jTAsalidas);

        javax.swing.GroupLayout jPsalidasLayout = new javax.swing.GroupLayout(jPsalidas);
        jPsalidas.setLayout(jPsalidasLayout);
        jPsalidasLayout.setHorizontalGroup(
            jPsalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPsalidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPsalidasLayout.setVerticalGroup(
            jPsalidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPsalidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setText("ELIMINAR SALIDA");

        jBeliminarSalida.setText("OK");
        jBeliminarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPeliminarSalidaLayout = new javax.swing.GroupLayout(jPeliminarSalida);
        jPeliminarSalida.setLayout(jPeliminarSalidaLayout);
        jPeliminarSalidaLayout.setHorizontalGroup(
            jPeliminarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPeliminarSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBsalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBeliminarSalida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPeliminarSalidaLayout.setVerticalGroup(
            jPeliminarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPeliminarSalidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPeliminarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBsalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminarSalida)
                    .addComponent(jLabel11)))
        );

        jBmodificar.setText("MODIFICAR");
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });

        jBpermitirEditar.setText("PERMITIR EDITAR");
        jBpermitirEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpermitirEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jCBvehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTkini, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jTkfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(jBcerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPeliminarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBañadirSalidas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBmostrar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBmodificar)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBpermitirEditar)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBaceptar)))
                            .addComponent(jPsalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBcerrar)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBvehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTkini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTkfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBañadirSalidas)
                    .addComponent(jBmostrar))
                .addGap(18, 18, 18)
                .addComponent(jPsalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPeliminarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBaceptar)
                    .addComponent(jBmodificar)
                    .addComponent(jBpermitirEditar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcerrarActionPerformed
        
        tipo="SC";
        //crearParte(tipo);
        int idParte=main.registrarParteBasura(Double.parseDouble(jTkini.getText()),Double.parseDouble(jTkfinal.getText()),tipo,jCBvehiculos.getSelectedItem().toString(),jTAincidencias.getText(),
                               Double.parseDouble(jTggasoil.getText()),Double.parseDouble(jTgpeajes.getText()),Double.parseDouble(jTgdietas.getText()),Double.parseDouble(jTotros.getText()));
        main.registrarSalidasBasura(idParte);
        G2vJovi.cerrarVentanaCreacionPartes();
        
   
    }//GEN-LAST:event_jBcerrarActionPerformed

    private void jBañadirSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBañadirSalidasActionPerformed
        // BOTON PARA REGISTRAR LAS SALIDAS DEL TRABAJADOR DE LOGISTICA EN UNA LISTA:
        
        G2vJovi.registrarSalidas(jTalbaran.getText(), jFThsalida.getText(), jFThllegada.getText());
        G2vJovi.calcularHorasTotalesTrabajadasXSalida(jFThsalida.getText(), jFThllegada.getText());
        limpiarCamposDeSalidas();
        jTAsalidas.setText("");
        jCBsalidas.removeAllItems();
        jBmostrar.setEnabled(true);
        
    }//GEN-LAST:event_jBañadirSalidasActionPerformed

    private void jBmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmostrarActionPerformed
        // BOTON DE MOSTRAR TODAS LAS SALIDAS REGISTRADAS EN EL PARTE ANTES DE CERRARLO:
        
        String lista=G2vJovi.verListaDeSalidasRegistradas();
        jTAsalidas.setText(lista);
        Integer numTotalSalidas=G2vJovi.numeroDeSalidasRegistradasHastaELMomento();
        jCBsalidas.removeAllItems();
        rellenarComboBoxSalidas(numTotalSalidas);
        jPeliminarSalida.setVisible(true);
        
    }//GEN-LAST:event_jBmostrarActionPerformed

    private void jBeliminarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarSalidaActionPerformed
        // BOTON PARA ELIMINAR UNA SALIDA REGISTRADA:
        
        G2vJovi.restarDeltotalDeHorasTrabajadas(jCBsalidas.getSelectedItem().toString());
        G2vJovi.borrarSalidaDelRegistro(jCBsalidas.getSelectedItem().toString());
        jCBsalidas.removeAllItems();
        jTAsalidas.setText("");
        
    }//GEN-LAST:event_jBeliminarSalidaActionPerformed

    private void jBaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaceptarActionPerformed
        // BOTON DE ACEPTAR PARTE, UNA VEZ QUE HAS FINALIZADO DE RELLENARLO:
        tipo="C";
        crearParte(tipo);
        G2vJovi.cerrarVentanaCreacionPartes();
    }//GEN-LAST:event_jBaceptarActionPerformed

    private void jBpermitirEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpermitirEditarActionPerformed
        // BOTON PARA PERMITIR EDITAR LOS CAMPOS:
        
        jCBvehiculos.setEditable(true);
        jTkini.setEditable(true);
        jTkfinal.setEditable(true);
        jTAincidencias.setEditable(true);
        jTggasoil.setEditable(true);
        jTgpeajes.setEditable(true);
        jTgdietas.setEditable(true);
        jTotros.setEditable(true);
        jTalbaran.setEditable(true);
        jFThsalida.setEditable(true);
        jFThllegada.setEditable(true);
        jBañadirSalidas.setEnabled(true);
    }//GEN-LAST:event_jBpermitirEditarActionPerformed

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
        Parte objetoParteActualizado;
        G2vJovi.registarAviso();
        objetoParteActualizado=G2vJovi.actualizarDatosParte(Double.parseDouble(jTkini.getText()),Double.parseDouble(jTkfinal.getText()),jCBvehiculos.getSelectedItem().toString(),jTAincidencias.getText(),
                               Double.parseDouble(jTggasoil.getText()),Double.parseDouble(jTgpeajes.getText()),Double.parseDouble(jTgdietas.getText()),Double.parseDouble(jTotros.getText()),objetoP);
        main.procModificarParteAdmin(objetoParteActualizado);
    }//GEN-LAST:event_jBmodificarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoParte dialog = new NuevoParte(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBaceptar;
    private javax.swing.JButton jBañadirSalidas;
    private javax.swing.JButton jBcerrar;
    private javax.swing.JButton jBeliminarSalida;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBmostrar;
    private javax.swing.JButton jBpermitirEditar;
    private javax.swing.JComboBox<String> jCBsalidas;
    private javax.swing.JComboBox<String> jCBvehiculos;
    private javax.swing.JFormattedTextField jFThllegada;
    private javax.swing.JFormattedTextField jFThsalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPeliminarSalida;
    private javax.swing.JPanel jPsalidas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAincidencias;
    private javax.swing.JTextArea jTAsalidas;
    private javax.swing.JTextField jTalbaran;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTgdietas;
    private javax.swing.JTextField jTggasoil;
    private javax.swing.JTextField jTgpeajes;
    private javax.swing.JTextField jTkfinal;
    private javax.swing.JTextField jTkini;
    private javax.swing.JTextField jTotros;
    // End of variables declaration//GEN-END:variables
}
