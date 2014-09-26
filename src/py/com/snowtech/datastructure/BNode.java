package py.com.snowtech.datastructure;

public class BNode {
	int value;
	boolean visited;
	BNode left;
	BNode right;
	//private static final String[] ITEMS = {"A","B","C","D","E","F", "G", "H", "I"};
	
	public BNode(int value) {
		this.value = value;
	}
	
	public BNode(int value, BNode left, BNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BNode getLeft() {
		return left;
	}

	public void setLeft(BNode left) {
		this.left = left;
	}

	public BNode getRight() {
		return right;
	}

	public void setRight(BNode right) {
		this.right = right;
	}
	
	public boolean isLeaf() {
		return (this.left == null && this.right == null);
	}
	
	@Override
	public String toString() {
		return " " + /*ITEMS[*/this.value/*]*/;
	}
}
