/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 1GLM07
 */
public class Logistica extends Trabajador {
    private Time horas;
    
    private ArrayList<Parte> partes;

    public Logistica() {
    }

    public Logistica(Time horas, ArrayList<Parte> partes, String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String portal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, float salario,java.sql.Date fechaNac, String tipoTrabajador, String Centro_idCentro, String Usuario_idUsuario, String centro) {
        super(dni, nombre, apellidoUno, apellidoDos, calle, portal, piso, mano, telefonoPersonal, telefonoEmpresa, salario, fechaNac, tipoTrabajador, Centro_idCentro, Usuario_idUsuario, centro);
        this.horas = horas;
        this.partes = partes;
    }

    public Time getHoras() {
        return horas;
    }

    public void setHoras(Time horas) {
        this.horas = horas;
    }

    public ArrayList<Parte> getPartes() {
        return partes;
    }

    public void setPartes(ArrayList<Parte> partes) {
        this.partes = partes;
    }
    
    
    public static void cerrarParte(){
        
    }
    
    public static void crearParte(){

    }
 
    public static void corregirAviso(){
        
    }
    
    
    
    
}
