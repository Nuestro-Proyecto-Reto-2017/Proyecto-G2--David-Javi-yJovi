/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author 1gbd02
 */
public class GenericoBD {
    public static void main(String[] args) {
        
    }
    public Connection abrirConexion(Connection conexion){

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102","system", "oracle");  
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
    }
    public void cerrarConexion(Connection conexion){
        try{
        conexion.close();
        }
        catch(Exception e){
                
        }
    }
}
