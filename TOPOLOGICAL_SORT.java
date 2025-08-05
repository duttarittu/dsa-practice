import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TOPOLOGICAL_SORT {
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args){

        int n=6;
        for (int i=0; i<n;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        topoSort(graph,6);
    }

    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public static int[] topoSort(List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,stack,i);
            }
        }

        int[] ans = new int[n];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        for( int item : ans){
            System.out.println(item + " ");
        }
        return ans;

    }

    private static void dfs(List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack, int i) {
        visited[i] = true;

        for(int neighbour : graph.get(i)){
            if(!visited[neighbour]){
                dfs(graph,visited,stack,neighbour);
            }
        }
        stack.push(i);
    }
}
