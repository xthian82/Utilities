package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;


//import py.com.snowtech.datastructure.IndexMinPQ;
import py.com.snowtech.datastructure.IndexedMinPriorityQueue;


public class Dijkstra extends SP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	//private IndexMinPQ<Double> pq;
	private IndexedMinPriorityQueue<Double> pq;
	
	private int capacity;
	
	public Dijkstra(WeightedDigraph g, int s) {
		capacity = g.V();
		
		distTo = new double[capacity];
		edgeTo = new DirectedEdge[capacity];
		//pq = new IndexMinPQ<Double>(capacity);
		pq = new IndexedMinPriorityQueue<Double>(capacity);
		
		for (int v=0; v<capacity; v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (DirectedEdge e : g.adj(v))
				relax(e);
		}	
	}
	
	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		double vLength = distTo[v] + e.weight();
		
		if (distTo[w] > vLength) {
			distTo[w] = vLength;
			edgeTo[w] = e;
			
			if (pq.contains(w)) 
				pq.decreaseKey(w, distTo[w]);
			else 
				pq.insert(w, distTo[w]);
		}
	}
	
	public double distTo(int v) {
		if (v >= capacity) return -1.0;
		return this.distTo[v];
	}
	
	public DirectedEdge edgeTo(int v) {
		if (v >= capacity) return null;
		
		return this.edgeTo[v];
	}
	
	public void print() {
		pq.print();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		WeightedDigraph g = new WeightedDigraph(new FileReader("graphs/dgraphsp.txt"));
		//g.print();
		
		Dijkstra sp = new Dijkstra(g, 0);
		//sp.print();
		for (int v = 0; v < g.V(); v++) {
			System.out.printf("%d to %d (%.2f): \n", 0, v, sp.distTo(v));
			//for (DirectedEdge e : sp.pathTo(v)) {
				//System.out.print(" " + e);
			//}
			//System.out.println( );
		}
	}

	@Override
	public Iterable<DirectedEdge> pathTo(int v) {
		// TODO Auto-generated method stub
		return null;
	}
}
