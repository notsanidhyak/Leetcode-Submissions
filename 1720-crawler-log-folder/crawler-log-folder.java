class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String i : logs){
            if (i.charAt(0)!='.') level++;
            else{
                if (i.charAt(1)=='.'){
                    if (level>0) level--;
                }
            }
        }
        return level;
    }
}