
package ModeloUML;

import java.util.Date;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public abstract class Trabajador {
    /**
    * Esta es nuestra clase Trabajador, es abstracta por lo que no tiene constructores, pero si tiene getter y setter de los atributos
    * Los atributos van en protected porque si no las clases hijas no pueden crear los constructores
    * Se podria hacer con private y que las clases hijas en el constructor hagan sets al atributo de la clase padre como vimos en clase.
    */
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
    protected double salario;
    protected Date fechaNac;
    protected Centro centroDelTrabajador;
    protected Usuario usuarioDelTrabajador;
    
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
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


    
    
}
