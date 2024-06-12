class Solution {
    public void sortColors(int[] nums) {
        // Dutch national flag algo
        int s = 0; // start -> stores first element of 1 which comes after 0 after sorting (goes from left to right)
        int m = 0; // mid -> stores first element of 2 which comes after 1 after sorting (goes from left to right)
        int h = nums.length-1; // high -> stores first element of 1 which comes after 2 while traversing back (goes from right to left)

        // Loop breaking case -> when mid and high pointers cross each other
        while(m<=h){
            switch(nums[m]){
                case 0:{
                    // swap mid and start and do s++ and m++
                    int temp = nums[m];
                    nums[m] = nums[s];
                    nums[s] = temp;
                    s++;
                    m++;
                    break; // break is imp so that while is checked everytime after each change! otherwise it will go on and do one more change after the array is perfectly sorted. THINK.
                }
                case 1:{
                    // do nothing, mid came cross its member only, simply m++
                    m++;
                    break;
                }
                case 2:{
                    // swap mid and high, also do and h--, here no m++ bcs jo swap kiya hai wo galat ho sakta toh wapis check hoga wo next iter me;
                    int temp = nums[m];
                    nums[m] = nums[h];
                    nums[h] = temp;
                    h--;
                    break;
                }
            }
        }
        // once m and h cross each other, h comes left to m means everything is done and hence the loop will break!
    }
}