package py.com.snowtech.string.search;

/**
 * takes ~N/M character compares to search 
 * for a pattern.
 * 
 * worst case can be as bad as MN
 * 
 * @author cristhian
 *
 */
public class BooyerMoore {
	private String pat;
	private static final int R = 256;
	private int[] right;
	
	//pat is the string to search
	public BooyerMoore(String pat) {
		this.pat = pat;
		right = new int[R];
		
		for (int c=0; c<R; c++) 
			right[c] = -1;
		
		for (int j=0; j<pat.length(); j++) 
			right[pat.charAt(j)] = j;
		
	}
	
	public int search(String txt) {
		int N = txt.length();
		int M = pat.length();
		int skip = 0;
		
		for (int i=0; i <= N-M; i += skip) {
			skip = 0;
			for (int j = M - 1; j >= 0; j--) {
				if (pat.charAt(j) != txt.charAt(i + j)) {
					skip = Math.max(1, j - right[txt.charAt(i + j)]);
					break;
				}
			}
			if (skip == 0) return i;
		}
		return N;
	}
	
}
