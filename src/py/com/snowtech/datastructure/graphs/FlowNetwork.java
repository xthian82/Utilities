package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Lista;

public class FlowNetwork {
	protected final int vertices;
	protected int edges;
	protected Lista<FlowEdge>[] adj;
	
	public FlowNetwork(int v) {
		this.vertices = v;
		buildList(v);
	}
	
	@SuppressWarnings("unchecked")
	private void buildList(int total) {
		adj = (Lista<FlowEdge>[])new Lista[total];
		
		for (int v = 0; v < total; v++) {
			adj[v] = new Lista<FlowEdge>();
		}
	}
	
	public void addEge(FlowEdge e) {
		int v = e.from(), w = e.to();
		
		adj[v].add(e);
		adj[w].add(e);
		++this.edges;
	}
	
	public Iterable<FlowEdge> adj(int v) {
		return this.adj[v];
	}
	
	public int V() {
		return this.vertices;
	}
	
	public int E() {
		return this.edges;
	}
}
