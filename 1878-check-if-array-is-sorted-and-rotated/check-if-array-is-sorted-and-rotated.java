class Solution {
    public boolean check(int[] nums) {
        int i=0;
        while(i<nums.length-1 && nums[i]<=nums[i+1]){
            System.out.println(i);
            i++;
        }
        if(i==nums.length-1) return true;
        System.out.println("hi");
        if(nums[0]>=nums[nums.length-1]){
            i++;
            System.out.println(i);
            while(i<nums.length-1 && nums[i]<=nums[i+1]){
                System.out.println(i);
                i++;
            }
            if(i==nums.length-1) return true;
        }
        return false;
    }
}