package com.mycompany.proyecto_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileLoader {

    /**
     *
     * @param ruta direccion del archivo a leer
     * @return retorna un cadena con el archivo completo para mostrarlo en un
     * text area
     */
    public String showInScreen(String ruta) {
        String cadena = "";
        File file = new File(ruta);
        try (FileInputStream fis = new FileInputStream(file)) {
            int content;
            while ((content = fis.read()) != -1) {
                cadena += (char) content;
            }
            return cadena;
        } catch (IOException e) {
            return e.toString();
        }
    }
/**
 * lee cada dos lineas para poder saber el tipo de estrutura y los datos a conformala
 * @param ruta direccion del archivo a leer
 */
    public void loadFileWithJava7(String ruta) {
        procesos obj = new procesos();
        int cont =0;
        String linea1="";
        String linea2="";
        File file = new File(ruta);
        try (FileInputStream fis = new FileInputStream(file)) {
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linea;            
            while ((linea = br.readLine()) != null ) {
                 if(cont==0){
                     linea1=linea;
                     cont++;
                 }else if(cont==1){
                     cont=0;
                     linea2=linea;
                     obj.agragardatos(ruta,linea1,linea2);
                 }                         
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * recibe un cadena de texto que luegue escribe dentro de un archivo llamado TempGraficas.dot que hace posible la grafica de la estructura
 * @param data datos a escribir
 */
    public void writeUsingFileWriter(String data) {
        File file = new File("C:\\Users\\walte\\OneDrive\\Documents\\universidad\\segundo ciclo\\progra. avanzada\\proyecto-avanzada-2/TempGraficas.dot");       
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
