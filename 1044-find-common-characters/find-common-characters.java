class Solution {
    public List<String> commonChars(String[] words) {
        List<String> hash = new ArrayList<>();
        for(char al = 'a'; al<='z'; al++){
            int finalct = Integer.MAX_VALUE;
            for(int wordsidx = 0; wordsidx<words.length; wordsidx++){
                int ct = 0;
                for(int charidx = 0; charidx<words[wordsidx].length(); charidx++){
                    if(al==words[wordsidx].charAt(charidx)){
                        ct++;
                    }

                }
                if(ct!=finalct){
                    finalct = Math.min(ct, finalct);
                }
            }
            for(int k = 0; k<finalct; k++){
                hash.add(String.valueOf(al));
            }
        }
        return hash;
    }
}