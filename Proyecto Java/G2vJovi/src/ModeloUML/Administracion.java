/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.util.Date;

/**
 *
 * @author 1gprog02
 */
public class Administracion extends Trabajador{

    public Administracion() {
    }
    public Administracion(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, float salario, Date fechaNac) {
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
    public Administracion(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, float salario, Date fechaNac,Centro centroDelTrabajador) {
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
