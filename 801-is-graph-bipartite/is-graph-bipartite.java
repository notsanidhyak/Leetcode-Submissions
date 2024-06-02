// BFS Approach -

class Solution {
    public boolean checkBipartite(int node, int[][]graph, int[]color){
        color[node]=0;
        Queue <Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int currnode = q.remove();
            for(int adjNode : graph[currnode]){
                if(color[adjNode]==-1){
                    q.add(adjNode);
                    color[adjNode] = 1-color[currnode];
                }
                else if(color[adjNode]==color[currnode]){
                    return false;
                }
            }   
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int [] color = new int [graph.length];
        // for-each loop does not work to modify values
        for(int i = 0; i < color.length; i++){
            color[i] = -1;
        }

        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
                if(!checkBipartite(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
}