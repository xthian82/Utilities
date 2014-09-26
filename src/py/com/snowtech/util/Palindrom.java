package py.com.snowtech.util;

import java.util.ArrayList;
import java.util.List;

public class Palindrom {
	public static boolean isPalindrom(int number) {
		List<Integer> n = new ArrayList<Integer>();
		
		do {
			n.add(number % 10);
			number /= 10;
		} while (number != 0);
		
		
		for (int i=0, j=n.size()-1; i<n.size() / 2; i++, j--) {
			if (n.get(i) != n.get(j))
				return false;
		}
		return true;
	}
	
	public static void main(String... args) {
		System.out.print(Palindrom.isPalindrom(2325232));
	}
}


