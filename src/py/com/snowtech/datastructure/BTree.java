package py.com.snowtech.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {
	
	//parent, left, right
	public static void preOrder(BNode n) {
		if (n == null) return;
		
		System.out.print( n );
		preOrder(n.getLeft());
		preOrder(n.getRight());
	}
	
	//left, parent, right
	public static void inOrder(BNode n) {
		if (n == null) return;
		
		inOrder(n.getLeft());
		System.out.print( n );
		inOrder(n.getRight());
	}
	
	//left, right, parent
	public static void postOrder(BNode n) {
		if (n == null) return;
		
		postOrder(n.getLeft());
		postOrder(n.getRight());
		System.out.print( n );
	}
	
	public static void levelOrder(BNode root) {
		if (root == null) return;
		//Cola q = new Cola();
		Queue<BNode> q = new LinkedList<BNode>();
		q.add(root);
		
		while (!q.isEmpty()) {
			BNode n = q.poll();
			
			if (n.visited == false) {
				System.out.print(n);
				n.visited = true;
			}
			
			if (n.left != null)
				q.add(n.left);
			
			if (n.right != null)
				q.add(n.right);
		}
	}
	
	public static int pathSum(BNode node) {
		if (node == null) return 0;
		
		if (node.isLeaf()) return node.value;
			
		return node.value + pathSum(node.left) + pathSum(node.right);
	}
	
	public static BNode buildTreeFromOrderArray(int[] array, int begin, int end) {
		if (begin >= end) return null;
		int m = (end - begin) / 2;
		
		BNode root = new BNode(array[m]);
		root.left = buildTreeFromOrderArray(array, begin, m - 1);
		root.right = buildTreeFromOrderArray(array, m + 1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		BNode a = new BNode(0);
		BNode b = new BNode(1);
		BNode c = new BNode(2);
		BNode d = new BNode(3);
		BNode e = new BNode(4);
		BNode f = new BNode(5);
		BNode g = new BNode(6);
		BNode h = new BNode(7);
		BNode i = new BNode(8);
		
		c.setRight(g);
		d.setLeft(e);
		d.setRight(f);
		b.setLeft(c);
		b.setRight(d);
		
		/*
		d.setLeft(c);
		d.setRight(e);
		
		b.setLeft(a);
		b.setRight(d);
		
		i.setLeft(h);
		
		g.setRight(i);
		
		f.setLeft(b);
		f.setRight(g); */
		
		System.out.print("Pre-Order: ");
		BTree.preOrder(f);
		System.out.println();
		
		System.out.print("In-Order: ");
		BTree.inOrder(f);
		System.out.println();
		
		System.out.print("Post-Order: ");
		BTree.postOrder(f);
		System.out.println();
		
		System.out.print("level-Order: ");
		BTree.levelOrder(f);
		System.out.println();
		
		System.out.println("PathSum: " + BTree.pathSum(b));
		int [] ar = {1,2,3,4,5,6,7,8,9};
		BNode r = BTree.buildTreeFromOrderArray(ar, 0, ar.length-1);
		
		BTree.inOrder(r);
		
	}
}
