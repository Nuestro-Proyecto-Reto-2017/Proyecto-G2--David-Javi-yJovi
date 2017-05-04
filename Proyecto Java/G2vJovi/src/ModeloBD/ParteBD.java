
package ModeloBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


public class ParteBD {
    
    private Connection con;
  
    
    public void registrarParteEBD(Float kmi,Float kmf,String tipoparte,String logistica ,String matricula,String observaciones,String avis_descripcion,Float gastoG,Float gastoP,Float gastoD,Float ogastos,Date fechaParte){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="{call registrar_parte(?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try {
            
            CallableStatement cst =con.prepareCall(sql);
            cst.setFloat(1, kmi);
            cst.setFloat(2, kmf);
            cst.setString(3, tipoparte);
            cst.setString(4,logistica);
            cst.setString(5, matricula);
            cst.setString(6, observaciones);
            cst.setString(7,avis_descripcion);
            cst.setFloat(8,gastoG);
            cst.setFloat(9,gastoP);
            cst.setFloat(10, gastoD);
            cst.setFloat(11, ogastos);
            cst.setDate(12, fechaParte);
            
            cst.execute();
         
            cst.close();
            con.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE PARTE "+ e.getClass()+ " " + e.getMessage());
        }
        
    
    
    }
}