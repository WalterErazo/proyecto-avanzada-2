package com.mycompany.proyecto_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoader {

    public void loadFileWithJava7() {
        File file = new File("/Users/tuxtor/Downloads/linked_list.dot");

        try (FileInputStream fis = new FileInputStream(file)) {

            System.out.println("Total file size to read (in bytes) : " + fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
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
