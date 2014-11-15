package py.com.coursera.graph.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.BreadFirstPath;
import py.com.snowtech.datastructure.graphs.Grafo;

public class Graph2 {
	public static void main(String... args) throws FileNotFoundException {
		Grafo g = new Grafo(new FileReader("c:\\APs\\ques2.txt"));
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		for (int v=0; v<g.V(); v++) {
			System.out.print(letters[v] + ": ");
			for (int w : g.adj(v)) {
				System.out.print(letters[w] + " ");
			}
			System.out.println();
		}
		
		BreadFirstPath p = new BreadFirstPath(g, 0);	
		System.out.print("\nQuestion 2: ");
		for (int v : p.pushedNodes()) {
			System.out.print(letters[v] + " ");
		}
	}
}

/*
  0 4 5 6 2 7 1 3
//A E F G C H B D
8 con bag
0 5
0 4
1 2
2 5
2 6
2 7
3 7
4 5
5 6
6 7
* */
 