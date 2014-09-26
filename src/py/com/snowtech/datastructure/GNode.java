package py.com.snowtech.datastructure;

public class GNode {
	int value;
	GNode next;
	GNode[] neighbors;
	boolean visited;
	
	GNode(int value) {
		this.value = value;
	}
	GNode(int value, GNode[] n) {
		this.value = value;
		this.neighbors = n;
	}
	public String toString() {
		return " " + (this == null ? "" : this.value);
	}
}
