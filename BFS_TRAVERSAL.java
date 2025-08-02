import java.util.*;

public class BFS_TRAVERSAL {
    public static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + " ");

            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6; // Number of nodes (0 to 5)
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(4);

        // Start BFS from node 0
        bfs(0, graph);
    }

}
