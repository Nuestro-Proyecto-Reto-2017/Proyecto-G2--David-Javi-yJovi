/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import oracle.jdbc.OracleTypes;
import ModeloUML.*;
import g2vjovi.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author 1gbd02
 */
public class TrabajadorBD extends GenericoBD {
    
    Connection con ;
    //de main
    /*Para buscar por DNI
    public String consultas (String vdni){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        String cadena="";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_dni(?,?) } ";
            con=generico.abrirConexion(con);
            CallableStatement llamada = con.prepareCall(sql);

                // Preparamos la llamada

                llamada.setString(1, vdni); // param de entrada
                llamada.registerOutParameter(2, Types.VARCHAR); // Cadena devuelta
                
                
                
                llamada.execute(); // ejecutar el procedimiento
                final ResultSet rs = llamada.getResultSet();
                if(rs.next()){
                        cadena=llamada.getString(2);
                }
                else cadena=llamada.getString(2);
                
                
                //cadena = llamada.getString(2);// recupero la cadena
            
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        cerrarConexion(con);
        return cadena;
    }
*/
    public ArrayList consultaPk (String vdni){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Trabajador> listaTrabajadores=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_dni_boolean(?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.setString(1, vdni); // param de entrada
            llamada.registerOutParameter(2, OracleTypes.CURSOR); // Cadena devuelta
                
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(2);

                
                if(rs.next()){
                    do{
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tAdmin);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
            
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
        return listaTrabajadores;
}  
    public ArrayList consultaNombre (String vnombre){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Trabajador> listaTrabajadores=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_nombreCursor(?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.setString(1, vnombre); // param de entrada
            llamada.registerOutParameter(2, OracleTypes.CURSOR); // Cadena devuelta
                
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(2);

                
                if(rs.next()){
                    do{
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tAdmin);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
        return listaTrabajadores;
    }
    public ArrayList consultaListaTrab(){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Trabajador> listaTrabajadores=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_todos(?) } ";
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
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tAdmin);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
        return listaTrabajadores;
    }
    public void eliminarTrabajador (String vdni){
       GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "delete from trabajador where upper(dni) = ?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada

                llamada.setString(1, vdni); // param de entrada    
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
    public void updateTrabajador (String vdni,Trabajador t,String nombreCentro){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "update trabajador set nombre = ?,apellidouno=?,apellidodos=?,calle=?,portal=?,piso=?,mano=?,telefonopersonal=?,telefonoempresa=?,salario=?,tipotrabajador=?,fechanac=to_date(?,'dd/mm/yy'), centro_idcentro=(select idcentro from centro where upper(nombre) = ?)where upper(dni)=?";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada
                llamada.setString(1, t.getNombre()); // param de entrada    
                llamada.setString(2, t.getApellidoUno());
                llamada.setString(3, t.getApellidoDos());
                llamada.setString(4, t.getCalle());
                llamada.setString(5, t.getPostal());
                llamada.setString(6, t.getPiso());
                llamada.setString(7, t.getMano());
                llamada.setString(8, t.getTelefonoPersonal());
                llamada.setString(9, t.getTelefonoEmpresa());
                llamada.setFloat(10, t.getSalario());
                if(t.getClass().getSimpleName().compareToIgnoreCase("Administracion")==0){
                    llamada.setString(11, "ADMINISTRACION");
                }
                else{
                    llamada.setString(11, "LOGISTICA");
                }
                java.sql.Date sqlFechaNac = new java.sql.Date(t.getFechaNac().getTime());
                llamada.setDate(12, sqlFechaNac);
                llamada.setString(13, nombreCentro.toUpperCase());
                llamada.setString(14, vdni);
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
    public void insertTrabajador (Trabajador t,String nombreCentro){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "insert into trabajador (dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,tipotrabajador,fechanac,centro_idcentro=(select idcentro from centro where upper(nombre) = ?)) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada
                llamada.setString(1, nombreCentro.toUpperCase());
                llamada.setString(2, t.getDni());
                llamada.setString(3, t.getNombre()); // param de entrada    
                llamada.setString(4, t.getApellidoUno());
                llamada.setString(5, t.getApellidoDos());
                llamada.setString(6, t.getCalle());
                llamada.setString(7, t.getPostal());
                llamada.setString(8, t.getPiso());
                llamada.setString(9, t.getMano());
                llamada.setString(10, t.getTelefonoPersonal());
                llamada.setString(11, t.getTelefonoEmpresa());
                llamada.setFloat(12, t.getSalario());
                if(t.getClass().getSimpleName().compareToIgnoreCase("Administracion")==0){
                    llamada.setString(13, "ADMINISTRACION");
                }
                else{
                    llamada.setString(14, "LOGISTICA");
                }
                java.sql.Date sqlFechaNac = new java.sql.Date(t.getFechaNac().getTime());
                llamada.setDate(15, sqlFechaNac);
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
}
 