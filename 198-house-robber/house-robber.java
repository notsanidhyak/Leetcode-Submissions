// Memoization -

// class Solution {
//     public int rec(int[] nums, int idx, int [] dp){
//         if (idx >= nums.length) return 0;
//         if (dp[idx]!=-1) return dp[idx];
//         int rob = nums[idx] + rec(nums, idx+2, dp);
//         int notrob = 0 + rec(nums, idx+1, dp);
//         dp[idx] = Math.max(rob, notrob);
//         return dp[idx];
//     }

//     public int rob(int[] nums) {
//         int [] dp = new int[nums.length];
//         for(int i = 0; i<nums.length; i++){
//             dp[i] = -1; 
//         }
//         return rec(nums, 0, dp);
//     }
// }

// -----------------------------------------------------------------

// Tabulation -

// class Solution {
//     public int rob(int[] nums) {
//         int [] dp = new int [nums.length];
//         for(int i = 0; i<nums.length; i++){
//             int rob = nums[i];
//             if(i>1) rob+=dp[i-2];
//             int notrob = 0;
//             if(i>0) notrob+=dp[i-1];
//             dp[i] = Math.max(rob, notrob);
//         }
//         return dp[nums.length-1];
//     }
// }

// -----------------------------------------------------------------

// Tabulation with space optimization -

class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 0; i<nums.length; i++){
            int rob = nums[i] + prev2;
            int notrob = 0 + prev1;
            prev2 = prev1;
            prev1 = Math.max(rob, notrob);
        }
        return prev1;
    }
}