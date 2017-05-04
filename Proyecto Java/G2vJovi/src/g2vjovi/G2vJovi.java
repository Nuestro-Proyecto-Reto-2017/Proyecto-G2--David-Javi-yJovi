/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2vjovi;

import ModeloBD.*;
import ModeloUML.*;
import Parser.*;
import VentanasAdmin.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 1gprog02
 */
public class G2vJovi {

    /**
     * @param args the command line arguments
     */
    private static Administracion tAdministracion;
    private static Logistica tLogistica;
    private static Parte pParte;
    private static Aviso aAviso;
    private static Gasto gGasto;
    private static Vehiculo vVehiculo;
    private static Salida sSalida;
    private static Trabajador tTrab;
    private static Centro cCentro;
    private static ArrayList <Trabajador> listaT;
    private static ArrayList <Centro> listaC;
    private static ArrayList <Parte> listaP;
    private static VentanaAdministracion vAdministracion;
    private static NuevoTrabajador vNuevoTrabajador;
    private static ModificarTrabajador vModificarTrabajador;
    private static NuevoCentro vNuevoCentro;
    private static ModificarCentro vModificarCentro;
    private static BuscarTrabajadorPK vBuscarTrabPk;
    private static BuscarCentroPK vBuscarCentroPk;
    private static BuscarCentro vBuscarCentro;
    private static BuscarTrabajador vBuscarTrabajador;
    private static TrabajadorBD bdTrabajador = new TrabajadorBD();
    private static CentroBD bdCentro = new CentroBD();
    private static ParteBD bdParte = new ParteBD();
    private static ValidarPartes vValidarPartes;
    
    public static void main(String[] args ) throws ParseException, IOException  {
        abrirVentanaAdministracion();
        
        
        DOMParserPartes dpe = new DOMParserPartes();

        //call run example
        
        //dpe.runExample();
        
        
    }
    public static void abrirVentanaAdministracion(){
        vAdministracion = new VentanaAdministracion();
        vAdministracion.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        vAdministracion.setVisible(true);
    }
    public static void cerrarVentanaAdministracion(){
        vAdministracion.dispose();
        System.exit(0);
    }
    public static void abrirVentanaValidarPartes(){
        vValidarPartes = new ValidarPartes(new javax.swing.JFrame(), true,0,10);
        vValidarPartes.setVisible(true);
    }
    public static void disposeBuscarTrabPk(String tipoVentana,ArrayList pTrabajador,String pdni){
        switch (tipoVentana){
            case "altat":{
                listaC =bdCentro.consultaCentro();
                vNuevoTrabajador =new NuevoTrabajador(new javax.swing.JFrame(), true,listaC,pdni);
                vNuevoTrabajador.setVisible(true);
                vBuscarTrabPk.setVisible(false);
                break;
            }
            case "modt":{
                listaC =bdCentro.consultaCentro();
                vModificarTrabajador =new ModificarTrabajador(new javax.swing.JFrame(), true,pTrabajador,listaC);
                vModificarTrabajador.setVisible(true);
                vBuscarTrabPk.dispose();
                break;
            }
            case "bajat":{
                vBuscarTrabPk.setVisible(false);
                break;
            }
        }
    }  
        public static void disposeBuscarCentroPk(String tipoVentana,ArrayList pCentro){
        switch (tipoVentana){
            case "altac":{
                vNuevoCentro=new NuevoCentro(new javax.swing.JFrame(), true);
                vNuevoCentro.setVisible(true);
                vBuscarCentroPk.setVisible(false);
                break;
            }
            case "modc":{
                vModificarCentro =new ModificarCentro(new javax.swing.JFrame(), true,pCentro);
                vModificarCentro.setVisible(true);
                vBuscarCentroPk.dispose();
                break;
            }
            case "bajac":{
                vBuscarCentroPk.setVisible(false);
                break;
            }
        }
    }
    public static void abrirVentanaCrearTrabajador(){
        vBuscarTrabPk =new BuscarTrabajadorPK(new javax.swing.JFrame(), true,"altat");
        vBuscarTrabPk.setVisible(true);
    }
    public static void abrirVentanaCrearCentro(){
        vBuscarCentroPk =new BuscarCentroPK(new javax.swing.JFrame(), true,"altac");
        vBuscarCentroPk.setVisible(true);
    }
    public static void abrirVentanaModificarTrabajador(){
        vBuscarTrabPk =new BuscarTrabajadorPK(new javax.swing.JFrame(), true,"modt");
        vBuscarTrabPk.setVisible(true);
    }
    public static void abrirVentanaModificarCentro(){
        vBuscarCentroPk =new BuscarCentroPK(new javax.swing.JFrame(), true,"modc");
        vBuscarCentroPk.setVisible(true);
    }
    public static void abrirVentanaBorrarTrabajador(){
        vBuscarTrabPk =new BuscarTrabajadorPK(new javax.swing.JFrame(), true,"bajat");
        vBuscarTrabPk.setVisible(true);
    }
    public static void abrirVentanaBorrarCentro(){
        vBuscarCentroPk =new BuscarCentroPK(new javax.swing.JFrame(), true,"bajac");
        vBuscarCentroPk.setVisible(true);
    }
    public static void cerrarVentanaCrearTrabajador(){
        vNuevoTrabajador.dispose();
    }
    public static void cerrarVentanaCrearCentro(){
        vNuevoCentro.dispose();
    }
    public static void cerrarVentanaModificarCentro(){
        vModificarCentro.dispose();
    }
    public static void cerrarVentanaModificarTrabajador(){
        vModificarTrabajador.dispose();
    }
    
    public static void cerrarAltaBajaModificacionCentro(String tipoVentana){
        switch (tipoVentana){
            case "altac":{
                vNuevoCentro.dispose();
                vBuscarCentroPk.dispose();
                break;
            }
            case "modc":{
                vModificarCentro.dispose();
                vBuscarCentroPk.dispose();
                break;
            }
            case "bajac":{
                vBuscarCentroPk.dispose();
                break;
            }
        }
    }
    public static void cerrarAltaBajaModificacionTrabajador(String tipoVentana){
        switch (tipoVentana){
            case "altat":{
                vNuevoTrabajador.dispose();
                vBuscarTrabPk.dispose();
                break;
            }
            case "modt":{
                vModificarTrabajador.dispose();
                vBuscarTrabPk.dispose();
                break;
            }
            case "bajat":{
                vBuscarTrabPk.dispose();
                break;
            }
        }
    }
    public static Centro centroC(String nom,String calle, String numero, String cpostal,String ciudad, String prov,String telefono){
        cCentro = new Centro();
        cCentro.setNombre(nom);
        cCentro.setCalle(calle);
        cCentro.setNumero(numero);
        cCentro.setCodigoPostal(cpostal);
        cCentro.setCiudad(ciudad);
        cCentro.setProvincia(prov);
        cCentro.setTelefono(telefono);
        return cCentro;
    }
    public static Administracion trabajadorAdministracion(String dni, String nombre,String apeUno,String apeDos,String calle, String portal,String piso, String mano,String telefonoP,String telefonoE,float Salario,Date fechaNac){
        tAdministracion = new Administracion(dni, nombre,apeUno,apeDos,calle, portal,piso, mano,telefonoP,telefonoE,Salario,fechaNac);
        return tAdministracion;
    }
    public static Logistica trabajadorLogistica(String dni, String nombre,String apeUno,String apeDos,String calle, String portal,String piso, String mano,String telefonoP,String telefonoE,float Salario,Date fechaNac){
        tLogistica = new Logistica(dni, nombre,apeUno,apeDos,calle, portal,piso, mano,telefonoP,telefonoE,Salario,fechaNac);
        return tLogistica;
    }
    public static Parte rellenarParte(int ID, float kmInicio, float kmFinal, String tipoParte, Trabajador trabajadorDelParte, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte){
        pParte = new Parte(ID,kmInicio,kmFinal,tipoParte,trabajadorDelParte,vehiculoDelParte,avisoDelParte,gastoDelParte);
        return pParte;
    }
    public static Aviso rellenarAviso(String descripcion){
        aAviso = new Aviso(descripcion);
        return aAviso;
    }
    public static Gasto rellenarGasto(float gastoGasoil, float gastoPeaje, float gastoDietas, float otrosGastos){
        gGasto = new Gasto(gastoGasoil,gastoPeaje,gastoDietas,otrosGastos);
        return gGasto;
    }
    public static Vehiculo rellenarVehiculo(String matricula, String marca, String modelo){
        vVehiculo = new Vehiculo(matricula,marca,modelo);
        return vVehiculo;
    }
    public static Salida rellenarSalida(Date horaSalida, Date horaLlegada, String albaran){
        sSalida = new Salida(horaSalida,horaLlegada,albaran);
        return sSalida;
    }
    public static void abrirVentanaBuscarTrabajador(){
        vBuscarTrabajador = new BuscarTrabajador(new javax.swing.JFrame(), true);
        vBuscarTrabajador.setVisible(true);
    }
    public static void cerrarVentanaBuscarTrabajador(){
        vBuscarTrabajador.dispose();
    }
    public static void abrirVentanaBuscarCentro(){
        vBuscarCentro = new BuscarCentro(new javax.swing.JFrame(), true);
        vBuscarCentro.setVisible(true);
    }
    public static void cerrarVentanaBuscarCentro(){
        vBuscarCentro.dispose();
    }
    /*Para buscar por DNI
    public String ejecutarconsultas(String vdni){
        String cadena =bdTrabajador.consultas(vdni);
        return cadena;
    }*/
    public ArrayList ejecutarconsultaNombreC(String vnombre){
        listaT =bdTrabajador.consultaNombre(vnombre);
        return listaT;
    }
    public ArrayList ejecutarconsultasPk(String vdni){
        listaT =bdTrabajador.consultaPk(vdni);
        return listaT;
    }
    public ArrayList ejecutarconsultasListaTrab(){
        listaT =bdTrabajador.consultaListaTrab();
        return listaT;
    }
    public ArrayList ejecutarconsultasPkc(String vnombreC){
        listaC =bdCentro.consultaPk(vnombreC);
        return listaC;
    }
    public void ProcEliminarTrabajador(String vdni){
        bdTrabajador.eliminarTrabajador(vdni);
    }
    public void ProcEliminarCentro(String vnombreC){
        bdCentro.eliminarCentro(vnombreC);
    }
    public void procUpdateTrabajador(String vdni,Trabajador t,String nombreCentro){
        bdTrabajador.updateTrabajador(vdni,t,nombreCentro);
    }
    public void procUpdateCentro(String vnombreC,Centro c){
        bdCentro.updateCentro(vnombreC,c);
    }
    public void procInsertTrabajador(Trabajador t, String nombreCentro){
        bdTrabajador.insertTrabajador(t,nombreCentro);
    }
    public void procInsertCentro(Centro c){
        bdCentro.insertCentro(c);
    }
    public ArrayList procConsultaCentro(){
        listaC =bdCentro.consultaCentro();
        return listaC;
    }
    public ArrayList procConsultaCentroNombre(String vnombreC){
        listaC =bdCentro.consultaCentroNombre(vnombreC);
        return listaC;
    }
    public ArrayList procConsultarPartesJoin(int filasMin,int filasMax){
        listaP =bdParte.consultarPartesJoin(filasMin,filasMax);
        return listaP;
    }
    
}
