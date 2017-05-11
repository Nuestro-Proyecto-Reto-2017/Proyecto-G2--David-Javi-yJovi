package ModeloBD;

import ModeloUML.Trabajador;
import ModeloUML.Usuario;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author 1GLM07
 */
public class UsuarioBD extends GenericoBD {
    
       Connection con ;
       private String IDdni;
       
       /**
        * recoge los datos de la cuenta del trabajador que ha iniciado sesion 
        */
       
  public Usuario consultarTrabajador(String dni)throws Exception{
      GenericoBD generico =new GenericoBD();
  IDdni=dni;
  con=generico.abrirConexion(con);
  PreparedStatement buscarUser=con.prepareStatement("select * from usuario where Trabajador_dni=?");
  buscarUser.setString(1,dni);
  
ResultSet datos=  buscarUser.executeQuery();
Usuario u =new Usuario();
while (datos.next()){//no hace falta repetitiva porque estamos buscando 1 usuario y al ser la tabla de 1 a 1 Trabajador_dni cumple como PK


u.setUsuario(datos.getString(1));
u.setPassword(datos.getString(2));
}
con.close();
      
  return u;
  }     
  
  /**
   * funcion para cambiar la contraseña de el usuario
   * tambien puede cambiar su nombre de usuario con una modificacion en la ventana 
   */
  public int actualizarTrabajador(Usuario u)throws Exception{
  GenericoBD generico =new GenericoBD();
  
  con=generico.abrirConexion(con);
  PreparedStatement actualizarUser=con.prepareStatement("update usuario set usuario=?, contraseña=? where Trabajador_dni=?");
  actualizarUser.setString(1,u.getUsuario());
  actualizarUser.setString(2,u.getPassword());
  actualizarUser.setString(3,IDdni);
  
  
     int x=actualizarUser.executeUpdate();
  
  return x;
  }
    
    
}
