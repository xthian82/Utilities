package py.com.snowtech.datastructure;

import java.util.Iterator;

public class Pila<Item> implements Iterable<Item> {
	private class Node {
		Item item = null;
		Node next = null;
	}
	
	private Node top;
	private int size;
	
	public Pila() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public Item peek() {
		return top == null ? null : top.item;
	}
	
	public void push(Item s) {
		Node tmp = top;
		
		top = new Node();
		top.item = s;
		top.next = tmp;
		++size;
	}
	
	public Item pop() {
		Item n = null;
		
		if (top != null) {
			n = top.item;
			top = top.next;
			--size;
		}
		
		return n;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		Pila<String> a = new Pila<String>();
		
		a.push("1");
		a.push("2");
		a.push("3");
		a.push("4");
		a.push("5");
		
		Iterator<String> it = a.iterator();
		while (it.hasNext()) System.out.println(it.next());
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = top;
		
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
}
