
package ModeloUML;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public class Parte {
    /**
    * Esta es nuestra clase Parte
    */
    private int ID;
    private double kmInicio;
    private double kmFinal;
    private String tipoParte;
    private String incidencias;
    private Logistica logistica;
    private ArrayList <Salida> salidasDelParte;
    private Vehiculo vehiculoDelParte;
    private Aviso avisoDelParte;
    private Gasto gastoDelParte;
    private Date fechaParte;
    

    public Parte() {
    }

    public Parte(double kmInicio, double kmFinal, String tipoParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
    }

    public Parte(int ID, double kmInicio, double kmFinal, String tipoParte,String incidencias, Logistica logistica, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte) {
        this.ID = ID;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.incidencias = incidencias;
        this.logistica = logistica;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisoDelParte;
        this.gastoDelParte = gastoDelParte;
    }

    public Parte(double kmInicio, double kmFinal, String tipoParte, Logistica logistica, ArrayList<Salida> salidasDelParte, Vehiculo vehiculoDelParte, Aviso avisosDelParte, Gasto gastoDelParte) {
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.tipoParte = tipoParte;
        this.logistica = logistica;
        this.salidasDelParte = salidasDelParte;
        this.vehiculoDelParte = vehiculoDelParte;
        this.avisoDelParte = avisosDelParte;
        this.gastoDelParte = gastoDelParte;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }
    
    public ArrayList<Salida> getSalidasDelParte() {
        return salidasDelParte;
    }

    public void setSalidasDelParte(ArrayList<Salida> salidasDelParte) {
        this.salidasDelParte = salidasDelParte;
    }

    public double getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(double kmInicio) {
        this.kmInicio = kmInicio;
    }

    public double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(double kmFinal) {
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

    public Gasto getGastoDelParte() {
        return gastoDelParte;
    }

    public void setGastoDelParte(Gasto gastoDelParte) {
        this.gastoDelParte = gastoDelParte;
    }

    public Aviso getAvisoDelParte() {
        return avisoDelParte;
    }

    public void setAvisoDelParte(Aviso avisoDelParte) {
        this.avisoDelParte = avisoDelParte;
    }

    public Date getFechaParte() {
        return fechaParte;
    }

    public void setFechaParte(Date fechaParte) {
        this.fechaParte = fechaParte;
    }
    

}
