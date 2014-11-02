package py.com.snowtech.datastructure;

import java.util.Iterator;

public class Bolsa<Item> implements Iterable<Item> {
	private int size;
	private Node init;
	
	private class Node {
		Item item = null;
		Node next = null;
	}

	public Bolsa() {
		this.init = null;
		this.size = 0;
	}
	
	public void add(Item x) {
		Node tmp = init;
		
		init = new Node();
		init.item = x;
		init.next = tmp;
		++size;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return init == null;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item> {
		private Node current = init;
		
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
		public void remove() {}
	}
	
	public static void main(String[] args) {
		Bolsa<String> a = new Bolsa<String>();
		
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		
		Iterator<String> it = a.iterator();
		while (it.hasNext()) System.out.println(it.next());
	}
}
