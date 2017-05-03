
package ModeloBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ParteBD {
    
    private Connection con;
    
    //ESTA SIN ACABAR, TENGO ALGUNA DUDA
    
    public void registrarParteEBD(){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="insert into parte () values(?,?,?,?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
          
           
            int filas=ps.executeUpdate();
            
            ps.close();
            con.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE PARTE "+ e.getClass()+ " " + e.getMessage());
        }
        
    
    
    }
}