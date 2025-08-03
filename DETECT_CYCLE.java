import java.util.ArrayList;
import java.util.List;

public class DETECT_CYCLE {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n=5;

    public static void main(String[] args){
        boolean[] visited = new boolean[8];
        for ( int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 1); // This edge introduces a cycle

        if(detect_cycle(graph,visited,0,-1)){
            System.out.println("Cycle Present");
        }
        else {
            System.out.println("No Cycle Present");
        }

    }

    private static boolean detect_cycle(List<List<Integer>> graph, boolean[] visited, int start, int parent) {
        visited[start] = true;
        for(int neighbour : graph.get(start)){
            if(!visited[neighbour]){
                if(detect_cycle(graph,visited,neighbour,start)){
                    return true;
                }
            }
            else if(parent!=neighbour){
                return true;
            }
        }

        return false;
    }


    static void addEdge(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }


}
