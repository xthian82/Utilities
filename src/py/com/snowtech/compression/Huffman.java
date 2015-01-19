package py.com.snowtech.compression;

import py.com.snowtech.datastructure.MinPQ;

public class Huffman {
	private BinaryStdIn bStdin;
	private BinaryStdOut bStdout;
	private static final int R = 256;
	
	private static class Node implements Comparable<Node> {
		private char ch; //unused for internal nodes
		private int freq; //unused for expand
		private final Node left, right;
		
		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}

		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
		
	}
	
	private Node buildTrie(int[] freq) {
		MinPQ<Node> pq = new MinPQ<Node>();
		for (char i=0; i<R; i++)
			if (freq[i] > 0)
				pq.insert(new Node(i, freq[i], null, null));
		
		while (pq.size() > 1) {
			Node x = pq.delete();
			Node y = pq.delete();
			Node parent = new Node('\0', x.freq + y.freq, x, y);
			pq.insert(parent);
		}
		
		return pq.delete();
	}
	
	public void expand() {
		Node root = readTrie();
		int N = bStdin.readInt();
		
		for (int i=0; i < N; i++) {
			Node x = root;
			while (!x.isLeaf()) {
				if (!bStdin.readBoolean())
					x = x.left;
				else
					x = x.right;
			}
			bStdout.write(x.ch, 8);
		}
		bStdout.close();
	}
	
	private Node readTrie() {
		if (bStdin.readBoolean()) {
			char c = bStdin.readChar(8);
			return new Node(c, 0, null, null);
		}
		
		Node x = readTrie();
		Node y = readTrie();
		return new Node('\0', 0, x, y);
	}
	private void writeTrie(Node x) {
		if (x.isLeaf()) {
			bStdout.write(true);
			bStdout.write(x.ch, 8);
			return;
		}
		bStdout.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}
}
