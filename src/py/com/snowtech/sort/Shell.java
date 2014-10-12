package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Shell extends Sort {	
	public void sort(Comparable[] a) {
		sort(a, null);
	}
	
	public void sort(Comparable[] a, Comparator c) {
		int N = a.length;
		int h = 1;
		
		while (h < N / 3) h = 3*h + 1;
		
		//h-sort the array
		while ( h >= 1 ) {
			for (int i=h; i<N; i++) {
				for (int j=i; j<N && j>=h && less(c, a[j], a[j-h]); j += h) {
					exch(a, j-h, j);
				}
			}
			h /= 3;
		}
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		Shell b = new Shell();
		
		b.print( a );
		b.sort( a );
		b.print( a );
	}
}
