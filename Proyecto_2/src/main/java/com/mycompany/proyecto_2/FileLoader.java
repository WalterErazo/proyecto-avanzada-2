package com.mycompany.proyecto_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoader {
    /**
     * 
     * @param ruta direccion del archivo a leer
     * @return retorna un cadena con el archivo completo para mostrarlo en un text area
     */
    public String showInScreen(String ruta) {
        String cadena="";
        File file = new File(ruta);
        try (FileInputStream fis = new FileInputStream(file)) {            
            int content;
            while ((content = fis.read()) != -1) {                                
                cadena+=(char) content;
            }
            return cadena;
        } catch (IOException e) {
            return e.toString();
        }
    }
    
    public void loadFileWithJava7(String ruta) {
        File file = new File(ruta);
        try (FileInputStream fis = new FileInputStream(file)) {            
            int content;
            while ((content = fis.read()) != -1) {              
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeUsingFileWriter(String data) {
        File file = new File("/Users/tuxtor/Downloads/salida.txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
