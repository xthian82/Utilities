package py.com.snowtech.datastructure.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;

import py.com.snowtech.sort.Topological;

/**
 * Get a list of strong connected vertices of a graph
 * 
 * @author cristhian
 *
 */
//reverse dfs 
//original dfs
public class KosarajuSharirSC {
	private boolean marked[];
	private int count;
	private int[] id;
	private Digrafo rg;
	
	public KosarajuSharirSC(Digrafo g) {
		marked = new boolean[g.V()];
		id = new int [g.V()];
		this.count = 0;
		rg = g.reverse();
		Topological dfs = new Topological( rg );
		
		for (int v : dfs.reversePost()) {
			if (!marked[v]) {
				dfs(g, v);
				count++;
			}
		}
	}
	
	private void dfs(Digrafo g, int s) {
		marked[s] = true;
		id[s] = count;
		
		for (int w : g.adj(s)) {
			if (!marked[w]) dfs(g, w);
		}
	}
	
	
	//esta v conectado a w ?
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int getVertexs() {
		return this.id.length;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Digrafo g = new Digrafo(new FileReader("graphs/digraph3.txt"));
		KosarajuSharirSC app = new KosarajuSharirSC(g);
		
		for (int v = 0; v < app.getVertexs(); v++) {
			System.out.println(v + " - " + app.id(v));
		}
	}
}
