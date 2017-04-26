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
public class Logistica extends Trabajador{
    
    public Logistica() {
    }
    
    public Logistica(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String postal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, float salario, Date fechaNac, String tipoTrabajador,Centro centroDelTrabajador) {
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
        this.tipoTrabajador= tipoTrabajador;
        this.centroDelTrabajador = centroDelTrabajador;
        
    }
    
}
