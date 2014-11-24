package py.com.snowtech.datastructure;

import java.util.Iterator;

/** MaxPQ
 *  Uses for Priority Queues
 *  ------------------------
 *  
 * event driven simulation
 * numerical comp
 * data compresion
 * graph searching
 * number theory
 * AI
 * statistics
 * Operating systems
 * discrete optimization
 * spam filtering
 * */

public class Heap<Key extends Comparable<Key>> implements Iterable<Key> {
	private Key[] p = null;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		p = (Key[]) new Comparable[capacity+1];
		p[0] = null;
	}
	
	public void insert(Key key) {
		if (N >= p.length) throw new ArrayIndexOutOfBoundsException(N);
		
		p[++N] = key;
		
		swimUp(N/2, N);
	}
	
	//or deleteMax()
	public Key delete() {
		if (isEmpty()) throw new ArrayIndexOutOfBoundsException(-1);
		
		Key max = p[1];
		exch(1, N--);
		sink( 1 );
		p[N + 1] = null;
		
		return max;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}

	private void swimUp(int parent, int child) {
		if (parent < 1) return;
		
		if (less(parent, child)) {
			exch(parent, child);
			swimUp(parent / 2, parent);
		}
	}
	
	private void sink(int k) {
		int j = 2*k, swap;		
		
		while (j <= N) {
			swap = k;
			
			if (less(swap, j))
				swap = j;
			
			if (j + 1 <= N && less(swap, j+1))
				swap = j + 1;
			
			if (swap != k) {
				exch(swap, k);
				k = swap;
			} else 
				break;
			
			j = 2*k;
		}
	}

	private void exch(int i, int j) {
		Key tmp = p[i];
		
		p[i] = p[j];
		p[j] = tmp;		
	}
	
	private boolean less(int i, int j) {
		return p[i].compareTo(p[j]) < 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Heap<Integer> h = new Heap<Integer>(12);
		
		h.insert(6);
		h.insert(5);		
		h.insert(3);
		h.insert(1);
		h.insert(8);
		h.insert(7);
		h.insert(2);
		h.insert(12);
		h.insert(4);
		h.delete();
		
		Iterator<Integer> it = h.iterator();
		
		while (it.hasNext())
			System.out.print(it.next()+" ");
	}

	@Override
	public Iterator<Key> iterator() {
		return new HeapIterator();
	}
	
	private class HeapIterator implements Iterator<Key> {
		private int current = 1;
		
		@Override
		public boolean hasNext() {
			return current <= N;
		}

		@Override
		public Key next() {
			return p[current++];
		}

		@Override
		public void remove() { }
		
	}
}
