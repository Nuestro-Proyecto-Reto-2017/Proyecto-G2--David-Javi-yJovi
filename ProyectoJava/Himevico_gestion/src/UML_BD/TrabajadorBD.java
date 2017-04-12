
package UML_BD;

import UML.Administrador;
import UML.Centro;
import UML.Logistica;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TrabajadorBD extends GenericoBD {
    
    private Logistica logis;
    private Administrador admin;
    
    public boolean registrarTrabajadorLogisticaABD(Logistica log, Integer idc) throws SQLException{
        
        boolean ok=false;
        
        String sql="insert into trabajador values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = abrirConexionBD().prepareStatement(sql); 
        ps.setString(1, log.getDni());
        ps.setString(2, log.getNombre());
        ps.setString(3, log.getPrimerApellido());
        ps.setString(4, log.getSegundoApellido());
        ps.setString(5, log.getCalle());
        ps.setString(6, log.getPortal());
        ps.setString(7, log.getPiso());
        ps.setString(8, log.getMano());
        ps.setString(9, log.getTlfPersonal());
        ps.setString(10, log.getTlfEmpresa());
        ps.setString(11, log.getSalario().toString());
        ps.setString(12, log.getFechaNac().toString());
        ps.setString(13, log.getTipo());
        ps.setInt(14, idc);
       
       
        int filas=ps.executeUpdate();
        
        if(filas>0){
            
            ok=true;
            
        }
        
        ps.close();
        cerrarConexionBD();
        
        
        return ok;
        
    }
    public boolean registrarTrbajadorAdministradorABD(Administrador ad,Integer idc) throws SQLException{
        
        boolean ok=false;
        
        
        java.sql.Date sqlDate = new java.sql.Date(ad.getFechaNac().getTime());
        
        String sql="insert into trabajador values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = abrirConexionBD().prepareStatement(sql); 
        ps.setString(1, ad.getDni());
        ps.setString(2, ad.getNombre());
        ps.setString(3, ad.getPrimerApellido());
        ps.setString(4, ad.getSegundoApellido());
        ps.setString(5, ad.getCalle());
        ps.setString(6, ad.getPortal());
        ps.setString(7, ad.getPiso());
        ps.setString(8, ad.getMano());
        ps.setString(9, ad.getTlfPersonal());
        ps.setString(10,ad.getTlfEmpresa());
        ps.setString(11, ad.getSalario().toString());
        ps.setDate(12, sqlDate);
        ps.setString(13, ad.getTipo());
        ps.setInt(14, idc);
       
        int filas=ps.executeUpdate();
        
        if(filas>0){
            
            ok=true;
            
        }

        ps.close();
        cerrarConexionBD();
        
        return ok;
    
    }
    public void borrarTrabajadorEnBD(String dni) throws SQLException{
           
        String sql="delete from trabajador where dni=?";
        
        PreparedStatement ps=abrirConexionBD().prepareStatement(sql);
        ps.setString(1, dni);
        
        int fila=ps.executeUpdate();
          
        
        ps.close();
        cerrarConexionBD();
        
        
        
    }
    public String buscarTrabajador(String dni) throws SQLException{
        
        String tipo;
        
        String sql="{call obtenerDatosTrabajador(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        CallableStatement cst= abrirConexionBD().prepareCall(sql);
        cst.setString(1, dni);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);
        cst.registerOutParameter(4, java.sql.Types.VARCHAR);
        cst.registerOutParameter(5, java.sql.Types.VARCHAR);
        cst.registerOutParameter(6, java.sql.Types.VARCHAR);
        cst.registerOutParameter(7, java.sql.Types.VARCHAR);
        cst.registerOutParameter(8, java.sql.Types.VARCHAR);
        cst.registerOutParameter(9, java.sql.Types.VARCHAR);
        cst.registerOutParameter(10, java.sql.Types.VARCHAR);
        cst.registerOutParameter(11, java.sql.Types.FLOAT);
        cst.registerOutParameter(12, java.sql.Types.DATE);
        cst.registerOutParameter(13, java.sql.Types.VARCHAR);
        cst.registerOutParameter(14, java.sql.Types.NUMERIC);
        
        CentroBD cbd= new CentroBD();
        Centro c=cbd.buscarCentroXid(cst.getInt(14));

        cst.execute();

        if (cst.getString(13).equalsIgnoreCase("Logistica")){
            
             logis = new Logistica(dni,cst.getString(2),cst.getString(3),cst.getString(4),cst.getString(5)
                                        ,cst.getString(6),cst.getString(7),cst.getString(8),cst.getString(9),cst.getString(10),cst.getFloat(11)
                                        ,cst.getDate(12),cst.getString(13),c);
             tipo="logistica";
            
            
        }else{
            
              admin = new Administrador(dni,cst.getString(2),cst.getString(3),cst.getString(4),cst.getString(5)
                                        ,cst.getString(6),cst.getString(7),cst.getString(8),cst.getString(9),cst.getString(10),cst.getFloat(11)
                                        ,cst.getDate(12),cst.getString(13),c);
              tipo="administrador";
            
        }
        

        cst.close();
        cerrarConexionBD();
 
        return tipo;
    }
    public boolean modificarDatosTrabajadorLogisticaEnBD(Logistica log, Integer idc) throws SQLException{
        
        boolean ok=false;
        
        String sql="update trabajador set nombre=?, apellidouno=?, apellidodos=?, calle=?, portal=?"
                + ",piso=? ,mano=?, telefonopersonal=?,t elefonoEmpresa=?, salario=?, fechanac=?, tipotrabajador=? where centro_idecentro=?";
        
        
        java.sql.Date sqlDate = new java.sql.Date(log.getFechaNac().getTime());
        
        
        PreparedStatement ps = abrirConexionBD().prepareStatement(sql); 
        ps.setString(1, log.getNombre());
        ps.setString(2, log.getPrimerApellido());
        ps.setString(3, log.getSegundoApellido());
        ps.setString(4, log.getCalle());
        ps.setString(5, log.getPortal());
        ps.setString(6, log.getPiso());
        ps.setString(7, log.getMano());
        ps.setString(8, log.getTlfPersonal());
        ps.setString(9, log.getTlfEmpresa());
        ps.setString(10, log.getSalario().toString());
        ps.setDate(11, sqlDate);
        ps.setString(12, log.getTipo());
        ps.setInt(13, idc);
       
       
        int filas=ps.executeUpdate();
        
        if(filas>0){
            
            ok=true;
            
        }
        
        ps.close();
        cerrarConexionBD();
        
        
        return ok;
        
    }
    public boolean modificarDatosTrabajadorAdministrador(Administrador ad,Integer idc) throws SQLException{
        
        boolean ok=false;
        
        String sql="update trabajador set nombre=?, apellidouno=?, apellidodos=?, calle=?, portal=?"
                + ",piso=? ,mano=?, telefonopersonal=?,t elefonoEmpresa=?, salario=?, fechanac=?, tipotrabajador=?,where centro_idecentro=?";
        
        java.sql.Date sqlDate = new java.sql.Date(ad.getFechaNac().getTime());
        
        PreparedStatement ps = abrirConexionBD().prepareStatement(sql); 
        ps.setString(1, ad.getNombre());
        ps.setString(2, ad.getPrimerApellido());
        ps.setString(3, ad.getSegundoApellido());
        ps.setString(4, ad.getCalle());
        ps.setString(5, ad.getPortal());
        ps.setString(6, ad.getPiso());
        ps.setString(7, ad.getMano());
        ps.setString(8, ad.getTlfPersonal());
        ps.setString(9, ad.getTlfEmpresa());
        ps.setString(10, ad.getSalario().toString());
        ps.setDate(11, sqlDate);
        ps.setString(12, ad.getTipo());
        ps.setInt(13, idc);
       
       
        int filas=ps.executeUpdate();
        
        if(filas>0){
            
            ok=true;
            
        }
        
        ps.close();
        cerrarConexionBD();
        
        
        return ok;
 
    }
    public Logistica obtenerObjLogistica(){
        
        return logis;
        
    }
    public Administrador obtenerObjadministrador(){
        
        return admin;
        
    }
}
