package py.com.snowtech.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Heapsort extends Sort {
	@Override
	public void sort(Comparable[] e) {
		sort(null, e);		
	}
	
	public void sort(Comparator c, Comparable[] a) {
		int count = a.length;
		
		buildHeap(c, a, count);
		int end = count - 1;
		
		while (end > 0) {
			exch(a, 0, end--);
			sink(c, a, 0, end);
		}
	}

	private void sink(Comparator c, Comparable[] a, int start, int end) {
		int root = start, child, swap;
		
		while (root*2 + 1 <= end) {
			child = 2*root + 1; //left child
			swap = root;
			
			if (less(c, a[swap], a[child]))
				swap = child;
			if (child+1 <= end && less(c, a[swap], a[child+1]))
				swap = child + 1;
			if (swap != root) {
				exch(a, root, swap);
				root = swap;
			}
			else 
				return;
		}
	}

	private void buildHeap(Comparator c, Comparable[] a, int n) {
		//start is assigned the index in a of the last parent node
	    //the last element in a 0-based array is at index count-1; find the parent of that element
	    for (int k=n/2; k >= 0; k--) {
	    	//sift down the node at index start to the proper place such that all nodes below
	        //the start index are in heap order)
	        sink(c, a, k, n-1);
	        //go to the next parent node
	    }
	}
	
	public static void main(String[] args) {
		Integer [] a = {6,5,46,2,3,10,9};
		String [] b = {"Xavier", "Orange", "Blue", "apple", "Pimple"};
		Short[] c = {1,8,7,12,15,4};
		Character[] d = {'L','x','D','a','b','C'};
		
		Heapsort heap = new Heapsort();
		
		heap.print( a );
		heap.sort( a );
		heap.print( a );
		
		heap.print( b );
		heap.sort( b );
		heap.print( b );
		
		heap.print( c );
		heap.sort( c );
		heap.print( c );
		
		heap.print( d );
		heap.sort( d );
		heap.print( d );
	}

	
}
