package ModeloBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ModeloUML.Centro;
import ModeloUML.Vehiculo;
import excepciones.*;
import ModeloBD.GenericoBD;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author 1GLM07
 */
public class VehiculoBD extends GenericoBD{
      Connection con ;
    /**
     * funcion que registra en la BD un nuevo vehiculo
     */
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
/**
 * funcion que borra de la BD el vehiculo especificado 
 */
    public   void borrarVehiculo(String matricula) throws Exception {
         GenericoBD generico =new GenericoBD();
         con=generico.abrirConexion(con);
         
        PreparedStatement insertVehiculo =con.prepareStatement("delete from vehiculo where matricula=?");
        insertVehiculo.setString(1, matricula);
         int fila =insertVehiculo.executeUpdate();
          javax.swing.JOptionPane.showMessageDialog(null,"se ha(n) borrado "+ fila+" fila(s)");
       con.close();;
    }
    /**
     * funcion que recoge todos los datos de los vehiculo para mostrarlos por pantalla
     */
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
     /**
      * funcion que recoge las matriculas de los vehiculos para rellenar el combobox del parte
      */
     public  ArrayList consultarVehiculosComboB()  {
         try{
         ArrayList <Vehiculo> listaV =new ArrayList();
         GenericoBD generico =new GenericoBD();
         String matricula="";
         con=generico.abrirConexion(con);
        PreparedStatement selectVehiculos = con.prepareStatement("select matricula from vehiculo");
        
        ResultSet vehiculos=selectVehiculos.executeQuery();
        
    
    while(vehiculos.next()){
        Vehiculo v = new Vehiculo();
        v.setMatricula(vehiculos.getString("MATRICULA"));
        listaV.add(v);
    }
   
       
        
      con.close();
      return listaV;
         }
         catch(Exception e){
             return null;
         }
        
     
        
        
    }
     /**
      * funcionque recoge los datos del vehicuo para modificarlos mas adelante 
      */
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
     /**
      * funcion que actualiza los datos de un vehiculo almacenado en la BD 
      */
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
