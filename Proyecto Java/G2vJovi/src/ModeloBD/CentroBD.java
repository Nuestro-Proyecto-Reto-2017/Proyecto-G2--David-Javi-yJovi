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
import java.sql.Types;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author 1gbd02
 */
public class CentroBD {
    Connection con ;
    public ArrayList consultaCentro (){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Centro> listaCentros=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call gest_centro.visualizar_lista_centro(?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.registerOutParameter(1, OracleTypes.CURSOR); // Cadena devuelta
                
                 
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(1);
                
                if(rs.next()){
                    do{
                        Centro cCentro; 
                        cCentro=G2vJovi.centroC(rs.getString("NOMBRE"),rs.getString("CALLE"),rs.getString("NUMERO"),rs.getString("CODIGOPOSTAL"),rs.getString("CIUDAD"),rs.getString("PROVINCIA"),rs.getString("TELEFONO"));
                        cCentro.setEncontrado(true);
                        listaCentros.add(cCentro);
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
                //cadena = llamada.getString(2);// recupero la cadena
            
            llamada.close(); 
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
        return listaCentros;
}  
    public ArrayList consultaCentroNombre (String vnombreC){
        GenericoBD generico= new GenericoBD();
        String sql;
        Centro cCentro =new Centro();
        ArrayList <Centro> listaCentros=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call gest_centro.visualizar_datos_centro_nombre(?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada
                
                llamada.setString(1, vnombreC);
                llamada.registerOutParameter(2, OracleTypes.CURSOR);
                
                 
                llamada.execute(); // ejecutar el procedimiento
               // ResultSet rs = llamada.getResultSet();
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(2);
                
                while (rs.next()){
                    cCentro=G2vJovi.centroC(rs.getString("NOMBRE"),rs.getString("CALLE"),rs.getString("NUMERO"),rs.getString("CODIGOPOSTAL"),rs.getString("CIUDAD"),rs.getString("PROVINCIA"),rs.getString("TELEFONO"));
                    cCentro.setEncontrado(true);
                    listaCentros.add(cCentro);
                }
                
                //cadena = llamada.getString(2);// recupero la cadena
            
            llamada.close(); 
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }

        return listaCentros;
}  
    public void eliminarCentro (String vnombreC){
       GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "delete from centro where upper(nombre) = ?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setString(1, vnombreC); // param de entrada    
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
    }
    public void updateCentro (String vnombreC,Centro c){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update centro set nombre = ?,calle=?,numero=?,codigopostal=?,ciudad=?,provincia=?,telefono=? where upper(nombre)=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setString(1, c.getNombre()); // param de entrada    
                llamada.setString(2, c.getCalle());
                llamada.setString(3, c.getNumero());
                llamada.setString(4, c.getCodigoPostal());
                llamada.setString(5, c.getCiudad());
                llamada.setString(6, c.getProvincia());
                llamada.setString(7, c.getTelefono());
                llamada.setString(8, vnombreC);
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();   
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
    }
    public void insertCentro (Centro c){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "insert into centro (nombre,calle,numero,codigopostal,ciudad,provincia,telefono) values(?,?,?,?,?,?,?)";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada
                llamada.setString(1, c.getNombre());
                llamada.setString(2, c.getCalle()); // param de entrada    
                llamada.setString(3, c.getNumero());
                llamada.setString(4, c.getCodigoPostal());
                llamada.setString(5, c.getCiudad());
                llamada.setString(6, c.getProvincia());
                llamada.setString(7, c.getTelefono());
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();  
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        } 
    }
    public ArrayList consultaPk (String vnombreC){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Centro> listaCentros=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_nombrec_boolean (?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.setString(1, vnombreC); // param de entrada
            llamada.registerOutParameter(2, OracleTypes.CURSOR); // Cadena devuelta
                
                

                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(2);
                
                if(rs.next()){
                    do{
                        Centro cCentro=G2vJovi.centroC(rs.getString("NOMBRE"),rs.getString("CALLE"),rs.getString("NUMERO"),rs.getString("CODIGOPOSTAL"),rs.getString("CIUDAD"),rs.getString("PROVINCIA"),rs.getString("TELEFONO"));
                        cCentro.setEncontrado(true);
                        listaCentros.add(cCentro);
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
                //cadena = llamada.getString(2);// recupero la cadena
            
            llamada.close(); 
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
        return listaCentros;
}  
}
