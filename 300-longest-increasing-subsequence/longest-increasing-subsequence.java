// Recursion (Brute Force) -

// class Solution {
//     public int recursion(int idx, int previdx,int [] nums){
//         if(idx==nums.length){
//             return 0;
//         }
//         int lenpick=0;
//         int lennotpick=0;
//         lennotpick = 0 + recursion(idx+1, previdx, nums);
//         if(previdx == -1 || nums[idx] > nums[previdx]){
//             lenpick = 1 + recursion(idx+1, idx, nums);
//         }
//         int len = Math.max(lennotpick, lenpick);
//         return len;
//     }

//     public int lengthOfLIS(int[] nums) {
//         return (recursion(0, -1, nums));
//     }
// }

// -----------------------------------------------------------------

// DP (Memoization)

class Solution {
    public int dpfunc(int idx, int previdx, int [][]dp, int []nums){
        if (idx==nums.length){
            return 0;
        }
        if (dp[idx][previdx+1]!=-1){
            return dp[idx][previdx+1];
        }
        int len = 0 + dpfunc(idx+1, previdx, dp, nums); // not pick this idx
        if(previdx==-1 || nums[idx]>nums[previdx]){
            len = Math.max(len, 1 + dpfunc(idx+1, idx, dp, nums));
        }  // pick this idx

        dp[idx][previdx+1] = len;
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        // dp will store len obtained till (idx, previdx)
        int [][] dp = new int [nums.length][nums.length+1];
        for (int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length+1; j++){
                dp[i][j]=-1;
            }
        }
        // taking previdx s -1 but dp doesnot have any index at -1 hence doing change of coordinates in dp array: -1 in nums -> 0 in dp 2nd array , 0 in nums -> 1 in dp 2nd array, etc
        return dpfunc(0, -1, dp, nums);
    }
}

// DP (Tabulation)

