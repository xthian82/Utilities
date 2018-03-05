package py.com.snowtech.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int vertex;
    private int edges;
    private boolean isUndirected;
    private List<Integer>[] children;

    public Graph(int v, boolean isUndirected) {
        this.vertex = v;
        this.edges = 0;
        this.isUndirected = isUndirected;

        this.children = new List[v];
        for (int i = 0; i < v; i++) {
            this.children[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        if (v >= vertex || w >= vertex || v < 0 || w < 0) {
            throw new IllegalArgumentException();
        }

        this.children[v].add(w);
        if (isUndirected) {
            this.children[w].add(v);
        }
    }

    public int vertices() {
        return this.vertex;
    }

    public int edges() {
        return this.edges;
    }

    public Iterable<Integer> adjacents(int v) {
        return this.children[v];
    }

    public void display() {
        for (int v = 0; v < vertex; v++) {
            System.out.print("\n" + v + ":");
            for (int w : adjacents(v)) {
                System.out.print(" " + w);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = buildGraph();

        graph.display();

        // new GraphBFS().bfs(graph, 0);
    }

    static Graph buildGraph() {
        Graph g = new Graph(7, true);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 6);

        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.addEdge(4, 5);
        g.addEdge(4, 6);

        return g;
    }


}
