/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

/**
 *
 * @author 1ged02
 */
public class Gasto {
    private float gastoGasoil;
    private float gastoPeaje;
    private float gastoDietas;
    private float otrosGastos;

    public Gasto() {
    }

    public Gasto(float gastoGasoil, float gastoPeaje, float gastoDietas, float otrosGastos) {
        this.gastoGasoil = gastoGasoil;
        this.gastoPeaje = gastoPeaje;
        this.gastoDietas = gastoDietas;
        this.otrosGastos = otrosGastos;
    }

    public float getGastoGasoil() {
        return gastoGasoil;
    }

    public void setGastoGasoil(float gastoGasoil) {
        this.gastoGasoil = gastoGasoil;
    }

    public float getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(float gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public float getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(float gastoDietas) {
        this.gastoDietas = gastoDietas;
    }

    public float getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(float otrosGastos) {
        this.otrosGastos = otrosGastos;
    }
    
    
}
