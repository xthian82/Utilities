package py.com.snowtech.datastructure;

import java.util.Iterator;

public class Mapa<Key extends Comparable<Key>, Value> {
	private Node first = null;
	private int size;
	
	private class Node {
		Key k;
		Value v;
		Node next;
		
		public Node() {
			this.k = null;
			this.v = null;
			this.next = null;
		}
		public Node(Key k, Value v) {
			this.k = k;
			this.v = v;
			this.next = null;
		}
	}
	
	public Mapa() {
		this.first = new Node();
		this.size = 0;
	}
	
	private Node getNode(Key key) {
		if (key == null) return null;
		
		Node n = first.next;
		
		while (n != null) {
			if (n.k.compareTo(key) == 0) return n;
			
			n = n.next;
		}
					
		return null;
	}
	
	public void put(Key key, Value value) {
		if (key == null) return;
		
		Node n = getNode(key);
		
		if (n == null) {
			n = new Node(key, value);
			n.next = first.next;
			first.next = n;
			++this.size;
		}
		
		n.v = value;
	}
	
	
	public Value get(Key key) { 
		Node n = getNode(key);
		
		if (n == null) return null;
				
		return n.v;
	}
	
	public void delete(Key key) {
		put(key, null);
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public boolean isEmpty() {
		return first.next == null;
	}
	
	public int size() {
		return this.size;
	}
	
	Iterable<Key> keys() {
		return new MapaIterable();
	}
	
	private class MapaIterable implements Iterable<Key> {
		public Iterator<Key> iterator() {
			return new MapaIterador();
		}		
	}

	private class MapaIterador implements Iterator<Key> {
		private Node current = first.next;
		
		public boolean hasNext() {
			return current != null;
		}

		public Key next() {
			if (isEmpty()) return null;
			
			Key k = current.k;
			current = current.next;
			
			return k;
		}

		public void remove() {			
		}
	}
	
	public static void main(String... args) {
		Mapa<String, Integer> m = new Mapa<String, Integer>();
		
		m.put("hola", 1);
		m.put("maiz", 4);
		m.put("hola", 7);
		m.put("pepe", 6);
		m.put("Gato", 45);
		m.put("gATO", 3);
		m.put(null, 3);
		
	    for (String s : m.keys()) {
	    	System.out.println(s + " - " + m.get(s));
	    }
	}
}
