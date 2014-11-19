package py.com.snowtech.datastructure.graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import py.com.snowtech.datastructure.lists.Lista;

public class WeigthedGraph {
	private final int vertices;
	private Lista<Edge>[] adj;
	private Lista<Edge> edges;
	
	public WeigthedGraph(int V) {
		this.vertices = V;
		this.edges = new Lista<Edge>();
		buildList(V);
	}
	
	public WeigthedGraph(InputStreamReader in) {
		this.edges = new Lista<Edge>();
		this.vertices = processFile( in );
	}
	
	@SuppressWarnings("unchecked")
	private void buildList(int total) {
		adj = (Lista<Edge>[])new Lista[total];
		
		for (int v = 0; v < total; v++) {
			adj[v] = new Lista<Edge>();
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
						addEge(new Edge(v, w, we));
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

	public void addEge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		edges.add(e);
		
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public void print() {
		for (int v=0; v<V(); v++) {
			System.out.print(v + ":");
			for (Edge e : adj(v)) {
				System.out.print(" " + e);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public Iterable<Edge> edges() {
		return this.edges;
	}
	

	//number of vertifces
	public int V() {
		return this.vertices;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		WeigthedGraph g = new WeigthedGraph(new FileReader("wgrafo1.txt"));
		g.print();
	}
}
