package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Shell extends Sort {	
	public void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		
		while (h < N / 3) h = 3*h + 1;
		
		//h-sort the array
		while (h >= 1) {
			for (int i=h; i<N; i++) {
				for (int j=i; j>=h && less(a[j], a[j-h]); j += h) {
					exch(a, j-h, j);
				}
			}
			h /= 3;
		}
	}
	
	public void sort(Object[] a, Comparator c) {
		int N = a.length;
		int h = 1;
		
		while (h < N / 3) h = 3*h + 1;
		
		//h-sort the array
		while (h >= 1) {
			for (int i=h; i<N; i++) {
				for (int j=i; j>=h && less(c, a[j], a[j-h]); j += h) {
					exch(a, j-h, j);
				}
			}
			h /= 3;
		}
	}
}
