
package g2vjovi;

import ModeloBD.*;
import ModeloUML.*;
import Parser.*;
import VentanasAdmin.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */
 
public class G2vJovi {

    /**
     * @param variables globales usadas en mas de un metodo.
     * 
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
    private static ArrayList <Vehiculo> listaV;
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
    private static TrabajadorBD bdTrabajador = new TrabajadorBD();
    private static CentroBD bdCentro = new CentroBD();
    private static ParteBD bdParte = new ParteBD();
    private static SalidaBD bdSalida = new SalidaBD();
    private static ValidarPartes vValidarPartes;
    private static int minFilas =0;
    private static int maxFilas =10;
    private static UsuarioBD bdusuario= new UsuarioBD();
    private static ModificarUsuario pu;
    private static VehiculoBD bdvehiculo= new VehiculoBD();
    private static LoginBD bdLogin =new LoginBD();
    private static ArrayList<Salida>listaDeSalidas;
    private static Integer totalHorasTrabajadas;
    private static Integer totalMinutosTrabajados;
    private static AvisoBD avisoBD=new AvisoBD();
    private static GastoBD gastoBD=new GastoBD();
    private static SalidaBD salidaBD;
    private static Integer idParte;// id obtenido al iniciar sesion, igual sobra pero mañana lo comento 
    private static ParteBD parteBD;
    private static String mensajeDeAviso;
    private static NuevoParte vNuevoParte;
    private static String dniTrabajador;
    private static ArrayList<String> matri;
    private static VentanaLogin vlogin;
    
    /**
     * 
     * main de la controladora
     * En caso de querer abrir una ventana directamente para posibles pruebas se puede comentar el metodo abrirVentanaLogin(); y descomentar la ventana que queremos abrir. Para ahorrarnos el login
     */
    public static void main(String[] args ) {
        abrirVentanaLogin();
		
        //abrirVentanaAdministracion();
        //abrirVentanaLogistica(); 
    }
    /**
     * Desde este comentario hasta el siguente son metodos para abrir o cerrar ventanas, en caso de los metodos que contienen un Switch es porque la ventana que se quiere abrir o cerrar es la misma pero hace diferentes acciones.
     */
    public static void abrirVentanaAdministracion(){
        //vlogin.dispose();
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
        public static void disposeBuscarCentroPk(String tipoVentana,ArrayList pCentro,String nombreCentro){
        switch (tipoVentana){
            case "altac":{
                vNuevoCentro=new NuevoCentro(new javax.swing.JFrame(), true,nombreCentro);
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
    public static void abrirVentanaVehiculos(){
        VentanaVehiculo vehiculo= new VentanaVehiculo(new javax.swing.JFrame(),true);
        vehiculo.setVisible(true); 
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
    public static void abrirventanaUsuario(){
        pu = new ModificarUsuario(new javax.swing.JFrame(),true,dniTrabajador);
        pu.setVisible(true);
        
    }
    public static void cerrarventanaUsuario(){ 
        pu.dispose();
    }
    public static void abrirVentanaLogin() {
       vlogin =new VentanaLogin();
      vlogin.setVisible(true);
    }
    public static void abrirVentanaLogistica(){
        vlogin.dispose();
        vLogistica=new VentanaLogistica ();
        vLogistica.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        vLogistica.setVisible(true);
    }
    public void abrirVentanaCreacionPartes(){
        totalHorasTrabajadas=0;
        totalMinutosTrabajados=0;
        listaDeSalidas=new ArrayList(); 
        listaV=bdvehiculo.consultarVehiculosComboB();
        vNuevoParte=new NuevoParte(vLogistica, true,listaV);
        vNuevoParte.setVisible(true);         
    }
    public static void cerrarVentanaCreacionPartes(){
        vNuevoParte.dispose(); 
    }
    
    /**
     * Desde este comentario hasta el siguiente los metodos son "news" de un objeto que reciben unos parametros y la controladora realiza el new y los llena para luego devolverlos (modelo-controlador-vista)
     * 
     */

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
    public static Administracion trabajadorAdministracion(String dni, String nombre,String apeUno,String apeDos,String calle, String portal,String piso, String mano,String telefonoP,String telefonoE,double Salario,Date fechaNac){
        tAdministracion = new Administracion(dni, nombre,apeUno,apeDos,calle, portal,piso, mano,telefonoP,telefonoE,Salario,fechaNac);
        return tAdministracion;
    }
    public static Logistica trabajadorLogistica(String dni, String nombre,String apeUno,String apeDos,String calle, String portal,String piso, String mano,String telefonoP,String telefonoE,double Salario,Date fechaNac){
        tLogistica = new Logistica(dni, nombre,apeUno,apeDos,calle, portal,piso, mano,telefonoP,telefonoE,Salario,fechaNac);
        return tLogistica;
    }
    public static Parte rellenarParte(int ID, double kmInicio, double kmFinal, String tipoParte,String incidencias, Logistica logistica, Vehiculo vehiculoDelParte, Aviso avisoDelParte, Gasto gastoDelParte){
        pParte = new Parte(ID,kmInicio,kmFinal,tipoParte,incidencias,logistica,vehiculoDelParte,avisoDelParte,gastoDelParte);
        return pParte;
    }
    public static Aviso rellenarAviso(String descripcion){
        aAviso = new Aviso(descripcion);
        return aAviso;
    }
    public static Gasto rellenarGasto(double gastoGasoil, double gastoPeaje, double gastoDietas, double otrosGastos){
        gGasto = new Gasto(gastoGasoil,gastoPeaje,gastoDietas,otrosGastos);
        return gGasto;
    }
    public static Vehiculo rellenarVehiculo(String matricula, String marca, String modelo){
        vVehiculo = new Vehiculo(matricula,marca,modelo);
        return vVehiculo;
    }
    public static Salida rellenarSalida(Date horaSalida, Date horaLlegada, String albaran){
        sSalida = new Salida(albaran,dateToLocalTime(horaSalida),dateToLocalTime(horaLlegada));
        return sSalida;
    }
    
    /**
     * Este metodo convierte un Date a un LocalTime, es usado para poder calcular las horas para generar un aviso, tambien se podia haber hecho don date poniendole formato de hora hh:mm
     */
    public static LocalTime dateToLocalTime (Date hora){
        Date horaDate = hora ;
        Instant instant = Instant.ofEpochMilli(horaDate.getTime());
        LocalTime resHora = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
        return resHora;
        
    }
    /**
     * Desde este comentario hasta el siguiente son metodo que realizan sentencias DML (consultas o inserts/update/delete) a sus respectivas clasesBD, algunas tienen parametros de entrada (ej:buscar por dni tiene de entrada DNI) y algunos tambien tienen salidas de una lista de objetos, objetos, string...
     */

    public ArrayList ejecutarconsultas(String vdni){
        listaT =bdTrabajador.consultas(vdni);
        return listaT;
    }
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
    public ArrayList procConsultarSalidasParte(int vIdParte){
        listaS = bdSalida.consultarSalidasParte(vIdParte);
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
        listaV=bdvehiculo.consultarVehiculosComboB();
        vNuevoParte=new NuevoParte(vLogistica, true,p,listaV);
        vNuevoParte.setVisible(true);
    }
    /**
     * 
     * Este metodo ejecuta el runExample del parser y despues abre el HTML con un explorador GoogleChrome. No se contempla que el usuario no tenga googlechrome(¿Quien usa otro explorador?)
     */
    public static void ejecutarParse()throws ParseException, IOException,InterruptedException {
        DOMParserPartes dpe = new DOMParserPartes();
        dpe.runExample();
        //Esto para ejecutar el HTML
        Runtime rt = Runtime.getRuntime();           
        Process p = rt.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"+" "+"InformeParte.html");            
        p.waitFor();        
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
	 public static void generarCredenciales(String usuario, String contraseña) {
        Usuario c =new Usuario();
        c.setUsuario(usuario);
        c.setPassword(contraseña);
        try{   
            tTrab=bdLogin.login(c);
            dniTrabajador=tTrab.getDni();

        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }

    
    public static void registrarSalidas(String alba, String hini, String hlleg){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm");
        LocalTime hI=LocalTime.parse(hini, dtf);
        LocalTime hLL=LocalTime.parse(hlleg, dtf);

        Salida s =new Salida (alba,hI,hLL);
        listaDeSalidas.add(s);
        
    }
    public static void registrarSalidasVentanaModificar(Parte p){   
        listaDeSalidas=p.getSalidasDelParte();
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
    /**
     * 
     * Metodos para calcular las horas para generar el aviso.
     */
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
    /**
     * 
     * metodo que registra los gastos
     */
    public static Gasto registrarGastos(String gastoGasoil, String gastoPeajes, String gastoDietas, String otrosGastos ){
        double gg=0f;
        double gp=0f;
        double gd=0f;
        double og=0f;      
        if(!gastoGasoil.isEmpty()){   
            gg=Double.parseDouble(gastoGasoil);            
        }
        if(!gastoGasoil.isEmpty()){           
            gp=Double.parseDouble(gastoPeajes);            
        }
        if(!gastoGasoil.isEmpty()){           
            gd=Double.parseDouble(gastoDietas);            
        }
        if(!gastoGasoil.isEmpty()){           
            og=Double.parseDouble(otrosGastos);            
        }
        Gasto gasto= new Gasto(gg,gp,gd,og);        
        gastoBD.registrarGastosEBD(gg, gp, gd, og);       
        return gasto;       
    }
    /**
     * 
     * metodo que registra los partes y partes basura
     */
    public static void registrarParte(Double kmi ,Double kmf ,String tipoparte,String matricula ,String observaciones , Double gastoG, Double gastoP , Double gastoD, Double ogastos){   
        Date fsistema= new Date();
        java.sql.Date sqlFechaParte = new java.sql.Date(fsistema.getTime());
        
        bdParte.registrarParteEBD(kmi, kmf, tipoparte, dniTrabajador, matricula, observaciones, mensajeDeAviso, gastoG, gastoP, gastoD, ogastos, sqlFechaParte);
    }
    public int registrarParteBasura(Double kmi ,Double kmf ,String tipoparte,String matricula ,String observaciones , Double gastoG, Double gastoP , Double gastoD, Double ogastos){
   
        Date fsistema= new Date();
        java.sql.Date sqlFechaParte = new java.sql.Date(fsistema.getTime());

        idParte=bdParte.registrarParteBasuraEBD(kmi, kmf, tipoparte, dniTrabajador, matricula, observaciones, mensajeDeAviso, gastoG, gastoP, gastoD, ogastos, sqlFechaParte);
        return idParte;
    }
    /**
     * 
     * metodo que registra las salidas y salidas basura
     */
    public static void registrarSalidas(){  
        bdSalida.registrarSalidasEBD(listaDeSalidas);
    }
    public static void registrarSalidasBasura(int idParte){        
        bdSalida.registrarSalidasBasuraEBD(listaDeSalidas, idParte );
    }
    /**
     * TODO lo referente a la modificacion de los partes por parte del administrador esta codificado pero da errores que no hemos podido corregir por falta de tiempo.
     * 
     * metodo que modifica los datos de un parte (update de un parte solo puede un admin)
     */
    public static Parte actualizarDatosParte(Double kmi ,Double kmf ,String matricula ,String observaciones , Double gastoG, Double gastoP , Double gastoD, Double ogastos,Parte p){
        pParte=p;
        pParte.getAvisoDelParte().setDescripcion(mensajeDeAviso);
        pParte.setKmInicio(kmi);
        pParte.setKmFinal(kmf);
        pParte.getVehiculoDelParte().setMatricula(matricula);
        pParte.setIncidencias(observaciones);
        pParte.getGastoDelParte().setGastoGasoil(gastoG);
        pParte.getGastoDelParte().setGastoPeaje(gastoP);
        pParte.getGastoDelParte().setGastoDietas(gastoD);
        pParte.getGastoDelParte().setOtrosGastos(ogastos);
        return pParte;
    }
    /**
     * NO Funciona.
     * metodo que registra los avisos,gastos,partes y avisos modificados
     */
    public void procModificarParteAdmin(Parte p){
        avisoBD.ModificarAvisoAdmin(p);
        gastoBD.ModificarGastosAdmin(p);
        parteBD.ModificarParteAdmin(p);
        salidaBD.ModificarSalidasAdmin(p);
    }
    /**
     * metodo que registra los avisos
     */
    public static void registarAviso(){
        if (totalHorasTrabajadas>8){
            int hextra=totalHorasTrabajadas-8;
            mensajeDeAviso="HAS TRABAJADO "+hextra+ " HORAS DE MAS";
        }else{
            if (totalHorasTrabajadas<8){
                mensajeDeAviso="NO HAS CUMPLIDO CON EL MINIMO DE HORAS ESTABLECIDO"; 
            }else{
                mensajeDeAviso=null;
            }
        }       
    }
    
    /*public ArrayList <String>  obtenerMatricukas()throws Exception{
        //falta terminar necesito parte vehiculos
        matri=
        return matri;
    }*/
}
