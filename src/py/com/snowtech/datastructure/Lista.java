package py.com.snowtech.datastructure;

class Node {
	int value;
	Node left;
	Node next;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return " " + (this == null ? "-" : value);
	}
}

public class Lista {
	Node head;

	void rprint() {
		rprint(head.next);
	}

	void rprint(Node n) {
		if (n == null) {
			System.out.println("");
			return;
		}

		System.out.print(n);
		rprint(n.next);
	}

	void createList(int[] array) {
		if (array.length < 1) return;

		head = new Node(-1);

		Node m, n = new Node(array[0]);
		head.next = n;
		for (int i=1; i<array.length; i++) {
			m = new Node(array[i]);
			n.next = m;
			n = m;
		}
	}

	void deleteDuplicates() {
		//deleteDuplicates(head.next);
		delete2(head.next);
	}

	void deleteDuplicates(Node head) {
		if (head == null) return;

		Node p = head;
		head = head.next;

		while (head != null) {
			if (p.value == head.value) {
				head = head.next;
			}
			else {
				p.next = head;
				p = head;
			}
		}
		p.next = null;
	}

	void delete2(Node head) {
		if(head == null || head.next == null)
			return;

		Node p = head;

		while( p!= null && p.next != null){
			if(p.value == p.next.value){
				p.next = p.next.next;
			}else{
				p = p.next; 
			}
		}
	}

	public static void main(String... args) {
		Lista ap = new Lista();
		int[] a = {1, 1, 1, 2, 3, 3, 4, 4, 4};

		ap.createList(a);
		System.out.print("Original : ");
		ap.rprint();
		ap.deleteDuplicates( );
		System.out.print("\nRemoveDup : ");
		ap.rprint();
	}
}
