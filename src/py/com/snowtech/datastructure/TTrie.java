package py.com.snowtech.datastructure;


/**
 * Ternary tries
 * 
 * Optimized for large set of characters
 * 
 * @author cristhian
 *
 */
public class TTrie<Value> {
	private Node root;
	
	private class Node {
		private Value val;
		private char c;
		private Node left, mid, right;
	}
	
	public TTrie() {
		root = new Node();	
	}
	
	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, Value value, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		
		if (c < x.c) {
			x.left = put(x.left, key, value, d);
		} else if (c > x.c) {
			x.right = put(x.right, key, value, d);
		} else if (d < key.length() - 1) {
			x.mid = put(x.mid, key, value, d+1);
		} else x.val = value;
		
		return x;
	}
	
	public Value get(String key) {
		Node t = get(root, key, 0);
		
		if (t == null) return null;
		
		return (Value) t.val; 
	}
	
	private Node get(Node x, String key, int d) {
		if (key == null) return null;
		char c = key.charAt(d);
		
		if (c < x.c) return get(x.left, key, d);
		else if (c > x.c) return get(x.right, key, d);
		else if (d < key.length() - 1) return get(x.mid, key, d+1);
		else return x;
	}
}
