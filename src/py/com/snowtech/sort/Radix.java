package py.com.snowtech.sort;

import py.com.snowtech.util.Utils;

public class Radix {
	private static final int BASE = 10;
	
	public static void sort(int[] a)
	{
		int n = a.length, i, m = a[0], exp = 1;
		int[] b = new int [n];
		int[] bucket = new int[BASE];

		//Get the greatest value in the array a and assign it to m
		for (i = 1; i < n; i++)
		{
			if (a[i] > m)
				m = a[i];
		}

		//Loop until exp is bigger than the largest number
		while (m / exp > 0)
		{
			//int bucket[BASE] = { 0 };
			for (i=0; i<BASE; i++) bucket[i] = 0;

			//Count the number of keys that will go into each bucket
			for (i = 0; i < n; i++)
				bucket[(a[i] / exp) % BASE]++;

			//Add the count of the previous buckets to acquire the indexes after the end of each bucket location in the array
			for (i = 1; i < BASE; i++)
				bucket[i] += bucket[i - 1]; //similar to count sort algorithm i.e. c[i]=c[i]+c[i-1];

			//Starting at the end of the list, get the index corresponding to the a[i]'s key, decrement it, and use it to place a[i] into array b.
			for (i = n - 1; i >= 0; i--)
				b[--bucket[(a[i] / exp) % BASE]] = a[i];

			Utils.copyArray(b, 0, n, a);

			//Multiply exp by the BASE to get the next group of keys
			exp *= BASE;
		}
	}
	
	public static void bucket(char[] a, int R) {
		int N = a.length;
		int[] count = new int[R+1];
		char[] aux = new char[N];
		
		for (int i=0; i<N; i++)
			count[ (int)(a[i]-'a') + 1 ]++;
		
		for (int r=0; r < R; r++)
			count[r+1] += count[r];
		
		for (int i=0; i<N; i++)
			aux[ count[ (int)(a[i]-'a') ]++ ] = a[i];
		
		for (int i=0; i<N; i++)
			a[i] = aux[i];
	}
	
	public static void main(String[] args) {
		int [] a = {6,5,46,2,3,10,9};
		char [] b = {'d','a','c','f','f','b','d','b','f','b','e','a'}; //R = 6
		
		Utils.print( a );
		Radix.sort( a );
		Utils.print( a );
		System.out.println("===================");
		Utils.print( b );
		Radix.bucket(b, 6);
		Utils.print( b );
	}
}
