
package ModeloUML;

import java.sql.Time;


public class Salida {
    private Time horaSalida;
    private Time horaLLegada;

    public Salida() {
    }

    public Salida(Time horaSalida, Time horaLLegada) {
        this.horaSalida = horaSalida;
        this.horaLLegada = horaLLegada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLLegada() {
        return horaLLegada;
    }

    public void setHoraLLegada(Time horaLLegada) {
        this.horaLLegada = horaLLegada;
    }
    
    
}
