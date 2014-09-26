package py.com.snowtech.sort;

import py.com.snowtech.util.Utils;

public class Heapsort {
	public static void sort(int[] a) {
		int count = a.length;
		
		heapify(a, count);
		int end = count - 1;
		
		while (end > 0) {
			Utils.swapElement(a, 0, end);
			end--;
			siftDown(a, 0, end);
		}
	}
	
	private static void siftDown(int[] a, int start, int end) {
		int root = start, child, swap;
		
		while (root*2 + 1 <= end) {
			child = 2*root + 1; //left child
			swap = root;
			
			if (a[swap] < a[child])
				swap = child;
			if (child+1 < end && a[swap] < a[child+1])
				swap = child + 1;
			if (swap != root) {
				Utils.swapElement(a, root, swap);
				root = swap;
			}
			else 
				return;
		}
	}

	private static void heapify(int[] a, int n) {
		//start is assigned the index in a of the last parent node
	    //the last element in a 0-based array is at index count-1; find the parent of that element
	    int start = (n - 2 ) / 2;
	    
	    while (start >= 0) {
	    	//sift down the node at index start to the proper place such that all nodes below
	        //the start index are in heap order)
	        siftDown(a, start, n-1);
	        //go to the next parent node
	        start--;
	        //after sifting down the root all nodes/elements are in heap order
	    }
	}
	
	public static void main(String[] args) {
		int [] a = {6,5,46,2,3,10,9};
		
		Utils.print( a );
		Heapsort.sort( a );
		Utils.print( a );
	}
}
