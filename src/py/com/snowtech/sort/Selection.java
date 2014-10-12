package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Selection extends Sort {
	public void sort(Comparable[] e) {
		int N = e.length;
		int min;
		for (int i=0; i<N; i++) {
			min = i;
			for (int j=i+1; j<N; j++) {
				if (less(e[j], e[min])) {
					min = j;
				}
			}
			exch(e, i, min);
		}
	}
	
	public void sort(Object[] e, Comparator c) {
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
}
