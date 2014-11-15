package py.com.snowtech.datastructure.lists;

import java.util.Iterator;



public class Lista<Item> implements Iterable<Item> {
	private Node head;
	private Node current;
	private int size = 0;
	
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
	
	public Lista() {
		head = new Node(null);
		current = null;
	}
	
	public void add(Item item) {
		if (current == null) current = head;
		
		current.next = new Node(item);
		current = current.next;
		++size;
	}
	
	public void addFirst(Item item) {
		 Node n = new Node(item);
		 n.next = head.next;
		 head.next = n;
		 ++size;
	}
	
	public void removeFirst() {
		if (head != null && head.next != null) {
			head.next = head.next.next;
			--size;
		}
	}
	
	//TODO: fix remove
	public void remove() {
		if (size <= 0) return;
		Node t = head;
		
		while (t != null && t.next != null && t.next.next != null) {
			t = t.next;
		}
		
		if (t != null) {
			t.next = null;
			--size;
			current = t;
		}
	}
	
	public boolean isEmpty() {
		return head.next == null;
	}
	
	public int size() {
		return this.size;
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
		
		ap.add(1);
		ap.add(5);
		ap.add(9);
		ap.add(19);
		System.out.println("\n------------- " + ap.size());
		Iterator<Integer> it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
		ap.addFirst(31);
		ap.addFirst(4);
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
		ap.removeFirst();
		ap.remove();
		ap.remove();
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
		ap.removeFirst();
		ap.remove();
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
		ap.remove();
		ap.remove();
		ap.remove();
		ap.remove();
		
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
		ap.add(67);
		ap.addFirst(34);
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
	}
}
