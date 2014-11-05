package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Pila;

public class DepthFirstPath implements Path {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstPath(Grafo g, int s) {
		int vertices = g.V();
		
		marked = new boolean[vertices];
		edgeTo = new int[vertices];
		this.s = s;
		
		for (int i=0; i<vertices; i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}
		
		dfs(g, s);
	}

	private void dfs(Grafo g, int s) {
		marked[s] = true;
		for (int w : g.adj(s)) {
			if (!marked[w]) {
				dfs(g, w);
				edgeTo[w] = s;
			}
		}
	}
	
	// is there a path from s to v
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		
		Pila<Integer> stack = new Pila<Integer>();
		
		for (int x=v; x != s; x = edgeTo[x])
			stack.push(x);
		stack.push(s);
		
		return stack;
	}
}
