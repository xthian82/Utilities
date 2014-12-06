package py.com.snowtech.datastructure;

import py.com.snowtech.datastructure.lists.Cola;


/**
 * Rway Trie, good for small R
 * bad for large R
 * 
 * @author cristhian
 *
 * @param <Value>
 */
public class RTrie<Value> {
	private static final int R = 256;
	private Node root;
	
	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}
	
	public RTrie() {
		root = new Node();	
	}
	
	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, Value value, int d) {

		if (x == null) x = new Node();
		if (d == key.length()) {
			x.value = value; 
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d+1);
				
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node t = get(root, key, 0);
		
		if (t == null) return null;
		
		return (Value) t.value; 
	}
	
	private Node get(Node x, String key, int d) {
		if (key == null) return null;
		if (d == key.length()) return x;
		char c = key.charAt(d);
		
		return get(x.next[c], key, d+1);
	}

	public Iterable<String> keys() {
		Cola<String> q = new Cola<String>();
		
		collect(root, "", q);
		
		return q;
	}
	
	private void collect(Node x, String string, Cola<String> q) {
		if (x == null) return;
		
		if (x.value != null) q.enqueue(string);
		
		for (char c=0; c<R; c++) {
			collect(x.next[c], string + c, q);
		}
		
	}

	Iterable<String> keysWithPrefix(String s) {
		Cola<String> q = new Cola<String>();
		Node x = get(root, s, 0);
		collect(x, s, q);
		
		return q;
	}
	/*
	Iterable<String> keysThatMatch(String s) {
		
	}*/
	
	public String longestPrefixOf(String query) {
		int length = search(root, query, 0, 0);
		return query.substring(0, length);
	}
	
	private int search(Node x, String query, int d, int length) {
		if (x == null) return length;
		if (x.value != null) length = d;
		if (d == query.length()) return length;
		char c = query.charAt(d);
		return search(x.next[c], query, d+1, length);
	}

	//TODO
	public void delete(String key) {
		
	}
}
