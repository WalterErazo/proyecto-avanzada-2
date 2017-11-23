package com.mycompany.proyecto_2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class procesos {

    private int contArchivos = 0;
    public FileLoader write = new FileLoader();
    public DemoGraphviz draw = new DemoGraphviz();

    /**
     *
     * @param ruta direccion del archivo
     * @param estructura tipo de estructura que se desea graficar
     * @param datos datos a conformar la estructuta
     */
    public void agragardatos(String ruta, String estructura, String datos) {
        String partes[] = datos.split(" ");
        String letra = estructura.substring(0);
        letra = letra.toLowerCase();
        char let = letra.charAt(0);
        switch (let) {
            case 's': {
                try {
                    JOptionPane.showMessageDialog(null, "stack");//pila
                    write.writeUsingFileWriter(ingresarStack(partes));
                    draw.createDemoFromDot();
                } catch (IOException ex) {
                    Logger.getLogger(procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 'q': {
                try {
                    JOptionPane.showMessageDialog(null, "queue");//cola
                    write.writeUsingFileWriter(ingresarQueue(partes));
                    draw.createDemoFromDot();
                } catch (IOException ex) {
                    Logger.getLogger(procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 'l': {
                try {
                    JOptionPane.showMessageDialog(null, "linked");
                    write.writeUsingFileWriter(ingresarlist(partes));
                    draw.createDemoFromDot();
                } catch (IOException ex) {
                    Logger.getLogger(procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 'c': {
                try {
                    JOptionPane.showMessageDialog(null, "circular");
                    write.writeUsingFileWriter(ingresarCircularList(partes));
                    draw.createDemoFromDot();
                } catch (IOException ex) {
                    Logger.getLogger(procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 'd': {
                try {
                    JOptionPane.showMessageDialog(null, "double");
                    write.writeUsingFileWriter(ingresarDoubleList(partes));
                    draw.createDemoFromDot();
                } catch (IOException ex) {
                    Logger.getLogger(procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 'b':
                JOptionPane.showMessageDialog(null, "btree");
                break;
            default:
                JOptionPane.showMessageDialog(null, "error");
                break;
        }
    }

    /**
     * escribe el formato para el archivo .dot
     *
     * @param datos elementos que conforma estrutura de una pila
     * @return
     */
    private String ingresarStack(String datos[]) {
        String cadena = "graph g{ ";
        for (int z = 0; z < datos.length; z++) {
            cadena += datos[z] + "; ";
        }
        for (int x = datos.length - 1; x > 0; x--) {
            cadena += datos[x] + " -- " + datos[x - 1] + "; ";
        }
        cadena += "}";
        return cadena;
    }

    /**
     * escribe el formato para el archivo .dot
     *
     * @param datos elementos que conforma estrutura de una cola
     * @return fromato ya creado
     */
    private String ingresarQueue(String datos[]) {
        String cadena = "graph{ ";
        for (int x = 0; x < datos.length - 1; x++) {
            cadena += datos[x] + " -- " + datos[x + 1] + "; ";
        }
        cadena += "}";
        return cadena;
    }

    /**
     * escribe el formato para el archivo .dot
     *
     * @param datos elementos que conforma estrutura de una lista simple
     * @return
     */
    private String ingresarlist(String datos[]) {
        String cadena = "graph{ head--" + datos[0] + "; ";
        for (int x = 0; x < datos.length - 1; x++) {
            cadena += datos[x] + " -- " + datos[x + 1] + "; ";
        }
        cadena += datos[datos.length - 1] + "-- tail" + "}";
        return cadena;
    }
    /**
     * escribe el formato para el archivo .dot
     *
     * @param datos elementos que conforma estrutura de una lista circular
     * @return
     */
    private String ingresarCircularList(String datos[]) {
        String cadena = "graph{ layout=circo; ";
        for (int x = 0; x < datos.length - 1; x++) {
            cadena += datos[x] + " -- " + datos[x + 1] + "; ";
        }
        cadena += datos[datos.length - 1] + "--" + datos[0];
        cadena += "tail" + "--" + datos[datos.length - 1];
        cadena += "}";
        return cadena;
    }
    /**
     * escribe el formato para el archivo .dot
     * @param datos elementos que conforma estrutura de una lista doblemente
     * enlasada
     * @return
     */
    private String ingresarDoubleList(String datos[]) {
        String cadena = "graph{ head--" + datos[0] + "; ";
        for (int x = 0; x < datos.length - 1; x++) {
            cadena += datos[x] + " -- " + datos[x + 1] + "; ";
            cadena += datos[x + 1] + " -- " + datos[x] + "; ";
        }
        cadena += datos[datos.length - 1] + "-- tail" + "}";
        return cadena;
    }
    
}
