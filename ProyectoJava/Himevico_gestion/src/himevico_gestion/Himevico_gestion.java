/*
 ----- PROYECTO FINAL 2017 -----
     -- CURSO 141GA DAW --

 Se nos pide desarrollar una aplicación de gestión interna para una empresa

 Desarrollado por el grupo 2 (JOVI, JAVIER, DAVID)

 */
package himevico_gestion;

import UML.*;
import UML_BD.*;
import GUI.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Himevico_gestion {

    private static Ventrada v1;
    private static Vloggin v2;
    private static VAdministrador v3;
    private static VLogistica v4;
    private static Vparte v5;
    private static VgestionCentros v6;
    private static VseleccionDeCentro v7;
    private static VgestionTrabajadores v8;
    private static CentroBD cen;
    private static TrabajadorBD trbd;
    private static ArrayList<Centro>listaC;
    
    public static void main(String[] args) {
       //crearVgestionCentros();
       crearVgestionTrabajadores();
        
    }
public static void crearVentanaDeEntrada(){
        v1=new Ventrada();
        v1.setVisible(true);
          
}
public static void crearVentanaLoggin(){
        v1.setVisible(false);
        v2=new Vloggin();
        v2.setVisible(true);

}
public static void cerrarVentanaLoggin(){
    v2.dispose();
    v1.setVisible(true);
    
    
}
public static void crarVentanaAdmin(){
        v3=new VAdministrador();
        v3.setVisible(true);
        v3.setExtendedState(6);
}
public static void crearVentanaLogis(){
        v4=new VLogistica();
        v4.setVisible(true);
        v4.setExtendedState(6);
    
    
}
public static void crearVentanaDeParte(){
   v5=new Vparte(); 
   v5.setVisible(true);
    
}
public static void crearVgestionCentros(){
    v6= new VgestionCentros();
    v6.setVisible(true);
      
}
public static void crearVseleccionDeCentro() throws SQLException{
    
    v7=new VseleccionDeCentro(v6 , true);
    v7.setVisible(true);
    
}
public static void crearVgestionTrabajadores(){
    
    v8=new VgestionTrabajadores();
    v8.setVisible(true);
    
    
}
public static void salirPrograma(){
    System.exit(0); 
}
public static void rellenarCBdeCentros(javax.swing.JComboBox cb) throws SQLException{
    
    listaC=cen.buscarTodosLosCentros();
    
    for(int x = 0; x < listaC.size(); x++){
        
        cb.insertItemAt(listaC.get(x).getNombre(),x);
        
    }

}
public static int crearCentro(String nom,String cal, String num, String cp,String ciu, String prov,String tel) throws SQLException{
    
    cen=new CentroBD();
    Centro c= new Centro(nom,cal,num,cp,ciu,prov,tel);
    int filas = cen.añadirCentroABD(c);
    
    return filas;
    
    
}
public static boolean borrarCentro() throws SQLException{
    
    boolean ok=cen.borrarCentroDBD();
    
    return ok;
    
}
public static boolean modificarCentro(String nom,String cal, String num, String cp,String ciu, String prov,String tel) throws SQLException{
    
    boolean ok=cen.modificarCentroDBC(nom, cal, num, cp, ciu, prov, tel);
    
    return ok;
    
}
public static void buscarCentro(String nombre) throws SQLException{
    
    Centro dv = cen.buscarCentroEnBD(nombre);
    
    v6.rellenarCamposVentana(dv.getNombre(), dv.getCalle(), dv.getNumero(), dv.getCodigoPostal(), dv.getCiudad(), dv.getProvincia(), dv.getTelefono());
   
   
}
public static Centro buscarSoloElCentro(String nombre) throws SQLException{
    
    
    Centro ce = cen.buscarCentroEnBD(nombre);
    
    return ce;
}
public static void buscarTrabajadorEnBD(String dni) throws SQLException{
    
    Logistica lo=null;
    Administrador adm=null;
    
    String tip= trbd.buscarTrabajador(dni);
    
    if (tip.equalsIgnoreCase("logistica")){
        
        lo=trbd.obtenerObjLogistica();
        v8.rellenarCamposTrabajador(lo.getDni(),lo.getNombre(),lo.getPrimerApellido(),lo.getSegundoApellido(),lo.getCalle(),lo.getPortal(),
                lo.getPiso(),lo.getMano(),lo.getTlfPersonal(),lo.getTlfEmpresa(),String.valueOf(lo.getSalario()),lo.getFechaNac());
    }else{
        
        
        adm=trbd.obtenerObjadministrador();
         v8.rellenarCamposTrabajador(adm.getDni(),adm.getNombre(),adm.getPrimerApellido(),adm.getSegundoApellido(),adm.getCalle(),adm.getPortal(),
                adm.getPiso(),adm.getMano(),adm.getTlfPersonal(),adm.getTlfEmpresa(),String.valueOf(adm.getSalario()),adm.getFechaNac());
    }
    
   
   
    
}
public static boolean registrartrabajador(String dni, String nom, String ap1, String ap2, String calle, String portal, String piso, String mano,String tlPers, String tlEmpre, String sala, Date fnac, String tipo, String ce) throws SQLException{
        trbd=new TrabajadorBD();
        
        boolean ok;
        
        Centro centro = buscarSoloElCentro(ce);
        
        if (tlPers.isEmpty()){
            
            tlPers="NO HAY VALOR ALMACENADO POR SER UN DATO OPCIONAL";
            
        }
        
        if(sala.isEmpty()){
            
            sala=null;
            
        }
        
        Integer ideCntro= cen.obteneridCentro();
        
        if(tipo.equalsIgnoreCase("Logistica")){
           
           Logistica log=new Logistica (dni, nom,ap1,ap2,calle,portal,piso,mano,tlPers,tlEmpre,Float.parseFloat(sala),fnac,tipo,centro);
           ok=trbd.registrarTrabajadorLogisticaABD(log,ideCntro );
            
        }else{
            
            Administrador ad=new Administrador (dni, nom,ap1,ap2,calle,portal,piso,mano,tlPers,tlEmpre,Float.parseFloat(sala),fnac,tipo,centro);
           ok=trbd.registrarTrbajadorAdministradorABD(ad,ideCntro );
        }
 
       return ok;
        
}
public static void borrarTrabajadorDelaBD(String dni) throws SQLException{
    
     trbd.borrarTrabajadorEnBD(dni);
    
}
public static boolean modificarDatosTrabajador(String dni, String nom, String ap1, String ap2, String calle, String portal, String piso, String mano,String tlPers, String tlEmpre, String sala, Date fnac, String tipo, String ce) throws SQLException{
    
    boolean ok;
    
    Centro centro = buscarSoloElCentro(ce);
        
        if (tlPers.isEmpty()){
            
            tlPers="NO HAY VALOR ALMACENADO POR SER UN DATO OPCIONAL";
            
        }
        
        if(sala.isEmpty()){
            
            sala=null;
            
        }
        
        Integer ideCntro= cen.obteneridCentro();
        
        if(tipo.equalsIgnoreCase("Logistica")){
           
           Logistica log=new Logistica (dni, nom,ap1,ap2,calle,portal,piso,mano,tlPers,tlEmpre,Float.parseFloat(sala),fnac,tipo,centro);
           ok=trbd.modificarDatosTrabajadorLogisticaEnBD(log,ideCntro);
            
        }else{
            
            Administrador ad=new Administrador (dni, nom,ap1,ap2,calle,portal,piso,mano,tlPers,tlEmpre,Float.parseFloat(sala),fnac,tipo,centro);
           ok=trbd.modificarDatosTrabajadorAdministrador(ad,ideCntro);
        }
 
    
    return ok;
    
}
}