class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;        
        List<Integer> res = new ArrayList<>();

        // Array to track node status: 0 = Unvisited, 1 = Safe, 2 = Visited
        int[] safe = new int[n];

        // Create reverse graph: vertex[i] contains nodes that have an edge to i
        List<Integer>[] vertex = new ArrayList[n];
        for(int i = 0; i < n; i++){
            vertex[i] = new ArrayList();
        }

        // Populate the reverse graph
        for(int i = 0; i < n; i++){
            for(int idx : graph[i]){
                vertex[idx].add(i);                
            }
        }

        Queue<Integer> que = new LinkedList();
        // Initialize terminal nodes (nodes with no outgoing edges) as safe
        for(int i = 0; i < n; i++){
            if(graph[i].length == 0){
                safe[i] = 1; // Mark as safe
                que.add(i);
            }
        }

        // Process safe nodes
        while(!que.isEmpty()){
            int idx = que.poll(); // Get a safe node
            for(int inNode : vertex[idx]){ // Check incoming nodes
                if(isSafe(graph, safe, inNode)){
                    safe[inNode] = 1; // Mark as safe
                    que.add(inNode);
                }
                else{
                    safe[inNode] = 2; // Mark as visited but not safe
                }
            }
        }
        
        // Collect all safe nodes
        for(int i = 0; i < n; i++){
            if(safe[i] == 1)
                res.add(i);
        }
        
        return res;
    }

    // Check if all outgoing nodes from inNode are safe
    boolean isSafe(int[][] graph, int[] safe, int inNode){
        for(int outNode : graph[inNode]){
            if(safe[outNode] != 1){
                return false;
            }
        }
        return true;
    }
}