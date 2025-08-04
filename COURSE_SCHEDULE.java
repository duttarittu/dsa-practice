import java.util.ArrayList;
import java.util.List;

public class COURSE_SCHEDULE {

    public static void main(String[] args){
        int numCourses =3;
        int[][] prerequisites = {{1,0},{1,2}};
        boolean[] visited  = new boolean[numCourses];

        if(canFinish(numCourses,prerequisites)){
            System.out.println("Possible");
        }
        else{
            System.out.println("Not possible");
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(graph,visited,recStack,i)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] recStack, int i) {
        visited[i]=true;
        recStack[i]=true;
        for(int neighbour : graph.get(i)){
            if(!visited[neighbour]) {
                if (hasCycle(graph, visited, recStack, neighbour)) {
                    return true;
                }
            }
            else if(recStack[neighbour]){
                return true;
            }
        }
        recStack[i]=false;
        return false;
    }
}
