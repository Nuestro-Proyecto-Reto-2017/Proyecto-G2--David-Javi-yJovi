/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.sql.Time;

/**
 *
 * @author 1GLM07
 */
public class Salida {
    private Time horaSalida;
    private Time horaLlegada;
    private String albaran;

    public Salida() {
    }

    public Salida(Time horaSalida, Time horaLlegada, String albaran) {
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.albaran = albaran;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }
    
    public static Time calcularHorasTotal(Time horaSalida, Time horaLlegada){
      Time totalHoras=null;  
       return totalHoras;
    }
    public static Time calcularHorasExtra(){
        Time horasExtra =null;
        return horasExtra;
    }
}
