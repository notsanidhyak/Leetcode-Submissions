// Approach 1 - brute force, 2 for loops, 2 pointers, find pairs -> if found ok else got our single num.

// Approach 2 - use hashmap, tell freq 1

// Approach 3 - use xor. 

// Similar prob = where only 1 num is unique, for that also do xor of all, xor ans is your ans because pairs would cut out to 0. Use this logic here -

class Solution {
    public int[] singleNumber(int[] nums) {
        int xorofall = 0;
        for(int i : nums){
            xorofall^=i;
        }

        // And operation bw x and -x gives the position where rightmost bit is 1
        // We wish to find this because using this we can differentiate bw the numbers.
        int rightmostbit1 = xorofall & (-xorofall);

        int [] ans = new int[2];

        // if and opeartion bw i and rightmostbit1 == 0 it means at the position of rightmostbit1, 1 is not present in i, hence belongs to class 0
        // else 1 is present in i at rightmostbit1 position and hence belongs to class 1
        // xor of class 0 will give 0^num1 bcs all other are in pairs and exhibit same binary rep and hence their xor will be 0, so only left with out num1.
        // same logic for class 1

        for(int i : nums){
            if((i & rightmostbit1) == 0){
                ans[0]^=i;
            }
            else{
                ans[1]^=i;
            }
        }
        return ans;
    }
}