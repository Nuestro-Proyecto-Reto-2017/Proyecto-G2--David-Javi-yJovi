
package UML;

import java.util.Date;


public class Administrador extends Trabajador {
    
     public Administrador() {
    }
    
     public Administrador(String dni, String nombre, String primerApellido, String segundoApellido, String calle, String portal, String piso, String mano, String tlfPersonal, String tlfEmpresa, Float salario, Date fechaNac, String tipo, Centro centro) {
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.mano = mano;
        this.tlfPersonal = tlfPersonal;
        this.tlfEmpresa = tlfEmpresa;
        this.salario = salario;
        this.fechaNac = fechaNac;
        this.tipo=tipo;
        this.centro=centro;
    }
  
    
}
