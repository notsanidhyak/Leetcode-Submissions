class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Initialize the distance matrix
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Step 2: Apply Floyd-Warshall algorithm to find all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Count the number of reachable cities for each city within the distance threshold
        int minReachableCities = Integer.MAX_VALUE;
        int cityWithSmallestNumberOfNeighbors = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities < minReachableCities || (reachableCities == minReachableCities && i > cityWithSmallestNumberOfNeighbors)) {
                minReachableCities = reachableCities;
                cityWithSmallestNumberOfNeighbors = i;
            }
        }

        return cityWithSmallestNumberOfNeighbors;
    }
}