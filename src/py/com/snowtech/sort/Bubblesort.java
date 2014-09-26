package py.com.snowtech.sort;

import py.com.snowtech.util.Utils;

public class Bubblesort {
	public static void sort(int [] a) {
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				if (a[i] > a[j])
					Utils.swapElement(a, i, j);
			}
		}
	}
	
	public static void main(String[] args) {
		int [] a = {6,5,46,2,3,10,9};
		
		Utils.print( a );
		Bubblesort.sort( a );
		Utils.print( a );
	}
}
