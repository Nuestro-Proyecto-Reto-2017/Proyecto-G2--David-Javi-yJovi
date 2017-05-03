/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.util.ArrayList;

/**
 *
 * @author 1ged02
 */
public class Parte {
    private float kmInicio;
    private float kmFinal;
    private String tipoParte;
    private Trabajador trabajadorDelParte;
    private ArrayList <Salida> salidasDelParte;
    private Vehiculo vehiculoDelParte;
    private ArrayList<Aviso> avisosDelParte;
    private Gasto gastoDelParte;

    public Parte() {
    }

    public Parte(float kmInicio, float kmFinal, String tipoParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
    }

    public Parte(float kmInicio, float kmFinal, String tipoParte, Trabajador trabajadorDelParte, ArrayList<Salida> salidasDelParte, Vehiculo vehiculoDelParte, ArrayList<Aviso> avisosDelParte, Gasto gastoDelParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.trabajadorDelParte = trabajadorDelParte;
        this.salidasDelParte = salidasDelParte;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisosDelParte = avisosDelParte;
        this.gastoDelParte = gastoDelParte;
    }

    public ArrayList<Salida> getSalidasDelParte() {
        return salidasDelParte;
    }

    public void setSalidasDelParte(ArrayList<Salida> salidasDelParte) {
        this.salidasDelParte = salidasDelParte;
    }

    

    public float getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(float kmInicio) {
        this.kmInicio = kmInicio;
    }

    public float getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(float kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    public Trabajador getTrabajadorDelParte() {
        return trabajadorDelParte;
    }

    public void setTrabajadorDelParte(Trabajador trabajadorDelParte) {
        this.trabajadorDelParte = trabajadorDelParte;
    }

    public Vehiculo getVehiculoDelParte() {
        return vehiculoDelParte;
    }

    public void setVehiculoDelParte(Vehiculo vehiculoDelParte) {
        this.vehiculoDelParte = vehiculoDelParte;
    }

    public ArrayList<Aviso> getAvisosDelParte() {
        return avisosDelParte;
    }

    public void setAvisosDelParte(ArrayList<Aviso> avisosDelParte) {
        this.avisosDelParte = avisosDelParte;
    }

    public Gasto getGastoDelParte() {
        return gastoDelParte;
    }

    public void setGastoDelParte(Gasto gastoDelParte) {
        this.gastoDelParte = gastoDelParte;
    }
    
    
}
