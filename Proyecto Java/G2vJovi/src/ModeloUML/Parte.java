
package ModeloUML;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;


public class Parte {
   private int id;
   private Float kmInicio;
   private Float kmFinal;
   private String tipoParte;

   private Logistica logistica;
   private ArrayList <Salida> salidasDelParte;
   private Vehiculo vehiculoDelParte;
   private Aviso avisoDelParte;
   private Gasto gastoDelParte;
   
   private Date fechaDelSistema;
   private LocalTime horasTrabajadas;
   

    public Parte() {
    }

    public Parte(Float kmInicio, Float kmFinal, String tipoParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
    }

    public Parte(int id, Float kmInicio, Float kmFinal, String tipoParte, Logistica logistica, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte) {
        this.id = id;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.logistica = logistica;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisoDelParte;
        this.gastoDelParte = gastoDelParte;
    }

    public Parte(Float kmInicio, Float kmFinal, String tipoParte, Logistica logistica, ArrayList<Salida> salidasDelParte, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.logistica = logistica;
        this.salidasDelParte = salidasDelParte;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisoDelParte;
        this.gastoDelParte = gastoDelParte;
    }

    public Float getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(Float kmInicio) {
        this.kmInicio = kmInicio;
    }

    public Float getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Float kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    public Logistica getLogistica() {
        return logistica;
    }

    public void setLogistica(Logistica logistica) {
        this.logistica = logistica;
    }

    public ArrayList<Salida> getSalidasDelParte() {
        return salidasDelParte;
    }

    public void setSalidasDelParte(ArrayList<Salida> salidasDelParte) {
        this.salidasDelParte = salidasDelParte;
    }

    public Vehiculo getVehiculoDelParte() {
        return vehiculoDelParte;
    }

    public void setVehiculoDelParte(Vehiculo vehiculoDelParte) {
        this.vehiculoDelParte = vehiculoDelParte;
    }

    public Aviso getAvisoDelParte() {
        return avisoDelParte;
    }

    public void setAvisoDelParte(Aviso avisoDelParte) {
        this.avisoDelParte = avisoDelParte;
    }

    public Gasto getGastoDelParte() {
        return gastoDelParte;
    }

    public void setGastoDelParte(Gasto gastoDelParte) {
        this.gastoDelParte = gastoDelParte;
    }

  
    

 


   
}
