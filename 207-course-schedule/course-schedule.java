class Solution {
    // Method to check if there's a cycle starting from the node `i`
    public boolean checkCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean [] dfsvisited) {
        visited[node] = true;
        dfsvisited[node] = true;

        for (int adjNode : adj.get(node)){
            if (!visited[adjNode]){
                if(checkCycle(adjNode, adj, visited, dfsvisited)){
                    return true;
                }
            }
            else if(dfsvisited[adjNode]){
                return true;
            }
        }
        dfsvisited[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean visited [] = new boolean[numCourses];
        boolean dfsvisited [] = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            adj.get(pre).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (checkCycle(i, adj, visited, dfsvisited)) {
                    return false; // Cycle found, cannot finish courses
                }
            }
        }
        return true; // No cycles found, can finish courses
    }
}