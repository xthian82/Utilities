package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;


import py.com.snowtech.datastructure.lists.Lista;

public class Digrafo extends Grafo {
	private static final ProcessEdge f2 = new ProcessEdge() {
		public void addEdge(int v, int w, Lista<Integer>[] adj) {
			adj[v].add(w);
	    }
		public void revAddEdge(int v, int w, Lista<Integer>[] adj) {
			adj[v].addFirst(w);
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
	
	public void revAddEdge(int v, int  w) {
		f2.revAddEdge(v, w, adj);
		++edges;
	}
	
	public Digrafo reverse() {
		Digrafo rg = new Digrafo(this.vertices);
		
		for (int v=0; v<this.vertices; v++) {
			for (int w : this.adj(v)) {
				rg.revAddEdge(w, v);
				//p.push(w);
			}
		}
		
		return rg;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("digraph3.txt"));
		Digrafo rg = g.reverse();
		System.out.print("Original Graph\n");
		g.print();
		System.out.print("\nReverse Graph\n");
		rg.print();
	}
}
