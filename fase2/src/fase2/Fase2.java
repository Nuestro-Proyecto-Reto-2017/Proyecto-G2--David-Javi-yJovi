/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import java.sql.*;
import java.util.ArrayList;
import uml.Centro;
import uml.Trabajador;
import uml.Vehiculo;
import vistas.*;
import umlBD.*;

/**
 *
 * @author 1GLM07
 */
public class Fase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
     
     //centros();
    //trabajadores();
    vehiculos();
        
      
    }
    public static void centros(){
         Centros_ventana centro= new Centros_ventana();
        centro.setVisible(true);
        
        
    }
     public static void trabajadores(){
         Trabajador_ventana trab= new Trabajador_ventana();
        trab.setVisible(true);
        
        
    }
      public static void vehiculos(){
         Vehiculo_ventana vehiculo= new Vehiculo_ventana();
        vehiculo.setVisible(true);
        
        
    }
public static void generarCentro(String idCentro,String nombre, String calle,String numero,String codigoPostal, String ciudad,String provincia,String telefono){
         Centro c =new Centro();
         c.setNombre(nombre);
         c.setIdCentro(idCentro);
         c.setCalle(calle);
         c.setCiudad(ciudad);
         c.setCodigoPostal(codigoPostal);
         c.setProvincia(provincia);
         c.setTelefono(telefono);      
         c.setNumero(numero);
         
         CentroBD.anadirCentro(c);
            
        
    }
public static void borrarCentro(String id){
    Centro c1 =new Centro();
    c1.setIdCentro(id);
    CentroBD.borrarCentro(c1);
}
public static void actualizarCentro(String idCentro,String nombre, String calle,String numero,String codigoPostal, String ciudad,String provincia,String telefono){
    Centro c =new Centro();
    c.setIdCentro(idCentro);
    c.setNombre(nombre);
    c.setCalle(calle);
    c.setNumero(numero);
    c.setCodigoPostal(codigoPostal);
    c.setCiudad(ciudad);
    c.setProvincia(provincia);
    c.setTelefono(telefono);
    
    
    CentroBD.actualizarCentro(c);
    
    
}

 public static Centro consultarCentro(String idCentro){
        try{
            
        
      ResultSet x=  CentroBD.cogerDatosCentro(idCentro);
     
     Centro c =new Centro();
     while(x.next()){
      c.setIdCentro(idCentro);
      c.setNombre(x.getString(2));
      
      c.setCalle(x.getString(3));
      c.setNumero(x.getString(4));
      c.setCodigoPostal(x.getString(5));
      c.setCiudad(x.getString(6));
      c.setProvincia(x.getString(7));
      c.setTelefono(x.getString(8));
      
    }
            
             
                    
      
        return c;
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error en la busqueda de datos:"+ e.getMessage()+e.getClass());
            return null;
        }
    }

 
    public static ArrayList rellenarCentros() throws Exception{
        ArrayList idcentros  =  CentroBD.consultarCentros();
        
        
      return idcentros;  
    }
    public static void actualizarTrabajador(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String portal, String piso, String mano, String telpersonal, String telempresa, Float salario, Date sqlFechaNac, String tipo, String centro) {
       
          Trabajador t1 =new Trabajador();
         t1.setDni(dni);
         t1.setNombre(nombre);
         t1.setApellidoUno(apellidoUno);
         t1.setApellidoDos(apellidoDos);
         t1.setCalle(calle);
         t1.setPortal(portal);
         t1.setPiso(piso);
         t1.setMano(mano);
         t1.setTelefonoPersonal(telpersonal);
         t1.setTelefonoEmpresa(telempresa);
         t1.setSalario(salario);
         t1.setFechaNac(sqlFechaNac);
         t1.setTipoTrabajador(tipo);
         t1.setCentro(centro);
         
         AdministracionBD.actualizarTrabajador(t1);
    }
    public static Trabajador consultarTrabajador(String dni){
        try{
            
        
      ResultSet x=  AdministracionBD.cogerDatosTrabajador(dni);
     
     Trabajador t =new Trabajador();
     while(x.next()){
      t.setDni(dni);
        t.setNombre(x.getString(2));
      t.setApellidoUno(x.getString(3));
      t.setApellidoDos(x.getString(4));
      t.setCalle(x.getString(5));
      t.setPortal(x.getString(6));
      t.setPiso(x.getString(7));
      t.setMano(x.getString(8));
      t.setTelefonoPersonal(x.getString(9));
      t.setTelefonoEmpresa(x.getString(10));
      t.setSalario(Float.parseFloat(x.getString(11)));
     // t.setFechaNac(x.getString(12));
      t.setTipoTrabajador(x.getString(13));
      t.setCentro(x.getString(14));}
            
             
                    
      
        return t;
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error en la busqueda de datos:"+ e.getMessage()+e.getClass());
            return null;
        }
    }
    
    
 public static void generarTrabajador(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String portal, String piso, String mano, String telpersonal, String telempresa, Float salario, Date sqlFechaNac, String tipo, String centro) {
        
     Trabajador t =new Trabajador();
         t.setDni(dni);
         t.setNombre(nombre);
         t.setApellidoUno(apellidoUno);
         t.setApellidoDos(apellidoDos);
         t.setCalle(calle);
         t.setPortal(portal);
         t.setPiso(piso);
         t.setMano(mano);
         t.setTelefonoPersonal(telpersonal);
         t.setTelefonoEmpresa(telempresa);
         t.setSalario(salario);
         t.setFechaNac(sqlFechaNac);
         t.setTipoTrabajador(tipo);
         t.setCentro(centro);
         
         AdministracionBD.anadirTrabajador(t);
 }
        
         public static void borrarTrabajador(String dni){
            try{
             Trabajador t2= new Trabajador();
             t2.setDni(dni);
             AdministracionBD.borrarTrabajador(dni);
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null,"error al borrar al trabajador "+ e.getMessage()+e.getClass());
            
            }
             
         }
         
         
         
         
         
         
         
         
         public static void generarVehiculo(String matricula, String marca, String modelo) throws Exception{
         
             try{
             Vehiculo v =new Vehiculo();
             v.setMatricula(matricula);
             v.setMarca(marca);
             v.setModelo(modelo);
             
             VehiculoBD.anadirVehiculo(v);
             
             }
             catch(Exception e){
                 javax.swing.JOptionPane.showMessageDialog(null, "Error al generar vehiculo"+e.getMessage()+e.getClass());
             }
         }

    public static void borrarVehiculo(String matricula) {
        try{
            Vehiculo v2 =new Vehiculo();
            v2.setMatricula(matricula);
            
            VehiculoBD.borrarVehiculo(matricula);
        }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null,"error al borrar vehiculo "+ e.getMessage()+e.getClass());
            
            }
        
    }
    public static String consultarVehiculos(){
        try{
        
 String vehiculos= VehiculoBD.consultarVehiculos();
    
    return vehiculos;
    }catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null,"error en la descompresion de datos "+ e.getClass()+e.getMessage());
    return null;
}      
    }
    public static void actualizarVehiculo(String matricula,String marca, String modelo,String matriculaID){
        Vehiculo v1=new Vehiculo();
        
        v1.setMatricula(matricula);
        v1.setMarca(marca);
        v1.setModelo(modelo);
        
        VehiculoBD.actualizarVehiculo(v1,matriculaID);
        
    }
     public static Vehiculo consultarVehiculo(String matricula)throws Exception{
        Vehiculo v =new Vehiculo();
        
        v= VehiculoBD.buscarVehiculo(matricula);
         
        return v;
     }
    
         }

    

