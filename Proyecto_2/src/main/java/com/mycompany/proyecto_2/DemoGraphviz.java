package com.mycompany.proyecto_2;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DemoGraphviz {
    private int cont=1;    
    /**
     * grafica el formato TempGraficas.dot que fue previamente modificado segun la estructura deseada
     * @throws IOException 
     */
    public void createDemoFromDot() throws IOException {        
        File file = new File("C:\\Users\\walte\\OneDrive\\Documents\\universidad\\segundo ciclo\\progra. avanzada\\proyecto-avanzada-2/TempGraficas.dot");
        FileInputStream fis = null;
        fis = new FileInputStream(file);
        MutableGraph g = Parser.read(fis);
        Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\walte\\OneDrive\\Documents\\universidad\\segundo ciclo\\progra. avanzada\\proyecto-avanzada-2\\pictures/picture"+cont+".png"));
        cont ++;
    }
}
