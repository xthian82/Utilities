package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Cola;


public class DirectedDFS {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private Cola<Integer> markedNodes;

	public DirectedDFS(Digrafo g, int s) {
		//run DFS from each source, without unmarking vertices
		int vertices = g.V();
		markedNodes = new Cola<Integer>();
		marked = new boolean[vertices];
		edgeTo = new int[vertices];
		this.s = s;
		
		for (int i=0; i<vertices; i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}
		markedNodes.enqueue(s);
		dfs(g, s);
		
	}
	
	public DirectedDFS(Digrafo g, Iterable<Integer> s) {
		int vertices = g.V();
		markedNodes = new Cola<Integer>();
		marked = new boolean[vertices];
		edgeTo = new int[vertices];
		for (int i=0; i<vertices; i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}
		
		for (int item : s) {	
			if (!marked(item)) {
				markedNodes.enqueue(item);
				dfs(g, item);
			}
		}
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	

	private void dfs(Digrafo g, int s) {
		marked[s] = true;
		for (int w : g.adj(s)) {
			if (!marked[w]) {				
				markedNodes.enqueue(w);
				dfs(g, w);
				edgeTo[w] = s;
			}
		}
	}
	/*
	public Iterable<Integer> pathTo(int v) {
		if (!marked(v)) return null;
		
		Pila<Integer> stack = new Pila<Integer>();
		
		for (int x=v; x != s; x = edgeTo[x])
			stack.push(x);
		stack.push(s);
		
		return stack;
	} */
	
	public Iterable<Integer> path() {
		return this.markedNodes;
	}

}
