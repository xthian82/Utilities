package py.com.snowtech.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IndexMinPQ<Item extends Comparable<Item>> {
	private MinPQ<Item>[] p;
	private int size;
	
	//create a priority queue of capacity maxN with possible indices between 0 and maxN-1
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int capacity) {
		p = (MinPQ<Item>[]) new MinPQ[capacity];
		
		for (int i=0; i<capacity; i++)
			p[i] = new MinPQ<Item>();
		
		size = 0;
	}
	
	//insert item;associate it with k
	public void insert(int k, Item item) {
		if (k < 0 || k >= p.length) return;
		
		p[k].insert(item);
		++this.size;
	}
	
	public void decreaseKey(int k, Item item) {
		if (k <= 0) return;
		
		p[k-1].insert(item);
		p[k].delete();
	}
	
	//change the item associated with k to item
	public void change(int k, Item item) {
		if (k < 0 || k >= p.length) return;
		
		delete(k);
		p[k].insert(item);
	}
	
	//is k associated with some item?
	public boolean contains(int k) {
		if (k < 0 || k >= p.length) return false;

		return p[k].isEmpty();
	}
	
	//remove k and its associated item
	public void delete(int k) {
		if (k < 0 || k >= p.length) return;
		
		if (p[k].delete() != null)
			--size;
	}
	
	//return a minimal item
	public Item min() {
		Item item = null;
		
		int index = minIndex();
		
		if (index != -1)
			item = p[index].get(0);
		
		return item;
	}
	
	//return a minimal item's index
	public int minIndex() {
		int beginMin = -1;
		
		for (int i=0; i<p.length; i++) {
			
			if (!p[i].isEmpty()) {
				beginMin = i;
				break;
			}
		}
		
		if (beginMin == -1) return -1;
		
		Item min = p[beginMin].get(0);
		
		for (int i=0; i<p.length; i++) {
			if (i == beginMin) continue;
			
			if (p[i].isEmpty()) continue;
			Item item = p[i].get(0);
			if (item.compareTo(min) < 0) {
				beginMin = i;
				min = item;
			}
		}
		
		return beginMin;
		
	}
	
	//remove a minimal item and return its index 
	public int delMin() {
		int minId = minIndex();
		
		if (minId < 0) return -1;
			
		if (p[minId].delete() != null)
			--this.size;
		
		return minId;
	}
	
	//is the priority queue empty?
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	//number of items in the priority queue
	public int size() {
		return this.size;
	}
	
	public void print() {
		for (int i=0; i<p.length; i++) {
			System.out.print(i + " => ");
			p[i].print();
		}
		System.out.println("Total Size : " + this.size);
	}
	
	public void print(int i) {
		System.out.print(i + " => ");
		p[i].print();
		System.out.println("Total Size : " + this.size);
	}
	
	public static void main(String[] args) throws IOException {
		FileReader[] r = {new FileReader("multisort/f1.txt"), 
				          new FileReader("multisort/f2.txt"),
				          new FileReader("multisort/f3.txt")};
		
		IndexMinPQ<String> pq = new IndexMinPQ<String>(r.length);
		
		for (int i=0; i<r.length; i++) {
			BufferedReader br = new BufferedReader(r[i]);
			String str = null;
			
			while ((str = br.readLine()) != null) {
				pq.insert(i, str.trim());
			}
		}
		
		pq.print();
		while (!pq.isEmpty()) {
			int delMin = pq.minIndex();
			System.out.println("Eliminando index(" + delMin + ") = " + pq.min());
			pq.delMin();
			//pq.print(delMin);
		}
	}
}
