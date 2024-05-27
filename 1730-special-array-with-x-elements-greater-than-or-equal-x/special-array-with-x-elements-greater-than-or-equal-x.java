class Solution {
    public int specialArray(int[] nums) {
        int x = 0;
        int ct = 0;
        int l = nums.length;
        boolean flag = false;
        while (x<=l){
            for (int i = 0; i<l; i++){
                if (nums[i]>=x){
                    ct++;
                }
            }
            if (ct==x){
                flag = true;
                break;
            }
            ct = 0;
            x++;
        }
        if (flag){
            return x;
        }
        else{
            return -1;
        }
    }
}