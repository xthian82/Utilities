package py.com.snowtech.util;

/*
 * Determinar si un numero es palindrome
 * 
 * Ej 2111223 = false
 *    212 = true
 *    3656556 = false
 *    3112113 = true 
 * 
 * */

public class Palindrom {
	public static boolean isPalindrom(int number) {
		int n = number / 10;
		int d = 1;
		int r,l;
		
		while (n != 0) {
			n /= 10;
			d *= 10;
		} 
		
		n = number;
		
		while (n != 0) {
			r = n / d;
			l = n % 10;
			
			if (r != l) return false;
			
			n -= r*d;
			n /= 10;
			d /= 100;
		}
		
		return true;
	}
	
	public static void main(String... args) {
		int c = 0;
		for (int i=1;i<1000000000;i++) {
			if (isPalindrom(i)) {
				++c;
			}
		}
		System.out.println(c);
	}
}


