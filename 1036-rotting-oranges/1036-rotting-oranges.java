class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    int [] arr = {i,j,0};
                    q.add(arr);
                }
            }
        }
        int tmax=0;
        int [] drow = {-1,0,1,0};
        int [] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int crow = q.peek()[0];
            int ccol = q.peek()[1];
            int ctime = q.peek()[2];
            // tmax = Math.max(tmax,ctime);
            tmax = ctime;
            q.remove();
            for(int i=0; i<4; i++){
                int nrow = crow+drow[i];
                int ncol = ccol+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    grid[nrow][ncol]=2;
                    int [] arr = {nrow,ncol,ctime+1};
                    q.add(arr);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return tmax;
    }
}