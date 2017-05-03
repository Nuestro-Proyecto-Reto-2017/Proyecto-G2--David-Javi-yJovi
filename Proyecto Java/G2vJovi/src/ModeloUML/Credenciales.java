/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

/**
 *
 * @author 1GLM07
 */
public class Credenciales {
    private String user;
    private String passw;

    public Credenciales() {
    }

    public Credenciales(String user, String passw) {
        this.user = user;
        this.passw = passw;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
    
    
    
}
