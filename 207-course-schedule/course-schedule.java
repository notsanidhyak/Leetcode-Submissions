// DFS Approach -

// class Solution {
//     public boolean checkCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean [] dfsvisited) {
//         visited[node] = true;
//         dfsvisited[node] = true;

//         for (int adjNode : adj.get(node)){
//             if (!visited[adjNode]){
//                 if(checkCycle(adjNode, adj, visited, dfsvisited)){
//                     return true;
//                 }
//             }
//             else if(dfsvisited[adjNode]){
//                 return true;
//             }
//         }
//         dfsvisited[node] = false;
//         return false;
//     }

//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         boolean visited [] = new boolean[numCourses];
//         boolean dfsvisited [] = new boolean[numCourses];

//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int pre = pair[1];
//             adj.get(pre).add(course);
//         }

//         for (int i = 0; i < numCourses; i++) {
//             if (!visited[i]) {
//                 if (checkCycle(i, adj, visited, dfsvisited)) {
//                     return false; // Cycle found, cannot finish courses
//                 }
//             }
//         }
//         return true; // No cycles found, can finish courses
//     }
// }

// ------------------------------------------------------------------

// BFS Approach (aka Kahn's algo - topo sort method)
// if len(topo)<V -> cycle detected
// because no further indegree == 0 found, hence stopped

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int [] pair : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            indegree[course]++;
            adj.get(pre).add(course);
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ct = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ct++;
            for(int adjNode : adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    q.add(adjNode);
                }
            }
        }
        if(ct==numCourses){
            return true;
        }
        return false;
    }
}