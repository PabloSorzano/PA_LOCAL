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
public class agregaCuarto {

    JButton minimizar, cerrar;
    JLabel barra, titulo;

    BD bd = new BD();
    validacionesJT vd = new validacionesJT();
    Scanner leer = new Scanner(System.in);
    Connection co = null;
    Statement s = null;
    ResultSet rs = null;

    int idUsr = 666, idHs = 666;

    String resTex = "", datos[] = null;
    boolean sigueCu = true, siguePi = true, sigueDis = true;
    String sigCu, sigPi, sigDis;
    int pisos=0,cuartos = 0, dispositivos = 0;

    int numeroPiso;
    String nombreCuarto, disP, obS;
    boolean numP;

    public agregaCuarto(String d) {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));

        this.datos = d.split(",");
        idHs = Integer.parseInt(datos[0]);
        idUsr = Integer.parseInt(datos[1]);
        System.out.println("Usuario: " + idUsr);
        System.out.println("Casa: " + idHs);
        System.out.println(d);
        agregaC();
    }

    private void agregaC() {
        System.out.println("==========Agregar cuarto(s)==========");
        do {
            System.out.println("Ingrese el numero del piso");
            numeroPiso += Integer.parseInt(leer.nextLine()) + 0;
            analiza(String.valueOf(numeroPiso).trim());

            do {
                System.out.println("Ingrese el nombre del cuarto");
                nombreCuarto = leer.nextLine();
                analiza(nombreCuarto);

                do {
                    System.out.println("Seleccione un tipo de dispositivo a agregar");
                    System.out.println("1. FOCO");
                    System.out.println("2. VENTILA");
                    System.out.println("3. PUERTA");
                    System.out.println("4. VENTANA");
                    System.out.println("5. CÁMARA");
                    disP = leer.nextLine();

                    System.out.println("Desea agregar otro dispositivo en el mismo cuarto? SI / NO");
                    sigDis = leer.nextLine();
                    if (sigDis.equalsIgnoreCase("si")) {
                        cuartos++;
                    } else if (sigDis.equalsIgnoreCase("no")) {
                        sigueCu = false;
                    }
                } while (sigueDis);

                System.out.println("Desea agregar otro cuarto en el mismo piso? SI / NO");
                sigCu = leer.nextLine();
                if (sigCu.equalsIgnoreCase("si")) {
                    dispositivos++;
                } else if (sigCu.equalsIgnoreCase("no")) {
                    sigueCu = false;
                }
            } while (sigueCu);

            System.out.println("Ingrese observaciones (optativa)");
            obS = leer.nextLine();
            analiza(obS);

            System.out.println("Desea agregar otro piso? SI / NO");
            sigPi = leer.nextLine();
            if (sigPi.equalsIgnoreCase("si")) {
                pisos++;
            } else if (sigPi.equalsIgnoreCase("no")) {
                sigueCu = false;
            }
        } while (siguePi);
        
        evalua();
    }
    private void evalua(){
        System.out.println("===========Numero Piso===========");
        System.out.println(numeroPiso);
        numP = vd.soloNumeros(String.valueOf(numeroPiso));
        
        System.out.println("===========Numero Piso===========");
        System.out.println(numeroPiso);
        numP = vd.soloNumeros(String.valueOf(numeroPiso));
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
        System.out.println(bd.eliminarDatos("Casa", "idCasa", "" + idHs + "", ""));
        System.exit(0);
    }

}
