/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

/**
 * imports necesarios para el parse
 */
import ModeloUML.*;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import g2vjovi.G2vJovi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 * @author Grupo 2: Javi, David, Jovi
 * 
 * @version 7854.0
 * 
 * NOTA: Los comentarios  como este: /** usados para la documentacion hacen referencia siempre a lo que tienen debajo. 
 */

public class DOMParserPartes {
    /**
     * variables globales usadas
     */
    private Document dom;
    private G2vJovi main = new G2vJovi();
    private Element rootElement;
    private ArrayList <Parte> Partes;
    
    public void runExample() throws IOException {  
        /**
         * Partes es un ArrayList que se rellena mediante una consulta con joins
         */
        Partes = main.procConsultarPartesMensuales();
        createDOMDoc();
        createDOMTree();        
        printToFile();
        parseHtml();
    }
    
    /**
     * Metodo que crea el doc y el elemento raiz "listaPartes"
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
    /**
     * Metodo que genera la estructura de nuestro xml mediante una repetitiva
     */
    private void createDOMTree() {   
        Iterator it = Partes.iterator();
        while (it.hasNext()) {
            Parte c = (Parte) it.next();
            //Por cada parte crea un ojbeto<Parte> y lo mete en la raiz "listaPartes"
            rootElement.appendChild(createParteElement(c));
        }
    }
    /**
     * Esta es la estructura generada mediante la repetitiva
     */
    private Element createParteElement(Parte c) {
        //Elemento parte que se crea por cada parte que tengamos en el arraylist
        Element elementoParte = dom.createElement("Parte");
        
        /**
         * los demas elementos van dentro de parte y algunas van dentro de otros como : dni, nombre apellido van dentro de trabajador...
         */
        Element kmIele = dom.createElement("kmInicio");
        Text kmInicio = dom.createTextNode(String.valueOf(c.getKmInicio()));
        kmIele.appendChild(kmInicio);
        elementoParte.appendChild(kmIele);

        Element kmFele = dom.createElement("kmFinal");
        Text kmFinal = dom.createTextNode(String.valueOf(c.getKmFinal()));
        kmFele.appendChild(kmFinal);
        elementoParte.appendChild(kmFele);
        
        Element tipoPartele = dom.createElement("tipoParte");
        Text tipoParte = dom.createTextNode(String.valueOf(c.getTipoParte()));
        tipoPartele.appendChild(tipoParte);
        elementoParte.appendChild(tipoPartele);
        
        Element incidenciasele = dom.createElement("incidencias");
        Text incidencias = dom.createTextNode(c.getIncidencias());
        incidenciasele.appendChild(incidencias);
        elementoParte.appendChild(incidenciasele);
        
        Element elementoTrabajador = dom.createElement("Trabajador");
        elementoParte.appendChild(elementoTrabajador);  
        
        Element dniele = dom.createElement("dni");
        Text dni = dom.createTextNode(String.valueOf(c.getLogistica().getDni()));
        dniele.appendChild(dni);
        elementoTrabajador.appendChild(dniele);
        
        Element nombreele = dom.createElement("nombre");
        Text nombre = dom.createTextNode(String.valueOf(c.getLogistica().getNombre()));
        nombreele.appendChild(nombre);
        elementoTrabajador.appendChild(nombreele);
        
        Element apellidoele = dom.createElement("apellido");
        Text apellido = dom.createTextNode(String.valueOf(c.getLogistica().getApellidoUno()));
        apellidoele.appendChild(apellido);
        elementoTrabajador.appendChild(apellidoele);
        
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
            Text horaLlegada = dom.createTextNode(String.valueOf(c.getSalidasDelParte().get(x).getHoraLLegada()));
            horaLele.appendChild(horaLlegada);
            elementoSalida.appendChild(horaLele);
            
            Element albaranele = dom.createElement("albaran");
            Text albaran = dom.createTextNode(String.valueOf(c.getSalidasDelParte().get(x).getAlbaran()));
            albaranele.appendChild(albaran);
            elementoSalida.appendChild(albaranele);
        }

        Element elementoAviso = dom.createElement("Aviso");
        elementoParte.appendChild(elementoAviso);  

        Element descripcionele = dom.createElement("descripcion");
        Text descripcion = dom.createTextNode(String.valueOf(c.getAvisoDelParte().getDescripcion()));
        descripcionele.appendChild(descripcion);
        elementoAviso.appendChild(descripcionele);
        
        Element elementoGasto = dom.createElement("Gasto");
        elementoParte.appendChild(elementoGasto);   
        
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

        return elementoParte;
    }
       
    /**
     * Metodo que genera el XML
     */
    private void printToFile() {

        try {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("partes.xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    /**
     * Metodo que genera el HTML a partir del XML que hemos generado previamente y de el XSL que hemos creado a mano (ver en la carpeta del programa)
     */
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
