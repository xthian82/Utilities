package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Insertion extends Sort {
	public void sort(Comparable[] e) {
		int N = e.length;

		for (int i=0; i<N; i++) {			
			for (int j=i+1; j>=0; j--) {
				if (less(e[j], e[j-1])) {
					exch(e, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	public void sort(Object[] e, Comparator c) {
		int N = e.length;

		for (int i=0; i<N; i++) {			
			for (int j=i+1; j>=0; j--) {
				if (less(c, e[j], e[j-1])) {
					exch(e, j, j-1);
				} else {
					break;
				}
			}
		}
	}
}
