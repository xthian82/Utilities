package py.com.snowtech.datastructure.graphs;

import py.com.snowtech.datastructure.lists.Lista;

public interface ProcessEdge {
	void addEdge(int v, int w, Lista<Integer>[] adj);
	void revAddEdge(int v, int w, Lista<Integer>[] adj);
}
