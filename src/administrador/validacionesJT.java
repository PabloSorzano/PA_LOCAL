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
    String letSign = "-+";

    char letrA[] = letras.toCharArray();
    char numA[] = numeros.toCharArray();
    char mailA[] = letMail.toCharArray();
    char signo[] = letSign.toCharArray();

    boolean vacio = true, mai;
    int cLetras, cNumeros, cMail, cSigno;

    public void evalua(char keC) {
        cLetras = 0;
        cNumeros = 0;
        cMail = 0;
        cSigno = 0;
        for (int i = 0; i < letras.length(); i++) {//evaluador
            if (keC == letrA[i]) {//letras
                cLetras++;
            } else if (i <= 9 && keC == numA[i]) {//numeros
                cNumeros++;
            } else if (i <= 3 && keC == mailA[i]) {//numeros
                cMail++;
            } else if (i <= 1 && keC == signo[i]) {//numeros y signo -
                System.out.println(signo[i]);
                cSigno++;
            }
        }
    }

    public boolean soloSigno(int tamaño, String str) {
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
//            System.out.println("cosas raras");
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
//            System.out.println("cosas raras");
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
//            System.out.println("cosas raras");
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
//            System.out.println("cosas raras");
            vacio = false;
        }
        return vacio;
    }

    public boolean evaluaCorreo(String correo) {
        int arroba = 0, punto = 0, letra = 0, largo = correo.trim().length();

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
            System.out.println(correo.charAt(i));
            System.out.println(arroba);
            System.out.println(punto);
            System.out.println(letra + "\n");
        }

        if (arroba == 0 || arroba > 1 || punto == 0 || letra <= 4) {
            mai = false;
        } else if (arroba == 1 && punto != 0 && letra > 4) {
            mai = true;
        }
        System.out.println(mai);
        return mai;
    }
}
