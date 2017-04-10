/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase2;

import java.sql.Date;
import uml.Centro;
import vistas.*;

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
        
      //tengo que hacer todos los metodos (estan puestos con void)
        /*        y me queda fijar relaciones entre clases
                        hacer conexion y mirar url en el drive 
cambiar java.util.Date a java.sql.Date*/
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
public static Centro generarCentro(){
         Centro c =new Centro();
         c.setNombre(nombre);
         c.setIdCentro(idCentro);
         c.setCalle(calle);
         c.setCiudad(ciudad);
         c.setCodigoPostal(codigoPostal);
         c.setProvincia(provincia);
         c.setTelefono(telefono);
         

         c.setNumero(numero);
            
        return c;
    }
public static  Trabajador generarTrabajador(){
    
}
}
    

