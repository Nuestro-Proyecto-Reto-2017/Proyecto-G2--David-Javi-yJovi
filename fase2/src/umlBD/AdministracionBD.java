/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;

import java.sql.*;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import uml.*;
import umlBD.*;



/**
 *
 * @author 1GLM07
 */
public class AdministracionBD { 

    public void anadirUsuario() {

    }

    public  void borrarUsuario() {

    }

    public void guardarParte() {

    }

    public  void revisarParte() {

    }
    public  void visualizarParte() {

    }

    public  void generarInforme() {

    }

    public static  void anadirTrabajador(Trabajador t) {
        try {
            conexionBD.conectar();
            
            PreparedStatement insertTrabajador = conexionBD.conectar().prepareStatement("insert into trabajador values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertTrabajador.setString(1, t.getDni());
            insertTrabajador.setString(2, t.getNombre());
            insertTrabajador.setString(3, t.getApellidoUno());
            insertTrabajador.setString(4, t.getApellidoDos());
            
            insertTrabajador.setString(5, t.getCalle());
            insertTrabajador.setString(6, t.getPortal());
            insertTrabajador.setString(7, t.getPiso());
            insertTrabajador.setString(8, t.getMano());
            
            insertTrabajador.setString(9, t.getTelefonoPersonal());
            insertTrabajador.setString(10, t.getTelefonoEmpresa());
            
            insertTrabajador.setFloat(11, t.getSalario());
            
             insertTrabajador.setDate(12, t.getFechaNac());
            
            insertTrabajador.setString(13, t.getTipoTrabajador());
            insertTrabajador.setString(14, t.getCentro());
            
            int x =insertTrabajador.executeUpdate();
            
            conexionBD.dc();
            javax.swing.JOptionPane.showMessageDialog(null,"se han insertado " +x+" filas");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en el alta: " + e.getMessage());
        }

    }

    public static void borrarTrabajador(String dni) throws Exception {
       conexionBD.conectar();
        PreparedStatement deleteTrabajador = conexionBD.conectar().prepareStatement("delete from trabajador where dni=?");
        deleteTrabajador.setString(1, dni);
        
       int x= deleteTrabajador.executeUpdate();
        conexionBD.dc();
        javax.swing.JOptionPane.showMessageDialog(null,"se han borrado "+ x+" filas");
    

    }

    public static  void actualizarTrabajador(Trabajador t1) {
        
            try {
            conexionBD.conectar();
            
             PreparedStatement actualizarTrabajador = conexionBD.conectar().prepareStatement("update trabajador set nombre=?,apellidouno=?,apellidodos=?,calle=?,portal=?,piso=?,mano=?,telefonopersonal=?,telefonoempresa=?,salario=?,fechanac=?,tipotrabajador=?,centro_idcentro=? where dni=?");
            actualizarTrabajador.setString(14, t1.getDni());
            actualizarTrabajador.setString(1, t1.getNombre());
            actualizarTrabajador.setString(2, t1.getApellidoUno());
            actualizarTrabajador.setString(3, t1.getApellidoDos());
            
            actualizarTrabajador.setString(4, t1.getCalle());
            actualizarTrabajador.setString(5, t1.getPortal());
            actualizarTrabajador.setString(6, t1.getPiso());
            actualizarTrabajador.setString(7, t1.getMano());
            
            actualizarTrabajador.setString(8, t1.getTelefonoPersonal());
            actualizarTrabajador.setString(9, t1.getTelefonoEmpresa());
            
            actualizarTrabajador.setFloat(10, t1.getSalario());
            
             actualizarTrabajador.setDate(11, t1.getFechaNac());
            
            actualizarTrabajador.setString(12, t1.getTipoTrabajador());
            actualizarTrabajador.setString(13, t1.getCentro());

            int x=actualizarTrabajador.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null,"se han actualizador " +x+"filas");
            
            conexionBD.dc();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en el alta: " + e.getMessage());
        }
        

    }   
     
    
   public static ResultSet cogerDatosTrabajador(String dni)throws Exception{
        CallableStatement x=conexionBD.conectar().prepareCall("{call select_trabajadores_dni(?, ?)}");
        x.setString(1, dni);
        x.registerOutParameter(2, OracleTypes.CURSOR);
        x.execute();
        
         ResultSet datos = ((OracleCallableStatement)x).getCursor(2);
        
         
        
        //como estamos buscando por la clave no hace falta hacer una repetitiva para scar datos porque solo devuelve una fila
        
       
        
         
       
      return datos;
   }
}
