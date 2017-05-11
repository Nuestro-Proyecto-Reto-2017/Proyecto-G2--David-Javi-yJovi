package ModeloBD;

import ModeloUML.*;
import g2vjovi.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Jovi
 */
public class ParteBD {
    private G2vJovi main =new G2vJovi();
    Connection con ;
    
    /**
     * consulta que se raliza para la venta de validar partes 
     */
    public ArrayList consultarPartesJoin (int filasMin,int filasMax){
        
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Parte> listaPartes=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{call buscar_partesJoin(?,?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.setInt(1, filasMin); // param de entrada
            llamada.setInt(2, filasMax); // param de entrada
            llamada.registerOutParameter(3, OracleTypes.CURSOR); // Cadena devuelta
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(3);

                
                if(rs.next()){
                    do{
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
                            Aviso aAviso = G2vJovi.rellenarAviso(rs.getString("DESCRIPCION"));
                            Vehiculo vVehiculo= G2vJovi.rellenarVehiculo(rs.getString("MATRICULA"),rs.getString("MARCA"),rs.getString("MODELO"));
                            Gasto gGasto = G2vJovi.rellenarGasto(rs.getDouble("GASTOGASOIL"),rs.getDouble("GASTOPEAJES"),rs.getDouble("GASTODIETAS"),rs.getDouble("OTROSGASTOS"));
                            Parte pParte=G2vJovi.rellenarParte(rs.getInt("IDPARTE"),rs.getDouble("KMINICIO"),rs.getDouble("KMFINAL"),rs.getString("TIPOPARTE"),rs.getString("INCIDENCIAS"),tLogis,vVehiculo,aAviso,gGasto);
                            listaPartes.add(pParte);
                        } 
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
        
        return listaPartes;
    }
    /**
     * consulta que se realiza para generar la estructura de datos necesaria para generar el informe
     */
    public ArrayList consultarPartesMensuales (){
        
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Parte> listaPartes=new ArrayList();
        ArrayList <Salida> listaSalidas=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{call buscar_partesMensualesJoin(?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada


            llamada.registerOutParameter(1, OracleTypes.CURSOR); // Cadena devuelta
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(1);

                
                if(rs.next()){
                    do{
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
                            Aviso aAviso = G2vJovi.rellenarAviso(rs.getString("DESCRIPCION"));
                            Vehiculo vVehiculo= G2vJovi.rellenarVehiculo(rs.getString("MATRICULA"),rs.getString("MARCA"),rs.getString("MODELO"));
                            Gasto gGasto = G2vJovi.rellenarGasto(rs.getDouble("GASTOGASOIL"),rs.getDouble("GASTOPEAJES"),rs.getDouble("GASTODIETAS"),rs.getDouble("OTROSGASTOS"));
                            Parte pParte=G2vJovi.rellenarParte(rs.getInt("IDPARTE"),rs.getDouble("KMINICIO"),rs.getDouble("KMFINAL"),rs.getString("TIPOPARTE"),rs.getString("INCIDENCIAS"),tLogis,vVehiculo,aAviso,gGasto);
                            listaSalidas=main.procConsultarSalidasParte(pParte.getID());
                            pParte.setSalidasDelParte(listaSalidas);
                            listaPartes.add(pParte);
                        } 
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
        
        return listaPartes;
    }
/**
 * corrige y ejecuta los cambios realizados por un admin sobre los partes y lo actualiza en BD 
 */
    public void updateParteRevisado (int vIdParte){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update parte set tipoparte = 'R' where idparte=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setInt(1, vIdParte); // param de entrada    

                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
    }
    /**
     * funcion que borrara un parte sin revisar
     */
    public void deleteParteSinRevisar (int vIdParte){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "delete from parte where idparte = ?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setInt(1, vIdParte); // param de entrada    

                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }  
    }
    /**
     * funcion que guardara el registro del parte en la BD
     */
	public void registrarParteEBD(Double kmi,Double kmf,String tipoparte,String logistica ,String matricula,String observaciones,String avis_descripcion,Double gastoG,Double gastoP,Double gastoD,Double ogastos,Date fechaParte){
        
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        String sql="{call registrar_parte(?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try {
            
            CallableStatement cst =con.prepareCall(sql);
            cst.setDouble(1, kmi);
            cst.setDouble(2, kmf);
            cst.setString(3, tipoparte);
            cst.setString(4,logistica);
            cst.setString(5, matricula);
            cst.setString(6, observaciones);
            cst.setString(7,avis_descripcion);
            cst.setDouble(8,gastoG);
            cst.setDouble(9,gastoP);
            cst.setDouble(10, gastoD);
            cst.setDouble(11, ogastos);
            java.sql.Date sqlFechaParte = new java.sql.Date(fechaParte.getTime());
            cst.setDate(12, sqlFechaParte);
          
            
            cst.execute();
            
         
            cst.close();
            con.close();

        } catch (Exception e) {
            
            javax.swing.JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE PARTE "+ e.getClass()+ " " + e.getMessage());
        }
        
    }
        
        /**
         * funcion que almacenara los datos no guardados en la BD para mostrarlos en el proximo parte y guardar el progreso en el rellenado del mismo 
         */
        public int registrarParteBasuraEBD(Double kmi,Double kmf,String tipoparte,String logistica ,String matricula,String observaciones,String avis_descripcion,Double gastoG,Double gastoP,Double gastoD,Double ogastos,Date fechaParte){
        
        GenericoBD gbd=new GenericoBD();
        int idParte=0;
        con=gbd.abrirConexion(con);
        String sql="{call insertar_parteb(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try {
            
            CallableStatement cst =con.prepareCall(sql);
            cst.setDouble(1, kmi);
            cst.setDouble(2, kmf);
            cst.setString(3, tipoparte);
            cst.setString(4,logistica);
            cst.setString(5, matricula);
            cst.setString(6, observaciones);
            cst.setString(7,avis_descripcion);
            cst.setDouble(8,gastoG);
            cst.setDouble(9,gastoP);
            cst.setDouble(10, gastoD);
            cst.setDouble(11, ogastos);
            java.sql.Date sqlFechaParte = new java.sql.Date(fechaParte.getTime());
            cst.setDate(12, sqlFechaParte);
            cst.registerOutParameter(13, Types.NUMERIC);
            
            cst.execute();
            idParte=cst.getInt(13);
            cst.close();
            con.close();

        } catch (Exception e) {
            
            javax.swing.JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE PARTE "+ e.getClass()+ " " + e.getMessage());
        }
        return idParte;
        
    }
        /**
         * funcion para corregir el Parte por un admin 
         */
    public void ModificarParteAdmin (Parte p){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update parte set kminicio=?, set kmfinal=?, set creado=?, set vehiculo_matricula=?, set incidencias=? where idparte=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setDouble(1, p.getKmInicio()); // param de entrada    
                llamada.setDouble(2, p.getKmFinal());
                llamada.setString(3, p.getLogistica().getDni());
                llamada.setString(4, p.getVehiculoDelParte().getMatricula());
                llamada.setString(5, p.getIncidencias());
                llamada.setInt(6, p.getID());
                
                llamada.executeUpdate(); // ejecutar el procedimiento
   
            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
    }
	
}
