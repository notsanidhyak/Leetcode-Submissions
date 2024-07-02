class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]) j++;
            else if(nums1[i]<nums2[j]) i++;
            else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int [] resultarr = new int [result.size()];
        int k = 0;
        for(int ele : result){
            resultarr[k++] = ele;
        }
        return resultarr;
    }
}