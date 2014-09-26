package py.com.snowtech.datastructure;

public class Cola {
	BNode first;
	BNode last;
	
	public BNode peek() {
		return first;
	}
	
	public BNode poll() {
		BNode n = null;
		
		if (first != null) {
			n = new BNode(first.value, first.left, first.right);
			
			first = first.right;
		}
		
		return n;
	}
	
	public void add(BNode n) {
		if (n != null) {
			if (last != null) {
				last.right = n;
			}
			
			last = n;
			
			if (first == null) {
				first = last;
			}
		}
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public static void main(String [] args) {
		Cola a = new Cola();
		System.out.println(a.isEmpty());
		System.out.println(a.peek());
		a.add(new BNode(1));
		a.add(new BNode(2));
		a.add(new BNode(3));
		System.out.println(a.isEmpty());
		a.add(new BNode(4));
		a.add(new BNode(5));
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.peek());
		System.out.println(a.isEmpty());
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.peek());
		System.out.println(a.isEmpty());
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.isEmpty());
		System.out.println(a.peek());
		System.out.println(a.poll());
		System.out.println(a.isEmpty());
	}
}
