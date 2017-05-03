/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ModeloUML.Centro;
import ModeloUML.Vehiculo;
import excepciones.*;
import ModeloBD.GenericoBD;
import java.sql.Connection;


/**
 *
 * @author 1GLM07
 */
public class VehiculoBD extends GenericoBD{
      Connection con ;
    
    public   void anadirVehiculo(Vehiculo v) throws Exception {
       GenericoBD generico =new GenericoBD();
       con=generico.abrirConexion(con);
        
        PreparedStatement insertVehiculo = con.prepareStatement("insert into vehiculo values (?,?,?)");
        insertVehiculo.setString(1, v.getMatricula());
        insertVehiculo.setString(2, v.getMarca());
        insertVehiculo.setString(3, v.getModelo());
        int fila=insertVehiculo.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null,"se ha(n) insertado "+ fila+" fila(s)");
       con.close();
    }

    public   void borrarVehiculo(String matricula) throws Exception {
         GenericoBD generico =new GenericoBD();
         con=generico.abrirConexion(con);
         
        PreparedStatement insertVehiculo =con.prepareStatement("delete from vehiculo where matricula=?");
        insertVehiculo.setString(1, matricula);
         int fila =insertVehiculo.executeUpdate();
          javax.swing.JOptionPane.showMessageDialog(null,"se ha(n) borrado "+ fila+" fila(s)");
       con.close();;
    }
    
     public  String consultarVehiculos() throws Exception {
      
         GenericoBD generico =new GenericoBD();
         con=generico.abrirConexion(con);
        PreparedStatement selectVehiculos = con.prepareStatement("select * from vehiculo");
        
        ResultSet vehiculos=selectVehiculos.executeQuery();
        
        String lista="";
    
    while(vehiculos.next()){
      lista+= "\n"+ vehiculos.getString(1)+" "+vehiculos.getString(2)+" "+vehiculos.getString(3);
      lista+="\n------------------------------------"; 
     
    }
   
       
        
      con.close();
        return lista;
     
        
        
    }
     public  Vehiculo buscarVehiculo(String matricula)throws Exception {
            GenericoBD generico =new GenericoBD();
           Vehiculo v=new Vehiculo();
            con=generico.abrirConexion(con);
             PreparedStatement buscarVehiculo = con.prepareStatement("select * from vehiculo where matricula=?");
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
     
     public  void actualizarVehiculo(Vehiculo v,String matriculaID) throws Exception{
        
       
          GenericoBD generico =new GenericoBD();
            con=generico.abrirConexion(con);
             PreparedStatement actualizarVehiculo =con.prepareStatement("update vehiculo set matricula=?,marca=?,modelo=? where matricula=?");
             actualizarVehiculo.setString(1, v.getMatricula());
             actualizarVehiculo.setString(2, v.getMarca());
             actualizarVehiculo.setString(3, v.getModelo());
             actualizarVehiculo.setString(4, matriculaID);
             
             
             
            
            

            int x=actualizarVehiculo.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null,"se han actualizado " +x+"filas");
            
         con.close();
        
    
}
}
