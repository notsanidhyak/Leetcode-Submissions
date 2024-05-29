class Solution {
    public int numSteps(String s) {
        int idx = s.length()-1;
        int carry = 0;
        int ct = 0;
        while (idx>0){
            int thisNum = Character.getNumericValue(s.charAt(idx));
            // 0 + 0 -> carry = 0 and just divide by 2
            if (thisNum + carry == 0){
                carry = 0;
                ct++;
            }
            // 1 + 1 -> carry = 1 and just divide by 2
            else if (thisNum + carry == 2){
                carry = 1;
                ct++;
            }
            // 1 + 0 or 0 + 1 -> we will add 1 and then divide by 2 hence carry will be 1 due to the 1 which we are adding
            else{
                carry = 1;
                ct+=2; // coz add 1 and divide by 2
            }
            idx--;
        }

        // if carry 1 at last then 1+1 = 10 -> divide by 2 needed to obtain final 1 hence ct++
        if (carry==1){
            ct++;
        }
        return ct;
    }
}