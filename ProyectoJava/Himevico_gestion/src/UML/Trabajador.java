
package UML;

import java.util.Date;


public abstract class Trabajador {
    protected String dni;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String calle; 
    protected String portal; 
    protected String piso; 
    protected String mano;
    protected String tlfPersonal;
    protected String tlfEmpresa;
    protected Float salario;
    protected Date fechaNac;
    protected String tipo;
    
    protected Centro centro;

    public String getDni() {
        return dni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public String getTlfPersonal() {
        return tlfPersonal;
    }

    public void setTlfPersonal(String tlfPersonal) {
        this.tlfPersonal = tlfPersonal;
    }

    public String getTlfEmpresa() {
        return tlfEmpresa;
    }

    public void setTlfEmpresa(String tlfEmpresa) {
        this.tlfEmpresa = tlfEmpresa;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

   
    
    
       
       
       
       
}
