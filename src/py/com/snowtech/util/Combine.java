package py.com.snowtech.util;

public class Combine {
	private static void combinate(int[] c, int pos, int length, int maxpos) {
		if (pos > maxpos) {
			for (int i=1; i<=maxpos; i++)
				System.out.print(c[i] + " "); 
		
			System.out.println("");
			return;
		}
		
		for (int j=c[pos-1]+1; j<=length; j++) {
			c[pos] = j;
			combinate(c, pos+1, length, maxpos);
		}
	}
	
	public static void combine(int m, int n) {
		int [] c = new int[m + 1];
		
		c[0] = 0;
		combinate(c, 1, m, n);
	}
	
	
	public static void permute(int n) {
		int [] numbers = new int[n];
		
		for (int i=0; i<n; i++)
			numbers[i] = i+1;

		permute(numbers, 0);
	}
	
	private static void permute(int[] a, int pos) {
		
		if (pos >= a.length) { return;}
		Utils.print(a);
		
		for (int i=pos; i<a.length-1; i++) {
			for (int j=i+1; j<a.length; j++) {
				Utils.swapElement(a, i, j);
				permute(a, i+1);
				Utils.swapElement(a, i, j);
			}
		}
	}
	
	public static void main(String... args) {
		//Combine.combine(5, 2);
		Combine.permute(3);
	}
}
