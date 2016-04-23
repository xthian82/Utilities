package py.com.snowtech.dynprog;

public class LongestPalindrom extends RepeatedSubstring {

	@Override
	int compare(String src, String dst) {
		int len = 0;
		int min = Math.min(src.length(), dst.length());
		
		for (int i=0; i<min; i++) {
			if (src.charAt(i) != dst.charAt(min-i-1)) 
				break;
			
			len++;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		LongestPalindrom app = new LongestPalindrom();
		
		System.out.println(app.lrs("dcabbacdcyturabbacabbacdat"));
	}
}
