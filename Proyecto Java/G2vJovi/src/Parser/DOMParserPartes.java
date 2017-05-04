/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import ModeloUML.*;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import g2vjovi.G2vJovi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 *
 * @author 1ged02
 */

public class DOMParserPartes {
    //ArrayList misanimales; aqui arraylist partes
    private Document dom;
    private G2vJovi main = new G2vJovi();
    private Element rootElement;
    private ArrayList <Parte> Partes;
        //create a list to hold the contact objects
    
    public void runExample() throws IOException {        
        Partes = main.procConsultarPartesMensuales();
        createDOMDoc();
        createDOMTree();        
        printToFile();
        parseHtml();
    }
    /*Prueba para crear parse (borrar al terminar)
    private ArrayList pruebaRellenarParte(){
        try{
            ArrayList <Parte> Partes1 = new ArrayList();
            Parte p1 = new Parte(300f,400f,"C");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm");
            Date hora;
            Date fechaNac;
            fechaNac = sdf.parse("05/05/2017");
            hora= sdf2.parse("5:23");
            Logistica tLogistica = new Logistica("12345678G", "Parse","ApeParse","ApeParse","CalleParse", "33","4", "b","987654321","987654321",200f,fechaNac);
            p1.setLogistica(tLogistica);
            ArrayList <Salida> salidas = new ArrayList();
            Salida s1 = new Salida(hora,hora,"12345alb");
            salidas.add(s1);
            p1.setSalidasDelParte(salidas);
            Vehiculo v1 = new Vehiculo("1234mat","Opel","Corsa");
            p1.setVehiculoDelParte(v1);
            Partes1.add(p1);
            return Partes1;
        }
        catch(Exception e){
             System.out.println(e);
             return null;
        }
        
        
    }
    */
    private void createDOMDoc() {   
         try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                dom = docBuilder.newDocument();
		rootElement= dom.createElement("listaPartes");
		dom.appendChild(rootElement);
            } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
            }
    }
    private void createDOMTree() {   
        Iterator it = Partes.iterator();
        while (it.hasNext()) {
            Parte c = (Parte) it.next();
            //For each Contact object  create <contacto> element and attach it to root
           
            rootElement.appendChild(createParteElement(c));
        }
    }
    private Element createParteElement(Parte c) {
        Element elementoParte = dom.createElement("Parte");
        
        //create nombre element and nombre text node and attach it to contactElement
        Element kmIele = dom.createElement("kmInicio");
        Text kmInicio = dom.createTextNode(String.valueOf(c.getKmInicio()));
        kmIele.appendChild(kmInicio);
        elementoParte.appendChild(kmIele);

        //create apellidos element and apellidos text node and attach it to contactElement
        Element kmFele = dom.createElement("kmFinal");
        Text kmFinal = dom.createTextNode(String.valueOf(c.getKmFinal()));
        kmFele.appendChild(kmFinal);
        elementoParte.appendChild(kmFele);
        
        Element tipoPartele = dom.createElement("tipoParte");
        Text tipoParte = dom.createTextNode(String.valueOf(c.getTipoParte()));
        tipoPartele.appendChild(tipoParte);
        elementoParte.appendChild(tipoPartele);
        
        Element elementoTrabajador = dom.createElement("Trabajador");
        elementoParte.appendChild(elementoTrabajador);  
        
        Element dniele = dom.createElement("dni");
        Text dni = dom.createTextNode(String.valueOf(c.getLogistica().getDni()));
        dniele.appendChild(dni);
        elementoTrabajador.appendChild(dniele);
        
        Element elementoVehiculo = dom.createElement("Vehiculo");
        elementoParte.appendChild(elementoVehiculo);  
            
        Element matriculaele = dom.createElement("matricula");
        Text matricula = dom.createTextNode(String.valueOf(c.getVehiculoDelParte().getMatricula()));
        matriculaele.appendChild(matricula);
        elementoVehiculo.appendChild(matriculaele);
            
        Element marcaele = dom.createElement("marca");
        Text marca = dom.createTextNode(String.valueOf(c.getVehiculoDelParte().getMarca()));
        marcaele.appendChild(marca);
        elementoVehiculo.appendChild(marcaele);
        
        Element modeloele = dom.createElement("modelo");
        Text modelo = dom.createTextNode(String.valueOf(c.getVehiculoDelParte().getModelo()));
        modeloele.appendChild(modelo);
        elementoVehiculo.appendChild(modeloele);
        
        for (int x = 0;x<c.getSalidasDelParte().size();x++){
            
            Element elementoSalida = dom.createElement("Salida");
            elementoParte.appendChild(elementoSalida);  
            
            Element horaSele = dom.createElement("horaSalida");
            Text horaSalida = dom.createTextNode(String.valueOf(c.getSalidasDelParte().get(x).getHoraSalida()));
            horaSele.appendChild(horaSalida);
            elementoSalida.appendChild(horaSele);
            
            Element horaLele = dom.createElement("horaLlegada");
            Text horaLlegada = dom.createTextNode(String.valueOf(c.getSalidasDelParte().get(x).getHoraLlegada()));
            horaLele.appendChild(horaLlegada);
            elementoSalida.appendChild(horaLele);
            
            Element albaranele = dom.createElement("albaran");
            Text albaran = dom.createTextNode(String.valueOf(c.getSalidasDelParte().get(x).getAlbaran()));
            albaranele.appendChild(albaran);
            elementoSalida.appendChild(albaranele);
        }
        /*
        for (int x = 0;x<c.getAvisosDelParte().size();x++){
            
            Element elementoAviso = dom.createElement("Aviso");
            
            Element descripcionele = dom.createElement("descripcion");
            Text descripcion = dom.createTextNode(String.valueOf(c.getAvisosDelParte().get(x).getDescripcion()));
            descripcionele.appendChild(descripcion);
            elementoAviso.appendChild(descripcionele);
        }
        
        Element elementoGasto = dom.createElement("Gasto");
            
        Element gastoGele = dom.createElement("gastoGasoil");
        Text gastoGasoil = dom.createTextNode(String.valueOf(c.getGastoDelParte().getGastoGasoil()));
        gastoGele.appendChild(gastoGasoil);
        elementoGasto.appendChild(gastoGele);

        Element gastoPele = dom.createElement("gastoPeaje");
        Text gastoPeaje = dom.createTextNode(String.valueOf(c.getGastoDelParte().getGastoPeaje()));
        gastoPele.appendChild(gastoPeaje);
        elementoGasto.appendChild(gastoPele);

        Element gastoDele = dom.createElement("gastoDietas");
        Text gastoDietas = dom.createTextNode(String.valueOf(c.getGastoDelParte().getGastoDietas()));
        gastoDele.appendChild(gastoDietas);
        elementoGasto.appendChild(gastoDele);
        
        Element otrosGele = dom.createElement("otrosGastos");
        Text otrosGastos = dom.createTextNode(String.valueOf(c.getGastoDelParte().getOtrosGastos()));
        otrosGele.appendChild(otrosGastos);
        elementoGasto.appendChild(otrosGele);
        
        */
        
        
        
        
        return elementoParte;
    }
       
    private void printToFile() {

        try {
            //print
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            //to generate output to console use this serializer
            //XMLSerializer serializer = new XMLSerializer(System.out, format);

            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("partes.xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    private static void parseHtml() {
        try {

          TransformerFactory tFactory=TransformerFactory.newInstance();

            Source xslDoc=new StreamSource("partesXsl.xsl");
            Source xmlDoc=new StreamSource("partes.xml");

            String outputFileName="InformeParte.html";

            OutputStream htmlFile=new FileOutputStream(outputFileName);
            Transformer trasform=tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
          }
        catch (Exception e) {
          e.printStackTrace( );
          }
    }


}
