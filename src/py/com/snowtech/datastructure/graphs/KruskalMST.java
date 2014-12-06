package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.MinPQ;
import py.com.snowtech.datastructure.lists.Cola;
import py.com.snowtech.substring.UnionFind;

/**
 * Minumum spanning tree (Kruskal's Algorithm)
 * 
 * 
 * @author cristhian
 *
 */
public class KruskalMST {
	private Cola<Edge> mst = new Cola<Edge>();
	
	public KruskalMST(WeigthedGraph g) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : g.edges()) {
			pq.insert(e);
		}
		
		UnionFind uf = new UnionFind(g.V());
		
		while (!pq.isEmpty() && mst.size() < g.V() - 1) {
			Edge e = pq.delete();
			int v = e.either(), w = e.other(v);
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(e);
			}
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
}
