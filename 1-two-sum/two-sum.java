// 2 pointer approach

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Keep a copy for later
//         int [] ori = new int [nums.length];
//         for(int i = 0; i<nums.length; i++) ori[i]=nums[i];

//         // Find indices in sorted array using 2 pointer approach
//         Arrays.sort(nums);
//         int left = 0;
//         int right = nums.length-1;
//         while(left<right){
//             int sum = nums[left]+nums[right];
//             if(sum==target) break;
//             else if (sum<target) left++;
//             else right--;
//         }

//         // Find the original index in original unsorted array
//         for (int i = 0; i<ori.length; i++){
//             if(ori[i]==nums[left]){
//                 left = i;
//                 break;
//             }
//         }
//         for(int i = 0; i<ori.length; i++){
//             // Should not be same as left (IMP)
//             if(ori[i]==nums[right] && i!=left){
//                 right = i;
//                 break;
//             }
//         }

//         // Return the answer
//         int [] ans =  {left, right};
//         return ans;
//     }
// }

// ------------------------------------------------------------------

// Using HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++){
            int needed = target - nums[i];
            if(map.containsKey(needed)){
                ans[0] = i;
                ans[1] = map.get(needed);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}