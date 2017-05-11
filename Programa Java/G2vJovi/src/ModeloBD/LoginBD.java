package ModeloBD;

import ModeloUML.Administracion;
import ModeloUML.Usuario;
import ModeloUML.Logistica;
import ModeloUML.Trabajador;
import excepciones.UserNoEncontrado;
import g2vjovi.G2vJovi;
import java.sql.*;
import oracle.jdbc.OracleTypes;
import excepciones.*;
/**
 *
 * @author 1GLM07
 */
public class LoginBD extends GenericoBD{
      Connection con ;
      private Trabajador t1;
      
      /**
       * funcion que comprobara los credenciales de inicio de sesion 
       */
      public Trabajador login(Usuario c)throws Exception{         
           GenericoBD generico= new GenericoBD();
        con=   generico.abrirConexion(con);
           
           String sql="select * from trabajador where dni =(select trabajador_dni from usuario where usuario =? and contraseña=?) ";
          PreparedStatement logn=con.prepareStatement(sql);
          logn.setString(1, c.getUsuario());
          logn.setString(2, c.getPassword());
          
         
          ResultSet datos =logn.executeQuery();
         
               
         
           String tipo="";
          if(datos.next()){
             tipo=  datos.getString("TIPOTRABAJADOR");
          }
          else{
              throw new UserNoEncontrado() ;
          }
          char x =tipo.charAt(0);
          
          switch(x){
              case 'A': t1=recojerAdmin(datos);
              break;
              case 'L':   t1=recojerLogis(datos); 
              break;
          }
               
                            
          
     
        
          con.close();
          return t1;
         }       
      
      /**
       * funcion que identificara al usuario de administracion y recogera sus datos 
       */
       public Administracion recojerAdmin(ResultSet datos)throws Exception{ 
                  Administracion t1 =new Administracion();

                            t1.setDni(datos.getString("DNI"));
                            t1.setNombre(datos.getString("NOMBRE"));
                            t1.setApellidoUno(datos.getString("APELLIDOUNO"));
                            t1.setApellidoDos(datos.getString("APELLIDODOS"));
                            t1.setCalle(datos.getString("CALLE"));
                            t1.setPostal(datos.getString("Portal"));
                            t1.setPiso(datos.getString("PISO"));
                            t1.setMano(datos.getString("MANO"));
                            t1.setTelefonoPersonal(datos.getString("TELEFONOPERSONAL"));
                            t1.setTelefonoEmpresa(datos.getString("TELEFONOEMPRESA"));
                            t1.setSalario(datos.getDouble("SALARIO"));
                            t1.setFechaNac(datos.getDate("FECHANAC"));
         
                            
                            g2vjovi.G2vJovi.abrirVentanaAdministracion();
                            return t1;
      }
    
       /**
       * funcion que identificara al usuario de logistica y recogera sus datos 
       */
        public Logistica recojerLogis (ResultSet datos)throws Exception{ 
        Logistica t1=new Logistica();
                            t1.setDni(datos.getString("DNI"));
                            t1.setNombre(datos.getString("NOMBRE"));
                            t1.setApellidoUno(datos.getString("APELLIDOUNO"));
                            t1.setApellidoDos(datos.getString("APELLIDODOS"));
                            t1.setCalle(datos.getString("CALLE"));
                            t1.setPostal(datos.getString("Portal"));
                            t1.setPiso(datos.getString("PISO"));
                            t1.setMano(datos.getString("MANO"));
                            t1.setTelefonoPersonal(datos.getString("TELEFONOPERSONAL"));
                            t1.setTelefonoEmpresa(datos.getString("TELEFONOEMPRESA"));
                            t1.setSalario(datos.getDouble("SALARIO"));
                            t1.setFechaNac(datos.getDate("FECHANAC"));
                            
                            g2vjovi.G2vJovi.abrirVentanaLogistica();
            return t1;
        }
}
