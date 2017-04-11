/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.util.Date;

/**
 *
 * @author 1GLM07
 */
public class Trabajador {
    private String dni;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String calle;
    private String portal;
    private String piso;
    private String mano;
    private String telefonoPersonal;
    private String telefonoEmpresa;
    private float salario;
    private java.sql.Date fechaNac;
    private String tipoTrabajador;

    private String centro;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidoUno, String apellidoDos, String calle, String portal, String piso, String mano, String telefonoPersonal, String telefonoEmpresa, float salario, java.sql.Date fechaNac, String tipoTrabajador, String Centro_idCentro, String Usuario_idUsuario, String centro) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.mano = mano;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoEmpresa = telefonoEmpresa;
        this.salario = salario;
        this.fechaNac = fechaNac;
        this.tipoTrabajador = tipoTrabajador;
        this.centro = centro;
    }

    public Trabajador(String dni) {
        this.dni = dni;
    }
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public java.sql.Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(java.sql.Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

  

   
    

   
    
    
    
}
