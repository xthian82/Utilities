package py.com.snowtech.datastructure.trees;

import java.util.LinkedList;
import java.util.Queue;

import py.com.snowtech.datastructure.lists.Cola;

public class ArbolBinario<Item> {
    private class Node {
    	Item value;    	
    	Node left;
    	Node right;
    	
    	Node(Item item) {
    		this.value = item;
    		this.left = null;
    		this.right = null;
    	}
    	
    	public String toString() {
    		return (value == null ? "" : value.toString() + " ");
    	}
    }
    private Node root;
    private Node current;
    private Queue<Node> q;
    
    public void inOrder() {
    	System.out.print("InOrder: ");
    	inOrder(root);
    	System.out.println();
    }
    
    public ArbolBinario() {
    	root = null;
    	current = null;
    	q = new LinkedList<Node>();
    }
    
    public void buildTreeFromOrderArray(Item[] array) {
    	this.root = buildTreeFromOrderArray(array, 0, array.length-1);
    }
    
	private Node buildTreeFromOrderArray(Item[] array, int begin, int end) {
		if (begin >= end) return null;
		int m = (end - begin) / 2;
		
		Node root = new Node(array[m]);
		root.left = buildTreeFromOrderArray(array, begin, m - 1);
		root.right = buildTreeFromOrderArray(array, m + 1, end);
		
		return root;
	}
    
    public void postOrder() {
    	System.out.print("postOrder: ");
    	Node t = root;
    	postOrder(t);
    	System.out.println();
    }
    
    public void preOrder() {
    	System.out.print("preOrder: ");
    	Node t = root;
    	preOrder(t);
    	System.out.println();
    }
    
    public void levelOrder() {
    	System.out.print("levelOrder: ");
    	Node t = root;
    	levelOrder(t);
    	System.out.println();
    }
    
    private void inOrder(Node n) {
    	if (n == null) return;
    	
    	inOrder(n.left);
    	System.out.print(n);
    	inOrder(n.right);
    }   
    
    private void postOrder(Node n) {
    	if (n == null) return;
    	
    	postOrder(n.left);
    	postOrder(n.right);
    	System.out.print(n);
    }
    
    private void levelOrder(Node n) {
    	if (n == null) return;
    	
    	Cola<Node> q = new Cola<Node>();
    	q.enqueue(n);
    	
    	while ( !q.isEmpty() ) {
    		Node node = q.dequeue();
    		
    		System.out.print(node);
    		
    		if (node.left != null) q.enqueue(node.left);    		
    		if (node.right != null) q.enqueue(node.right);
    	}
    }
    
    private void preOrder(Node n) {
    	if (n == null) return;
    	
    	System.out.print(n);    	
    	preOrder(n.left);
    	preOrder(n.right);
    }   
  
    public void add(Item item) {
    	Node n = new Node(item);
    	
    	if (root == null) {
    		root = n;
    		current = root;    		
    	} 
    	else {
    		if (current.left == null) {
    			current.left = n;
    			if (n != null) q.add(n);
    		} else if (current.right == null) {
    			current.right = n;
    			if (n != null) q.add(n);
    			current = q.poll();
    		}
    	}
    }
    
	public static void main(String[] args) {
		ArbolBinario<Character> a = new ArbolBinario<Character>();
		
		//F, B, G, A, D, I, C, E, H
		a.add('F');
		a.add('B');
		a.add('G');
		a.add('A');
		a.add('D');
		a.add(null);
		a.add('I');
		a.add(null);
		a.add(null);
		a.add('C');
		a.add('E');
		a.add(null);
		a.add(null);
		a.add('H');
		
		a.levelOrder();
		a.postOrder();
		a.preOrder();		
		a.inOrder();
		
		//Level-order: F, B, G, A, D, I, C, E, H
		//Post-order: A, C, E, D, B, H, I, G, F
		//Pre-order: F, B, A, D, C, E, G, I, H
		//In-order: A, B, C, D, E, F, G, H, I
	}

}
