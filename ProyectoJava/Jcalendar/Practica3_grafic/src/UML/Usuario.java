/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 *
 * @author pcwin
 */
public class Usuario {
    
    private String nomUsuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña) {
        this.nomUsuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return nomUsuario;
    }

    public void setUsuario(String usuario) {
        this.nomUsuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
