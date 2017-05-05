
package ModeloUML;


public class Gasto {
   private Float gastoGasoil;
   private Float gastoPeajes;
   private Float gastoDietas;
   private Float otrosGastos;

    public Gasto() {
    }

    public Gasto(Float gastoGasoil, Float gastoPeajes, Float gastoDietas, Float otrosGastos) {
        this.gastoGasoil = gastoGasoil;
        this.gastoPeajes = gastoPeajes;
        this.gastoDietas = gastoDietas;
        this.otrosGastos = otrosGastos;
    }

    public Float getGastoGasoil() {
        return gastoGasoil;
    }

    public void setGastoGasoil(Float gastoGasoil) {
        this.gastoGasoil = gastoGasoil;
    }

    public Float getGastoPeajes() {
        return gastoPeajes;
    }

    public void setGastoPeajes(Float gastoPeajes) {
        this.gastoPeajes = gastoPeajes;
    }

    public Float getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(Float gastoDietas) {
        this.gastoDietas = gastoDietas;
    }

    public Float getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Float otrosGastos) {
        this.otrosGastos = otrosGastos;
    }
      
   
}
