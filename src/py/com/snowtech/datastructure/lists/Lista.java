package py.com.snowtech.datastructure.lists;

import java.util.Comparator;
import java.util.Iterator;



public class Lista<Item extends Comparable<Item>> implements Iterable<Item> {
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
	
	public void addSort(Item item) {
		Node t = head.next;
		Node n = new Node(item);
		
		if (t == null) {
			head.next = n;
			current = n;
			return;
		}
		
		while (t != null && less(t.value, item) && t.next != null) {
			t = t.next;
		}
		
		if (t.next != null) {
			n.next = t.next.next;
			t.next = n;
		} else if (t == head.next){
			if (less(n.value, t.value)) {
				n.next = head.next;
				head.next = n;
			} else {
				t.next = n;
			}
		} else {
			t.next=n;
			current = n;
		}
		
		++size;
	}
	
	private boolean less(Item value, Item item) {
		return value.compareTo(item) < 0;
	}

	public void removeFirst() {
		if (head.next != null) {
			head.next = head.next.next;
			--size;
		}
	}
	
	public void remove() {
		if (size <= 0) return;
		
		Node t = head.next;

		while (t != null && t.next != null && t.next.next != null) {
			t = t.next;
		}
		
		if (t != null) {
			if (t.next != null) {
				t.next = null;			
				current = t;
			} else {
				head.next = null;
				current = null;
			}
			--size;
		}
	}
	
	public void remove(Item value) {
		Node t = head.next;

		while (t != null && t.value != value && t.next != null && t.next.value != value) {
			t = t.next;
		}
		
		if (t != null) {
			if (t != head.next) {
				t.next = t.next.next;
			}
			else {
				head.next = t.next;	
			}
			--size;
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
		ap.add(6);
		ap.add(5);
		ap.remove(34);
		ap.remove();
		ap.remove();
		ap.addSort(4);
		ap.addSort(68);
		ap.addSort(80);
		ap.addSort(70);
		//ap.add(10);
		System.out.println("\n------------- " + ap.size());
		it = ap.iterator();
		while(it.hasNext()) System.out.print(it.next() + " ");
	}
}
