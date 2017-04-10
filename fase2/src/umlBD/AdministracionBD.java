/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umlBD;

import java.sql.*;
import uml.*;
import umlBD.*;



/**
 *
 * @author 1GLM07
 */
public class AdministracionBD {
  Connection con=conexionBD.conectar();
conexionBD c=new conexionBD();
    public  void anadirVehiculo(Vehiculo v) throws Exception {
      
        
        PreparedStatement insertVehiculo = c.conectar().prepareStatement("insert into vehiculo values (?,?,?)");
        insertVehiculo.setString(1, v.getMatricula());
        insertVehiculo.setString(2, v.getMarca());
        insertVehiculo.setString(3, v.getModelo());
        int fila=insertVehiculo.executeUpdate();
        con.close();
    }

    public static  void borrarVehiculo(String matricula) throws Exception {
        
      /*  PreparedStatement insertVehiculo = c.conectar().prepareStatement("delete from vehiculo where matricula=?");
        insertVehiculo.setString(1, matricula);
        insertVehiculo.executeUpdate();
        c.dc();*/
    }

    public void anadirUsuario() {

    }

    public  void borrarUsuario() {

    }

    public void guardarParte() {

    }

    public  void revisarParte() {

    }

    public static void anadirCentro(Centro c) {
        try{
        conexionBD.conectar();
        PreparedStatement insertCentro = conexionBD.conectar().prepareStatement("insert into centro values(?,?,?");
        insertCentro.setString(1, c.getIdCentro());
        insertCentro.setString(2, c.getNombre());
        insertCentro.setString(3, c.getCalle());
        insertCentro.setString(4, c.getNumero());
        insertCentro.setString(5, c.getCodigoPostal());
        insertCentro.setString(6, c.getCiudad());
        insertCentro.setString(7, c.getProvincia());
        insertCentro.setString(8, c.getTelefono());
        insertCentro.executeUpdate();
        conexionBD.dc();
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error al insertar centro: "+ e.getClass()+e.getMessage());
        }
    }

    public static void borrarCentro(String id) throws Exception {
      /*  conexionBD.conectar();
        PreparedStatement deleteCentro = conexionBD.con.prepareStatement("delete from centro where idcentro=?");
        deleteCentro.setString(1, id);
        deleteCentro.executeUpdate();
        conexionBD.dc();*/

    }

    public  void visualizarParte() {

    }

    public  void generarInforme() {

    }

    public static  void anadirTrabajador(String dni, String nombre, String apellidouno, String apellidodos,
            String calle, String portal, String piso,String provincia, String mano, String telefonopersonal, String telefonoempresa,
            Float salario, Date fechanac, String tipotrabajador, String centro_idcentro) {/*
        try {
            conexionBD.conectar();
            
            PreparedStatement insertTrabajador = conexionBD.con.prepareStatement("insert into trabajador values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertTrabajador.setString(1, dni);
            insertTrabajador.setString(2, nombre);
            insertTrabajador.setString(3, apellidouno);
            insertTrabajador.setString(4, apellidodos);
            
            insertTrabajador.setString(5, calle);
            insertTrabajador.setString(6, portal);
            insertTrabajador.setString(7, piso);
            insertTrabajador.setString(8, mano);
            
            insertTrabajador.setString(9, telefonopersonal);
            insertTrabajador.setString(10, telefonoempresa);
            
            insertTrabajador.setFloat(11, salario);
            
             insertTrabajador.setDate(1, fechanac);
            
            insertTrabajador.setString(13, tipotrabajador);
            insertTrabajador.setString(14, centro_idcentro);

            insertTrabajador.executeUpdate();
            
            conexionBD.dc();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error en el alta: " + e.getMessage());
        }
*/
    }

    public static void borrarTrabajador(String dni) throws Exception {
       conexionBD.conectar();
        PreparedStatement deleteTrabajador = conexionBD.conectar().prepareStatement("delete from trabajador where dni=?");
        deleteTrabajador.setString(1, dni);
        
        deleteTrabajador.executeUpdate();
        conexionBD.dc();

    }

    public static  void actualizarTrabajador() {

    }
}
