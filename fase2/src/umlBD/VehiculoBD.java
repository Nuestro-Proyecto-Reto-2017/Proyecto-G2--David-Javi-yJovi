/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import uml.Centro;
import uml.Vehiculo;
import excepciones.*;


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
    
     public  static String consultarVehiculos() throws Exception {
      try{
        
        PreparedStatement selectVehiculos = conexionBD.conectar().prepareStatement("select * from vehiculo");
        
        ResultSet vehiculos=selectVehiculos.executeQuery();
        
        String lista="";
    
    while(vehiculos.next()){
      lista+= "\n"+ vehiculos.getString(1)+" "+vehiculos.getString(2)+" "+vehiculos.getString(3);
      lista+="\n------------------------------------"; 
     
    }
   
       
        
        conexionBD.dc();
        return lista;
      }catch(Exception e){
          javax.swing.JOptionPane.showMessageDialog(null,"error al recoger vehiculos "+ e.getClass()+e.getClass());
         return null; 
      }
        
        
    }
     public static Vehiculo buscarVehiculo(String matricula)throws Exception {
           conexionBD.conectar();
           Vehiculo v=new Vehiculo();
            
             PreparedStatement buscarVehiculo = conexionBD.conectar().prepareStatement("select * from vehiculo where matricula=?");
             buscarVehiculo.setString(1, matricula);
           ResultSet datos=  buscarVehiculo.executeQuery();
          if(datos.next()){ 
        v.setMatricula(datos.getString(1));
        v.setMarca(datos.getString(2));
        v.setModelo(datos.getString(3));
          }else{
              throw new sinDatos(); 
                     
          }
        
        return v;
             
             
     }
     
     public static void actualizarVehiculo(Vehiculo v,String matriculaID) {
        
        try {
             conexionBD.conectar();
            
             PreparedStatement actualizarVehiculo = conexionBD.conectar().prepareStatement("update vehiculo set matricula=?,marca=?,modelo=? where matricula=?");
             actualizarVehiculo.setString(1, v.getMatricula());
             actualizarVehiculo.setString(2, v.getMarca());
             actualizarVehiculo.setString(3, v.getModelo());
             actualizarVehiculo.setString(4, matriculaID);
             
             
             
            
            

            int x=actualizarVehiculo.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null,"se han actualizado " +x+"filas");
            
            conexionBD.dc();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en la actualizacion: " + e.getMessage());
        }
    
}
}
