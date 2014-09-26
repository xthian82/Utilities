package py.com.snowtech.sort;

import py.com.snowtech.util.Utils;

public class Quicksort {
	
	public static void sort(int[] v, int m, int n) {
		int i,j,k;
		if (m < n) {
			i = m;
			j = n+1;
			k = v[i];
			while (true)
			{
				do {++i;} while (i<v.length && v[i]<k);
				do {--j;} while (j>-1 && v[j]>k);

				if (i<j)
					Utils.swapElement(v, i, j);
				else
					break;
			}
			Utils.swapElement(v, m, j);
			sort(v, m, j-1);
			sort(v, j+1, n);
		}
	}
	
	public static void main(String[] args) {
		int [] a = {6,5,46,2,3,10,9};
		
		Utils.print(a);
		Quicksort.sort(a, 0, a.length-1);
		Utils.print(a);
	}
}
