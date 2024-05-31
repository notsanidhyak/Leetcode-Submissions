class Solution {
    public void bfs(char[][] grid, int i, int j){
        int [][] del = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        grid[i][j] = '2';
        int [] pair = {i, j};
        Queue<int []> q = new LinkedList<>();
        q.add(pair);
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.remove();
            for (int [] delpair : del){
                int newrow = row + delpair[0];
                int newcol = col + delpair[1];
                if(newrow >=0 && newrow<grid.length && newcol>=0 && newcol<grid[0].length && grid[newrow][newcol]=='1'){
                    grid[newrow][newcol]='2';
                    int [] newpair = {newrow, newcol};
                    q.add(newpair); 
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int ct = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if (grid[i][j]=='1'){
                    bfs(grid, i, j);
                    ct++;
                }
            }
        }
        return ct;
    }
}