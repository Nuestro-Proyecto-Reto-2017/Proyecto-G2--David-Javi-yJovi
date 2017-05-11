package ModeloBD;

import ModeloUML.*;
import g2vjovi.G2vJovi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class SalidaBD {
    
   private Connection con;
    /**
     * funcion para guardar las salidas de un parte en la BD
     */
    public void registrarSalidasEBD(ArrayList<Salida>salidas){

        GenericoBD gbd=new GenericoBD();
        String sql="insert into salida (horasalida,horallegada,albaran,parte_idparte) values(?,?,?,(select max(idParte)from parte))";
      
        try{
          con=gbd.abrirConexion(con);
          PreparedStatement ps=con.prepareStatement(sql);
         
        for(int i=0;i<salidas.size();i++){
            
                ps.setTime(1,java.sql.Time.valueOf(salidas.get(i).getHoraSalida()));
                ps.setTime(2,java.sql.Time.valueOf(salidas.get(i).getHoraLLegada()));
                ps.setString(3, salidas.get(i).getAlbaran());
                
                int filas=ps.executeUpdate();

        }
           
          ps.close();
          con.close();

        }catch(Exception e ){
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE SALIDAS "+ e.getClass()+ " " + e.getMessage());
}
    }
    /**
     *guardar las basuras de un parte sin cerrar para no tener que volver a insertarlas 
     */
    public void registrarSalidasBasuraEBD(ArrayList<Salida>salidas, int idParte){

        GenericoBD gbd=new GenericoBD();
        String sql="insert into salidaBasura (horasalida,horallegada,albaran,partebasura_idparte) values(?,?,?,?)";
        
          try {
                con=gbd.abrirConexion(con);
                PreparedStatement ps=con.prepareStatement(sql);
            for(int i=0;i<salidas.size();i++){
            
                ps.setTime(1,java.sql.Time.valueOf(salidas.get(i).getHoraSalida()));
                ps.setTime(2,java.sql.Time.valueOf(salidas.get(i).getHoraLLegada()));
                ps.setString(3, salidas.get(i).getAlbaran());
                ps.setInt(4, idParte);
                
               ps.executeUpdate();

            }
                ps.close();
                con.close();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE SALIDAS "+ e.getClass()+ " " + e.getMessage());
        }
        
    }
    /**
     * recoger de la BD las salidas referentes a un parte 
     */
        public ArrayList consultarSalidasParte (int vIdParte){
        
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Salida> listaSalidas=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{call buscar_salidasParte(?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
                // Preparamos la llamada

            llamada.setInt(1, vIdParte); // param de entrada
            llamada.registerOutParameter(2, OracleTypes.CURSOR); // Cadena devuelta
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(2);

                
                if(rs.next()){
                    do{
                        Salida sSalida=G2vJovi.rellenarSalida(rs.getDate("HORASALIDA"),rs.getDate("HORALLEGADA"),rs.getString("ALBARAN"));
                        listaSalidas.add(sSalida); 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
        llamada.close();    
        con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
        return listaSalidas;
    }
        /**
         *funcion para que el admin modifique o corrija las salidas de un parte
         */
        public void ModificarSalidasAdmin (Parte p){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
        for(int x=0;x<p.getSalidasDelParte().size();x++){
            sql = "update salida set horasalida=?, set horallegada=?, set albaran=?,where parte_idparte=? ";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setTime(1,java.sql.Time.valueOf(p.getSalidasDelParte().get(x).getHoraSalida()));// param de entrada    
                llamada.setTime(2,java.sql.Time.valueOf(p.getSalidasDelParte().get(x).getHoraLLegada()));
                llamada.setString(3, p.getSalidasDelParte().get(x).getAlbaran());
                llamada.setInt(4, p.getID());
                
                llamada.executeUpdate(); // ejecutar el procedimiento

            llamada.close();   
            con.close();
        }
        } 
        catch (Exception e) {
            System.out.println(e);

        }
    }
        
        
        
        
        
}
    

