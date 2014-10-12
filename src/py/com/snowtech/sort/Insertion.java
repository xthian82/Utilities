package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Insertion extends Sort {
	public void sort(Comparable[] e) {
		sort(e, null);
	}
	
	public void sort(Comparable[] e, Comparator c) {
		int N = e.length;

		for (int i=0; i<N; i++) {			
			for (int j=i; j>0; j--) {
				if (less(c, e[j], e[j-1])) {
					exch(e, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		Insertion b = new Insertion();
		
		b.print( a );
		b.sort( a );
		b.print( a );
	}
}
