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
    public void createDemoGraph() throws IOException {
		Graph g = graph("example1").directed().with(node("A").link(node("B")).link(node("C")));                
		Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("C:\\Users\\walte\\Desktop\\example/ex1.png"));
	}
	
	public void createDemoFromDot() throws IOException {
            /*File file = new File("/Users/tuxtor/Downloads/linked_list.dot");            
            FileInputStream fis = null;		
            fis = new FileInputStream(file);		
            MutableGraph g = Parser.read(fis);
            Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("example/ex4-1.png"));*/
            File file = new File("C:\\Users\\walte\\Desktop\\linked_list.dot");            
            FileInputStream fis = null;		
            fis = new FileInputStream(file);		
            MutableGraph g = Parser.read(fis);
            Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("C:\\Users\\walte\\Desktop\\example\\WalterOsoy_1126017.png"));
        }
}
