class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                int flagIndex = val - 1;
                if (nums[flagIndex] > 0)
                    nums[flagIndex] *= -1;
            }
        }

        for (int i = 1; i <= n; i++) 
            if (nums[i - 1] > 0)
                    return i;

        return n + 1;
    }
}