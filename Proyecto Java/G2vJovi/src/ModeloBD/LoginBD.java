/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Credenciales;
import java.sql.*;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author 1GLM07
 */
public class LoginBD extends GenericoBD{
      Connection con ;
      public String login(Credenciales c)throws Exception{         
           GenericoBD generico= new GenericoBD();
        con=   generico.abrirConexion(con);
           
           String sql="select tipoTrabajador from trabajador where dni =(select trabajador_dni from usuario where usuario =? and contraseña=?) ";
          PreparedStatement logn=con.prepareStatement(sql);
          logn.setString(1, c.getUser());
          logn.setString(2, c.getPassw());
          ResultSet datos =logn.executeQuery();
         
               
         
           String tipo="";
          if(datos.next()){
             tipo=  datos.getString(1);
          }
          
          con.close();
         return tipo;        
      }
      
       public String login1(String usuario,String contraseña)throws Exception{         
           GenericoBD generico= new GenericoBD();
           generico.abrirConexion(con);
           
           String sql="{ call login(?,?,?) } ";
          CallableStatement logn=con.prepareCall(sql);
          logn.setString(1, usuario);
          logn.setString(2, contraseña);
          logn.registerOutParameter(3,OracleTypes.VARCHAR );
         
                logn.execute(); // ejecutar el procedimiento
                ResultSet datos = null;
                datos = (ResultSet) logn.getObject(3);
         
           String tipo="";
          while(datos.next()){
             tipo=  datos.getString(1);
          }
          
          con.close();
         return tipo;        
      }
    
}
