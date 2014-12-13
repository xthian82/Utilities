package py.com.snowtech.string.search;


/**
 * Knuth-Morris-Pratt Search, uses 
 * Build a Deterministic Finite Automata to
 * search for a path
 * 
 * M character accesses (but space/time proportional to RM)
 * 
 * @author cristhian
 *
 */
public class KnuthMorrisPrat {
	private int[][] dfa;
	private int M;
	private final int R = 256;


	//pat is the pattern to look for
	public KnuthMorrisPrat(String pat) {
		this.M = pat.length();

		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++) {
				dfa[c][j] = dfa[c][X];
			}
			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];
		}
	}
	
	
	public int search(String txt) {
		int i, j, N = txt.length();
		
		for (i = 0, j = 0; i<N && j<M; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == M) return i-M;
		else return N;
	}
}
