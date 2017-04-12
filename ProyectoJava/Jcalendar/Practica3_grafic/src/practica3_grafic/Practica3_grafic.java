/*
 La empresa XXXXXXXXXX dispone de una aplicacion con una ventana 
inicial que muestra el logo de la empresa y justo encima aparece un cuadro
de conexion (JDialog)(usuario y contrasena (cuadro de contraseña)) para 
que solo pueda ser utiliza por los trabajadores. Los usuarios haran login y 
se pondran a trabajar.
Si se producen tres fallos de identificacion se mostrar a un mensaje y se 
acabara la ejecucion del proyecto. 
Una vez identificados como usuario valido, se da la bienvenida y entramos
en una ventana principal que contendra un menu con todas las opciones que
hay que desarrollar (Parte de trabajo, perfil y salir). Esta ventana tambien
ofrecera la posibilidad de realizar estas operaciones a traves de una barra
de herramientas.
Desde la opcion perfil los trabajadores podran actualizar sus datos personales 
que son: dni, nombre, apellidos (1 y 2), direccion (calle, portal, piso y mano) 
y telefonos (personal -opcional- y/o movil empresa -obligatorio-), salario -opcional- 
y fecha de nacimiento -opcional-.
*/
package practica3_grafic;

import GUI.*;
import UML.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Practica3_grafic {

    private static Ventrada v1;
    private static Vloggin v2;
    private static Vmenu v3;
    private static Vperfil v4;
    
    private static ArrayList<Trabajador>listaTrabajadores;
    
    
    public static void main(String[] args) {
      
        crearTrabajadoresDeLaEmpresa();
        crearVentanaInicio();
        
        

        
    }
    public static void crearVentanaInicio(){
        
        v1=new Ventrada();
        v1.setVisible(true);
        v2 =new Vloggin(v1, true);
        v2.setVisible(true);
        
 
    }
    public static void crearVentanaMenu(){
        
        v2.dispose();
        v1.dispose();
        v3=new Vmenu();
        v3.setVisible(true);
        
 
    }
    public static void crearVentanaPerfil(){
        
        v3.dispose();
        v4=new Vperfil();
        v4.setVisible(true);
        
        
    }
    public static void crearTrabajadoresDeLaEmpresa(){
        
        
      //public Trabajador(String dni, String nombre, String apellidos, String calle, String portal, String piso, String mano, String telefonoFijo, String telefonoMovil, Double salario, Date fechaDeNacimiento) 
        
       SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
      
       listaTrabajadores= new ArrayList();
       
       String FechaNacimientot1="17/12/1994";
       String FechaNacimientot2="17/5/1994";
       
       Date fct1=null;
       Date fct2=null;
        try {
            fct1 = sdf.parse(FechaNacimientot1);
        } catch (ParseException ex) {
            Logger.getLogger(Practica3_grafic.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fct2 = sdf.parse(FechaNacimientot2);
        } catch (ParseException ex) {
            Logger.getLogger(Practica3_grafic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Trabajador t1=new Trabajador ("12345678A", "Pedro", "Gomez Martin", "Madrid", "1", "4", "D", "945253614", "666333222", 1500.0, fct1);
       Trabajador t2=new Trabajador ("98765412B", "Maria", "Segura Bueno ", "Francia", "12", "2", "I", "945847856", "636987452", 1250.0, fct2);
       
       Usuario u1= new Usuario("Administrador","admin");
       t1.setUsu(u1);
       Usuario u2=new Usuario("Egibide","12345abcde");
       t2.setUsu(u2);

        listaTrabajadores.add(t1);
        listaTrabajadores.add(t2);
           
    }
    public static boolean comprobarLoggin(String us, String contra){
       
        boolean ok=false;
        boolean cortar=false; 
        
        for(int i=0;i<listaTrabajadores.size()&& cortar==false;i++){
            
            if (us.equalsIgnoreCase(listaTrabajadores.get(i).getUsu().getUsuario())&& contra.equals(listaTrabajadores.get(i).getUsu().getContraseña())){

                    cortar=true;
                    ok=true;                   
                }
            }         
        
       return ok;
    }
    public static void trasTresFallos(){
    
    JOptionPane.showMessageDialog(null,"HAS REALIZADO DEMASIADOS INTENTOS, VUELVE A INTENTARLO MAS TARDE");
    System.exit(0);
    
    
}
    public static void cerrarProgrma(){
        
        System.exit(0);
    }
    
}
