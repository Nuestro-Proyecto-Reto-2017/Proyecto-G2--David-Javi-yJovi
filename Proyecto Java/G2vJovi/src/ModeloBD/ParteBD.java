/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.*;
import g2vjovi.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Jovi
 */
public class ParteBD {
    
    Connection con ;
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            Aviso aAviso = G2vJovi.rellenarAviso(rs.getString("DESCRIPCION"));
                            Vehiculo vVehiculo= G2vJovi.rellenarVehiculo(rs.getString("MATRICULA"),rs.getString("MARCA"),rs.getString("MODELO"));
                            Gasto gGasto = G2vJovi.rellenarGasto(rs.getFloat("GASTOGASOIL"),rs.getFloat("GASTOPEAJES"),rs.getFloat("GASTODIETAS"),rs.getFloat("OTROSGASTOS"));
                            Parte pParte=G2vJovi.rellenarParte(rs.getInt("IDPARTE"),rs.getFloat("KMINICIO"),rs.getFloat("KMFINAL"),rs.getString("TIPOPARTE"),rs.getString("INCIDENCIAS"),tLogis,vVehiculo,aAviso,gGasto);
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            Aviso aAviso = G2vJovi.rellenarAviso(rs.getString("DESCRIPCION"));
                            Vehiculo vVehiculo= G2vJovi.rellenarVehiculo(rs.getString("MATRICULA"),rs.getString("MARCA"),rs.getString("MODELO"));
                            Gasto gGasto = G2vJovi.rellenarGasto(rs.getFloat("GASTOGASOIL"),rs.getFloat("GASTOPEAJES"),rs.getFloat("GASTODIETAS"),rs.getFloat("OTROSGASTOS"));
                            Parte pParte=G2vJovi.rellenarParte(rs.getInt("IDPARTE"),rs.getFloat("KMINICIO"),rs.getFloat("KMFINAL"),rs.getString("TIPOPARTE"),rs.getString("INCIDENCIAS"),tLogis,vVehiculo,aAviso,gGasto);
                            listaSalidas=consultarSalidasParte(pParte.getID());
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
}

import java.sql.Date;
import javax.swing.JOptionPane;
    public void registrarParteEBD(Float kmi,Float kmf,String tipoparte,String logistica ,String matricula,String observaciones,String avis_descripcion,Float gastoG,Float gastoP,Float gastoD,Float ogastos,Date fechaParte){
    }
    
            con.close();
    
            cst.execute();
        
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON EL REGISTRO DE PARTE "+ e.getClass()+ " " + e.getMessage());
        } catch (Exception e) {
        }
            

            cst.close();
         
            
            cst.setDate(12, fechaParte);
            cst.setFloat(10, gastoD);
            cst.setFloat(11, ogastos);
            cst.setFloat(9,gastoP);
            cst.setString(7,avis_descripcion);
            cst.setFloat(8,gastoG);
            cst.setString(6, observaciones);
            cst.setString(4,logistica);
            cst.setString(5, matricula);
            cst.setString(3, tipoparte);
            cst.setFloat(1, kmi);
            cst.setFloat(2, kmf);
            CallableStatement cst =con.prepareCall(sql);
            
        
        try {
        String sql="{call registrar_parte(?,?,?,?,?,?,?,?,?,?,?,?)}";
        GenericoBD gbd=new GenericoBD();
        con=gbd.abrirConexion(con);
        