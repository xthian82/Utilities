package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Merge extends Sort {		
	private void merge(Comparator c, Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(c, a, lo, mid);
		assert isSorted(c, a, mid+1, hi);
		
		for (int k=lo; k<= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid+1;
		for (int k=lo; k<=hi; k++) {
			if (i > mid)                      a[k] = aux[j++];
			else if (j > hi)                  a[k] = aux[i++];
			else if (less(c, aux[j], aux[i])) a[k] = aux[j++];
			else                              a[k] = aux[i++];
		}
		
		assert isSorted(c, a, lo, hi);
	}
	
	private void sort(Comparator c, Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		
		int mid = lo + (hi - lo) / 2;
		
		sort(c, a, aux, lo, mid);
		sort(c, a, aux, mid+1, hi);
		if (!less(c, a[mid+1], a[mid])) return;
		merge(c, a, aux, lo, mid, hi);
		
	}

	public void sort(Comparable[] a) {
		sort(a, null);
	}
	
	public void sort(Comparable[] a, Comparator c) {
		if (a == null) return;
		
		Comparable[] aux = new Comparable[a.length];
				
		sort(c, a, aux, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		String [] b = {"Xavier", "Orange", "Blue", "apple", "Pimple"};
		Short[] c = {1,8,7,12,15,4};
		Character[] d = {'L','x','D','a','b','C'};
		Merge m = new Merge();
		m.print( a );
		m.sort( a );
		m.print( a );
		
		m.print( b );
		m.sort( b );
		m.print( b );
		
		m.print( c );
		m.sort( c );
		m.print( c );
		
		m.print( d );
		m.sort( d );
		m.print( d );
	}
}
