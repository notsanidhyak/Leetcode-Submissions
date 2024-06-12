class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        String [] numAsS = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            numAsS[i] = String.valueOf(nums[i]);
        }

        // main thing is here, you have to build a comparator which would compare s1 and s2 and return you the bigger (in terms of string);
        Comparator <String> mycomp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(numAsS, mycomp);

        if (numAsS[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : numAsS){
            sb.append(s);
        }

        return sb.toString();
    }
}