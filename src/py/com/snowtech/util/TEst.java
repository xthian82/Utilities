package py.com.snowtech.util;

class Item {
	int value = -1;
	int index = 0;
}

public class TEst {
	static int method (String a) {
		return 0;
	}
	static int method(Object b) {
		return 2;
	}
	
	static int maxDifference(int[] a) {
		if (a.length < 1) return -1;
		
		Item min = new Item(), max = new Item();
		
		min.value = a[0];
		max.value = a[0];
		
		for (int i = 1; i< a.length; i++) {
			if (a[i] < min.value && i <= max.index) {
				min.value = a[i];
				min.index = i;
			}
			
			if (a[i] > max.value && i >= min.index) {
				max.value = a[i];
				max.index = i;
			}
		}
		
		return max.value - min.value;
	}
	
	public static void main(String[] args) {
		int v[] = {7,9,5,6,3,2};
		System.out.println(maxDifference(v));
		String o = "hola";
		System.out.println(method(o));
	}
}
