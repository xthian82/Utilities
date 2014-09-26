package py.com.snowtech.datastructure;

public class Pila {
	Node top;
	
	public Pila() {
		top = null;
	}
	
	public Node peek() {
		return top;
	}
	
	public Node push(Node n) {
		if (n != null) {
			n.next = top;
			top = n;
		}
		
		return n;
	}
	
	public Node pop() {
		Node n = null;
		
		if (top != null) {
			n = new Node(top.value);
			top = top.next;
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		Pila a = new Pila();
		
		System.out.println(a.peek());
		a.push(new Node(1));
		a.push(new Node(2));
		a.push(new Node(3));
		a.push(new Node(4));
		a.push(new Node(5));
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.peek());
		System.out.println(a.pop());
		
		System.out.println(a.peek());
		System.out.println(a.pop());
		
	}
}
