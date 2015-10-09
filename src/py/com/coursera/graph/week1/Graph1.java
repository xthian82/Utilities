package py.com.coursera.graph.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.DepthFirstPath;
import py.com.snowtech.datastructure.graphs.Grafo;

public class Graph1 {
	
	public static void main(String... args) throws FileNotFoundException {
		Grafo g = new Grafo(new FileReader("ques2.txt"));
		g.letterPrint();
		
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		DepthFirstPath p = new DepthFirstPath(g, 0);
		//DepthFirstPath p2 = new DepthFirstPath(g, 0, true);
		
		System.out.print("\nQuestion 1: ");
		for (int v : p.pushedNodes()) {
			System.out.print(letters[v] + " ");
		}
		//System.out.print("\nQuestion 1: ");
		//for (int v : p2.pushedNodes()) {
			//System.out.print(letters[v] + " ");
		//}
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
