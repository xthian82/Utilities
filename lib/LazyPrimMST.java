package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.MinPQ;
import py.com.snowtech.datastructure.lists.Cola;

/**
 * Minimum spanning tree (Prim's Algorithm)
 * 
 * @author cristhian
 *
 */
public class LazyPrimMST {
	private boolean[] marked;
	private Cola<Edge> mst;
	private MinPQ<Edge> pq;
	
	public LazyPrimMST(WeigthedGraph g) {
		pq = new MinPQ<Edge>();
		mst = new Cola<Edge>();
		marked = new boolean[g.V()];
		visit(g, 0);
		
		while (!pq.isEmpty()) {
			Edge e = pq.delete();
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w]) continue;
			mst.enqueue(e);
			
			if (!marked[v]) visit(g, v);
			if (!marked[w]) visit(g, w);
		}
	}

	private void visit(WeigthedGraph g, int v) {
		marked[v] = true;
		for (Edge e : g.adj(v)) {
			if (!marked[e.other(v)]) 
				pq.insert(e);
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
}
