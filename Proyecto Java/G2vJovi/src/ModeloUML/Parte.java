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
    private int ID;
    private float kmInicio;
    private float kmFinal;
    private String tipoParte;
    private Logistica logistica;
    private ArrayList <Salida> salidasDelParte;
    private Vehiculo vehiculoDelParte;
    private Aviso avisoDelParte;
    private Gasto gastoDelParte;

    public Parte() {
    }

    public Parte(float kmInicio, float kmFinal, String tipoParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
    }

    public Parte(int ID, float kmInicio, float kmFinal, String tipoParte, Logistica logistica, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte) {
        this.ID = ID;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.logistica = logistica;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisoDelParte;
        this.gastoDelParte = gastoDelParte;
    }
    
    public Parte(float kmInicio, float kmFinal, String tipoParte, Logistica logistica, ArrayList<Salida> salidasDelParte, Vehiculo vehiculoDelParte, Aviso avisosDelParte, Gasto gastoDelParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.logistica = logistica;
        this.salidasDelParte = salidasDelParte;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisosDelParte;
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

    public Trabajador getLogistica() {
        return logistica;
    }

    public void setLogistica(Logistica logistica) {
        this.logistica = logistica;
    }

    public Vehiculo getVehiculoDelParte() {
        return vehiculoDelParte;
    }

    public void setVehiculoDelParte(Vehiculo vehiculoDelParte) {
        this.vehiculoDelParte = vehiculoDelParte;
    }

    public Aviso getAvisosDelParte() {
        return avisoDelParte;
    }

    public void setAvisosDelParte(Aviso avisoDelParte) {
        this.avisoDelParte = avisoDelParte;
    }

    public Gasto getGastoDelParte() {
        return gastoDelParte;
    }

    public void setGastoDelParte(Gasto gastoDelParte) {
        this.gastoDelParte = gastoDelParte;
    }
    
    
}
