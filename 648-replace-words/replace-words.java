class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        Set<String> prefixSet = new HashSet<>(dictionary);
        
        String[] words = sentence.split(" ");
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                if (prefixSet.contains(prefix)) {
                    words[i] = prefix;
                    break;
                }
            }
        }
        
        return String.join(" ", words);
    }
}
