package py.com.coursera.digraphy.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.Digrafo;
import py.com.snowtech.sort.Topological;

/*
 A:  
 B:  F G A 
 C:  D G B H 
 D:  H 
 E:  F B A 
 F:  G 
 G:  H 
 H:  
 * */
public class Digraph2 {
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("digraph2.txt"));
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H" };

		for (int v = 0; v < g.V(); v++) {
			System.out.print(letters[v] + ": ");
			for (int w : g.adj(v)) {
				System.out.print(letters[w] + " ");
			}
			System.out.println();
		}
		Topological app = new Topological(g);
		
		System.out.print("\nQuestion 2: ");
		for (int n : app.reversePost()) {
			System.out.print(letters[n] + " ");
		}
		
	}
}
