class cmp implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        int bitCountA = countSetBits(a);
        int bitCountB = countSetBits(b);
        if (bitCountA == bitCountB) return a-b; // If bit counts are the same, compare numerically.
        return bitCountA - bitCountB; // Sort by the bit count in ascending order.
    }
    
    static int countSetBits(int n){
        if(n==0) return 0;
        int ct = 0;
        while(n>0){
            ct+=n&1;
            n>>=1;
        }
        return ct;
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new cmp());
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}