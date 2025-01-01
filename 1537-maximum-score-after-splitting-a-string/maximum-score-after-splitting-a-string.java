class Solution {
    public int maxScore(String s) {
        int ct1 = 0;
        int ct0 = 0;
        int max = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='1') ct1++;
        }
        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i)=='0') ct0++;
            else ct1--;
            // ct1 = Math.max(ct1, 0);
            if(ct0+ct1>max) max = ct0+ct1;
        }
        return max;
    }
}