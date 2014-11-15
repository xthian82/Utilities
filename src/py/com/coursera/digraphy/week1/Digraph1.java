package py.com.coursera.digraphy.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.BreadFirstPath;
import py.com.snowtech.datastructure.graphs.Digrafo;

/*
 *  A:  E 
    B:  C G A 
    C:  G 
    D:  C 
    E:  B 
    F:  E G B 
    G:  H D 
    H:  D 
 * */
public class Digraph1 {
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("digraph1.txt"));
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		BreadFirstPath p = new BreadFirstPath(g, 0);
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
