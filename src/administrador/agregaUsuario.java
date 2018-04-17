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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author Sorz Torres
 */
public class agregaUsuario extends JFrame implements ActionListener, FocusListener, KeyListener, MouseMotionListener, MouseListener {

    JButton minimizar, cerrar, agregar;
    JLabel barra, titulo;

    BD bd = new BD();
    validacionesJT va = new validacionesJT();
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

    public agregaUsuario() {
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
        iniciarVentana();
        agregarComponentes();
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

        titulo = new JLabel("Administrador");
        titulo.setBounds(0, 0, this.getWidth() - cerrar.getWidth() - minimizar.getWidth() - 4, 30);
        titulo.setFont(new java.awt.Font("Bahnschrift", 0, 22));
        //titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22));
        titulo.setOpaque(true);
        titulo.setForeground(Color.BLACK);
        titulo.setBackground(Color.LIGHT_GRAY);
        titulo.setVisible(true);
        titulo.addMouseMotionListener(this);
        titulo.addMouseListener(this);
        titulo.setFocusable(false);
        barra.add(titulo);

        nE = new JTextField(namDef);
        nE.setBounds(100, 125, 300, 25);
        nE.setHorizontalAlignment(JTextField.CENTER);
        nE.setVisible(true);
        nE.addFocusListener(this);
        nE.addKeyListener(this);
        nE.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(nE);

        aP = new JTextField(patDef);
        aP.setBounds(nE.getX(), nE.getY() + nE.getHeight() + 15, 300, 25);
        aP.setHorizontalAlignment(JTextField.CENTER);
        aP.setVisible(true);
        aP.addFocusListener(this);
        aP.addKeyListener(this);
        aP.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(aP);

        aM = new JTextField(matDef);
        aM.setBounds(nE.getX(), aP.getY() + aP.getHeight() + 15, 300, 25);
        aM.setHorizontalAlignment(JTextField.CENTER);
        aM.setVisible(true);
        aM.addFocusListener(this);
        aM.addKeyListener(this);
        aM.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(aM);

        tC = new JTextField(celDef);
        tC.setBounds(nE.getX(), aM.getY() + aM.getHeight() + 15, 300, 25);
        tC.setHorizontalAlignment(JTextField.CENTER);
        tC.setVisible(true);
        tC.addFocusListener(this);
        tC.addKeyListener(this);
        tC.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(tC);

        mL = new JTextField(mailDef);
        mL.setBounds(nE.getX(), tC.getY() + tC.getHeight() + 15, 300, 25);
        mL.setHorizontalAlignment(JTextField.CENTER);
        mL.setVisible(true);
        mL.addFocusListener(this);
        mL.addKeyListener(this);
        mL.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(mL);

        pW = new JTextField(passDef);
        pW.setBounds(nE.getX(), mL.getY() + mL.getHeight() + 15, 300, 25);
        pW.setHorizontalAlignment(JTextField.CENTER);
        pW.setVisible(true);
        pW.addFocusListener(this);
        pW.addKeyListener(this);
        pW.setFont(new java.awt.Font("Bahnschrift", 0, 20));
        barra.add(pW);

        agregar = new JButton("GUARDAR DATOS");
        agregar.setBounds(nE.getX(), pW.getY() + pW.getHeight() + 15, 300, 25);
        agregar.setHorizontalAlignment(JTextField.CENTER);
        agregar.setVisible(true);
        agregar.addFocusListener(this);
        agregar.addActionListener(this);
        agregar.setActionCommand("agregarU");
        agregar.setFont(new java.awt.Font("Bahnschrift", 1, 20));
        agregar.setOpaque(true);
        agregar.setBorderPainted(false);
        barra.add(agregar);
    }

    private void accion() {
        try {
            bd.conectar();
            bd.agregaU(xnombre, xaPat, xaMat, xcel, xmail, xpass);
            rs = bd.obtenerDatos("usuario", "*", "Email = '" + xmail + "'");
            if (rs.next()) {
//                System.out.println("Usuario existente");
                JOptionPane.showMessageDialog(this, "Usuario existente");
                inicio obj = new inicio();
                this.dispose();
                obj.setVisible(true);
            } else {
                s = bd.procedimiento("altaUsuario");
                rs = bd.obtenerDatos("usuario", "*", "Email = '" + xmail + "'");
                while (rs.next()) {
                    resTex += rs.getString(1) + ",";
                    resTex += rs.getString(2) + ",";
                    resTex += rs.getString(6) + ",";
                    resTex += rs.getString(7);
                }
                agregaCasa obj = new agregaCasa(resTex);
                this.dispose();
                obj.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(agregaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregaUsuario() {
        xnombre = nE.getText().trim();
        xaPat = aP.getText().trim();
        xaMat = aM.getText().trim();
        xcel = tC.getText().trim();
        xmail = mL.getText().trim();
        xpass = pW.getText().trim();
        boolean cOrr = true,
                conD = true;

        if (cOrr || xcel.length() != 10 || nE.getText().equals(namDef)
                || aP.getText().equals(patDef) || aM.getText().equals(matDef)
                || tC.getText().equals(celDef) || mL.getText().equals(mailDef)
                || pW.getText().equals(passDef)) {
            
            cOrr = va.evaluaCorreo(xmail);
            System.out.println("\n" + cOrr);
            
            if (nE.getText().equals(namDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                conD = false;
            }
            if (aP.getText().equals(patDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un apellido paterno");
                conD = false;
            }
            if (aM.getText().equals(matDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un apellido materno");
                conD = false;
            }
            if (tC.getText().equals(celDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un celular");
                conD = false;
            }
            if (mL.getText().equals(mailDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese un correo");
                conD = false;
            }
            if (pW.getText().equals(passDef)) {
                JOptionPane.showMessageDialog(this, "Ingrese una contraseña");
                conD = false;
            }else if (cOrr == false) {
                JOptionPane.showMessageDialog(this, "Ingrese un correo valido");
                mL.setText(mailDef);
                conD = false;
            } else if (xcel.length() != 10) {
                JOptionPane.showMessageDialog(this, "Ingrese un celular valido");
                tC.setText(celDef);
                conD = false;
            } else if (conD == true && cOrr == true) {
                accion();
            } else {
                System.out.println("Checa tus datos");
            }
        } else {
            accion();
        }

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
            case "agregarU":
                agregaUsuario();
                break;
            default:
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == nE && nE.getText().equals(namDef)) {
            nE.setText("");
        } else if (e.getSource() == aP && aP.getText().equals(patDef)) {
            aP.setText("");
        } else if (e.getSource() == aM && aM.getText().equals(matDef)) {
            aM.setText("");
        } else if (e.getSource() == tC && tC.getText().equals(celDef)) {
            tC.setText("");
        } else if (e.getSource() == mL && mL.getText().equals(mailDef)) {
            mL.setText("");
        } else if (e.getSource() == pW && pW.getText().equals(passDef)) {
            pW.setText("");
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == nE && nE.getText().isEmpty()) {
            nE.setText(namDef);
        } else if (e.getSource() == aP && aP.getText().isEmpty()) {
            aP.setText(patDef);
        } else if (e.getSource() == aM && aM.getText().isEmpty()) {
            aM.setText(matDef);
        } else if (e.getSource() == tC && tC.getText().isEmpty()) {
            tC.setText(celDef);
        } else if (e.getSource() == mL && mL.getText().isEmpty()) {
            mL.setText(mailDef);
        } else if (e.getSource() == pW && pW.getText().isEmpty()) {
            pW.setText(passDef);
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

        if (e.getSource() == nE) {

            str = nE.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == aP) {

            str = aP.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == aM) {

            str = aM.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloLetras(tamaño, str);
        } else if (e.getSource() == tC) {

            str = tC.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloNumeros(tamaño, str);
        } else if (e.getSource() == mL) {

            str = mL.getText().trim();
            tamaño = (str.length());

            vacio = vd.soloMail(tamaño, str);
        } else if (e.getSource() == pW) {

            str = pW.getText().trim();
            tamaño = (str.length());

            vacio = vd.sinEspecial(tamaño, str);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (vacio) {

        } else if (e.getSource() == nE) {
            nE.setText("");
        } else if (e.getSource() == aP) {
            aP.setText("");
        } else if (e.getSource() == aM) {
            aM.setText("");
        } else if (e.getSource() == tC) {
            tC.setText("");
        } else if (e.getSource() == mL) {
            mL.setText("");
        } else if (e.getSource() == pW) {
            pW.setText("");
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
