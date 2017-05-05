
package ModeloBD;

import ModeloUML.Salida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SalidaBD {
    
   private Connection con;
    
    public void registrarSalidasEBD(ArrayList<Salida>salidas, int idParte){

        GenericoBD gbd=new GenericoBD();
        String sql="insert into aviso (horasalida,horallegada,albaran,parte_idparte) values(?,?,?,?)";
        
         
        for(int i=0;i<salidas.size();i++){
            
            try {

                con=gbd.abrirConexion(con);
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setTime(1,java.sql.Time.valueOf(salidas.get(i).getHoraSalida()));
                ps.setTime(2,java.sql.Time.valueOf(salidas.get(i).getHoraLLegada()));
                ps.setString(3, salidas.get(i).getAlbaran());
                ps.setInt(4, idParte);
                
                int filas=ps.executeUpdate();

                ps.close();
                con.close();
            
            } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE SALIDAS "+ e.getClass()+ " " + e.getMessage());
        }
        }
        
    }
        
        
        
        
        
        
    }
    

