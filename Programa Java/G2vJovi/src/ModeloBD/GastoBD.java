package ModeloBD;

import ModeloUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class GastoBD  {
    
    private Connection con;
    /**
     *funcion que almacena los gastos del parte que va a ser insertado  
     * 
     */
    
    public void registrarGastosEBD( double gGasoil, double gPeajes, double gDietas, double oGastos){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="insert into gasto (gastogasoil,gastopeajes,gastodietas,otrosgastos) values(?,?,?,?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, gGasoil);
            ps.setDouble(2, gPeajes);
            ps.setDouble(3, gDietas);
            ps.setDouble(4, oGastos);
           
            int filas=ps.executeUpdate();
            
            ps.close();
            con.close();

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE GASTOS "+ e.getClass()+ " " + e.getMessage());
        }
        

    }
    
    /**
     * funcion donde el administrador podra modificar los gastos de un parte 
     */
    public void ModificarGastosAdmin (Parte p){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update gasto set gastogasoil=?, set gastopeajes=?,set gastodietas=?,set otrosgastos=? where idgasto=select gasto_idgasto from parte where idparte=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setDouble(1, p.getGastoDelParte().getGastoGasoil());
                llamada.setDouble(2, p.getGastoDelParte().getGastoPeaje());// param de entrada   
                llamada.setDouble(3, p.getGastoDelParte().getGastoDietas());
                llamada.setDouble(4, p.getGastoDelParte().getOtrosGastos());
                llamada.setInt(5, p.getID());
                
                llamada.executeUpdate(); // ejecutar el procedimiento

            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
    }
}
