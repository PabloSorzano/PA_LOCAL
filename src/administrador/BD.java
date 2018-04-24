/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Sandy Torres
 */
public class BD {

    Connection c = null;
    Statement s = null;
    ResultSet rs = null;
    String servidor = "jdbc:mysql://localhost:3306/";
    String base = "SmartHouse";
    String usuario = "root";
    String pass = "n0m3l0";

    int idUsuario;
    String nama, aPat, aMat, cel, mail, contra,
            estado, muni, codigoP,//codigoPostal 5 caracteres
            col, calle, numInt, coordenadas;//numeroInterior 10 caracteres
    String datos, mensaje;

    public Connection conectar() {

        try {
            //Driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            //Se inicia la conexión
            c = DriverManager.getConnection(servidor + base, usuario, pass);

            //Se crea una declaración con la conexión establecida
            s = c.createStatement();
            rs = s.getResultSet();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            c = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            c = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            c = null;
        }
        if (c != null) {
            System.out.println("Conexion Exitosa \n");
        }
        return c;
    }

    public void agregaU(String nombre, String aPat, String aMat, String cel, String mail, String contra) {
        this.nama = nombre;
        this.aPat = aPat;
        this.aMat = aMat;
        this.cel = cel;
        this.mail = mail;
        this.contra = contra;
    }

    public void agregaC(int idUsuario, String coordenadas, String estado, String muni, String codigoP, String col, String calle, String numInt) {
        this.idUsuario = idUsuario;
        this.coordenadas = coordenadas;
        this.estado = estado;
        this.muni = muni;
        this.codigoP = codigoP;
        this.col = col;
        this.calle = calle;
        this.numInt = numInt;
    }

    public Statement procedimiento(String proc) {

        try {
            if (proc.equalsIgnoreCase("altaUsuario")) {
                s.execute("call smarthouse.sp_AltaUsuario('" + nama + "', '" + aPat + "', '" + aMat + "', '" + cel + "', '" + mail + "', '" + contra + "');");
                System.out.println("Usuario dado de alta con éxito");
            } else if (proc.equalsIgnoreCase("altaCasa")) {
                s.execute("call smarthouse.sp_AltaCasa(" + idUsuario + ", '" + coordenadas + "' , '" + estado + "', '" + muni + "', '" + codigoP + "', '" + col + "', '" + calle + "', '" + numInt + "');");
                System.out.println("Casa de alta con éxito");
            } else if (proc.equalsIgnoreCase("delUsuario")) {
                s.execute("call smarthouse.sp_EliminaUsuario(" + idUsuario + "');");
                System.out.println("El usuario no se ha guardado");
            } else {

            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public ResultSet obtenerDatos(String tabla, String valor, String condi) {
        try {
            if (condi.isEmpty()) {
                rs = s.executeQuery("select " + valor + " from " + tabla + " ;");
            } else {
                rs = s.executeQuery("select " + valor + " from " + tabla + " where " + condi + " ;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public String eliminarDatos(String tabla, String campo, String valor, String condi) {
        try {
            if (condi.isEmpty()) {
                s.execute("delete from " + tabla + " where " + tabla + "." + campo + " = " + valor + ";");
                mensaje = "Los datos seleccionados han sido borrados";
            } else {
                s.execute("delete from " + tabla + " where " + tabla + "." + campo + " = " + valor + " and " + condi + ";");
                mensaje = "Los datos seleccionados han sido borrados";
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

}