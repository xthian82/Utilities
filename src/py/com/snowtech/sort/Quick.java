package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Quick extends Sort {
	private void sort(Comparable[] v, int m, int n) {
		int i,j;
		Comparable k;
		if (m < n) {
			i = m;
			j = n+1;
			k = v[i];
			
			while (true)
			{
				do {++i;} while (i<v.length && less(v[i], k));
				do {--j;} while (j>-1 && less(k, v[j]));

				if (i<j) 
					exch(v, i, j);
				else
					break;
			}
			
			exch(v, m, j);
			sort(v, m, j-1);
			sort(v, j+1, n);
		}
	}
	
	private void sort(Comparator c, Object[] v, int m, int n) {
		int i,j;
		Object k;
		if (m < n) {
			i = m;
			j = n+1;
			k = v[i];
			
			while (true)
			{
				do {++i;} while (i<v.length && less(c, v[i], k));
				do {--j;} while (j>-1 && less(c, k, v[j]));

				if (i<j) 
					exch(v, i, j);
				else
					break;
			}
			
			exch(v, m, j);
			sort(c, v, m, j-1);
			sort(c, v, j+1, n);
		}
	}
	
	public void sort(Comparable[] o) {
		sort(o, 0, o.length-1);
	}
	
	public void sort(Object[] o, Comparator c) {
		sort(c, o, 0, o.length-1);
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		Quick quick = new Quick();
		
		quick.print(a);
		quick.sort(a);
		quick.print(a);
	}
}
