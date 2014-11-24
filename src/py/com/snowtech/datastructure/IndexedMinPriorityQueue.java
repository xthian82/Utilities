package py.com.snowtech.datastructure;

public class IndexedMinPriorityQueue<Item> {
	private Item[] p = null;
	private Integer[] id = null;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public IndexedMinPriorityQueue(int capacity) {
		p = (Item[]) new Comparable[capacity+1];
		id = new Integer[capacity + 1];
		p[0] = null;
		id[0] = -1;
	}
	
	public void insert(int k, Item key) {
		if (N >= id.length) throw new ArrayIndexOutOfBoundsException(k);
		++N;
		p[N] = key;
		id[N] = k;
		
		swimUp(N/2, N);
	}
	
	public int/*Item*/ delMin() {
		if (isEmpty()) throw new ArrayIndexOutOfBoundsException(-1);
		
		Item min = p[1];
		exch(1, N--);
		sink( 1 );
		id[N + 1] = null;
		p[N + 1] = null;
		
		return 1; //min;
	}
	
	public void decreaseKey(int k, Item item) {
		if (k > N || k <= 0) return;
		
		Item aux = p[k-1];
		p[k-1] = p[k];
		p[k] = aux;
	}
	
	public Item min() {
		if (isEmpty()) return null;
		
		return p[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void print() {
		System.out.print("[ ");
		for (Item k : p) {
			if (k == null) continue;
			System.out.print(k + " ");
		}
		System.out.println("]");
	}

	private void swimUp(int parent, int child) {
		if (parent < 1) return;
		
		if (great(parent, child)) {
			exch(parent, child);
			swimUp(parent / 2, parent);
		}
	}
	
	private boolean great(int i, int j) {
		return id[i].compareTo(id[j]) > 0;
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

	private void exch(int i, int j) {
		int tmp = id[i];
		Item aux = p[i];
		
		id[i] = id[j];
		p[i] = p[j];
		id[j] = tmp;
		p[j] = aux;
	}
	
	public static void main(String[] args) {
		IndexedMinPriorityQueue<String> app = new IndexedMinPriorityQueue<String>(10);
		
		app.insert(23, "A");
		System.out.println("Min: " + app.min());
		app.insert(2, "C");
		app.insert(19, "ero");
		System.out.println("Min: " + app.min());
		app.insert(10, "Ced");
		app.insert(9, "bala");
		System.out.println("Min: " + app.min());
		app.insert(1, "deep");
		System.out.println("Min: " + app.min());
		app.print();
		app.delMin();
		app.print();
	}

	public boolean contains(int w) {
		if (w < 0 || w > N) return false;
		
		return p[w] != null;
	}
}
