package py.com.snowtech.datastructure;

class GNode {
	int value;
	GNode next;
	GNode[] neighbors;
	boolean visited;
	
	GNode(int value) {
		this.value = value;
	}
	GNode(int value, GNode[] n) {
		this.value = value;
		this.neighbors = n;
	}
	public String toString() {
		return " " + (this == null ? "" : this.value);
	}
}

public class Grafo {
	
	public static void levelOrder(GNode root) {
		if (root == null) return;
		//GQueue q = new GQueue();
		int lHeight = 0;
	
		Cola<GNode> q = new Cola<GNode>();
		Cola<Integer> qi = new Cola<Integer>();
		
		root.visited = true;
		System.out.print(root);
		q.add(root);
		qi.add(1);
		
		//boolean newline = false;
		while (!q.isEmpty()) {
			GNode n = q.poll();
			int h = qi.poll();
			
			if (n == null) continue;
			
			GNode[] nb = n.neighbors;
			if (nb == null) continue;
			for (int i=0; i<nb.length; i++) {
				if (h > lHeight) {
					lHeight = h;
					System.out.println();
				}
				System.out.print(nb[i] + " ");
				q.add(nb[i]);
				qi.add(h + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		GNode n1 = new GNode(1); 
		GNode n2 = new GNode(2); 
		GNode n3 = new GNode(3); 
		GNode n4 = new GNode(4); 
		GNode n5 = new GNode(5); 
		GNode n6 = new GNode(6); 
		GNode n7 = new GNode(7); 
		GNode n8 = new GNode(8); 
		GNode n9 = new GNode(9); 
		GNode n10 = new GNode(10); 
		
		n5.neighbors = new GNode[]{n10};
		n4.neighbors = new GNode[]{n8,n9};
		n3.neighbors = new GNode[]{n6,n7};
		n2.neighbors = new GNode[]{n4,n5};
		n1.neighbors = new GNode[]{n2,n3};
		
		Grafo.levelOrder(n1);
	}
}
