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

    String resTex = "",
            datos[] = null;
    boolean sigueCu=true, siguePi=true;
    String sigCu, sigPi;
    int objetos=0;

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
        
        
        do{
        System.out.println("Ingrese el numero del piso");
        
        
        System.out.println("Ingrese el nombre del cuarto");
        
        
        System.out.println("Ingrese una observación (optativa)");
        
        
        }while(siguePi=true);
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
