package py.com.snowtech.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private Graph graph;
    private boolean[] visited;
    private Queue<Integer> queue;

    GraphBFS(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.vertices()];
        this.queue = new LinkedList<>();
    }

    public void bfs(int start) {
        for (int i = 0; i<visited.length; i++) {
            visited[i] = false;
        }

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int w : graph.adjacents(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public void dfs(int start) {

    }
}
