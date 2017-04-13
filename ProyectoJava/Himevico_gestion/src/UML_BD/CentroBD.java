
package UML_BD;

import UML.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CentroBD extends GenericoBD {
    
    private  Integer numeCentro;
    private Centro centro;

    public int añadirCentroABD(Centro c) throws SQLException{
        
        String sql="insert into centro (nombre,calle,numero,codigopostal,ciudad,provincia,telefono) values(?,?,?,?,?,?,?)";

        PreparedStatement ps = abrirConexionBD().prepareStatement(sql); 
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getCalle());
        ps.setString(3, c.getNumero());
        ps.setString(4, c.getCodigoPostal());
        ps.setString(5, c.getCiudad());
        ps.setString(6, c.getProvincia());
        ps.setString(7, c.getTelefono());
        
        int filas=ps.executeUpdate();
        
        
        ps.close();
        cerrarConexionBD();
        
        return filas;
        
        
    }
    public Centro buscarCentroEnBD(String nombre) throws SQLException{
        
        String sql="{call obtenerDatosCentro(?,?,?,?,?,?,?,?,?)}";
        
        CallableStatement cst= abrirConexionBD().prepareCall(sql);
        cst.setString(1, nombre);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);
        cst.registerOutParameter(4, java.sql.Types.VARCHAR);
        cst.registerOutParameter(5, java.sql.Types.VARCHAR);
        cst.registerOutParameter(6, java.sql.Types.VARCHAR);
        cst.registerOutParameter(7, java.sql.Types.VARCHAR);
        cst.registerOutParameter(8, java.sql.Types.VARCHAR);
        cst.registerOutParameter(9, java.sql.Types.VARCHAR);
        
        cst.execute();
        
        Centro c = new Centro(cst.getString(3),cst.getString(4),cst.getString(5),cst.getString(6),cst.getString(7),cst.getString(8),cst.getString(9));
        
        numeCentro=cst.getInt(1);
        
        cst.close();
        cerrarConexionBD();
        
        return c;
 
        
    }
    public Centro buscarCentroXid(int id) throws SQLException{
        
        String sql="{call obtenerDatosCentroConDni(?,?,?,?,?,?,?,?,?)}";
        
        CallableStatement cst= abrirConexionBD().prepareCall(sql);
        cst.setInt(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);
        cst.registerOutParameter(4, java.sql.Types.VARCHAR);
        cst.registerOutParameter(5, java.sql.Types.VARCHAR);
        cst.registerOutParameter(6, java.sql.Types.VARCHAR);
        cst.registerOutParameter(7, java.sql.Types.VARCHAR);
        cst.registerOutParameter(8, java.sql.Types.VARCHAR);
        cst.registerOutParameter(9, java.sql.Types.VARCHAR);
        
        cst.execute();
        
        Centro c = new Centro(cst.getString(3),cst.getString(4),cst.getString(5),cst.getString(6),cst.getString(7),cst.getString(8),cst.getString(9));
        
        numeCentro=cst.getInt(1);
        
        cst.close();
        cerrarConexionBD();
        
        return c;
    }
    
    public Integer obteneridCentro(){
        
        Integer id=numeCentro;
        return id;
        
        
    }
    
    public ArrayList<Centro> buscarTodosLosCentros() throws SQLException{
        
        ArrayList<Centro>lista=new ArrayList();
        
        String sql="{call obtenerTodosLosCentros ()}";
        
        CallableStatement cst =abrirConexionBD().prepareCall(sql);
        ResultSet resul=cst.executeQuery();
               
        while(resul.next()){
            
            centro=new Centro();
            centro.setNombre(resul.getString("nombre"));
            centro.setNombre(resul.getString("calle"));
            centro.setNombre(resul.getString("numero"));
            centro.setNombre(resul.getString("codigopostal"));
            centro.setNombre(resul.getString("ciudad"));
            centro.setNombre(resul.getString("provincia"));
            centro.setNombre(resul.getString("telefono"));
            
            lista.add(centro);

        }
        
        cst.close();
        cerrarConexionBD();
        
        return lista;
        
    }
    public boolean borrarCentroDBD() throws SQLException{
         
        boolean borradoOK=false;
        
        String sql="delete from centro where id=?";
        
        PreparedStatement ps=abrirConexionBD().prepareStatement(sql);
        ps.setInt(1, numeCentro);
        
        int fila=ps.executeUpdate();
        
        if (fila>0){
            
            borradoOK=true;
        }    
        
        ps.close();
        cerrarConexionBD();
        
        return borradoOK;
    }
    public boolean modificarCentroDBC(String nom, String calle, String num, String cp, String ciudad, String prov, String tlf) throws SQLException{
        
        boolean updateOK=false;
        
        String sql="update centro set nombre=?, calle=?, numero=?, codigopostal=?,ciudad=?,provincia=?,telefono=? where idcentro=?";
        
        PreparedStatement ps=abrirConexionBD().prepareStatement(sql);
        ps.setString(1, nom);
        ps.setString(2, calle);
        ps.setString(3, num);
        ps.setString(4, cp);
        ps.setString(5, ciudad);
        ps.setString(6, prov);
        ps.setString(7, tlf);
        ps.setInt(8, numeCentro);
        
        int fila=ps.executeUpdate();
        
        if (fila>0){
            
            updateOK=true;
        }    
        
        ps.close();
        cerrarConexionBD();
        
        return updateOK;
        
        
    }
    
}
