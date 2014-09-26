package py.com.snowtech.util;

public class Utils {
	public static void print(int[] a) {
		int i;
		System.out.print("[ ");
		
		for (i=0; i<a.length-1; i++) {
			System.out.print(a[i] + ", ");
		}
		
		System.out.println(a[i] + " ]");
	}
	
	public static void swapElement(int[] a, int i, int j) {
		int tmp = a[i];
		
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void copyArray(int[] source, int iBegin, int iEnd, int[] target)
	{
	    for(int k = iBegin; k < iEnd; k++)
	        target[k] = source[k];
	}
}
