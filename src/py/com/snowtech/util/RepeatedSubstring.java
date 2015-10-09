package py.com.snowtech.util;

import java.util.Arrays;

public abstract class RepeatedSubstring {
	abstract int compare(String src, String dst);
	
	void print(String[] w, char f) {
		for (int i=0;i<w.length;i++) {
			System.out.println(" "+f+f+f+f+f+f+f+" " + w[i]);
		}
	}
	
	public String lrs(String s) {
		int N = s.length();
		String[] suffixes = new String[N];
		
		for (int i=0; i<N; i++)
			suffixes[i] = s.substring(i, N);
		
		//System.out.println("...NonOrdered Words...");
		//print(suffixes, '-');
		Arrays.sort(suffixes);
		//System.out.println("...Ordered Words...");
		//print(suffixes, '*');
		String lrs = "";
		
		for (int i=0; i<N-1; i++) {
			int len = compare(suffixes[i], suffixes[i+1]);
			if (len > lrs.length())
				lrs = suffixes[i].substring(0, len);
		}
		
		return lrs;
	}
}
