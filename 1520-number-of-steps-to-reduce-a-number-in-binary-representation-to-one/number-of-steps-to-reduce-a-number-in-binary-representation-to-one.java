class Solution {
    public int numSteps(String s) {
        int idx = s.length()-1;
        int carry = 0;
        int ct = 0;
        while (idx>0){
            int thisNum = Character.getNumericValue(s.charAt(idx));
            if (thisNum + carry == 0){
                carry = 0;
                ct++;
            }
            else if (thisNum + carry == 2){
                carry = 1;
                ct++;
            }
            else{
                carry = 1;
                ct+=2;
            }
            idx--;
        }

        if (carry==1){
            ct++;
        }
        return ct;
    }
}