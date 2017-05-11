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
    //Para buscar por DNI
    /**
     * funcion para buscar que buscara los datos de un trabajador identificado por su dni 
     */
    public ArrayList consultas (String vdni){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Trabajador> listaTrabajadores=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{ call buscar_dni(?,?,?,?,?,?,?,?,?,?,?,?,?,?) } ";
            con=generico.abrirConexion(con);
            CallableStatement llamada = con.prepareCall(sql);

                // Preparamos la llamada

                llamada.setString(1, vdni); // param de entrada
                llamada.registerOutParameter(2, Types.VARCHAR);// Cadena devuelta
                llamada.registerOutParameter(3, Types.VARCHAR);
                llamada.registerOutParameter(4, Types.VARCHAR);
                llamada.registerOutParameter(5, Types.VARCHAR);
                llamada.registerOutParameter(6, Types.VARCHAR);
                llamada.registerOutParameter(7, Types.VARCHAR);
                llamada.registerOutParameter(8, Types.VARCHAR);
                llamada.registerOutParameter(9, Types.VARCHAR);
                llamada.registerOutParameter(10, Types.VARCHAR);
                llamada.registerOutParameter(11, Types.VARCHAR);
                llamada.registerOutParameter(12, Types.VARCHAR);
                llamada.registerOutParameter(13, Types.FLOAT);
                llamada.registerOutParameter(14, Types.DATE);

                llamada.execute(); // ejecutar el procedimiento
                        if(llamada.getString(2).compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(llamada.getString(3),
                                    llamada.getString(4),
                                    llamada.getString(5),
                                    llamada.getString(6),
                                    llamada.getString(7),
                                    llamada.getString(8),
                                    llamada.getString(9),
                                    llamada.getString(10),
                                    llamada.getString(11),
                                    llamada.getString(12),
                                    llamada.getDouble(13),
                                    llamada.getDate(14));
                                    listaTrabajadores.add(tLogis);

                        } 
                        if(llamada.getString(2).compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(llamada.getString(3),
                                    llamada.getString(4),
                                    llamada.getString(5),
                                    llamada.getString(6),
                                    llamada.getString(7),
                                    llamada.getString(8),
                                    llamada.getString(9),
                                    llamada.getString(10),
                                    llamada.getString(11),
                                    llamada.getString(12),
                                    llamada.getDouble(13),
                                    llamada.getDate(14));
                                    listaTrabajadores.add(tAdmin);
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
    /**
     * funcion para buscar que buscara los datos de un trabajador identificado por su dni 
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
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
    /**
     * recoger los datos del trabajador buscado por su nombre 
     */
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
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
    /**
     * recoger los datos de todos los trabajadores
     */
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
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
                            listaTrabajadores.add(tLogis);
                        } 
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("ADMINISTRACION")==0){ 
                            Administracion tAdmin=G2vJovi.trabajadorAdministracion(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getDouble("SALARIO"),rs.getDate("FECHANAC"));
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
    /**
     * funcion para borrar de la BD los datos de un trabajador 
     */
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
    
    /**
     * funcion para modificar de la BD los datos de un trabajador 
     */
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
                llamada.setDouble(10, t.getSalario());
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
    
    /**
     * funcion para dar de alta un trabajador 
     */
    public void insertTrabajador (Trabajador t,String nombreCentro){
        GenericoBD generico= new GenericoBD();
        String sql = "";
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "insert into trabajador (dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,tipotrabajador,fechanac,centro_idcentro) values(?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yy'),(select idcentro from centro where upper(nombre) = ?))";
            con=generico.abrirConexion(con);
            PreparedStatement llamada = con.prepareStatement(sql);

                // Preparamos la llamada
                llamada.setString(14, nombreCentro.toUpperCase());
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
                llamada.setDouble(11, t.getSalario());
                if(t.getClass().getSimpleName().compareToIgnoreCase("Administracion")==0){
                    llamada.setString(12, "ADMINISTRACION");
                }
                else{
                    llamada.setString(12, "LOGISTICA");
                }
                java.sql.Date sqlFechaNac = new java.sql.Date(t.getFechaNac().getTime());
                llamada.setDate(13, sqlFechaNac);
                
                
                llamada.executeUpdate(); // ejecutar el procedimiento


                
            llamada.close();    
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        cerrarConexion(con);
    }
}
 