package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.lists.Pila;

/**
 * Take a source and find the shortest path from s to every connected vertex
 * 
 * @author cristhian
 *
 * Uses of Shortest Path
 * =====================
 * 
 * pert
 * map routing
 * seam curving
 * robot navigation
 * texture mapping
 * urban traffic planning
 * optimal pipelining of vlsi chip
 * telemarketer operator scheduling
 * routing of telecomunications messages
 * network routing protocols
 * exploiting arbitrage opportunities in currency exchange
 * optimal truck routing through given traffic congestion pattern
 *
 */
public class SP {
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	
	public SP(WeightedDigraph g, int s) {
		int v = g.V();
		
		distTo = new double[v];
		edgeTo = new DirectedEdge[v];
	}
	
	public double distTo(int v) {
		return this.distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Pila<DirectedEdge> path = new Pila<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 2) {
			System.err.println("Usage : java SP fileGraph source");
			System.exit(-1);
		}
		
		WeightedDigraph g = new WeightedDigraph(new FileReader(args[0]));
		int s = Integer.parseInt(args[1]);
		SP sp = new SP(g, s);
		
		for (int v = 0; v < g.V(); v++) {
			System.out.printf("%d to %d (%.2f): ", s, v, sp.distTo(v));
			for (DirectedEdge e : sp.pathTo(v)) {
				System.out.print(" " + e);
			}
			System.out.println( );
		}
	}
}
