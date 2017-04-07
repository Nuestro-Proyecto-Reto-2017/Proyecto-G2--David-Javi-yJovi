/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;
import java.sql.*;

/**
 *
 * @author 1GLM07
 */
public class conexionBD  {
    private  Connection con;
    
    public static Connection conectar(){
    try{
        
     


        
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url="jdbc:oracle:thin:@10.10.10.9:1521:db12102";
    String user="dawxml";
    String password="dawxml";
    con =DriverManager.getConnection(url, user, password);
    
   return con;
    
    

}catch(Exception e){
    javax.swing.JOptionPane.showMessageDialog(null,"error al conectar:"+ e.getMessage());
    return null;
}
   
    }
    public  void dc(Connection con){
        try{
        con.close();
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"no se pudo cerrar la conexion"+ e.getMessage()+e.getClass());
        }
        
    }
}
