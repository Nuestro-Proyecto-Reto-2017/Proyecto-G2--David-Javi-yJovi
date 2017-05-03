/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import ModeloUML.Vehiculo;
import umlBD.AdministracionBD;
import java.util.ArrayList;

/**
 *
 * @author 1GLM07
 */
public class Parte {
    
    private float kmInicio;
    private float kmFinal;
    private String vehiculoMatricula;
    private String tipo;
    //gastos
    private float gastoGasoil;
    private float gastoPeajes;
    private float gastoDietas;
    private float otrosGastos;
    
    //relaciones
    private Vehiculo vehiculo;
    private ArrayList<Salida> salidas;
    private ArrayList<Aviso> avisos;
    
    private AdministracionBD admin;
    private Logistica logist;
    
}
