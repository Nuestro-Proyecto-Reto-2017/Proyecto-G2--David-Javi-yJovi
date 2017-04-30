
package ModeloUML;


import java.time.LocalTime;


public class Salida {
    
    private String albaran;
    private LocalTime horaSalida;
    private LocalTime horaLLegada;

    public Salida() {
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLLegada() {
        return horaLLegada;
    }

    public void setHoraLLegada(LocalTime horaLLegada) {
        this.horaLLegada = horaLLegada;
    }

    public Salida(String albaran, LocalTime horaSalida, LocalTime horaLLegada) {
        this.albaran = albaran;
        this.horaSalida = horaSalida;
        this.horaLLegada = horaLLegada;
    }

    
}
