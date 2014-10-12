package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class Sort {
	abstract void sort(Comparable[] e);
	void sort(Comparator c, Object[] e) {}

	public void exch(Object[] a, int i, int j) {
		Object tmp = a[i];
		
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public boolean less(Comparator c, Object a, Object b) {
		return c.compare(a, b) < 0;
	}
	
	public boolean equal(Comparable a, Comparable b) {
		return a.compareTo(b) == 0;
	}	
	
	public boolean equal(Comparator c, Object a, Object b) {
		return c.compare(a, b) == 0;
	}
	
	public boolean isSorted(Comparator c, Object[] a, int begin, int end) {
		for (int i=begin; i<end; i++) {
			if (less(c, a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isSorted(Comparable[] a, int begin, int end) {
		for (int i=begin; i<end; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	public void shuffle(Object[] a) {
		int r;
		int N = a.length;
		
		for (int i=0; i<N; i++) {
			r = (int)(10*Math.random()) % (i+1);
			
			exch(a, i, r);
		}		
	}
	
	public void print(Object[] a) {
		int i;
		System.out.print("[ ");
		
		for (i=0; i<a.length-1; i++) {
			System.out.print(a[i] + ", ");
		}
		
		System.out.println(a[i] + " ]");
	}
}
