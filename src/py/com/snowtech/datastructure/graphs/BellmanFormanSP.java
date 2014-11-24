package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.lists.Pila;

public class BellmanFormanSP extends SP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public BellmanFormanSP(WeightedDigraph g) {
		int vert = g.V();
		
		distTo = new double[vert];
		edgeTo = new DirectedEdge[vert];
		
		for (int v=0; v<vert; v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[0] = 0;
		
		for (int i=0; i<vert; i++) {
			for (int v=0; v<vert; v++) {
				for (DirectedEdge e : g.adj(v)) {
					relax(e);
				}
			}
		}
		
	}
	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		double vLength = distTo[v] + e.weight();
		
		if (distTo[w] > vLength) {
			distTo[w] = vLength;
			edgeTo[w] = e;
		}
	}
	
	public double distTo(int v) {
		return this.distTo[v];
	}
	
	public DirectedEdge edgeTo(int v) {
		return this.edgeTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Pila<DirectedEdge> path = new Pila<DirectedEdge>();
		for (DirectedEdge e = edgeTo(v); e != null; e = edgeTo(e.from())) {
			path.push(e);
		}
		return path;
	}
	public static void main(String[] args) throws FileNotFoundException {
			WeightedDigraph g = new WeightedDigraph(new FileReader("graphs/dgraphsp.txt"));
			g.print();
			
			BellmanFormanSP sp = new BellmanFormanSP(g);
			for (int v = 0; v < g.V(); v++) {
				System.out.printf("%d to %d (%.2f): ", 0, v, sp.distTo(v));
				for (DirectedEdge e : sp.pathTo(v)) {
					System.out.print(" " + e);
				}
				System.out.println( );
			}
	}
}
