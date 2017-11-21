package com.mycompany.proyecto_2;

import javax.swing.JOptionPane;

public class procesos {

    public void agragardatos(String ruta, String guardado, String estructura, String datos) {
        String partes[] = datos.split(" ");
        int argdatos[] = new int[partes.length];
        for (int x = 0; x < partes.length; x++) {
            argdatos[x] = Integer.parseInt(partes[x]);
        }
        String letra = estructura.substring(0);
        letra = letra.toLowerCase();
        char let = letra.charAt(0);
        switch (let) {
            case 's':
                
                break;
            case 'q':
                
                break;
            case 'l':
                
                break;
            case 'c':
                
                break;
            case 'd':
                
                break;
            case 'b':
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "error");
                break;
        }
    }

}
