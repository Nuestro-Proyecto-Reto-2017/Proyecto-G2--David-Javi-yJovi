package ModeloBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloUML.*;


public class AvisoBD  {
    
    private Connection con;
    /*No es usado, preguntar a david si se necesita si no borrar
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
        
        
    }*/
    
    /**
     * esta funcion permite al admin modificar el mensaje de aviso que recibira el trabajador de logistica
     * 
     */
    public void ModificarAvisoAdmin (Parte p){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update aviso set descripcion=? where idaviso=select aviso_idaviso from parte where idparte=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setString(1, p.getAvisoDelParte().getDescripcion()); // param de entrada    
                llamada.setInt(2, p.getID());
                
                llamada.executeUpdate(); // ejecutar el procedimiento

            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
    }
    
    
    
}
