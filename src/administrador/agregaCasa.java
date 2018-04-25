/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sorz Torres
 */
public class agregaCasa {

    JButton minimizar, cerrar;
    JLabel barra, titulo;

    BD bd = new BD();
    validacionesJT vd = new validacionesJT();
    Connection co = null;
    Statement s = null;
    ResultSet rs = null;

    int idUsr = 666;
    String resTex = "",
            xCoorde = "oye",
            xEstado = "estas",
            xMuni = "mandando",
            xCodigoP = "algo",//codigoPostal 5 caracteres
            xCol = "mal",
            xCalle = "mi",
            xNumInt = "hermano",//numeroInterior 10 caracteres
            estDef = "Ingrese el estado",
            munDef = "Ingrese el municipio",
            codDef = "Ingrese el codigo postal",
            colDef = "Ingrese la colonia",
            calDef = "Ingrese la calle",
            intDef = "Ingrese el numero interior",
            latDef = "Ingrese latitud (casa)",
            longDef = "Ingrese longitud (casa)",
            datos[] = null;
    boolean coord, conD, state, mun, coP, col, cal, numI;

    public agregaCasa(String d) {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
        this.datos = d.split(",");
        idUsr = Integer.parseInt(datos[0]);
        System.out.println("Usuario: "+idUsr);
        System.out.println(d);
        agregaC();
    }

    private void accion() {
        System.out.println("----------Agrega Casa----------");
        try {
            bd.conectar();
            bd.agregaC(idUsr, xCoorde, xEstado, xMuni, xCodigoP, xCol, xCalle, xNumInt);
            s = bd.procedimiento("altaCasa");
            rs = bd.obtenerDatos("casa", "*", "idUsuario = '" + idUsr + "'");
            while (rs.next()) {
                resTex += rs.getString(1) + ",";
                resTex += rs.getString(2) + ",";
                resTex += rs.getString(3) + ",";
                resTex += rs.getString(4) + ",";
                resTex += rs.getString(5) + ",";
                resTex += rs.getString(6);
            }
            agregaCuarto obj = new agregaCuarto(resTex);
        } catch (SQLException ex) {
            Logger.getLogger(agregaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    String LAT, LOG;
    Scanner leer = new Scanner(System.in);

    private void agregaC() {
        System.out.println("\n ===========Agregar casa===========");
        System.out.println(latDef);
        LAT = leer.nextLine().trim();analiza(LAT);

        System.out.println(longDef);
        LOG = leer.nextLine().trim();analiza(LOG);

        xCoorde = "(lat: " + LAT + " , " + "long: " + LOG + ")";

        System.out.println(estDef);
        xEstado = leer.nextLine().trim();analiza(xEstado);

        System.out.println(munDef);
        xMuni = leer.nextLine().trim();analiza(xMuni);

        System.out.println(codDef);
        xCodigoP = leer.nextLine().trim();analiza(xCodigoP);

        System.out.println(colDef);
        xCol = leer.nextLine().trim();analiza(xCol);

        System.out.println(calDef);
        xCalle = leer.nextLine().trim();analiza(xCalle);

        System.out.println(intDef);
        xNumInt = leer.nextLine().trim();analiza(xNumInt);
        
        evalua();

    }

    private void evalua() {
        System.out.println("===========Estado===========");
        state = vd.soloLetras(xEstado);
        
        System.out.println("===========Municipio===========");
        mun = vd.soloLetras(xMuni);
        
        System.out.println("===========Codigo Postal===========");
        coP = vd.soloNumeros(xCodigoP);
        
        System.out.println("===========Colonia===========");
        col = vd.soloLetras(xCol);
        
        System.out.println("===========Calle===========");
        cal = vd.soloLetras(xCalle);
        
        System.out.println("===========Numero Interior===========");
        numI = vd.soloNumeros(xNumInt);
        
        xCoorde = "(lat: " + LAT + " , " + "long: " + LOG + ")";
        conD = true;
        coord = vd.evaluaCoord(LAT, LOG);
        
        analiza(LAT);
        analiza(LOG);
        analiza(xEstado);
        analiza(xMuni);
        analiza(xCodigoP);
        analiza(xCol);
        analiza(xCalle);
        analiza(xNumInt);
        if (coord == false) {
            System.out.println("-------------Coordenadas incorrectas-------------");
            System.out.println("Ingrese una latitud valida");
            LAT = leer.nextLine().trim();analiza(LAT);

        
            System.out.println("Ingrese una longitud valida");
            LOG = leer.nextLine().trim();analiza(LOG);

            conD = false;
            evalua();

        } else if (coord || xCodigoP.length() != 5 || xNumInt.length() > 10 || xEstado.equals(estDef)
                || xMuni.equals(munDef) || xCodigoP.equals(codDef)
                || xCol.equals(colDef) || xCalle.equals(calDef)
                || xNumInt.equals(intDef) || LAT.equals(latDef) || LOG.equals(longDef)) {
            if (LAT.equals(latDef)) {
                System.out.println("Ingrese latitud valida");
                LAT = leer.nextLine().trim();
                analiza(LAT);
                conD = false;
                evalua();

            }
            if (LOG.equals(longDef)) {
                System.out.println("Ingrese longitud valida");
                LOG = leer.nextLine().trim();
                analiza(LOG);
                conD = false;
                evalua();

            }
            if (xEstado.equals(estDef) || state==false) {
                System.out.println("Ingrese un estado valido");
                xEstado = leer.nextLine().trim();
                analiza(xEstado);
                conD = false;
                evalua();
            }
            if (xMuni.equals(munDef) || mun==false) {
                System.out.println("Ingrese un municipio valido");
                xMuni = leer.nextLine().trim();
                analiza(xMuni);
                conD = false;
                evalua();
            }
            if (xCodigoP.equals(codDef) || coP==false) {
                System.out.println("Ingrese un codigo postal");
                xCodigoP = leer.nextLine().trim();
                analiza(xCodigoP);
                conD = false;
                evalua();
            }
            if (xCol.equals(colDef) || col==false) {
                System.out.println("Ingrese una colonia valida");
                xCol = leer.nextLine().trim();
                analiza(xCol);
                conD = false;
                evalua();
            }
            if (xCalle.equals(calDef) || cal==false) {
                System.out.println("Ingrese una calle valida");
                xCalle = leer.nextLine().trim();
                analiza(xCalle);
                conD = false;
                evalua();
            }
            if (xNumInt.equals(intDef) || numI==false) {
                System.out.println("Ingrese un numero interior valido");
                xNumInt = leer.nextLine().trim();
                analiza(xNumInt);
                conD = false;
                evalua();

            } else if (xCodigoP.length() != 5) {
                System.out.println("Ingrese un codigo postal valido");
                xCodigoP = leer.nextLine().trim();
                analiza(xCodigoP);
                conD = false;
                evalua();

            } else if (xNumInt.length() > 10) {
                System.out.println("Ingrese un numero interior valido");
                xNumInt = leer.nextLine().trim();
                analiza(xNumInt);
                conD = false;
                evalua();

            } else if (conD) {
                accion();
            }

        } else {
            accion();
        }
    }

    private void analiza(String t) {
        if (t.equalsIgnoreCase("cerrar")) {
            cerrar();
        } else {
        }
    }

    private void cerrar() {
        System.out.println("-------Cerrar-------");
        bd.conectar();
        System.out.println(bd.eliminarDatos("usuario", "idUsuario", "" + idUsr + "", ""));
        //System.out.println(bd.eliminarDatos("Casa", "idCasa", "" + idHs + "", "")); si la casa existe
        System.exit(0);
    }
}
