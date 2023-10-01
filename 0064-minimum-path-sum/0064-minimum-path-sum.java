class Solution {

    // DP - Memoization

    // public int func(int[][] dp, int[][] grid, int ri, int ci, int n, int m){
    //     if(ri == n-1 && ci == m-1){
    //         return grid[n-1][m-1];
    //     }
    //     if(ri<0 || ri>=n || ci<0 || ci>=m){
    //         return 40000;
    //     }
    //     if(dp[ri][ci]!=-1){
    //         return dp[ri][ci];
    //     }
    //     int curr = grid[ri][ci];
    //     int right = curr + func(dp, grid, ri+0, ci+1, n, m);
    //     int down = curr + func(dp, grid, ri+1, ci+0, n, m);
    //     int minsum = Math.min(right,down);
    //     dp[ri][ci]=minsum;
    //     return minsum;
    // }

    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int [][] dp = new int[n][m];
    //     for(int i = 0; i<n; i++){
    //         for(int j=0; j<m;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return func(dp, grid, 0, 0, n, m);
    // }

    // DP - Tabulation

    public int minPathSum(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j=0; j<m;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = grid[i][j];
                if(i<1 && j<1){
                    dp[i][j]+=0;
                }
                else if(i<1){
                    dp[i][j]+=dp[i][j-1];
                }
                else if(j<1){
                    dp[i][j]+=dp[i-1][j];
                }
                else{
                    dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}