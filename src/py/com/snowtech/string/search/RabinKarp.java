package py.com.snowtech.string.search;

public class RabinKarp {
	private long pathash;
	private int M;
	private long Q;
	private int R;
	private long MR;

	// pat is the string to search
	public RabinKarp(String pat) {
		M = pat.length();
		R = 256;
		Q = 997;
		
		MR = 1;
		for (int i=0;i<=M-1;i++)
			MR = (R * MR) % Q;
		pathash = hash(pat, M);
	}

	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}
	
	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, N);
		if (txtHash == pathash) return 0;
		
		for (int i=M; i<N; i++) {
			txtHash = (txtHash + Q - MR*txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			if (txtHash == pathash) return i - M + 1;
		}
		
		return N;
	}
}
