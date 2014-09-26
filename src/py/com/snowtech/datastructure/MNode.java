package py.com.snowtech.datastructure;

import java.util.ArrayList;

public class MNode {
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
