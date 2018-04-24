/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

/**
 *
 * @author Alumno
 */
public class validacionesJT {

    String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz ";
    String numeros = "1234567890";
    String letMail = "@._-";
    String letSign = "-+.";

    char letrA[] = letras.toCharArray();
    char numA[] = numeros.toCharArray();
    char mailA[] = letMail.toCharArray();
    char signo[] = letSign.toCharArray();

    boolean vacio = true, mai;
    int cLetras, cNumeros, cMail, cSigno, cPunto;

    public void contaR(String k) {
        cLetras = 0;
        cNumeros = 0;
        cMail = 0;
        cSigno = 0;
        cPunto = 0;
        for (int i = 0; i < k.length(); i++) {//evaluador
            if (k.charAt(i) == letrA[i]) {//letras
                cLetras++;
            } else if (i <= 9 && k.charAt(i) == numA[i]) {//numeros
                cNumeros++;
            } else if (i <= 3 && k.charAt(i) == mailA[i]) {//numeros
                cMail++;
            } else if (i <= 2 && k.charAt(i) == signo[i]) {//numeros y signo -
                cSigno++;
            }

        }
    }

    public boolean soloSignoyPunto(int tamaño, String str) {
        if (tamaño == 0 || tamaño == 1) {

        } else {
            tamaño = str.length() - 2;
        }
        if (cLetras != 0 && cNumeros == 0) {
//            System.out.println("pura letra");
            vacio = false;
        } else if (cNumeros != 0 && cLetras == 0) {
//            System.out.println("puro numero");
            vacio = true;
        } else if (cSigno != 0) {
//            System.out.println("caracteres correo");
            vacio = true;
        } else if (cMail != 0) {
//            System.out.println("cosas raras");
            vacio = false;
        } else {
            vacio = false;
        }
        return vacio;
    }

    public boolean soloLetras(int tamaño, String str) {
        if (tamaño == 0 || tamaño == 1) {

        } else {
            tamaño = str.length() - 2;
        }
        if (cLetras != 0 && cNumeros == 0) {
//            System.out.println("pura letra");
            vacio = true;
        } else if (cNumeros != 0 && cLetras == 0) {
//            System.out.println("puro numero");
            vacio = false;
        } else if (cMail != 0) {
//            System.out.println("caracteres correo");
            vacio = false;
        } else {
            vacio = false;
        }
        return vacio;
    }

    public boolean soloNumeros(int tamaño, String str) {
        if (tamaño == 0 || tamaño == 1) {

        } else {
            tamaño = str.length() - 2;
        }
        if (cLetras != 0 && cNumeros == 0) {
//            System.out.println("pura letra");
            vacio = false;
        } else if (cNumeros != 0 && cLetras == 0) {
//            System.out.println("puro numero");
            vacio = true;
        } else if (cMail != 0) {
//            System.out.println("caracteres correo");
            vacio = false;
        } else {
            vacio = false;
        }
        return vacio;
    }

    public boolean soloMail(int tamaño, String str) {
        if (tamaño == 0 || tamaño == 1) {

        } else {
            tamaño = str.length() - 2;
        }
        if (cLetras != 0 && cNumeros == 0) {
//            System.out.println("pura letra");
            vacio = true;
        } else if (cNumeros != 0 && cLetras == 0) {
//            System.out.println("puro numero");
            vacio = true;
        } else if (cMail != 0) {
//            System.out.println("caracteres correo");
            vacio = true;
        } else {
            vacio = false;
        }
        return vacio;
    }

    public boolean sinEspecial(int tamaño, String str) {
        if (tamaño == 0 || tamaño == 1) {

        } else {
            tamaño = str.length() - 2;
        }
        if (cLetras != 0 && cNumeros == 0) {
//            System.out.println("pura letra");
            vacio = true;
        } else if (cNumeros != 0 && cLetras == 0) {
//            System.out.println("puro numero");
            vacio = true;
        } else if (cMail != 0) {
//            System.out.println("caracteres correo");
            vacio = false;
        } else {
            vacio = false;
        }
        return vacio;
    }

    public boolean evaluaCorreo(String correo) {
        int arroba = 0,
                punto = 0,
                letra = 0,
                largo = correo.trim().length();

        for (int i = 0; i < largo; i++) {

            switch (correo.charAt(i)) {
                case '@':
                    arroba++;
                    break;
                case '.':
                    punto++;
                    break;
                default:
                    letra++;
                    break;
            }
//            System.out.println(correo.charAt(i));
//            System.out.println(arroba);
//            System.out.println(punto);
//            System.out.println(letra + "\n");
        }

        if (arroba == 0 || arroba > 1 || punto == 0 || letra <= 4) {
            mai = false;
        } else if (arroba == 1 && punto != 0 && letra > 4) {
            mai = true;
        }
        System.out.println("Eva Mai: " + mai);
        return mai;
    }

    public boolean evaluaCoord(String lat, String lg) {
        int arrobaA = 0,
                puntoA = 0,
                letraA = 0,
                arrobaO = 0,
                puntoO = 0,
                letraO = 0,
                largoA = lat.length(),
                largoO = lg.length();

        for (int i = 0; i < largoA; i++) {

            switch (lat.charAt(i)) {
                case '@':
                    arrobaA++;
                    break;
                case '.':
                    puntoA++;
                    break;
                default:
                    letraA++;
                    break;
            }
        }

        for (int i = 0; i < largoO; i++) {
            switch (lg.charAt(i)) {
                case '@':
                    arrobaO++;
                    break;
                case '.':
                    puntoO++;
                    break;
                default:
                    letraO++;
                    break;
            }
//            System.out.println(correo.charAt(i));
//            System.out.println(arroba);
//            System.out.println(punto);
//            System.out.println(letra + "\n");
        }

        if (puntoA != 1 || puntoO != 1 || arrobaA != 0 || arrobaO != 0 || letraA == 0 || letraO == 0) {
            mai = false;
        } else if (puntoA == 1 && puntoO == 1 && arrobaA == 0 && arrobaO == 0) {
            mai = true;
        }
        System.out.println("Eva Coord: " + mai + "\n");
        return mai;
    }
}
