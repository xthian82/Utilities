package py.com.snowtech.datastructure.graphs;

public class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int v) {
		if (this.v == v) return this.w;
		else return this.v;
	}

	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > this.weight)
			return 1;
		else return 0;
	}
	
	public double weight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return "[" + v + "-" + w + " " + weight + "]";
	}
	
	
}
