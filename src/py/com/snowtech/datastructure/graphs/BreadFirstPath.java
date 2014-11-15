package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Cola;

public class BreadFirstPath implements Path {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private Cola<Integer> markedNodes;
	
	public BreadFirstPath(Grafo g, int s) {
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
		bfs(g, s);
	}
	
	private void bfs(Grafo g, int s) {
		Cola<Integer> queue = new Cola<Integer>();
		
		queue.add(s);
		marked[s] = true;
		
		while (!queue.isEmpty()) {
			Integer v = queue.dequeue();
			for (int w : g.adj(v)) {
				if (!marked[w]) {					
					queue.enqueue(w);
					markedNodes.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
	
	// is there a path from s to v
	public boolean hasPathTo(int v) {
		return marked[v];
	}
		
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		
		Cola<Integer> queue = new Cola<Integer>();
		
		for (int x=v; x != s; x = edgeTo[x])
			queue.add(x);
		queue.add(s);
		
		return queue;
	}
	
	public Iterable<Integer> pushedNodes() {
		return this.markedNodes;
	}
}
