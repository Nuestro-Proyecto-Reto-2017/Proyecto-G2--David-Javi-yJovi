/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

/**
 *
 * @author 1GLM07
 */
public class Usuario {
    
  
    private String usuario;
    private String contraseña;
   
    private Trabajador trabajador;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, Trabajador trabajador) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.trabajador = trabajador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
    
}
