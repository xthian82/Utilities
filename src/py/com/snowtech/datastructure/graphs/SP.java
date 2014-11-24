package py.com.snowtech.datastructure.graphs;

/**
 * Take a source and find the shortest path from s to every connected vertex
 * 
 * @author cristhian
 *
 * Uses of Shortest Path
 * =====================
 * 
 * PERT
 * map routing
 * seam curving
 * robot navigation
 * texture mapping
 * urban traffic planning
 * optimal pipelining of VLSI chip
 * telemarketing operator scheduling
 * routing of telecommunications messages
 * network routing protocols
 * exploiting arbitrate opportunities in currency exchange
 * optimal truck routing through given traffic congestion pattern
 *
 */
abstract class SP {
	public abstract double distTo(int v);
	public abstract Iterable<DirectedEdge> pathTo(int v);
}
