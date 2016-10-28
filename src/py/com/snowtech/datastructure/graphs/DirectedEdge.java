package py.com.snowtech.datastructure.graphs;

public class DirectedEdge implements Comparable<DirectedEdge> {
	private int v;
	private int w;
	private double weight;

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public int to( ) {
		return this.w;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public String toString() {
		return "[" + this.v + "-" + this.w + " " + this.weight + "]";
	}

	@Override
	public int compareTo(DirectedEdge o) {
		if (o == null) return -1;
		if (o.weight == this.weight) return 0;
		else if (this.weight < o.weight) return -1;
		else return 1;
	}
}
