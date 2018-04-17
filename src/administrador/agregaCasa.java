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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sorz Torres
 */
public class agregaCasa extends JFrame implements ActionListener, FocusListener, KeyListener, MouseMotionListener, MouseListener {

    JButton minimizar, cerrar;
    JLabel barra, titulo;

    BD bd = new BD();
    Connection co = null;
    Statement s = null;
    ResultSet rs = null;

    int idUsr = 666;
    JButton agregar;
    JTextField eDo, muN, cP, cO, cA, nI, Lat, Long;
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
            latDef = "Latitud",
            longDef = "Longitud",
            datos[] = null;

    public agregaCasa(String d) {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
        iniciarVentana();
        agregarComponentes();
        this.datos = d.split(",");
        idUsr = Integer.parseInt(datos[0]);
        System.out.println(idUsr);
        System.out.println(d);

    }

    private void iniciarVentana() {
        this.setSize(500, 500);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Administrador");
        this.setLayout(null);
        this.setOpacity(Float.parseFloat(".95"));
        this.setVisible(true);

        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 1, true));

    }

    private void agregarComponentes() {
        barra = new JLabel();
        barra.setBounds(0, 0, this.getWidth(), this.getHeight());
        barra.setOpaque(true);
        barra.setBackground(Color.WHITE);
        barra.setVisible(true);
        barra.setFocusable(false);
        this.add(barra);

        titulo = new JLabel("Administrador");
        titulo.setBounds(0, 0, 396, 30);
        titulo.setFont(new java.awt.Font("Bahnschrift", 0, 22));
        //titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22));
        titulo.setHorizontalTextPosition(SwingConstants.RIGHT);
        titulo.setOpaque(true);
        titulo.setForeground(Color.BLACK);
        titulo.setBackground(Color.LIGHT_GRAY);
        titulo.setVisible(true);
        titulo.addMouseMotionListener(this);
        titulo.addMouseListener(this);
        titulo.setFocusable(false);
        barra.add(titulo);

        cerrar = new JButton("x");
        cerrar.setBounds(450, 0, 50, 30);
        cerrar.setFont(new java.awt.Font("Bahnschrift", 0, 22));
        cerrar.setForeground(Color.BLACK);
        cerrar.setBackground(Color.LIGHT_GRAY);
        cerrar.setBorderPainted(false);
        cerrar.setVisible(true);
        cerrar.setActionCommand("cerrar");
        cerrar.addActionListener(this);
        barra.add(cerrar);

        minimizar = new JButton("_");
        minimizar.setBounds(398, 0, 50, 30);
        minimizar.setFont(new java.awt.Font("Bahnschrift", 0, 22));
        minimizar.setForeground(Color.BLACK);
        minimizar.setBackground(Color.LIGHT_GRAY);
        minimizar.setBorderPainted(false);
        minimizar.setVisible(true);
        minimizar.setActionCommand("mini");
        minimizar.addActionListener(this);
        barra.add(minimizar);

        eDo = new JTextField(estDef);
        eDo.setBounds(100, 140, 300, 25);
        eDo.setHorizontalAlignment(JTextField.CENTER);
        eDo.setVisible(true);
        eDo.addFocusListener(this);
        eDo.addKeyListener(this);
        eDo.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(eDo);

        Lat = new JTextField(latDef);
//        80
        Lat.setBounds(eDo.getX() + 20, eDo.getY() - 40, 100, 25);
        Lat.setHorizontalAlignment(JTextField.CENTER);
        Lat.setVisible(true);
        Lat.addFocusListener(this);
        Lat.addKeyListener(this);
        Lat.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(Lat);

        Long = new JTextField(longDef);
        Long.setBounds(eDo.getWidth() + eDo.getX() - 120, eDo.getY() - 40, 100, 25);
        Long.setHorizontalAlignment(JTextField.CENTER);
        Long.setVisible(true);
        Long.addFocusListener(this);
        Long.addKeyListener(this);
        Long.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(Long);

        muN = new JTextField(munDef);
//        160
        muN.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 15, 300, 25);
        muN.setHorizontalAlignment(JTextField.CENTER);
        muN.setVisible(true);
        muN.addFocusListener(this);
        muN.addKeyListener(this);
        muN.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(muN);

        cP = new JTextField(codDef);
        cP.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 55, 300, 25);
        cP.setHorizontalAlignment(JTextField.CENTER);
        cP.setVisible(true);
        cP.addFocusListener(this);
        cP.addKeyListener(this);
        cP.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(cP);

        cO = new JTextField(colDef);
        cO.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 95, 300, 25);
        cO.setHorizontalAlignment(JTextField.CENTER);
        cO.setVisible(true);
        cO.addFocusListener(this);
        cO.addKeyListener(this);
        cO.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(cO);

        cA = new JTextField(calDef);
        cA.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 135, 300, 25);
        cA.setHorizontalAlignment(JTextField.CENTER);
        cA.setVisible(true);
        cA.addFocusListener(this);
        cA.addKeyListener(this);
        cA.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(cA);

        nI = new JTextField(intDef);
        nI.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 175, 300, 25);
        nI.setHorizontalAlignment(JTextField.CENTER);
        nI.setVisible(true);
        nI.addFocusListener(this);
        nI.addKeyListener(this);
        nI.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(nI);

        agregar = new JButton("GUARDAR DATOS");
        agregar.setBounds(eDo.getX(), eDo.getY() + eDo.getHeight() + 215, 300, 25);
        agregar.setHorizontalAlignment(JTextField.CENTER);
        agregar.setVisible(true);
        agregar.addFocusListener(this);
        agregar.addActionListener(this);
        agregar.setBorderPainted(false);
        agregar.setActionCommand("agregarC");
        agregar.setFont(new java.awt.Font("Bahnschrift", 1, 20));
        barra.add(agregar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cerrar":
                bd.conectar();
                System.out.println(bd.eliminarDatos("usuario", "idUsuario", "" + idUsr + "", ""));
                this.setVisible(false);
                System.exit(0);
            case "mini":
                this.setExtendedState(ICONIFIED);
                break;
            case "agregarC":
                agregaC();
                break;
            default:
                break;
        }
    }

    private void accion() {
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
            System.out.println(resTex);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(agregaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregaC() {
        xCoorde = "(lat: " + Lat.getText().trim() + " , " + "long: " + Long.getText().trim() + ")";
        xEstado = eDo.getText().trim();
        xMuni = muN.getText().trim();
        xCodigoP = cP.getText().trim();//5
        xCol = cO.getText().trim();
        xCalle = cA.getText().trim();
        xNumInt = nI.getText().trim();//10
        boolean conD = true;

        if (xCodigoP.length() != 5 || xNumInt.length() > 10 || eDo.getText().equals(estDef)
                || muN.getText().equals(munDef) || cP.getText().equals(codDef)
                || cO.getText().equals(colDef) || cA.getText().equals(calDef)
                || nI.getText().equals(intDef) || Lat.getText().equals(latDef) || Long.getText().equals(longDef)) {
            if (Lat.getText().equals(latDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un estado");
                conD = false;
            }
            if (Long.getText().equals(longDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un estado");
                conD = false;
            }
            if (eDo.getText().equals(estDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un estado");
                conD = false;
            }
            if (muN.getText().equals(munDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un municipio");
                conD = false;
            }
            if (cP.getText().equals(codDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un codigo postal");
                conD = false;
            }
            if (cO.getText().equals(colDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese una colonia");
                conD = false;
            }
            if (cA.getText().equals(calDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese una calle");
                conD = false;
            }
            if (nI.getText().equals(intDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero interior");
                conD = false;
            } else if (xCodigoP.length() != 5) {
                JOptionPane.showMessageDialog(this, "Ingrese un codigo postal valido");
                cP.setText(codDef);
                conD = false;
            } else if (xNumInt.length() > 10) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero interior valido");
                nI.setText(intDef);
                conD = false;
            } else if (conD) {
                accion();
            }

        } else {
            accion();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == eDo && eDo.getText().equals(estDef)) {
            eDo.setText("");
        } else if (e.getSource() == muN && muN.getText().equals(munDef)) {
            muN.setText("");
        } else if (e.getSource() == cP && cP.getText().equals(codDef)) {
            cP.setText("");
        } else if (e.getSource() == cO && cO.getText().equals(colDef)) {
            cO.setText("");
        } else if (e.getSource() == cA && cA.getText().equals(calDef)) {
            cA.setText("");
        } else if (e.getSource() == nI && nI.getText().equals(intDef)) {
            nI.setText("");
        } else if (e.getSource() == Lat && Lat.getText().equals(latDef)) {
            Lat.setText("");
        } else if (e.getSource() == Long && Long.getText().equals(longDef)) {
            Long.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == eDo && eDo.getText().isEmpty()) {
            eDo.setText(estDef);
        } else if (e.getSource() == muN && muN.getText().isEmpty()) {
            muN.setText(munDef);
        } else if (e.getSource() == cP && cP.getText().isEmpty()) {
            cP.setText(codDef);
        } else if (e.getSource() == cO && cO.getText().isEmpty()) {
            cO.setText(colDef);
        } else if (e.getSource() == cA && cA.getText().isEmpty()) {
            cA.setText(calDef);
        } else if (e.getSource() == nI && nI.getText().isEmpty()) {
            nI.setText(intDef);
        } else if (e.getSource() == Lat && Lat.getText().isEmpty()) {
            Lat.setText(latDef);
        } else if (e.getSource() == Long && Long.getText().isEmpty()) {
            Long.setText(longDef);
        }
    }

    int tamaño;
    char keC;
    String str;
    validacionesJT vd = new validacionesJT();
    boolean vacio;

    @Override
    public void keyTyped(KeyEvent e) {
        keC = e.getKeyChar();

        vd.evalua(keC);

        if (e.getSource() == eDo) {//solo Letras

            str = eDo.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == muN) {//solo letras

            str = muN.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == cP) {//solo numeros

            str = cP.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloNumeros(tamaño, str);
        } else if (e.getSource() == cO) {//solo Letras

            str = cO.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == cA) {//solo Letras

            str = cA.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == nI) {//solo numeros y letras

            str = nI.getText().trim();
            tamaño = (str.length());

            vacio = vd.sinEspecial(tamaño, str);
        } else if (e.getSource() == Lat) {//solo numeros y signos

            str = Lat.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloSigno(tamaño, str);
        } else if (e.getSource() == Long) {//solo numeros y signos

            str = Long.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloSigno(tamaño, str);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(vacio);
        if (vacio) {

        } else if (e.getSource() == eDo) {
            eDo.setText("");
        } else if (e.getSource() == muN) {
            muN.setText("");
        } else if (e.getSource() == cP) {
            cP.setText("");
        } else if (e.getSource() == cO) {
            cO.setText("");
        } else if (e.getSource() == cA) {
            cA.setText("");
        } else if (e.getSource() == nI) {
            nI.setText("");
        } else if (e.getSource() == Lat) {
            Lat.setText("");
        } else if (e.getSource() == Long) {
            Long.setText("");
        }
    }

    int x, y, equis, yes;
    boolean move = false;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (move) {
            x = e.getXOnScreen() - equis;
            y = e.getYOnScreen() - yes;

            this.setLocation(x, y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == titulo) {
            equis = e.getX();
            yes = e.getY();
            move = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        move = false;
        equis = 0;
        yes = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
