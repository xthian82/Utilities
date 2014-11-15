package py.com.coursera.graph.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.DepthFirstPath;
import py.com.snowtech.datastructure.graphs.Grafo;

public class Graph1 {
	
	public static void main(String... args) throws FileNotFoundException {
		Grafo g = new Grafo(new FileReader("c:\\APs\\ques1.txt"));
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		DepthFirstPath p = new DepthFirstPath(g, 0);
		for (int v=0; v<g.V(); v++) {
			System.out.print(letters[v] + ": ");
			for (int w : g.adj(v)) {
				System.out.print(letters[w] + " ");
			}
			System.out.println();
		}
		System.out.print("\nQuestion 1: ");
		for (int v : p.pushedNodes()) {
			System.out.print(letters[v] + " ");
		}
	}
}

/*
0 5 2 3 7 1 6 4
A F C D H B G E
con lista
8
0 5
0 4
5 2
2 3
3 7
1 5
5 6
7 2
1 2
*/
