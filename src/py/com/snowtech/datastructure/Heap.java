package py.com.snowtech.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Heap<Item extends Comparable<Item>> {
	private List<Item> ap;
	private Item min = null;
	private Item max = null;
	
	public Heap() {
		ap = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		ap.add(item);
		int l = ap.size()-1;
		
		if (min == null || min.compareTo(item) > 0) min = item;
		if (max == null || max.compareTo(item) < 0) max = item;
		
		if (l > 0) siftUp((l - 1) / 2, l);
	}
	
	public void remove(Item item) {
		ap.remove(item);
	}
	
	private void siftUp(int parent, int child) {
		if (parent < 0) return;
		
		if (ap.get(parent).compareTo(ap.get(child)) < 0) {
			//System.out.println("swaping " + ap.get(parent) + " and "+ ap.get(child));
			Item tmp = ap.get(parent);
			ap.set(parent, ap.get(child));
			ap.set(child, tmp);
			siftUp((parent-1) / 2, parent);
		}
	}

	public void heapify(Item[] a) {
		int start = a.length / 2;
		int end = a.length-1;
		
		while (start >= 0) {
			shift(a, start, end);
			start--;
		}
	}
	
	private void shift(Item[] a, int start, int end) {
		int root = start, child = 2*start+1, swap;		
		
		while (child <= end) {
			swap = root;
			
			if (a[swap].compareTo(a[child]) < 0)
				swap = child;
			
			if (child + 1 <= end && a[swap].compareTo(a[child+1]) < 0)
				swap = child + 1;
			
			if (swap != root) {
				change(a, swap, root);
				root = swap;
			} else 
				break;
			
			child = 2*root+1;
		}
	}

	private void change(Item[] a, int i, int j) {
		Item tmp = a[i];
		
		a[i] = a[j];
		a[j] = tmp;		
	}

	public static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public void print( ) {
		for (int i=0; i<ap.size(); i++) {
			System.out.print(ap.get(i) + " ");
		}
		System.out.println("");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] a = {1, 2, 3, 7,17,19,25,36,100};
		Heap<Integer> h = new Heap<Integer>();
		
		h.addItem(6);
		h.addItem(5);		
		h.addItem(3);
		h.addItem(1);
		h.addItem(8);
		h.addItem(7);
		h.addItem(2);
		h.addItem(4);
		
		h.print();
		h.remove(4);
		h.print();
		/*Heap.print(a);
		Heap.heapify(a);
		Heap.print(a);*/
	}
}
