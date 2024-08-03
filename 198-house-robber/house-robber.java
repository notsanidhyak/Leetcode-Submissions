class Solution {
    public int rec(int[] nums, int idx, int [] dp){
        if (idx >= nums.length) return 0;
        if (dp[idx]!=-1) return dp[idx];
        int rob = nums[idx] + rec(nums, idx+2, dp);
        int notrob = 0 + rec(nums, idx+1, dp);
        dp[idx] = Math.max(rob, notrob);
        return dp[idx];
    }

    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            dp[i] = -1; 
        }
        return rec(nums, 0, dp);
    }
}