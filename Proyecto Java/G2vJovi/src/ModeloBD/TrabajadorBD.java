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
    public static void main(String[] args) {

    }//de main
    /*Esto sera para buscar por DNI, esta sin acabar
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
                    while(rs.next()){
                        cadena += llamada.getString(2)+"\n";
                    }
                }
                
                
                //cadena = llamada.getString(2);// recupero la cadena
            
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        cerrarConexion(con);
        return cadena;
    }*/

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
                            Logistica tLogis=G2vJovi.trabajadorLogistica();
                            tLogis.setDni(rs.getString("DNI"));
                            tLogis.setNombre(rs.getString("NOMBRE"));
                            tLogis.setApellidoUno(rs.getString("APELLIDOUNO"));
                            tLogis.setApellidoDos(rs.getString("APELLIDODOS"));
                            tLogis.setCalle(rs.getString("CALLE"));
                            tLogis.setPostal(rs.getString("Portal"));
                            tLogis.setPiso(rs.getString("PISO"));
                            tLogis.setMano(rs.getString("MANO"));
                            tLogis.setTelefonoPersonal(rs.getString("TELEFONOPERSONAL"));
                            tLogis.setTelefonoEmpresa(rs.getString("TELEFONOEMPRESA"));
                            tLogis.setSalario(rs.getFloat("SALARIO"));
                            tLogis.setFechaNac(rs.getDate("FECHANAC"));
                            tLogis.setTipoTrabajador(rs.getString("TIPOTRABAJADOR"));
                            tLogis.setEncontrado(true);
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion();
                            tAdmin.setDni(rs.getString("DNI"));
                            tAdmin.setNombre(rs.getString("NOMBRE"));
                            tAdmin.setApellidoUno(rs.getString("APELLIDOUNO"));
                            tAdmin.setApellidoDos(rs.getString("APELLIDODOS"));
                            tAdmin.setCalle(rs.getString("CALLE"));
                            tAdmin.setPostal(rs.getString("Portal"));
                            tAdmin.setPiso(rs.getString("PISO"));
                            tAdmin.setMano(rs.getString("MANO"));
                            tAdmin.setTelefonoPersonal(rs.getString("TELEFONOPERSONAL"));
                            tAdmin.setTelefonoEmpresa(rs.getString("TELEFONOEMPRESA"));
                            tAdmin.setSalario(rs.getFloat("SALARIO"));
                            tAdmin.setFechaNac(rs.getDate("FECHANAC"));
                            tAdmin.setTipoTrabajador(rs.getString("TIPOTRABAJADOR"));
                            tAdmin.setEncontrado(true);
                            listaTrabajadores.add(tAdmin);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
                //cadena = llamada.getString(2);// recupero la cadena
            
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica();
                            tLogis.setDni(rs.getString("DNI"));
                            tLogis.setNombre(rs.getString("NOMBRE"));
                            tLogis.setApellidoUno(rs.getString("APELLIDOUNO"));
                            tLogis.setApellidoDos(rs.getString("APELLIDODOS"));
                            tLogis.setCalle(rs.getString("CALLE"));
                            tLogis.setPostal(rs.getString("Portal"));
                            tLogis.setPiso(rs.getString("PISO"));
                            tLogis.setMano(rs.getString("MANO"));
                            tLogis.setTelefonoPersonal(rs.getString("TELEFONOPERSONAL"));
                            tLogis.setTelefonoEmpresa(rs.getString("TELEFONOEMPRESA"));
                            tLogis.setSalario(rs.getFloat("SALARIO"));
                            tLogis.setFechaNac(rs.getDate("FECHANAC"));
                            tLogis.setTipoTrabajador(rs.getString("TIPOTRABAJADOR"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion();
                            tAdmin.setDni(rs.getString("DNI"));
                            tAdmin.setNombre(rs.getString("NOMBRE"));
                            tAdmin.setApellidoUno(rs.getString("APELLIDOUNO"));
                            tAdmin.setApellidoDos(rs.getString("APELLIDODOS"));
                            tAdmin.setCalle(rs.getString("CALLE"));
                            tAdmin.setPostal(rs.getString("Portal"));
                            tAdmin.setPiso(rs.getString("PISO"));
                            tAdmin.setMano(rs.getString("MANO"));
                            tAdmin.setTelefonoPersonal(rs.getString("TELEFONOPERSONAL"));
                            tAdmin.setTelefonoEmpresa(rs.getString("TELEFONOEMPRESA"));
                            tAdmin.setSalario(rs.getFloat("SALARIO"));
                            tAdmin.setFechaNac(rs.getDate("FECHANAC"));
                            tAdmin.setTipoTrabajador(rs.getString("TIPOTRABAJADOR"));
                            listaTrabajadores.add(tAdmin);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
                
                //cadena = llamada.getString(2);// recupero la cadena
            
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
            sql = "update trabajador set nombre = ?,apellidouno=?,apellidodos=?,calle=?,portal=?,piso=?,mano=?,telefonopersonal=?,telefonoempresa=?,salario=?,tipotrabajador=?, centro_idcentro=(select idcentro from centro where upper(nombre) = ?)where upper(dni)=?";
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
                llamada.setString(11, t.getTipoTrabajador());
                llamada.setString(12, nombreCentro.toUpperCase());
                llamada.setString(13, vdni);
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
    public void insertTrabajador (Trabajador t){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "insert into trabajador (dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,tipotrabajador,centro_idcentro) values(?,?,?,?,?,?,?,?,?,?,?,?,1)";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada
                llamada.setString(1, t.getDni());
                llamada.setString(2, t.getNombre()); // param de entrada    
                llamada.setString(3, t.getApellidoUno());
                llamada.setString(4, t.getApellidoDos());
                llamada.setString(5, t.getCalle());
                llamada.setString(6, t.getPostal());
                llamada.setString(7, t.getPiso());
                llamada.setString(8, t.getMano());
                llamada.setString(9, t.getTelefonoPersonal());
                llamada.setString(10, t.getTelefonoEmpresa());
                llamada.setFloat(11, t.getSalario());
                llamada.setString(12, t.getTipoTrabajador());
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
}
 