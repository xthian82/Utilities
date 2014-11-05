package py.com.snowtech.datastructure.graphs;

public interface Path {
	boolean hasPathTo(int v);
	Iterable<Integer> pathTo(int v);
}
