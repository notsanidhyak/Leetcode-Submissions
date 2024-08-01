class Solution {
    public int countSeniors(String[] details) {
        int ct = 0;
        for (String i: details){
            int x = (int)i.charAt(11)-48;
            int y = (int)i.charAt(12)-48;
            int age = (x*10)+y;
            if(age>60) ct++;
        }
        return ct;   
    }
}