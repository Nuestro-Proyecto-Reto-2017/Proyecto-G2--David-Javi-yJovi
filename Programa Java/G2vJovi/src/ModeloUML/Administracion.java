package ModeloUML;

import java.util.Date;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public class Administracion extends Trabajador{

    /**
    * Esta es nuestra clase administracion que hereda de trabajador. 
    * Como trabajador es abstracta los constructores van aquí.
    */
    public Administracion() {
    }
    public Administracion(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, double salario, Date fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.calle = calle;
        this.postal = postal;
        this.piso = piso;
        this.mano = mano;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoEmpresa = telefonoEmpresa;
        this.salario = salario;
        this.fechaNac = fechaNac;
    }
    public Administracion(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, double salario, Date fechaNac,Centro centroDelTrabajador) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.calle = calle;
        this.postal = postal;
        this.piso = piso;
        this.mano = mano;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoEmpresa = telefonoEmpresa;
        this.salario = salario;
        this.fechaNac = fechaNac;
        this.centroDelTrabajador = centroDelTrabajador; 
    }
    
}
