package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Cola;

public class FordFulkerson {
	private boolean[] marked; // true if s->v path in reidual network
	private FlowEdge[] edgeTo; //last edge on s->v path
	private double value; //value of flow
	
	public FordFulkerson(FlowNetwork g, int s, int t) {
		value = 0.0;
		while (hasAugment(g, s, t)) {
			double bottle = Double.POSITIVE_INFINITY;
			for (int v=t; v != s; v = edgeTo[v].other(v))
				bottle = Math.min(bottle, edgeTo[v].residualCapacity(v));
			
			for (int v= t; v!= s; v = edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle);
			
			value += bottle;
		}
	}

	private boolean hasAugment(FlowNetwork g, int s, int t) {
		edgeTo = new FlowEdge[g.V()];
		marked = new boolean[g.V()];
		
		Cola<Integer> q = new Cola<Integer>();
		q.enqueue(s);
		marked[s] = true;
		
		while (!q.isEmpty()) {
			int v = q.dequeue();
			
			for (FlowEdge e : g.adj(v)) {
				int w = e.other(v);
				if (e.residualCapacity(w) > 0 && !marked[w]) {
					edgeTo[w] = e;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
		return marked[t];
	}
	
	public double value() {
		return value;
	}
	
	public boolean inCut(int v) {
		return marked[v];
	}
}
