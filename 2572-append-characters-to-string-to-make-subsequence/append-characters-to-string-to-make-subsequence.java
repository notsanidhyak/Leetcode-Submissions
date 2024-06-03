// class Solution {
//     public int appendCharacters(String s, String t) {
//         int i = 0; // pointer for s
//         int j = 0; // pointer for t
//         while(i<s.length() && j<t.length()){
//             if(s.charAt(i)==t.charAt(j)){
//                 i++;
//                 j++;
//             }
//             else{
//                 i++;
//             }
//         }
//         return t.length()-j;
//     }
// }

class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                j++;
            }
            i++; // because pointer for s is always increased by one, doesn't matter the condition is satisfied or not. See detailed code above!
        }
        return t.length()-j;  
    }
}