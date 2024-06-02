// BFS Approach
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0 && n==1){
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int [] pair : edges){
            int a = pair[0];
            int b = pair[1];
            // Since undirected
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int visited[] = new int [n];
        Queue <Integer> q = new LinkedList<>();
        visited[source] = 1;
        q.add(source);
        while(!q.isEmpty()){
            int currnode = q.remove();
            for(int adjNode : adj.get(currnode)){
                if (adjNode == destination){
                    return true;
                }
                else if (visited[adjNode]==0){
                    visited[adjNode]=1;
                    q.add(adjNode);
                }
            }
        }
        return false;
    }
}

// -------------------------------------------------------------------

// DFS Approach -

// class Solution {
//     public boolean dfsCheck(int currnode, int destination, List<List<Integer>> adj, int [] visited){
//         visited[currnode] = 1;
//         for(int adjNode : adj.get(currnode)){
//             if (adjNode == destination){
//                 return true;
//             }
//             else if(visited[adjNode]==0){
//                 if(dfsCheck(adjNode, destination, adj, visited)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if (edges.length == 0 && n==1){
//             return true;
//         }
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for (int [] pair : edges){
//             int a = pair[0];
//             int b = pair[1];
//             // Since undirected
//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }
//         int visited[] = new int [n];
//         if (dfsCheck(source, destination, adj, visited)){
//             return true;
//         }
//         return false;
//     }
// }