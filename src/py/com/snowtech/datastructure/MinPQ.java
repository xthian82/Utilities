package py.com.snowtech.datastructure;

import java.util.ArrayList;
import java.util.Iterator;

public class MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
	private ArrayList<Key> p;
	private int N;
	
	public MinPQ() {
		p = new ArrayList<Key>();
		p.add(null);
		N = 0;
	}
	
	public void insert(Key key) {
		p.add(key);
		++N;
		
		swimUp(N/2, N);
	}
	
	private void swimUp(int parent, int child) {
		if (parent <= 0) return;
		
		if (great(parent, child)) {
			exch(parent, child);
			swimUp(parent / 2, parent);
		}
	}
	
	private void exch(int i, int j) {
		Key tmp = p.get(i);
		
		p.set(i, p.get(j));
		p.set(j, tmp);	
	}
	
	private boolean great(int i, int j) {
		return p.get(i).compareTo(p.get(j)) > 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public Key delete() {
		if (isEmpty()) return null;
		
		Key max = p.get(1);
		exch(1, N--);
		sink( 1 );
		p.remove(N+1);
		
		return max;
	}
	
	public Key get(int i) {
		if (i >= N) return null;
		
		return p.get(i + 1);
	}
	
	private void sink(int k) {
		int j = 2*k, swap;
		
		while (j <= N) {
			swap = k;
			
			if (great(swap, j))
				swap = j;
			
			if (j + 1 <= N && great(swap, j+1))
				swap = j + 1;
			
			if (swap != k) {
				exch(swap, k);
				k = swap;
			} else 
				break;
			
			j = 2*k;
		}
	}

	@Override
	public Iterator<Key> iterator() {
		return new PQIterator();
	}
	
	private class PQIterator implements Iterator<Key> {
		private int current = 1;
		
		@Override
		public boolean hasNext() {
			return current <= N;
		}

		@Override
		public Key next() {
			return p.get(current++);
		}

		@Override
		public void remove() {
		}

	}
	
	public int size() {
		return this.N;
	}
	
	public void print() {
		System.out.print("[ ");
		for (Key k : p) {
			if (k == null) continue;
			System.out.print(k + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		MinPQ<Integer> h = new MinPQ<Integer>();
		
		h.insert(6);
		h.insert(5);		
		h.insert(3);
		h.insert(1);
		h.insert(8);
		/*h.insert(7);
		h.insert(2);
		h.insert(12);
		h.insert(4);*/
		//System.out.println(h.get(0));
		//System.out.println(h.get(1));
		h.print();
		h.delete();
		h.print();
		h.delete();
        h.print();
		h.delete();
		h.print();
		//h.delete();
		System.out.println(h.get(0));
		System.out.println(h.get(1));
		h.print();
		
		Iterator<Integer> it = h.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
