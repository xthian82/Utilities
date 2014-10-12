package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Selection extends Sort {
	public void sort(Comparable[] e) {
		sort(e, null);
	}
	
	public void sort(Comparable[] e, Comparator c) {
		int N = e.length;
		int min;
		for (int i=0; i<N; i++) {
			min = i;
			for (int j=i+1; j<N; j++) {
				if (less(c, e[j], e[min])) {
					min = j;
				}
			}
			exch(e, i, min);
		}
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		Selection b = new Selection();
		
		b.print( a );
		b.sort( a );
		b.print( a );
	}
}
