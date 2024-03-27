class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ct = 0;
        for(int i=0; i<nums.length; i++){
            int product = nums[i];
            if(product<k){
                ct+=1;
                for(int j=i+1; j<nums.length; j++){
                    product *= nums[j];
                    if(product<k){
                        ct+=1;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return ct;
    }
}