package py.com.snowtech.datastructure.graphs;

/**
 * Preprocess a graph to get in constant time if a vertice is 
 * connected to another one
 * 
 * @author cristhian
 *
 */

public class CC {
	private boolean marked[];
	private int count;
	private int[] id;
	
    //encontrar componentes conectados en 'g'
	public CC(Grafo g) {
		marked = new boolean[g.V()];
		id = new int [g.V()];
		this.count = 0;
		
		for (int v=0; v<g.V(); v++) {
			if (!marked[v]) {
				dfs(g, v);
				count++;
			}
		}
	}
	
	//esta v conectado a w ?
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	//numero de componentes conectados;
	public int count() {
		return this.count;
	}
	
	//componente identificador para v
	public int id(int v) {
		return id[v];
	}

	private void dfs(Grafo g, int s) {
		marked[s] = true;
		id[s] = count;
		
		for (int w : g.adj(s)) {
			if (!marked[w]) dfs(g, w);
		}
	}
}
