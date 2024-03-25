class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList newarr = new ArrayList();
        for (int i = 0; i<nums.length; i++){
            int curr = nums[Math.abs(nums[i])-1];
            if (curr<0){
                newarr.add(Math.abs(nums[i]));
            }
            else{
                nums[Math.abs(nums[i])-1] = -curr;
            }
        }
        return newarr;
    }
}

// Edge Cases -
// Make sure to do Math.abs
// Make sure to deal with index properly (take care of -1)