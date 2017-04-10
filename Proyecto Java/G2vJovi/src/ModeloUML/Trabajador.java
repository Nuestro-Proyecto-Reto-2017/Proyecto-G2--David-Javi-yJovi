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
public abstract class Trabajador {
    protected String dni;
    protected String nombre;
    protected String apellidoUno;
    protected String apellidoDos;
    protected String calle;
    protected String postal;
    protected String piso;
    protected String mano;
    protected String telefonoPersonal;
    protected String telefonoEmpresa;
    protected float salario;
    protected Date fechaNac;
    protected String tipoTrabajador;
    protected Centro centroDelTrabajador;
    protected Usuario usuarioDelTrabajador;
    protected boolean estado;
    
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

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Centro getCentroDelTrabajador() {
        return centroDelTrabajador;
    }

    public void setCentroDelTrabajador(Centro centroDelTrabajador) {
        this.centroDelTrabajador = centroDelTrabajador;
    }

    public Usuario getUsuarioDelTrabajador() {
        return usuarioDelTrabajador;
    }

    public void setUsuarioDelTrabajador(Usuario usuarioDelTrabajador) {
        this.usuarioDelTrabajador = usuarioDelTrabajador;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }
    
    public void setEncontrado(boolean estado){
        this.estado = estado;
    }
    public boolean getEncontrado (){
        return estado;
    }

    
    
}
