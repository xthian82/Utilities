package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class Sort {
	abstract void sort(Comparable[] e);
	void sort(Comparator c, Comparable[] e) { sort(null, e); }

	public void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private boolean equal(Comparable a, Comparable b) {
		return a.compareTo(b) == 0;
	}	
	
	public boolean less(Comparator c, Comparable a, Comparable b) {
		if (c != null) return c.compare(a, b) < 0;
		else return less(a, b);
	}	
	
	public boolean equal(Comparator c, Comparable a, Comparable b) {
		if (c != null) return c.compare(a, b) == 0;
		else return equal(a, b);
	}
	
	public boolean isSorted(Comparator c, Comparable[] a, int begin, int end) {
		for (int i=begin; i<end; i++) {
			if (less(c, a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	public void shuffle(Comparable[] a) {
		int r;
		int N = a.length;
		
		for (int i=0; i<N; i++) {
			r = (int)(10*Math.random()) % (i+1);
			
			exch(a, i, r);
		}		
	}
	
	public void print(Comparable[] a) {
		int i;
		System.out.print("[ ");
		
		for (i=0; i<a.length-1; i++) {
			System.out.print(a[i] + ", ");
		}
		
		System.out.println(a[i] + " ]");
	}
}
