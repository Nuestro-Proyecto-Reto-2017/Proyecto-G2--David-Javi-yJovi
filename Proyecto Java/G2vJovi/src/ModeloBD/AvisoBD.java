
package ModeloBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AvisoBD  {
    
    private Connection con;
    
    public void registrarAvidoEBD(String men){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="insert into aviso (descripcion) values(?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, men);
            
            int filas=ps.executeUpdate();
            
            ps.close();
            con.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE AVISO "+ e.getClass()+ " " + e.getMessage());
        }
        
        
    }
    
    
    
}
