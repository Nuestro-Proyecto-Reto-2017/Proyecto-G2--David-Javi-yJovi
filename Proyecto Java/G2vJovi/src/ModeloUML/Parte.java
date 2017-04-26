
package ModeloUML;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class Parte {
   private Float kmInicial;
   private Float kmFinal;
   private String tipo;
   private Date fechaDelSistema;
   private Time horasTrabajadas;
   
   private Logistica logistica;
   private ArrayList <Administracion> administradores;
   private Vehiculo vehiculo;
   private ArrayList <Salida> salidas;
   private Gasto gasto;

    public Parte() {
    }

    public Parte(Float kmInicial, Float kmFinal, String tipo, Date fechaDelSistema, Time horasTrabajadas) {
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.tipo = tipo;
        this.fechaDelSistema = fechaDelSistema;
        this.horasTrabajadas = horasTrabajadas;
    }

    public Float getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Float kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Float getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Float kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaDelSistema() {
        return fechaDelSistema;
    }

    public void setFechaDelSistema(Date fechaDelSistema) {
        this.fechaDelSistema = fechaDelSistema;
    }

    public Time getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Time horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Logistica getLogistica() {
        return logistica;
    }

    public void setLogistica(Logistica logistica) {
        this.logistica = logistica;
    }

    public ArrayList<Administracion> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administracion> administradores) {
        this.administradores = administradores;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(ArrayList<Salida> salidas) {
        this.salidas = salidas;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }

   
   
   
   
   
}
