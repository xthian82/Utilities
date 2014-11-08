package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Bolsa;

public interface ProcessEdge {
	void addEdge(int v, int w, Bolsa<Integer>[] adj);
}
