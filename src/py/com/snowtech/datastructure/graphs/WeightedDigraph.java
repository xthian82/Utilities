package py.com.snowtech.datastructure.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import py.com.snowtech.datastructure.lists.Lista;

public class WeightedDigraph {
	private final int vertices;
	private Lista<DirectedEdge>[] adj;
	private Lista<DirectedEdge> edges;
	
	public WeightedDigraph(int V) {
		this.vertices = V;
		this.edges = new Lista<DirectedEdge>();
		buildList(V);
	}
	
	public WeightedDigraph(InputStreamReader in) {
		this.edges = new Lista<DirectedEdge>();
		this.vertices = processFile( in );
	}
	
	@SuppressWarnings("unchecked")
	private void buildList(int total) {
		adj = (Lista<DirectedEdge>[])new Lista[total];
		
		for (int v = 0; v < total; v++) {
			adj[v] = new Lista<DirectedEdge>();
		}
		
	}
	
	private int processFile(InputStreamReader in) {
		int n = 0;

		BufferedReader r = new BufferedReader(in);
		String s = null;
		
		try {
			n = Integer.parseInt(r.readLine());
			buildList(n);
			
			while ((s = r.readLine()) != null) {
				String [] tok = s.split(" ");
				
				if (tok.length == 3) {
					try {
						int v = Integer.parseInt(tok[0]);
						int w = Integer.parseInt(tok[1]);
						double we = Double.parseDouble(tok[2]);
						addEge(new DirectedEdge(v, w, we));
					} catch (NumberFormatException x) {
						System.err.println(x.getMessage());
					}
				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	public void addEge(DirectedEdge e) {
		int v = e.from();
		adj[v].add(e);
		edges.add(e);
		
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges() {
		return this.edges;
	}
	

	//number of vertifces
	public int V() {
		return this.vertices;
	}
	
	//number of edges
	public int E() {
		return this.edges.size();
	}
	
	public void print() {
		for (int v=0; v<V(); v++) {
			System.out.print(v + ":");
			for (DirectedEdge e : adj(v)) {
				System.out.print(" " + e);
			}
			System.out.println();
		}
		System.out.println();
	}
}
