// Visited means there's a path to reach and logic of allPossibleTravelNotDone -> Logic is correct but gives TLE!

// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if (edges.length == 0 && n==1){
//             return true;
//         }
//         int [] visited = new int[n];
//         boolean allPossibleTravelNotDone = true;
//         visited[source] = 1;
//         while(allPossibleTravelNotDone){
//             // I assume that all Possible Travel is Done.
//             allPossibleTravelNotDone = false;

//             // Now i check pair from edges and if really all Possible Travel is Done then for every entry pair[0]=pair[1] and hence allPossibleTravelNotDone = true koi nahi karega
//             for (int [] pair : edges){
//                 if(visited[pair[0]] != visited[pair[1]]){
//                     visited[pair[0]]=1;
//                     visited[pair[1]]=1;
//                     // Since all Possible Travel was Not Done
//                     allPossibleTravelNotDone = true;
//                 }
//                 if(visited[destination]==1){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// -----------------------------------------------------------------

// BFS Approach -

// class Solution {
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
//         Queue <Integer> q = new LinkedList<>();
//         visited[source] = 1;
//         q.add(source);
//         while(!q.isEmpty()){
//             int currnode = q.remove();
//             for(int adjNode : adj.get(currnode)){
//                 if (adjNode == destination){
//                     return true;
//                 }
//                 else if (visited[adjNode]==0){
//                     visited[adjNode]=1;
//                     q.add(adjNode);
//                 }
//             }
//         }
//         return false;
//     }
// }

// ------------------------------------------------------------------

// DFS Approach -

class Solution {
    public boolean dfsCheck(int currnode, int destination, List<List<Integer>> adj, int [] visited){
        if(currnode == destination){
            return true;
        }
        visited[currnode] = 1;
        for(int adjNode : adj.get(currnode)){
            if(visited[adjNode]==0){
                if(dfsCheck(adjNode, destination, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }

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
        if (dfsCheck(source, destination, adj, visited)){
            return true;
        }
        return false;
    }
}
