// BFS Approach -

// class Solution {
//     public boolean checkBipartite(int node, int[][]graph, int[]color){
//         color[node]=0;
//         Queue <Integer> q = new LinkedList<>();
//         q.add(node);

//         while(!q.isEmpty()){
//             int currnode = q.remove();
//             for(int adjNode : graph[currnode]){
//                 if(color[adjNode]==-1){
//                     q.add(adjNode);
//                     color[adjNode] = 1-color[currnode];
//                 }
//                 else if(color[adjNode]==color[currnode]){
//                     return false;
//                 }
//             }   
//         }
//         return true;
//     }
    
//     public boolean isBipartite(int[][] graph) {
//         int [] color = new int [graph.length];
//         // for-each loop does not work to modify values
//         for(int i = 0; i < color.length; i++){
//             color[i] = -1;
//         }

//         for(int i = 0; i<graph.length; i++){
//             if(color[i]==-1){
//                 // IMP - if you write in following way:
//                 // if(checkBipartite(i, graph, color)){
//                 //     return true;
//                 // }
//                 // Then this is wrong because it returns true when it should not. Always whenever condition of negation possible then try to find negation first. Otherwise if negation comes then your code cant read bcs you code is looking for true! Dry run and understand with testcases!
//                 if(!checkBipartite(i, graph, color)){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

// ------------------------------------------------------------------

// DFS Approach -

class Solution {
    public boolean dfscheckBipartite(int node, int nodecolor, int [][]graph, int []color){
        // Reason of doing below line is written in below function isBipartite. Thing in terms of recursion is reason!
        color[node]=nodecolor;
        for(int adjNode : graph[node]){
            if(color[adjNode]==-1){
                nodecolor = 1-color[node];
                if(!dfscheckBipartite(adjNode, nodecolor, graph, color)){
                    return false;
                }
            }
            else if(color[adjNode]==color[node]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color [] = new int [graph.length];
        for (int i = 0; i<color.length; i++){
            color[i]=-1;
        }
        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
                // Imp thing to note that here you have to give nodecolor in function because dfs does recursion and if in dfscheckBipartite you write color[node]=0 at top then color of all nodes become 0 by default. So you need something which can change color even on recursion. Hence did this. See dfscheckBipartite, you'll understand!
                if(!dfscheckBipartite(i, 0, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
}