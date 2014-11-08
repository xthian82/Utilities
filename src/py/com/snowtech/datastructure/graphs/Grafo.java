package py.com.snowtech.datastructure.graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import py.com.snowtech.datastructure.lists.Bolsa;

public class Grafo {
	protected final int vertices;
	protected int edges;
	protected Bolsa<Integer>[] adj;
	
	private static final ProcessEdge f1 = new ProcessEdge() {
		public void addEdge(int v, int w, Bolsa<Integer>[] adj) {
			adj[v].add(w);
			adj[w].add(v);
	    }
	};
	
	public Grafo(int V) {
		this.vertices = V;
		this.edges = 0;
		buildList(V);
	}
	
	@SuppressWarnings("unchecked")
	private void buildList(int total) {
		adj = (Bolsa<Integer>[])new Bolsa[total];
		
		for (int v = 0; v < total; v++)
			adj[v] = new Bolsa<Integer>();
	}
	
	private int processFile(InputStreamReader in, ProcessEdge p) {
		int n = 0;

		BufferedReader r = new BufferedReader(in);
		String s = null;
		
		try {
			n = Integer.parseInt(r.readLine());
			buildList(n);
			
			while ((s = r.readLine()) != null) {
				String [] tok = s.split(" ");
				
				if (tok.length == 2) {
					try {
						int v = Integer.parseInt(tok[0]);
						int w = Integer.parseInt(tok[1]);
						p.addEdge(v, w, this.adj);
						this.edges++;
						
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
	
	protected Grafo(InputStreamReader in, ProcessEdge p) {
		this.edges = 0;
		this.vertices = processFile(in, p);
	}
	
	public Grafo(InputStreamReader in) {
		this(in, f1);
	}
	
	//add edge v-w
	public void addEdge(int v, int  w) {
		f1.addEdge(v, w, adj);
		++edges;
	}
	
	// vertices adjacents to v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	//number of vertifces
	public int V() {
		return this.vertices;
	}
	
	//number of edges
	public int E() {
		return this.edges;
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
		int s = 1;
		
		Path p = new DepthFirstPath(g, s);
		
		//print all vertices connected to 's'
		for (int v=0; v<g.V(); v++) {
			if (p.hasPathTo(v))
				System.out.print(v + " ");
		}
	}
}
