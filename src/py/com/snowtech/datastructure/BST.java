package py.com.snowtech.datastructure;

/*
 * Binary Search Tree
 * 
 */
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		
		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public void put(Key key, Value value) {
		this.root = put(this.root, key, value);
	}
	
	private Node put(Node n, Key key, Value value) {
		if (n == null) return new Node(key, value);
		
	    int cmp = key.compareTo(n.key);
		if (cmp < 0) { 
			n.left = put(n.left, key, value);
		}
		else if (cmp > 0) {
			n.right = put(n.right, key, value);
		} else {
			n.value = value;
		}

		return n;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node n) {
		if (n == null) return 0;
		
		return 1 + size(n.left) + size(n.right);//n.count;
	}
	
	public Value get(Key key) {
		Node m = root;
		
		while (m != null) {
			int cmp = key.compareTo(m.key);
			if (cmp == 0) 
				return m.value;
			else if (cmp < 0)
				m = m.left;
			else
				m = m.right;
		}	
		
		return null;
	}
	
	public Value min() {
		Node n = min(root);
		if (n == null) return null;
		return n.value;
	}
	
	private Node min(Node n) {
		if (n == null) return null;
		
		while (n.left != null) {
			n = n.left;
		}
		
		return n;
	}
	
	public Value max() {
		return max(root);
	}
	
	private Value max(Node n) {
		if (n == null) return null;
		
		while (n.right != null)
			n = n.right;
		
		return n.value;
	}
	
	public Key floor(Key key) {
		Node x = floor(key, root);
		
		if (x == null) return null;
		
		return x.key;
	}
	
	private Node floor(Key key, Node n) {
		if (n == null) return null;
		
		int cmp = key.compareTo(n.key);
		
		if (cmp == 0) return n;
		else if (cmp < 0) return floor(key, n.left);
		Node t = floor(key, n.right);
		
		if (t != null)
			return t;
		else
			return n;
	}
	
	//how many keys < k
	public int rank(Key key) {
		return rank(key, root);
	}
	
	public int size(Key key) {
		return sizeGet(key, root);
	}
	
	private int sizeGet(Key k, Node n) {
		if (n == null) return 0;
		
		int cmp = k.compareTo(n.key);
		if (cmp == 0) return size(n);
		else if (cmp < 0) return sizeGet(k, n.left);
		else return sizeGet(k, n.right);
	}
	
	private int rank(Key key, Node n) {
		if (n == null)
			return 0;
		
		int cmp = key.compareTo(n.key);
		
		if (cmp == 0) 
			return size(n.left);
		else if (cmp < 0)
			return rank(key, n.left);
		else
			return 1 + size(n.left) + rank(key, n.right);
	}
	
	public Iterable<Key> iterator() {
		Cola<Key> q = new Cola<Key>();
		inorder(root, q);
		
		return q;
	}
	
	private void inorder(Node n, Cola<Key> q) {
		if (n == null) return;
		
		inorder(n.left, q);
		q.enqueue(n.key);
		inorder(n.right, q);
		
	}
	
	public void postorder() {
		System.out.print("postOrder : ");
		postorder(root);
		System.out.println();
	}
	
	private void postorder(Node n) {
		if (n == null) return;
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.key + " ");
	}
	
	public void preorder() {
		System.out.print("preorder : ");
		preorder(root);
		System.out.println();
	}
	
	private void preorder(Node n) {
		if (n == null) return;

		System.out.print(n.key + " ");
		preorder(n.left);
		preorder(n.right);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node n) {
		if (n.left == null) return n.right;
		n.left = deleteMin(n.left);
		
		return n;
	}
	
	public void delete(Key key) {
		root = delete(key, root);
	}
	
	private Node delete(Key k, Node n) {
		if (n == null) return null;
		
		int cmp = k.compareTo(n.key);
		
		if (cmp < 0) n.left = delete(k, n.left);
		else if (cmp > 0) n.right = delete(k, n.right);
		else {
			if (n.right == null) return n.left;
			if (n.left == null) return n.right;
			
			Node t = n;
			n = min(t.right);
			n.right = deleteMin(t.right);
			n.left = t.left;
		}
		return n;
	}
	
	/*
	 *  The pre-order traversal is: 8, 3, 1, 6, 4, 7, 10, 14, 13.
		The in-order traversal is: 1, 3, 4, 6, 7, 8, 10, 13, 14.
		The post-order traversal is: 1, 4, 7, 6, 3, 13, 14, 10, 8.
	 * */
	public static void main(String... args) {
		/*BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		bst.put(8,  8);
		
		bst.put(3, 3);
		bst.put(10, 10);
		bst.put(1, 1);
		bst.put(6, 6);
		bst.put(14, 14);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(13, 13);
		
		for (int n : bst.iterator()) {
			System.out.print(n + " ");
		}
		System.out.println();
		bst.postorder();
		bst.preorder();
		System.out.println("Size: " + bst.size());
		System.out.println("min: " + bst.min());
		System.out.println("max: " + bst.max());
		
		System.out.println("rank8: " + bst.rank(8));
		System.out.println("rank10: " + bst.rank(10));
		System.out.println("rank6: " + bst.rank(6));
		System.out.println("rank3: " + bst.rank(3));*/
		BST<Character, Character> bst = new BST<Character, Character>();
		
		bst.put('S', 'S');		
		bst.put('E', 'E');
		bst.put('X', 'X');
		bst.put('A', 'A');
		bst.put('R', 'R');
		bst.put('C', 'C');
		bst.put('H', 'H');
		bst.put('M', 'M');
		
		System.out.println(bst.floor('G'));
		System.out.println(bst.size('S'));
		
	}
}
