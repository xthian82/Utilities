package py.com.coursera.graph.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.CC;
import py.com.snowtech.datastructure.graphs.Grafo;

public class Graph3 {
	public static void main(String[] args) throws FileNotFoundException {
		Grafo g = new Grafo(new FileReader("c:\\APs\\ques3.txt"));
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};	
				
		for (int v=0; v<g.V(); v++) {
			System.out.print(letters[v] + ": ");
			for (int w : g.adj(v)) {
				System.out.print(letters[w] + " ");
			}
			System.out.println();
		}
		
		CC app = new CC(g);
		System.out.print("\nQuestion 3: ");
		for (int v = 0; v<letters.length; v++) {
			System.out.print(app.id(v) + " ");
		}
	}
}
