
package ModeloBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class GastoBD  {
    
    private Connection con;
    
    public void registrarGastosEBD( Float gGasoil, Float gPeajes, Float gDietas, Float oGastos){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="insert into gasto (gastogasoil,gastopeajes,gastodietas,otrosgastos) values(?,?,?,?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setFloat(1, gGasoil);
            ps.setFloat(2, gPeajes);
            ps.setFloat(3, gDietas);
            ps.setFloat(4, oGastos);
           
            int filas=ps.executeUpdate();
            
            ps.close();
            con.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE GASTOS "+ e.getClass()+ " " + e.getMessage());
        }
        

    }
}
