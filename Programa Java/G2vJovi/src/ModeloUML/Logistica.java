/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.util.Date;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public class Logistica extends Trabajador{
    /**
    * Esta es nuestra clase Logistica que hereda de trabajador. 
    * Como trabajador es abstracta los constructores van aquí.
    */
    public Logistica() {
    }
    public Logistica(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, double salario, Date fechaNac) {
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
    public Logistica(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, double salario, Date fechaNac, Centro centroDelTrabajador) {
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
