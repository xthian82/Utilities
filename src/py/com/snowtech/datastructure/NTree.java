package py.com.snowtech.datastructure;

import java.util.ArrayList;

public class NTree {
	private class MNode {
		private int value;
		private int visited;
		private ArrayList<MNode> children;
		
		MNode(int value) {
			this.value = value;
			this.visited = 0;
			this.children = new ArrayList<MNode>();
		}
		
		MNode getChildrenAt(int index) {
			if (index < children.size())
				return this.children.get(index);
			else 
				return null;
		}
		
		ArrayList<MNode> getChildren() {
			return this.children;
		}
		
		public String toString() {
			return " " + (this == null ? "" : this.value); 
		}
		
		public void addChild(MNode n) {
			this.children.add(n);
		}
		
		@SuppressWarnings("unused")
		public void removeChild(MNode n) {
			this.children.remove(n);
		}
		
		public int getVisited() {
			return this.visited;
		}
		
		public void visit() {
			this.visited++;
		}
		
		public boolean isLeaf() {
			return (this.children.size() == 0);
		}
	}
	private MNode root;
	
	public NTree() {
		this.root = null;
	}
	
	public void setTree() {
		MNode a = new MNode(0);
		MNode b = new MNode(1);
		MNode c = new MNode(2);
		MNode d = new MNode(3);
		MNode e = new MNode(4);
		root = new MNode(5);
		MNode g = new MNode(6);
		MNode h = new MNode(7);
		MNode i = new MNode(8);
		
		d.addChild(c);
		d.addChild(e);
		
		b.addChild(a);
		b.addChild(d);
		
		i.addChild(h);
		
		g.addChild(null);
		g.addChild(i);
		
		root.addChild(b);
		root.addChild(g);
		
	}
	
	public void inOrder() {
		System.out.print("inOrder: ");
		this.inOrder(root);
		System.out.println("");
	}
	
	public void preOrder() {
		System.out.print("preOrder: ");
		this.preOrder(root);
		System.out.println("");
	}
	
	public void postOrder() {
		System.out.print("postOrder: ");
		this.postOrder(root);
		System.out.println("");
	}
	
	//parent, left, right
	private void preOrder(MNode n) {
		if (n == null) return;
		
		System.out.print( n );
		for (int i=0; i<n.getChildren().size(); i++) {
			preOrder(n.getChildrenAt(i));
		}
	}
	
	//left, parent, right
	private void inOrder(MNode n) {
		if (n == null) return;
		int i = 0;
		
		n.visit();
		if (n.isLeaf()) System.out.print(n);
		while (i < n.getChildren().size() ) {
			inOrder(n.getChildrenAt(i++));
			n.visit();
			
			if (n.getVisited() == 2) 
				System.out.print(n);
		}
	}
	
	//left, right, parent
	private void postOrder(MNode n) {
		if (n == null) return;
		
		for (int i=0; i<n.getChildren().size(); i++) {
			postOrder(n.getChildrenAt(i));
		}
		System.out.print( n );
	}
	
	public static void main(String[] args) {
		NTree t = new NTree();
		
		t.setTree();
		
		t.preOrder();
		t.inOrder();
		t.postOrder();
	
	}
}
