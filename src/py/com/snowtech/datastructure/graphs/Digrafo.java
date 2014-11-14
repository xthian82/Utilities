package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import py.com.snowtech.datastructure.lists.Bolsa;

public class Digrafo extends Grafo {
	private static final ProcessEdge f2 = new ProcessEdge() {
		public void addEdge(int v, int w, Bolsa<Integer>[] adj) {
			adj[v].add(w);
	    }
	};
	
	public Digrafo(int V) {
		super(V);
	}

	public Digrafo(InputStreamReader in) {
		super(in, f2);
	}
	
	//add edge v-w
	public void addEdge(int v, int  w) {
		f2.addEdge(v, w, adj);
		++edges;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("digrafo.txt"));
		
		for (int v=0; v<g.V(); v++) {
			for (int w : g.adj(v)) {
				System.out.println(v + " - " + w);
			}
		}
		int s = 2;
		
		DepthFirstPath p = new DepthFirstPath(g, s);
		
		//print all vertices connected to 's'
		for (int v=0; v<g.V(); v++) {
			if (p.hasPathTo(v))
				System.out.print(v + " ");
		}
	}
}
