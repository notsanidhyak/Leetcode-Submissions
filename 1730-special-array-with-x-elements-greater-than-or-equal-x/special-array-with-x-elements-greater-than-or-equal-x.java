class Solution {
    public int specialArray(int[] nums) {
        int x = 0;
        int ct = 0;
        while (x<=nums.length){
            for (int i = 0; i<nums.length; i++){
                if (nums[i]>=x){
                    ct++;
                }
            }
            if (ct==x){
                return x;
            }
            ct = 0;
            x++;
        }
        return -1;
    }
}