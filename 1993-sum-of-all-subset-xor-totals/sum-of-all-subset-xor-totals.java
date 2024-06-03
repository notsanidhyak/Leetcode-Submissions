class Solution {
    public int rec(int[] nums, int i, int currxor){
        if(i==nums.length){
            return currxor;
        }
        int xor = rec(nums, i+1, currxor^nums[i]); // pick
        xor += rec(nums, i+1, currxor); // notpick
        currxor = xor;
        return currxor;
    }
    public int subsetXORSum(int[] nums) {
        return rec(nums, 0, 0);
    }
}