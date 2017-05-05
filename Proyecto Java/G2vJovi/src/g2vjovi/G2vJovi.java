
package g2vjovi;

import ModeloBD.*;
import ModeloUML.*;
import VentanasAdmin.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class G2vJovi {

    
    private static Administracion tAdministracion;
    private static Logistica tLogistica;
    private static Centro cCentro;
    private static ArrayList <Trabajador> listaT;
    private static ArrayList <Centro> listaC;
    private static VentanaAdministracion vAdministracion;
    private static VentanaLogistica vLogistica;
    private static NuevoTrabajador vNuevoTrabajador;
    private static ModificarTrabajador vModificarTrabajador;
    private static NuevoCentro vNuevoCentro;
    private static ModificarCentro vModificarCentro;
    private static BuscarTrabajadorPK vBuscarTrabPk;
    private static BuscarCentroPK vBuscarCentroPk;
    private static BuscarCentro vBuscarCentro;
    private static BuscarTrabajador vBuscarTrabajador;
    private static NuevoParte vNuevoParte;
    private static TrabajadorBD bdTrabajador = new TrabajadorBD();
    private static CentroBD bdCentro = new CentroBD();
    private static ArrayList<Salida>listaDeSalidas;
    private static Integer totalHorasTrabajadas;
    private static Integer totalMinutosTrabajados;
    private static AvisoBD avisoBD;
    private static GastoBD gastoBD;
    private static SalidaBD salidaBD;
    private static Integer idParte;// id obtenido al iniciar sesion, igual sobra pero mañana lo comento 
    private static ParteBD parteBD;
    private static String mensajeDeAviso;
    
    public static void main(String[] args) {
        listaDeSalidas=new ArrayList();
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
    public static void disposeBuscarTrabPk(String tipoVentana,ArrayList pTrabajador){
        switch (tipoVentana){
            case "altat":{
                listaC =bdCentro.consultaCentro();
                vNuevoTrabajador =new NuevoTrabajador(new javax.swing.JFrame(), true,listaC);
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
    public static Centro centroC(){
        cCentro = new Centro();
        return cCentro;
    }
    public static Administracion trabajadorAdministracion(){
        tAdministracion = new Administracion();
        return tAdministracion;
    }
    public static Logistica trabajadorLogistica(){
        tLogistica = new Logistica();
        return tLogistica;
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
    public String ejecutarconsultas(String vdni){
        String cadena =bdTrabajador.consultas(vdni);
        return cadena;
    }
    public ArrayList ejecutarconsultaNombreC(String vnombre){
        listaT =bdTrabajador.consultaNombre(vnombre);
        return listaT;
    }
    public ArrayList ejecutarconsultasPk(String vdni){
        listaT =bdTrabajador.consultaPk(vdni);
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
    public void procInsertTrabajador(Trabajador t){
        bdTrabajador.insertTrabajador(t);
    }
    public void procInsertCentro(Centro c){
        bdCentro.insertCentro(c);
    }
    public ArrayList procConsultaCentro(){
        listaC =bdCentro.consultaCentro();
        return listaC;
    }
    
    public static void abrirVentanaLogistica(){
        vLogistica=new VentanaLogistica ();
        vLogistica.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        vLogistica.setVisible(true);
    }
    public static void abrirVentanaCreacionPartes(){
        
        totalHorasTrabajadas=0;
        totalMinutosTrabajados=0;
        listaDeSalidas.clear();
        vNuevoParte=new NuevoParte(vLogistica, true);
        vNuevoParte.setVisible(true);
       
                
    }
    public static void cerrarVentanaCreacionPartes(){
        
        vNuevoParte.dispose();
        
        
    }
    public static void registrarSalidas(String alba, String hini, String hlleg){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm");
        
        LocalTime hI=LocalTime.parse(hini, dtf);
        LocalTime hLL=LocalTime.parse(hlleg, dtf);
        
        
        Salida s =new Salida (alba,hI,hLL);
        listaDeSalidas.add(s);
        
    }
    public static String verListaDeSalidasRegistradas(){
        
        String listaSal="LISTA DE LAS SALIDAS REGISTRADAS EN EL PARTE"
                       +"\n==================================================";
        
        int cont=1;
        
        for (int i=0;i<listaDeSalidas.size();i++){
 
            listaSal+="\n"+cont+":  NºALBARAN:  "+listaDeSalidas.get(i).getAlbaran()+"  H. SALIDA:  "+listaDeSalidas.get(i).getHoraSalida()+"  H. LLEGADA:  "+listaDeSalidas.get(i).getHoraLLegada();
            cont++;
        }

        return listaSal;
    }
    public static Integer numeroDeSalidasRegistradasHastaELMomento(){

        return listaDeSalidas.size();
        
    }
    public static void borrarSalidaDelRegistro(String pos){
        
        int index=Integer.parseInt(pos);
        index--;
        listaDeSalidas.remove(index);

    }
    public static void calcularHorasTotalesTrabajadasXSalida(String horaI, String horaLLeg){
        
    String [] horaIni =horaI.split(":");

    Integer hora1 = Integer.parseInt(horaIni[0]);
    Integer min1=Integer.parseInt(horaIni[1]);
    
    Integer minTotales=(hora1*60)+min1;

    String [] horaLLegada =horaLLeg.split(":");

    Integer hora2 = Integer.parseInt(horaLLegada[0]);
    Integer min2=Integer.parseInt(horaLLegada[1]);
    
    Integer minTotales2=(hora2*60)+min2;
    
    Integer minEntreHoras=minTotales2-minTotales;
    Integer resto=minEntreHoras%60;
    Integer horasTotales=minEntreHoras/60;
    
    sumaTotalDeHorasTrabajadas(horasTotales,resto);
    
    }
    public static void sumaTotalDeHorasTrabajadas(Integer horas,Integer min){

        Integer exmin=0;
        
        totalMinutosTrabajados+=min;
        
        if(totalMinutosTrabajados>60){
           
            exmin=totalMinutosTrabajados/60;
            totalMinutosTrabajados=totalMinutosTrabajados%60;
  
        }
        
        totalHorasTrabajadas+=horas+exmin;
        
        //Para comprobar
        System.out.println("SUMA DE HORAS POR SALIDA: "+totalHorasTrabajadas+" horas y "+totalMinutosTrabajados+ " minutos");
    }
    public static void restarDeltotalDeHorasTrabajadas(String pos){
        
        int index=Integer.parseInt(pos);
        index--;
        LocalTime hs=listaDeSalidas.get(index).getHoraSalida();
        LocalTime hll=listaDeSalidas.get(index).getHoraLLegada();
        
        String h1=String.valueOf(hs);
        String h2=String.valueOf(hll);
        
        String [] horaSalida =h1.split(":");
        String [] horaLLegada =h2.split(":");
        
        Integer hora1 = Integer.parseInt(horaSalida[0]);
        Integer min1=Integer.parseInt(horaSalida[1]);
        Integer hora2 = Integer.parseInt(horaLLegada[0]);
        Integer min2=Integer.parseInt(horaLLegada[1]);
        
        Integer minTotales=(hora1*60)+min1;
        
        Integer minTotales2=(hora2*60)+min2;

        Integer minEntreHoras=minTotales2-minTotales;
        Integer resto=minEntreHoras%60;
        Integer horasTotales=minEntreHoras/60;
        
        totalHorasTrabajadas=totalHorasTrabajadas-horasTotales;
        totalMinutosTrabajados=totalMinutosTrabajados-resto;
        
        while(0>totalMinutosTrabajados){
            
            totalHorasTrabajadas--;
            totalMinutosTrabajados+=60;
            
        }

        //para comprobar
         System.out.println("TRAS RESTAR => "+totalHorasTrabajadas+" horas y  "+totalMinutosTrabajados+" miniutos");
    }
    public static Gasto registrarGastos(String gastoGasoil, String gastoPeajes, String gastoDietas, String otrosGastos ){
        
        Float gg=0f;
        Float gp=0f;
        Float gd=0f;
        Float og=0f;
       
        if(!gastoGasoil.isEmpty()){
            
            gg=Float.parseFloat(gastoGasoil);
            
        }
        if(!gastoGasoil.isEmpty()){
            
            gp=Float.parseFloat(gastoPeajes);
            
        }
        if(!gastoGasoil.isEmpty()){
            
            gd=Float.parseFloat(gastoDietas);
            
        }
        if(!gastoGasoil.isEmpty()){
            
            og=Float.parseFloat(otrosGastos);
            
        }
        Gasto gasto= new Gasto(gg,gp,gd,og);
        
        gastoBD.registrarGastosEBD(gg, gp, gd, og);
        
        return gasto;
        
    }
    public static void registrarParte(Float kmi ,Float kmf ,String tipoparte,String matricula ,String observaciones , Float gastoG, Float gastoP , Float gastoD, Float ogastos){
   
        Date fsistema= new Date();
        java.sql.Date sqlFechaParte = new java.sql.Date(fsistema.getTime());
        
        parteBD.registrarParteEBD(kmi, kmf, tipoparte, Logistica, matricula, observaciones, mensajeDeAviso, gastoG, gastoP, gastoD, ogastos, sqlFechaParte);

    }
    public static void registrarSalidas(){
        
        salidaBD.registrarSalidasEBD(listaDeSalidas, idParte );
        

    }
    public static void registarAviso(){
 
        if (totalHorasTrabajadas>8){

            int hextra=totalHorasTrabajadas-8;
            
            mensajeDeAviso="HAS TRABAJADO "+hextra+ " HORAS";
            
        }else{
            
            
            mensajeDeAviso="NO HAS CUMPLIDO CON EL MINIMO DE HORAS ESTABLECIDO";
        }
        
    }
    public static ArrayList obtenerMatricukas(){
        //falta terminar necesito parte vehiculos
        
        ArrayList<String>matri=new ArrayList();
        
        return matri;
    }

}
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
    private static ArrayList <Salida> listaS;
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
    private static UsuarioBD bdusuario= new UsuarioBD();
    private static ModificarUsuario pu;
    private static VehiculoBD bdvehiculo =new VehiculoBD();
    private static LoginBD bdLogin =new LoginBD();
    private static ParteBD bdParte = new ParteBD();
    private static ValidarPartes vValidarPartes;
    private static int minFilas =0;
    private static int maxFilas =10;
    
    
    public static void main(String[] args) {
        abrirVentanaLogin();
        
        
      //  abrirVentanaAdministracion();
       
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
        vValidarPartes = new ValidarPartes(new javax.swing.JFrame(), true,minFilas,maxFilas);
        vValidarPartes.setVisible(true);
    }
    public static void cerrarVentanaValidarPartes(){
        vValidarPartes.dispose();
    }
    public static void abrirVentanaValidarPartesAnterior(){
        vValidarPartes = new ValidarPartes(new javax.swing.JFrame(), true,(minFilas-10),(maxFilas-10));
        vValidarPartes.setVisible(true);
    }
    public static void abrirVentanaValidarPartesSiguiente(){
        vValidarPartes = new ValidarPartes(new javax.swing.JFrame(), true,(minFilas+10),(maxFilas+10));
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
    public static Parte rellenarParte(int ID, float kmInicio, float kmFinal, String tipoParte,String incidencias, Logistica logistica, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte){
        pParte = new Parte(ID,kmInicio,kmFinal,tipoParte,incidencias,logistica,vehiculoDelParte,avisoDelParte,gastoDelParte);
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

    public static void generarCredenciales(String usuario, String contraseña) {
      Credenciales c =new Credenciales();
     c.setUser(usuario);
        c.setPassw(contraseña);
     try{   
       
         bdLogin.login(c);
   
     
     }catch(Exception e){
         javax.swing.JOptionPane.showMessageDialog(null, "Error"+e);
     }
    }

    private static void abrirVentanaLogin() {
      VentanaLogin vlogin =new VentanaLogin();
      vlogin.setVisible(true);
    }
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
    
    
    
    
    public static void abrirventanaUsuario(){
        pu = new ModificarUsuario(new javax.swing.JFrame(),true);
        pu.setVisible(true);
        
    }
    public static void cerrarventanaUsuario(){ 
        pu.dispose();
    }
    
    public static Usuario buscarUsuario(String dni)throws Exception{
        Usuario u = new Usuario();
        
        u=bdusuario.consultarTrabajador(dni);
       return u; 
    }
    
    public static int generarUsuario(String usuario, String contraseña)throws Exception{
    Usuario u= new Usuario();
    u.setUsuario(usuario);
    u.setPassword(contraseña);
   int x= bdusuario.actualizarTrabajador(u);
      
   return x; 
    }
    
    
    
     public static void abrirVentanaVehiculos(){
        VentanaVehiculo vehiculo= new VentanaVehiculo(new javax.swing.JFrame(),true);
        vehiculo.setVisible(true);
        
        
    }
    
       public static void generarVehiculo(String matricula, String marca, String modelo) throws Exception{
         
           
             Vehiculo v =new Vehiculo();
             v.setMatricula(matricula);
             v.setMarca(marca);
             v.setModelo(modelo);
             
             bdvehiculo.anadirVehiculo(v);
             
           
         }

    public static void borrarVehiculo(String matricula)throws Exception {
     
            Vehiculo v2 =new Vehiculo();
            v2.setMatricula(matricula);
            
            bdvehiculo.borrarVehiculo(matricula);
        
        
    }
    public static String consultarVehiculos()throws Exception{
        
        
 String vehiculos= bdvehiculo.consultarVehiculos();
    
    return vehiculos;
       }
    public static void actualizarVehiculo(String matricula,String marca, String modelo,String matriculaID)throws Exception{
        Vehiculo v1=new Vehiculo();
        
        v1.setMatricula(matricula);
        v1.setMarca(marca);
        v1.setModelo(modelo);
        
        bdvehiculo.actualizarVehiculo(v1,matriculaID);
        
    }
     public static Vehiculo consultarVehiculo(String matricula)throws Exception{
        Vehiculo v =new Vehiculo();
        
        v= bdvehiculo.buscarVehiculo(matricula);
         
        return v;
     }
    
         }
    
    
    

    public ArrayList procConsultaCentroNombre(String vnombreC){
        listaC =bdCentro.consultaCentroNombre(vnombreC);
        return listaC;
    }
    public ArrayList procConsultarPartesJoin(int filasMin,int filasMax){
        listaP =bdParte.consultarPartesJoin(filasMin,filasMax);
        return listaP;
    }
    public ArrayList procConsultarSalidasParte(int vIdParte){
        listaS = bdParte.consultarSalidasParte(vIdParte);
        return listaS;
    }
    public ArrayList procConsultarPartesMensuales(){
        listaP =bdParte.consultarPartesMensuales();
        return listaP;
    }
    
    public void procUpdateParteRevisado(int vIdParte){
        bdParte.updateParteRevisado(vIdParte);
    }
    public void procDeleteParteSinRevisar (int vIdParte){
        bdParte.deleteParteSinRevisar(vIdParte);
    }
    public void abrirVentanaModificarParte (Parte p){
        //Aqui va la ventana de David pasandole el parte
    }
    public static void ejecutarParse()throws ParseException, IOException,InterruptedException {
        DOMParserPartes dpe = new DOMParserPartes();
        dpe.runExample();
        
        //Esto para ejecutar el HTML
        Runtime rt = Runtime.getRuntime();           
        Process p = rt.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"+" "+"InformeParte.html");            
        p.waitFor();        

    } 
}
        abrirVentanaLogistica();
