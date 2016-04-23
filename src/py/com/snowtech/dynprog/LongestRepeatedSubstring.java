package py.com.snowtech.dynprog;

import java.util.Arrays;

/**
 * Longest Repeated Substring
 * 
 * @author cristhian
 *
 */

public class LongestRepeatedSubstring extends RepeatedSubstring {

	int compare(String src, String dst) {
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
		LongestRepeatedSubstring app = new LongestRepeatedSubstring();
		
		System.out.println(app.lrs("cabbaccatyturabbacabbaccat"));
	}
}
