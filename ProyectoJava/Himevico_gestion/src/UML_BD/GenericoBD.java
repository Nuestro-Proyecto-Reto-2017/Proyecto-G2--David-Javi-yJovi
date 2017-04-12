
package UML_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class GenericoBD {
    
    private Connection conex; 

   
    
    public Connection abrirConexionBD(){
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            conex=DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102","dawxml","dawxml");

        }catch(Exception e){
        
         JOptionPane.showMessageDialog(null, "PROBLEMAS CON LA CONEXION A LA BASE DE DATOS");
        
        }
        
        return conex;
    } 
    public void cerrarConexionBD() throws SQLException{
    
        conex.close();
        
    }
    
    
    
    
    
}
