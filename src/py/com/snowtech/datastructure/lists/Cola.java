package py.com.snowtech.datastructure.lists;

import java.util.Iterator;

public class Cola<Item> implements Iterable<Item> {
	private Node first = null;
	private Node last = null;
	private int size = 0;
	
	private class Node {
		Item item = null;
		Node next = null;
	}
	
	public Item peek() {
		return first == null ? null : first.item;
	}
	
	public Item dequeue() {
		Item n = null;
		
		if (first != null) {
			n = first.item;
			
			first = first.next;
			--size;
		}
		
		return n;
	}
	
	public Item poll() {
		return dequeue();
	}
	
	public void add(Item n) {
		enqueue(n);
	}
	
	public void enqueue(Item n) {
		if (n != null) {
			Node node = new Node();
			node.item = n;
			node.next = null;
			
			if (last != null) {
				last.next = node;
			}
			
			last = node;
			
			if (first == null) {
				first = last;
			}
			++size;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = null;
			if (current != null) {
				item = current.item;
				current = current.next;
			}
			
			return item;
		}

		@Override
		public void remove() { }
	}
	
	public static void main(String [] args) {
		Cola<String> a = new Cola<String>();
		a.enqueue("1");
		a.enqueue("2");
		a.enqueue("3");
		a.enqueue("4");
		a.enqueue("5");

		Iterator<String> it = a.iterator();
		while (it.hasNext()) System.out.println(it.next());
	}
}
