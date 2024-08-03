class Solution {
    public int rec(int[] nums, int previdx, int idx, int [][] dp){
        if (idx == nums.length) return 0;
        if (dp[previdx+1][idx]!=-1) return dp[previdx+1][idx];
        int rob = 0;
        if(previdx == -1 || previdx!=idx-1){
            rob = nums[idx] + rec(nums, idx, idx+1, dp);
        }
        int notrob = 0 + rec(nums, previdx, idx+1, dp);
        dp[previdx+1][idx] = Math.max(rob, notrob);
        return dp[previdx+1][idx];
    }

    public int rob(int[] nums) {
        int [][] dp = new int [nums.length][nums.length];
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                dp[i][j] = -1;
            }
        }
        return rec(nums, -1, 0, dp);
    }
}