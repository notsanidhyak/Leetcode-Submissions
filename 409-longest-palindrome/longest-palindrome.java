public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int length = 0;

        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
                length += 2;
            } else {
                charSet.add(c);
            }
        }
        
        // If there are any characters left in the set, add 1 to the length for the middle character
        if (!charSet.isEmpty()) {
            length += 1;
        }
        return length;
    }
}