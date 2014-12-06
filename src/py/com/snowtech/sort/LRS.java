package py.com.snowtech.sort;

import java.util.Arrays;

/**
 * Longest Repeated Substring
 * 
 * @author cristhian
 *
 */
public class LRS {
	public String lrs(String s) {
		int N = s.length();
		String[] suffixes = new String[N];
		
		for (int i=0; i<N; i++)
			suffixes[i] = s.substring(i, N);
		
		Arrays.sort(suffixes);
		String lrs = "";
		
		for (int i=0; i<N-1; i++) {
			int len = lcp(suffixes[i], suffixes[i+1]);
			if (len > lrs.length())
				lrs = suffixes[i].substring(0, len);
		}
		
		return lrs;
	}

	private int lcp(String src, String dst) {
		int len = 0;
		int min = Math.min(src.length(), dst.length());
		
		for (int i=0; i<min; i++) {
			if (src.charAt(i) != dst.charAt(i)) 
				break;
			
			len++;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		LRS app = new LRS();
		
		System.out.println(app.lrs("cabbaccatyturabbacabbaccat"));
	}
}
