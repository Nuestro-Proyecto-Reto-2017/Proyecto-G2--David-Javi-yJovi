/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import uml.Centro;

/**
 *
 * @author 1GLM07
 */
public class CentroBD {
    
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
            javax.swing.JOptionPane.showMessageDialog(null,"se han actualizado " +x+"filas");
            
            conexionBD.dc();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en el alta: " + e.getMessage());
        }
       
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
    
    public static ResultSet cogerDatosCentro(String idCentro)throws Exception{
        CallableStatement x=conexionBD.conectar().prepareCall("{call gest_centro.visualizar_datos_centro_id(?, ?)}");
        x.setString(1, idCentro);
        x.registerOutParameter(2, OracleTypes.CURSOR);
        x.execute();
         ResultSet datos = ((OracleCallableStatement)x).getCursor(2);
         
        
        //como estamos buscando por la clave no hace falta hacer una repetitiva para scar datos porque solo devuelve una fila
        
       
        
         
       
      return datos;
   }
    
       public static ArrayList consultarCentros()throws Exception{
        CallableStatement x=conexionBD.conectar().prepareCall("{call gest_centro.visualizar_lista_centro(?)}");
        x.registerOutParameter(2, OracleTypes.CURSOR);
        x.execute();
         ResultSet datos = ((OracleCallableStatement)x).getCursor(2);
         ArrayList<String> centros =new ArrayList();
         while(datos.next()){
           centros.add(datos.getString(1));
         }
         
        
        //como estamos buscando por la clave no hace falta hacer una repetitiva para scar datos porque solo devuelve una fila
        
       
        
         
       
      return centros;
   }
    
}
