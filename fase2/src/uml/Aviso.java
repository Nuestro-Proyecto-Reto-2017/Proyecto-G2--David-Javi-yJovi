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
public class Aviso {
    
   private String idAviso;
   private String descripcion;
   
   private Parte parte;
   
    public Aviso() {
    }
   
   

    public Aviso(String idAviso, String descripcion, Parte parte) {
        this.idAviso = idAviso;
        this.descripcion = descripcion;
        this.parte = parte;
        
    }

    public String getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(String idAviso) {
        this.idAviso = idAviso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }
    

   
   
   
}
