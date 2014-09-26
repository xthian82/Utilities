package py.com.snowtech.datastructure;

public class GQueue {
	GNode first;
	GNode last;
	
	public boolean isEmpty () {
		return (first == null);
	}
	
	public GNode peek() {
		return first;
	}
	
	public void enQueue(GNode n) {
		if (n != null) {
			if (last != null)
				last.next = n;
			
			last = n;
			
			if (isEmpty())
				first = last;
		}
	}
	
	public GNode deQueue() {
		GNode n = null;
		
		if (!isEmpty()) {
			n = new GNode(first.value, first.neighbors);
			first = first.next;
		}
		
		return n;
	}
}
