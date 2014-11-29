package py.com.snowtech.datastructure.graphs;

import javax.management.RuntimeErrorException;

public class FlowEdge {
	private int v;
	private int w;
	private double capacity;
	private double flow;
	
	
	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}
	
	public int from() {
		return this.v;
	}
	
	public int to() {
		return this.w;
	}
	
	public int other(int v) {
		if (this.v == v) return this.w;
		else if (v == this.w) return this.v;
		else throw new RuntimeErrorException(null, "Illegal Endpoint " + v);
	}
	
	public double capacity() {
		return this.capacity;
	}
	
	public double flow() {
		return this.flow;
	}
	
	double residualCapacity(int vertex) {
		if (vertex == this.v) return this.flow;
		else if (vertex == this.w) return this.capacity - this.flow;
		else throw new IllegalArgumentException();
	}
	
	void addResidualFlowTo(int vertex, double delta) {
		if (vertex == this.v) this.flow -= delta;
		else if (vertex == this.w) this.flow += delta;
		else throw new IllegalArgumentException();
	}
	
	public String toString() {
		return "[" + this.v + " " + flow + "/" + capacity + "]";
	}
}
