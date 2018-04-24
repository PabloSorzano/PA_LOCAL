///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editoFr.
// */
//package administrador;
//
//import java.awt.Color;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.IOException;
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.BevelBorder;
//
///**
// *
// * @author Sorz Torres
// */
//public class inicio extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
//
//    JButton minimizar, cerrar, agregaU;
//    JLabel barra, titulo, agU;
//
//    BD bd = new BD();
//    Connection co = null;
//    Statement s = null;
//    ResultSet rs = null;
//
//    public inicio() {
//        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        //System.out.println(Arrays.toString(fontNames));
//        iniciarVentana();
//        agregarComponentes();
//
//    }
//
//    private void iniciarVentana() {
//        this.setSize(500, 500);
//        this.setUndecorated(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.setTitle("Administrador");
//        this.setLayout(null);
//        this.setOpacity(Float.parseFloat(".95"));
//        this.setVisible(true);
//
//        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
//    }
//
//    private void agregarComponentes() {
//        barra = new JLabel();
//        barra.setBounds(0, 0, this.getWidth(), this.getHeight());
//        barra.setOpaque(true);
//        barra.setBackground(Color.WHITE);
//        barra.setVisible(true);
//        barra.setFocusable(false);
//        this.add(barra);
//        
//        cerrar = new JButton("x");
//        cerrar.setBounds(450, 0, 50, 30);
//        cerrar.setFont(new java.awt.Font("Bahnschrift", 0, 22));
//        cerrar.setForeground(Color.BLACK);
//        cerrar.setBackground(Color.LIGHT_GRAY);
//        cerrar.setBorderPainted(false);
//        cerrar.setVisible(true);
//        cerrar.setActionCommand("cerrar");
//        cerrar.addActionListener(this);
//        barra.add(cerrar);
//
//        minimizar = new JButton("_");
//        minimizar.setBounds(398, 0, 50, 30);
//        minimizar.setFont(new java.awt.Font("Bahnschrift", 0, 22));
//        minimizar.setForeground(Color.BLACK);
//        minimizar.setBackground(Color.LIGHT_GRAY);
//        minimizar.setBorderPainted(false);
//        minimizar.setVisible(true);
//        minimizar.setActionCommand("mini");
//        minimizar.addActionListener(this);
//        barra.add(minimizar);
//        
//        agregaU = new JButton();
//        agregaU.setCursor(Cursor.getPredefinedCursor(0));
//        agregaU.addActionListener(this);
//        agregaU.setActionCommand("agregar");
//        agregaU.setBounds(122, 80, 256, 256);
//        agregaU.setBackground(new Color(255, 255, 255));
//        agregaU.setBorder(null);
//        agregaU.setVisible(true);
//        barra.add(agregaU);
//
//        titulo = new JLabel("Administrador");
////        396
//        titulo.setBounds(0, 0, this.getWidth()-cerrar.getWidth()-minimizar.getWidth()-4, 30);
//        titulo.setFont(new java.awt.Font("Bahnschrift", 0, 22));
//        //titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22));
//        titulo.setOpaque(true);
//        titulo.setForeground(Color.BLACK);
//        titulo.setBackground(Color.LIGHT_GRAY);
//        titulo.setVisible(true);
//        titulo.addMouseMotionListener(this);
//        titulo.addMouseListener(this);
//        titulo.setFocusable(false);
//        barra.add(titulo);
//        
//        agU = new JLabel("AGREGAR USUARIO");
////        125, 100, 256, 256
//        agU.setBounds( (this.getWidth()-190 )/2, agregaU.getY()+agregaU.getHeight(), 300, 100);        
//        agU.setFont(new java.awt.Font("Bahnschrift", 0, 20));
//        agU.setVisible(true);
//        barra.add(agU);
//        
//        try {
//            Image img = ImageIO.read(getClass().getResource("/administrador/Images/agU.png"));
//            img = img.getScaledInstance(agregaU.getWidth(), agregaU.getHeight(), Image.SCALE_FAST);
//
//            agregaU.setIcon(new ImageIcon(img));
//        } catch (IOException ex) {
//            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//
//        
//
//       
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        switch (e.getActionCommand()) {
//            case "cerrar":
//                this.setVisible(false);
//                System.exit(0);
//            case "mini":
//                this.setExtendedState(ICONIFIED);
//                break;
//            case "agregar":
//                agregaUsuario obj = new agregaUsuario();
//                this.dispose();
//                obj.setVisible(true);
//                break;
//            default:
//                break;
//        }
//    }
//
//    int x, y, equis, yes;
//    boolean move = false;
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        if (move) {
//            x = e.getXOnScreen() - equis;
//            y = e.getYOnScreen() - yes;
//
//            this.setLocation(x, y);
//        }
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        if (e.getSource() == titulo) {
//            equis = e.getX();
//            yes = e.getY();
//            move = true;
//        }
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        move = false;
//        equis = 0;
//        yes = 0;
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//    }
//}
