package py.com.snowtech.datastructure.graphs;

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
}
