/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.*;
import g2vjovi.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Jovi
 */
public class ParteBD {
    
    Connection con ;
    public ArrayList consultarPartesJoin (int filasMin,int filasMax){
        
        GenericoBD generico= new GenericoBD();
        String sql = "";
        ArrayList <Parte> listaPartes=new ArrayList();
        try {
            //Obtenemos los códigos y nombres de todos los departamentos
            sql = "{call buscar_partesJoin(?,?,?) } ";
            con=generico.abrirConexion(con);
            
            CallableStatement llamada = con.prepareCall(sql);
            
                // Preparamos la llamada

            llamada.setInt(1, filasMin); // param de entrada
            llamada.setInt(2, filasMax); // param de entrada
            llamada.registerOutParameter(3, OracleTypes.CURSOR); // Cadena devuelta
                
                
                llamada.execute(); // ejecutar el procedimiento
                ResultSet rs = null;
                rs = (ResultSet) llamada.getObject(3);

                
                if(rs.next()){
                    do{
                        if(rs.getString("TIPOTRABAJADOR").compareToIgnoreCase("LOGISTICA")==0){ 
                            Logistica tLogis=G2vJovi.trabajadorLogistica(rs.getString("DNI"),rs.getString("NOMBRE"),rs.getString("APELLIDOUNO"),rs.getString("APELLIDODOS"),rs.getString("CALLE"),rs.getString("Portal"),rs.getString("PISO"),rs.getString("MANO"),rs.getString("TELEFONOPERSONAL"),rs.getString("TELEFONOEMPRESA"),rs.getFloat("SALARIO"),rs.getDate("FECHANAC"));
                            Aviso aAviso = G2vJovi.rellenarAviso(rs.getString("DESCRIPCION"));
                            Vehiculo vVehiculo= G2vJovi.rellenarVehiculo(rs.getString("MATRICULA"),rs.getString("MARCA"),rs.getString("MODELO"));
                            Gasto gGasto = G2vJovi.rellenarGasto(rs.getFloat("GASTOGASOIL"),rs.getFloat("GASTOPEAJES"),rs.getFloat("GASTODIETAS"),rs.getFloat("OTROSGASTOS"));
                            Parte pParte=G2vJovi.rellenarParte(rs.getInt("IDPARTE"),rs.getFloat("KMINICIO"),rs.getFloat("KMFINAL"),rs.getString("TIPOPARTE"),tLogis,vVehiculo,aAviso,gGasto);
                            listaPartes.add(pParte);
                        } 
                    }while(rs.next());
                }
                else{
                    System.out.println("No hay nada");
                }
        llamada.close();    
        con.close();
        } 
        catch (Exception e) {
            System.out.println(e);

        }
        
        return listaPartes;
    }
}
