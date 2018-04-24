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
public class agregaCuarto extends JFrame implements ActionListener, FocusListener, KeyListener, MouseMotionListener, MouseListener {

    JButton minimizar, cerrar;
    JLabel barra, titulo;

    BD bd = new BD();
    Connection co = null;
    Statement s = null;
    ResultSet rs = null;

    int idUsr = 666, idHs = 666;
    
    String resTex = "",
            datos[] = null;

    public agregaCuarto(String d) {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
        iniciarVentana();
        agregarComponentes();
        this.datos = d.split(",");
        idHs = Integer.parseInt(datos[0]);
        idUsr = Integer.parseInt(datos[1]);
        System.out.println("Usuario: "+idUsr+"\n");
        System.out.println("Casa: "+idHs+"\n");
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cerrar":
                
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
    
    private void agregaC() {
    }
    
    int x, y, equis, yes;
    boolean move = false;
    
    int tamaño;
    char keC;
    String str;
    validacionesJT vd = new validacionesJT();
    boolean vacio;
    
    @Override
    public void focusGained(FocusEvent e) {
//        if (e.getSource() == eDo && eDo.getText().equals(estDef)) {
//            eDo.setText("");
//        } else if (e.getSource() == muN && muN.getText().equals(munDef)) {
//            muN.setText("");
        
    }

    @Override
    public void focusLost(FocusEvent e) {
//        if (e.getSource() == eDo && eDo.getText().isEmpty()) {
//            eDo.setText(estDef);
//        } else if (e.getSource() == muN && muN.getText().isEmpty()) {
//            muN.setText(munDef);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
//        keC = e.getKeyChar();
//
//        vd.evalua(keC);

//        if (e.getSource() == eDo) {//solo Letras
//
//            str = eDo.getText().trim();
//            tamaño = (str.length());
//
//            vacio = vd.soloLetras(tamaño, str);
//        } else if (e.getSource() == muN) {//solo letras

           
        }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(vacio);
        if (vacio) {

//        } else if (e.getSource() == eDo) {
//            eDo.setText("");
//        } else if (e.getSource() == muN) {
        }
    }
    
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
