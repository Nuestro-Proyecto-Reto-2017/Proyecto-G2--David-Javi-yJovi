/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import uml.Vehiculo;

/**
 *
 * @author 1GLM07
 */
public class VehiculoBD {
    
    public  static void anadirVehiculo(Vehiculo v) throws Exception {
      
        
        PreparedStatement insertVehiculo = conexionBD.conectar().prepareStatement("insert into vehiculo values (?,?,?)");
        insertVehiculo.setString(1, v.getMatricula());
        insertVehiculo.setString(2, v.getMarca());
        insertVehiculo.setString(3, v.getModelo());
        int fila=insertVehiculo.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null,"se ha(n) insertado "+ fila+" fila(s)");
        conexionBD.dc();
    }

    public static  void borrarVehiculo(String matricula) throws Exception {
        
        PreparedStatement insertVehiculo = conexionBD.conectar().prepareStatement("delete from vehiculo where matricula=?");
        insertVehiculo.setString(1, matricula);
         int fila =insertVehiculo.executeUpdate();
          javax.swing.JOptionPane.showMessageDialog(null,"se ha(n) borrado "+ fila+" fila(s)");
        conexionBD.dc();
    }
    
     public  static void consultarVehiculos() throws Exception {
      try{
        
        PreparedStatement selectVehiculos = conexionBD.conectar().prepareStatement("select * from vehiculo");
        
        ResultSet vehiculos=selectVehiculos.executeQuery();
        
        String lista="";
    
    while(vehiculos.next()){
      lista+= "\n"+ vehiculos.getString(1)+" "+vehiculos.getString(2)+" "+vehiculos.getString(3);
      
    }
   
        javax.swing.JOptionPane.showMessageDialog(null, lista);
        
        conexionBD.dc();
        
      }catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null,"error al recoger vehiculos "+ e.getClass()+e.getClass());
          
      }
        
        
    }
    
}
