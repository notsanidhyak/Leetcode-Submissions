class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left<right){
            int l = Math.min(height[left], height[right]);
            int b = right - left;
            maxArea = Math.max(maxArea, l*b);
            if (height[right]>height[left]) left++;
            else right--;
        }
        return maxArea;
    }
}