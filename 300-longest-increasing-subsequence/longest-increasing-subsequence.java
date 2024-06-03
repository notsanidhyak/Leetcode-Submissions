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

// DP (Memoization) -

// class Solution {
//     public int dpfunc(int idx, int previdx, int [][]dp, int []nums){
//         if (idx==nums.length){
//             return 0;
//         }
//         if (dp[idx][previdx+1]!=-1){
//             return dp[idx][previdx+1];
//         }
//         int len = 0 + dpfunc(idx+1, previdx, dp, nums); // not pick this idx
//         if(previdx==-1 || nums[idx]>nums[previdx]){
//             len = Math.max(len, 1 + dpfunc(idx+1, idx, dp, nums));
//         }  // pick this idx

//         dp[idx][previdx+1] = len;
//         return len;
//     }

//     public int lengthOfLIS(int[] nums) {
//         // dp will store len obtained till (idx, previdx)
//         // idx varies from 0 to n-1 hence size n
//         // previdx varies from -1 to n-2 since name itself is previdx and can hence never reach n-1 idx, hence size n here also
//         // therefore dp array if of size[n][n]
//         int [][] dp = new int [nums.length][nums.length];
//         for (int i = 0; i<nums.length; i++){
//             for(int j = 0; j<nums.length; j++){
//                 dp[i][j]=-1;
//             }
//         }
//         // taking previdx s -1 but dp doesnot have any index at -1 hence doing change of coordinates in dp array: -1 in nums -> 0 in dp 2nd array , 0 in nums -> 1 in dp 2nd array, etc
//         return dpfunc(0, -1, dp, nums);
//     }
// }

// -----------------------------------------------------------------

// DP (Tabulation) -

// class Solution {
//     public int lengthOfLIS(int[] nums){
//         // size is [n+1][n+1] coz we need base case also
//         // also, all elements are initialized to 0 by default
//         int [][] dp = new int [nums.length+1][nums.length+1];
//         // all elements initialized to 0, hence base case also initialized to 0
//         for(int idx = nums.length-1; idx>=0; idx--){
//             for(int previdx = idx-1; previdx>=-1; previdx--){
//                 int len = 0 + dp[idx+1][previdx+1]; // not pick this idx
//                 if(previdx==-1 || nums[idx]>nums[previdx]){
//                     len = Math.max(len, 1 + dp[idx+1][idx+1]);
//                 }  // pick this idx
//                 dp[idx][previdx+1] = len;
//             }
//         }
//         return dp[0][-1+1];
//     }
// }

// -----------------------------------------------------------------

// DP (Tabulation with space optimization) -

class Solution {
    public int lengthOfLIS(int[] nums){
        // size is [n+1] and [n+1] coz we need base case also
        // also, all elements are initialized to 0 by default
        int [] nrow = new int [nums.length+1]; // nextrow (idx+1)
        int [] crow = new int [nums.length+1]; // currentrow (idx)
        // all elements initialized to 0, hence base case also initialized to 0
        for(int idx = nums.length-1; idx>=0; idx--){
            for(int previdx = idx-1; previdx>=-1; previdx--){
                int len = 0 + nrow[previdx+1]; // not pick this idx
                if(previdx==-1 || nums[idx]>nums[previdx]){
                    len = Math.max(len, 1 + nrow[idx+1]);
                }  // pick this idx
                crow[previdx+1] = len;
            }
            nrow = crow; // so that in next loop whenever idx+1 is needed it is nothing but this crow only. THINK!
        }
        return crow[-1+1]; // or nrow[-1+1] -> Anything works as nrow = crow at last
    }
}


