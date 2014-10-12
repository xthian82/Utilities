package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Bubble extends Sort {
	public void sort(Comparable [] a) {
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				if (less(a[j], a[i]))
					exch(a, i, j);
			}
		}
	}	
	
	public void sort(Object [] a, Comparator c) {
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				if (less(c, a[j], a[i]))
					exch(a, i, j);
			}
		}
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		Bubble b = new Bubble();
		
		b.print( a );
		b.sort( a );
		b.print( a );
	}
}
