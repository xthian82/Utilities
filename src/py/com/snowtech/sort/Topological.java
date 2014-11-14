package py.com.snowtech.sort;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.datastructure.graphs.Digrafo;
import py.com.snowtech.datastructure.lists.Pila;

public class Topological {
	private boolean[] marked;
	private Pila<Integer> reversePost;
	
	public Topological(Digrafo g) {
		int vertices = g.V();
		
		marked = new boolean[vertices];
		reversePost = new Pila<Integer>();
		
		for (int i=0; i<vertices; i++) {
			marked[i] = false;
		}
		
		for (int v=0; v<vertices; v++) {
			if (!marked[v]) dfs(g, v);
		}
	}

	private void dfs(Digrafo g, int s) {
		marked[s] = true;
		for (int w : g.adj(s))
			if (!marked[w]) dfs(g, w);
		reversePost.push(s);
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("toposort.txt"));
		
		/*for (int v=0; v<g.V(); v++) {
			for (int w : g.adj(v)) {
				System.out.println(v + " - " + w);
			}
		} */
		
		Topological app = new Topological(g);
		
		for (int n : app.reversePost()) {
			System.out.print(n + " ");
		}
	}
}
