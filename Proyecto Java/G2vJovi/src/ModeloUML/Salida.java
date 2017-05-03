/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.util.Date;

/**
 *
 * @author 1ged02
 */
public class Salida {
    private Date horaSalida;
    private Date horaLlegada;
    private String albaran;

    public Salida() {
    }

    public Salida(Date horaSalida, Date horaLlegada, String albaran) {
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.albaran = albaran;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }
    
    
}
