import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DFS_TRAVERSAL {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n = 8;

    public static void main(String[] args){
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        // Add undirected edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(4, 7);

        dfs(0,graph,visited);

    }

    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // because it's undirected
    }

    private static void dfs(int start, List<List<Integer>> graph,boolean[] visited) {
        visited[start] = true;
        System.out.println(start + " ");
        for(int neighbour : graph.get(start)){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }
}
