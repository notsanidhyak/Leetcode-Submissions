class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Pair<String,Integer> p = new Pair<String,Integer>(beginWord,1);
        q.add(p);
        HashSet <String> hashset = new HashSet<>(wordList);
        hashset.remove(beginWord);
        while(q.isEmpty()!=true){
            String cword = (String)q.peek().getKey();
            int level = (int)q.peek().getValue();
            q.remove();
            if(cword.equals(endWord)){
                return level;
            }
            for(int i = 0; i<cword.length(); i++){
                char original = cword.charAt(i);
                for(char ch = 'a'; ch<='z'; ch++){
                    char [] cwordArrayCopy = cword.toCharArray();
                    cwordArrayCopy[i]=ch;
                    String cwordCopy = new String(cwordArrayCopy);
                    if(hashset.contains(cwordCopy)){
                        hashset.remove(cwordCopy);
                        Pair<String,Integer> newp = new Pair<String,Integer>(cwordCopy,level+1);
                        q.add(newp);
                    }
                }
            }
        }
        return 0;
    }
}