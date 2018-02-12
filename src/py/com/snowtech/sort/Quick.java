package py.com.snowtech.sort;

import java.util.Comparator;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class Quick extends Sort {
	private int partition(Comparator c, Comparable[] a, int lo, int hi) {
		int i=lo, j = hi+1;
		while (true) {
			while (less(c, a[++i], a[lo]))
				if (i == hi) break;
			
			while (less(c, a[lo], a[--j]))
				if (j == lo) break;
			
			if (i >= j) break;
			
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private void sort(Comparator c, Comparable[] v, int lo, int hi) {
		if (hi <= lo) return;
		
		int j = partition(c, v, lo, hi);
		
		sort(c, v, lo, j-1);
		sort(c, v, j+1, hi);		
	}
	
	public void sort(Comparable[] o) {
		sort(o, null);
	}
	
	public void threeWayRadixSort(String[] a) {
		threeWayRadixSort(a, 0, a.length-1, 0);
	}
	
	private void threeWayRadixSort(String[] a, int lo, int hi, int d) {
		if (hi <= lo) return;
		
		int lt=lo, gt = hi;
		int v = MostSignificantDigit.charAt(a[lo], d);
		int i = lo + 1;
		
		while (i <= gt) {
			int t = MostSignificantDigit.charAt(a[i], d);
			
			if (t < v) 		exch(a, lt++, i++);
			else if (t > v) exch(a, i, gt--);
			else 			i++;
		}
		
		threeWayRadixSort(a, lo, lt-1, d);
		if (v >= 0) threeWayRadixSort(a, lt, gt, d+1);
		threeWayRadixSort(a, gt+1, hi, d);
		
	}

	public void sort(Comparable[] o, Comparator c) {
		sort(c, o, 0, o.length-1);
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		String [] b = {"Xavier", "Orange", "Blue", "apple", "Pimple"};
		Short[] c = {1,8,7,12,15,4};
		Character[] d = {'L','x','D','a','b','C'};
		
		Quick quick = new Quick();
		int size = 50_000;
		Random rand = new Random();
		Integer [] numbs = new Integer[size];
		for (int i = 0; i < size; i++) {
		    numbs[i] = rand.nextInt();
		}
		
		quick.print(numbs);
		quick.sort(numbs);
		quick.print(numbs);
		
		quick.print( b );
		quick.sort( b );
		quick.print( b );
		
		quick.print( c );
		quick.sort( c );
		quick.print( c );
		
		quick.print( d );
		quick.sort( d );
		quick.print( d );
	}
}
