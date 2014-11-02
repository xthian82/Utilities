package py.com.snowtech.datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grafo {
	private final int V;
	private Bolsa<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Grafo(int V) {
		this.V = V;
		
		adj = (Bolsa<Integer>[])new Bolsa[V];
		
		for (int v = 0; v < V; v++)
			adj[v] = new Bolsa<Integer>();
	}
	
	@SuppressWarnings("unchecked")
	public Grafo(InputStreamReader in) {
		BufferedReader r = new BufferedReader(in);
		int n = 0;
		String s = null;
		
		try {
			n = Integer.parseInt(r.readLine());
			adj = (Bolsa<Integer>[])new Bolsa[n];
			
			for (int v = 0; v < n; v++)
				adj[v] = new Bolsa<Integer>();
			
			while ((s = r.readLine()) != null) {
				String [] tok = s.split(" ");
				
				if (tok.length == 2) {
					try {
						int v = Integer.parseInt(tok[0]);
						int w = Integer.parseInt(tok[1]);
						addEdge(v, w);
						
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
		
		this.V = n;
	}
	
	//add edge v-w
	void addEdge(int v, int  w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	// vertices adjacents to v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	//number of vertifces
	public int V() {
		return V;
	}
	
	//number of edges
	public int E() {
		return 0;
	}
	
	public String toString() {
		return "";
	}
	
	//compute degree of v
	@SuppressWarnings("unused")
	public static int degree(Grafo g, int v) {
		int degree = 0;
		
		for (int w: g.adj(v)) ++degree;
		
		return degree;
	}
	
	//compute maximum degree
	public static int maxDegree(Grafo g) {
		int max = 0;
		int d;
		
		for (int v = 0; v<g.V(); v++) {
			d = degree(g, v);
			if (d > max) max = d;
		}
		
		return max;
	}
	
	//compute average degree
	public static double averageDegree(Grafo g) {
		return 2.0 * g.E() / g.V();
	}
	
	public static int numberOfSelfLoops(Grafo g) {
		int count = 0;
		for (int v = 0; v<g.V(); v++) {
			for (int w : g.adj(v)) {
				if (v == w) count++;
			}
		}
		
		return count / 2;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Grafo g = new Grafo(new FileReader("tokens.txt"));
		
		for (int v=0; v<g.V(); v++) {
			for (int w : g.adj(v)) {
				System.out.println(v + " - " + w);
			}
		}
	}
}
