package py.com.snowtech.datastructure;

public class RNBST<Key extends Comparable<Key>, Val> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		Key key;
		Val val;
		Node left, right;
		boolean color;
		
		Node(Key k, Val v, boolean color) {
			this.key = k;
			this.val = v;
			this.color = color;
			left = right = null;
		}
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	private boolean isRed(Node n) {
		if (n == null) return false;
		
		return n.color == RED;
	}
	
	private Node put(Node n, Key key, Val value) {
		if (n == null) return new Node(key, value, RED);
		
	    int cmp = key.compareTo(n.key);
		if (cmp < 0) n.left = put(n.left, key, value);
		else if (cmp > 0) n.right = put(n.right, key, value);
		else n.val = value;

		if (isRed(n.right) && !isRed(n.left)) n = rotateLeft(n);
		if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
		if (isRed(n.left) && isRed(n.right)) flipColors(n);
		
		return n;
	}
	
	private Node rotateLeft(Node h) {
		Node t = h.right;
		h.right = t.left;
		t.left = h;
		t.color = h.color;
		h.color = RED;
		
		return t;
	}
	
	private Node rotateRight(Node h) {
		Node t = h.left;
		h.left = t.right;
		t.right = h;
		t.color = h.color;
		h.color = RED;
		
		return t;
	}
	
	private void flipColors(Node n) {
		n.color = RED;
		n.left.color = BLACK;
		n.right.color = BLACK;
	}
	
	public Val get(Key key) {
		Node m = root;
		
		while (m != null) {
			int cmp = key.compareTo(m.key);
			if (cmp == 0) 
				return m.val;
			else if (cmp < 0)
				m = m.left;
			else
				m = m.right;
		}	
		
		return null;
	}
	
	public void put(Key key, Val value) {
		this.root = put(this.root, key, value);
	}
}
