class Solution {
    public boolean check(int[] nums) {
        int i=0;
        while(i<nums.length-1 && nums[i]<=nums[i+1]){
            System.out.println(i);
            i++;
        }
        System.out.println("ji");
        if(nums[0]>=nums[nums.length-1]){
            i++;
            while(i<nums.length-1 && nums[i]<=nums[i+1]){
                System.out.println(i);
                i++;
            }
            System.out.println(i);

        }
        if(i>=nums.length-1) return true;
        return false;
    }
}