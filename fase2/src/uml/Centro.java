/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.util.ArrayList;

/**
 *
 * @author 1GLM07
 */
public class Centro {
    
    //Atributos
    private String idCentro;
    private String nombre;
    private String calle;
    private String numero;
    private String codigoPostal;
    private String ciudad;
    private String provincia;
    private String telefono;
    
    //Relaciones
    private ArrayList<Trabajador>aTrabajadores;

    public Centro() {
    }

    public Centro(String idCentro, String nombre, String calle, String numero, String codigoPostal, String ciudad, String provincia, String telefono, ArrayList<Trabajador> aTrabajadores) {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.aTrabajadores = aTrabajadores;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Trabajador> getaTrabajadores() {
        return aTrabajadores;
    }

    public void setaTrabajadores(ArrayList<Trabajador> aTrabajadores) {
        this.aTrabajadores = aTrabajadores;
    }
    
    
    

    
    
    
    
    
    
}
