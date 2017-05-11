/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public class Gasto {
    /**
    * Esta es nuestra clase Gasto
    */
    private double gastoGasoil;
    private double gastoPeaje;
    private double gastoDietas;
    private double otrosGastos;

    public Gasto() {
    }

    public Gasto(double gastoGasoil, double gastoPeaje, double gastoDietas, double otrosGastos) {
        this.gastoGasoil = gastoGasoil;
        this.gastoPeaje = gastoPeaje;
        this.gastoDietas = gastoDietas;
        this.otrosGastos = otrosGastos;
    }

    public double getGastoGasoil() {
        return gastoGasoil;
    }

    public void setGastoGasoil(double gastoGasoil) {
        this.gastoGasoil = gastoGasoil;
    }

    public double getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(double gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public double getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(double gastoDietas) {
        this.gastoDietas = gastoDietas;
    }

    public double getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(double otrosGastos) {
        this.otrosGastos = otrosGastos;
    }
    
    
}
