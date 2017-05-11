
package ModeloUML;


import java.time.LocalTime;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
public class Salida {
    /**
    * Esta es nuestra clase Salida
    */
    private String albaran;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;

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
        return horaLlegada;
    }

    public void setHoraLLegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Salida(String albaran, LocalTime horaSalida, LocalTime horaLlegada) {
        this.albaran = albaran;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    
}
