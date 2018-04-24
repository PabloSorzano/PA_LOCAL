/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author Sorz Torres
 */
public class agregaUsuario extends JFrame {

    JButton minimizar, cerrar, agregar;
    JLabel barra, titulo;

    BD bd = new BD();
    Scanner leer = new Scanner(System.in);
    validacionesJT vd = new validacionesJT();
    Connection co = null;
    Statement s = null;
    ResultSet rs = null;

    JTextField nE, aP, aM, tC, mL, pW;
    String xiU = ":v",
            xnombre = "mal",
            xaPat = "perro",
            xaMat = "envias",
            xcel = "algo",
            xmail = "malo",
            xpass = ":v",
            resTex = "",
            namDef = "Anote el nombre",
            patDef = "Anote el apellido paterno",
            matDef = "Anote el apellido materno",
            celDef = "Anote el número móvil (10 dígitos)",
            mailDef = "Anote el correo electrónico",
            passDef = "Anote la contraseña";
    boolean cOrr = true, conD = true, nama, pata, mata, celu, mai, pass;

    public agregaUsuario() {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
        agregaUsr();
    }

    private void agregaUsr() {
        System.out.println("===========Agregar usuario===========");
        System.out.println(namDef);
        xnombre = leer.nextLine().trim();

        System.out.println(patDef);
        xaPat = leer.nextLine().trim();

        System.out.println(matDef);
        xaMat = leer.nextLine().trim();

        System.out.println(celDef);
        xcel = leer.nextLine().trim();

        System.out.println(mailDef);
        xmail = leer.nextLine().trim();

        System.out.println(passDef);
        xpass = leer.nextLine().trim();

        evalua();

    }

    private void evalua() {
        vd.contaR(xnombre);
        nama = vd.soloLetras();
        vd.contaR(xaPat);
        pata = vd.soloLetras();
        vd.contaR(xaMat);
        mata = vd.soloLetras();
        vd.contaR(xcel);
        celu = vd.soloNumeros();
        vd.contaR(xmail);
        mai = vd.soloMail();
        vd.contaR(xpass);
        pass = vd.sinEspecial();
        if (cOrr || xcel.length() != 10 || xnombre.equals(namDef)
                || xaPat.equals(patDef) || xaMat.equals(matDef)
                || xcel.equals(celDef) || xmail.equals(mailDef)
                || xpass.equals(passDef)) {

            cOrr = vd.evaluaCorreo(xmail);
            System.out.println("Corre: " + cOrr);
            if (cOrr == false) {
                System.out.println("Ingrese un correo valido");
                xmail = leer.nextLine().trim();
                conD = false;
                evalua();
            } 
            if (xnombre.equals(namDef) || nama == false) {
                System.out.println("Ingrese un nombre valido");
                xnombre = leer.nextLine().trim();
                conD = false;
                evalua();
            }
            if (xaPat.equals(patDef) || pata == false) {
                System.out.println("Ingrese un apellido paterno valido");
                xaPat = leer.nextLine().trim();
                conD = false;
                evalua();
            }
            if (xaMat.equals(matDef) || mata == false) {
                System.out.println("Ingrese un apellido materno valido");
                xaMat = leer.nextLine().trim();
                conD = false;
                evalua();
            }
            if (xcel.equals(celDef) || celu == false) {
                System.out.println("Ingrese un celular valido");
                xcel = leer.nextLine().trim();
                conD = false;
                evalua();
            }
            if (xmail.equals(mailDef) || mai == false) {
                System.out.println("Ingrese un correo valido");
                xmail = leer.nextLine().trim();
                conD = false;
                evalua();
            }
            if (xpass.equals(passDef) || pass == false) {
                System.out.println("Ingrese una contraseña valida");
                xpass = leer.nextLine().trim();
                conD = false;
                evalua();

            } else if (xcel.length() != 10) {
                System.out.println("Ingrese un celular valido");
                xcel = leer.nextLine().trim();
                conD = false;
                evalua();
            } else if (conD == true && cOrr == true) {
                accion();

            } else {
                System.out.println("Checa tus datos");
            }
        } else {
            accion();
        }
    }

    private void accion() {
        System.out.println("Accion");
        try {
            bd.conectar();
            bd.agregaU(xnombre, xaPat, xaMat, xcel, xmail, xpass);
            rs = bd.obtenerDatos("usuario", "*", "Email = '" + xmail + "'");
            if (rs.next()) {
                System.out.println("Usuario existente");
                agregaUsuario obj = new agregaUsuario();
                obj.setVisible(true);
            } else {
                s = bd.procedimiento("altaUsuario");
                rs = bd.obtenerDatos("usuario", "*", "Email = '" + xmail + "'");
                while (rs.next()) {
                    resTex += rs.getString(1) + ",";
                    resTex += rs.getString(2) + ",";
                    resTex += rs.getString(3) + ",";
                    resTex += rs.getString(4) + ",";
                    resTex += rs.getString(5) + ",";
                    resTex += rs.getString(6) + ",";
                    resTex += rs.getString(7);
                }
                agregaCasa obj = new agregaCasa(resTex);

            }

        } catch (SQLException ex) {
            Logger.getLogger(agregaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
