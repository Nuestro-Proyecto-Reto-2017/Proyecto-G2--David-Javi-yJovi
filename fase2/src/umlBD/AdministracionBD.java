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

    public static void actualizarCentro(Centro c) {
        
        try {
             conexionBD.conectar();
            
             PreparedStatement actualizarCentro = conexionBD.conectar().prepareStatement("update centro set nombre=?,calle=?,numero=?,codigopostal=?,ciudad=?,provincia=?,telefono=? where idcentro=?");
            actualizarCentro.setString(8, c.getIdCentro());
            actualizarCentro.setString(1, c.getNombre());
            actualizarCentro.setString(2, c.getCalle());
            actualizarCentro.setString(3, c.getNumero());
            
            actualizarCentro.setString(4, c.getCodigoPostal());
            actualizarCentro.setString(5, c.getCiudad());
            actualizarCentro.setString(6, c.getProvincia());
            actualizarCentro.setString(7, c.getTelefono());
            
            

            int x=actualizarCentro.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null,"se han actualizador " +x+"filas");
            
            conexionBD.dc();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en el alta: " + e.getMessage());
        }
       
    }
  Connection con=conexionBD.conectar();
conexionBD c=new conexionBD();
    public  void anadirVehiculo(Vehiculo v) throws Exception {
      
        
        PreparedStatement insertVehiculo = c.conectar().prepareStatement("insert into vehiculo values (?,?,?)");
        insertVehiculo.setString(1, v.getMatricula());
        insertVehiculo.setString(2, v.getMarca());
        insertVehiculo.setString(3, v.getModelo());
        int fila=insertVehiculo.executeUpdate();
        con.close();
    }

    public static  void borrarVehiculo(String matricula) throws Exception {
        
      /*  PreparedStatement insertVehiculo = c.conectar().prepareStatement("delete from vehiculo where matricula=?");
        insertVehiculo.setString(1, matricula);
        insertVehiculo.executeUpdate();
        c.dc();*/
    }

    public void anadirUsuario() {

    }

    public  void borrarUsuario() {

    }

    public void guardarParte() {

    }

    public  void revisarParte() {

    }

    public static void anadirCentro(Centro c) {
        try{
        conexionBD.conectar();
        PreparedStatement insertCentro = conexionBD.conectar().prepareStatement("insert into centro values(?,?,?,?,?,?,?,?)");
        insertCentro.setString(1, c.getIdCentro());
        insertCentro.setString(2, c.getNombre());
        insertCentro.setString(3, c.getCalle());
        insertCentro.setString(4, c.getNumero());
        insertCentro.setString(5, c.getCodigoPostal());
        insertCentro.setString(6, c.getCiudad());
        insertCentro.setString(7, c.getProvincia());
        insertCentro.setString(8, c.getTelefono());
       int filas= insertCentro.executeUpdate();
        conexionBD.dc();
        javax.swing.JOptionPane.showMessageDialog(null, "se han insertado "+ filas+" filas");
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error al insertar centro: "+ e.getClass()+e.getMessage());
        }
    }

    public static void borrarCentro(Centro c1){
      try{ 
          //conexionBD.conectar();
        PreparedStatement deleteCentro = conexionBD.conectar().prepareStatement("delete from centro where idcentro=?");
        deleteCentro.setString(1, c1.getIdCentro());
        int x =deleteCentro.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null, "se han borrado "+x+" filas");
        conexionBD.dc();}
      catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null, "error al borrar "+e.getMessage()+e.getClass());
      }

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
    
     public static ResultSet cogerDatosCentro(String idCentro)throws Exception{
        CallableStatement x=conexionBD.conectar().prepareCall("{call gest_centro.visualizar_datos_centro_id(?, ?)}");
        x.setString(1, idCentro);
        x.registerOutParameter(2, OracleTypes.CURSOR);
        x.execute();
         ResultSet datos = ((OracleCallableStatement)x).getCursor(2);
         
        
        //como estamos buscando por la clave no hace falta hacer una repetitiva para scar datos porque solo devuelve una fila
        
       
        
         
       
      return datos;
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
