package py.com.snowtech.datastructure;

import java.util.Iterator;



public class Lista<Item> implements Iterable<Item> {
	private Node head;
	
	private class Node {
		Item value;
	    Node next;
		
	    public Node(Item value) {
	    	this.value = value;
	    	this.next = null;
	    }

		@Override
		public String toString() {
			return " " + (this == null ? "-" : value);
		}
	}	
	
	public void addLast() {
		
	}
	
	public void addFirst() {
		
	}
	
	public void removeFirst() {
		
	}
	
	public void removeLast() {
		
	}
	
	public void createList(Item[] array) {
		if (array.length < 1) return;
			
		head = new Node(null);
		
		Node m, n = new Node(array[0]);
		head.next = n;
		for (int i=1; i<array.length; i++) {
			m = new Node(array[i]);
			n.next = m;
			n = m;
		}
	}	

	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = head.next;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = null;
			
			if (current != null) {
				item = current.value;
				current = current.next;
			}
			
			return item;
		}

		public void remove() { }		
	}
	
	public static void main(String... args) {
		Lista<Integer> ap = new Lista<Integer>();
		Integer[] a = {1, 2, 3, 4, 5, 6};
		
		ap.createList(a);
		
		Iterator<Integer> it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
	}
}
