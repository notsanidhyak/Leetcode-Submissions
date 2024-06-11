// Brute Force (Recursion) -

// class Solution {
//     public int rec(String text1, String text2, int i, int j){
//         if(i==text1.length() || j==text2.length()){
//             return 0;
//         }
//         if(text1.charAt(i)==text2.charAt(j)){
//             return 1+rec(text1, text2, i+1, j+1); // match found
//         }
//         else {
//             return Math.max(rec(text1, text2, i, j+1), rec(text1, text2, i+1, j)); // match not found, now here two cases possible, take what is beneficial for you (a match), hence Math.max()
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return rec(text1, text2, 0, 0);
//     }
// }

// --------------------------------------------------------------------

// Memoization (DP) -

// class Solution {
//     public int dpfunc(int[][] dp, String text1, String text2, int i, int j){
//         if(i==text1.length() || j==text2.length()){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         if(text1.charAt(i)==text2.charAt(j)){
//             dp[i][j] = 1 + dpfunc(dp, text1, text2, i+1, j+1);
//             return dp[i][j];
//         }
//         else{
//             dp[i][j]= Math.max(dpfunc(dp, text1, text2, i, j+1), dpfunc(dp, text1, text2, i+1, j));
//             return dp[i][j];
//         }
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int [][] dp = new int [text1.length()][text2.length()];
//         for (int i = 0; i<text1.length(); i++){
//             for(int j = 0; j<text2.length(); j++){
//                 dp[i][j] = -1;
//             }
//         }
//         return dpfunc(dp, text1, text2, 0, 0);
//     }
// }

// -------------------------------------------------------------------------

// Brute Force (Recursion but i-1, j-1 concept)-

// class Solution {
//     public int rec(String text1, String text2, int i, int j){
//         if(i<0 || j<0){
//             return 0;
//         }
//         if(text1.charAt(i)==text2.charAt(j)){
//             return 1 + rec(text1, text2, i-1, j-1); // match found
//         }
//         else {
//             return Math.max(rec(text1, text2, i, j-1), rec(text1, text2, i-1, j)); // match not found, now here two cases possible, take what is beneficial for you (a match), hence Math.max()
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return rec(text1, text2, text1.length()-1, text2.length()-1);
//     }
// }

// -------------------------------------------------------------------------

// Memoization (DP but with i-1, j-1 approach) -

// class Solution {
//     public int dpfunc(int[][] dp, String text1, String text2, int i, int j){
//         if(i<0 || j<0){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         if(text1.charAt(i)==text2.charAt(j)){
//             dp[i][j] = 1 + dpfunc(dp, text1, text2, i-1, j-1);
//             return dp[i][j];
//         }
//         else{
//             dp[i][j]= Math.max(dpfunc(dp, text1, text2, i, j-1), dpfunc(dp, text1, text2, i-1, j));
//             return dp[i][j];
//         }
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int [][] dp = new int [text1.length()][text2.length()];
//         for (int i = 0; i<text1.length(); i++){
//             for(int j = 0; j<text2.length(); j++){
//                 dp[i][j] = -1;
//             }
//         }
//         return dpfunc(dp, text1, text2, text1.length()-1, text2.length()-1);
//     }
// }

// ------------------------------------------------------------------------

// Tabulation Approach -

class Solution {
    public int dpfunc(int[][] dp, String text1, String text2, int i, int j){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + dpfunc(dp, text1, text2, i+1, j+1);
            return dp[i][j];
        }
        else{
            dp[i][j]= Math.max(dpfunc(dp, text1, text2, i, j+1), dpfunc(dp, text1, text2, i+1, j));
            return dp[i][j];
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for (int i = 0; i<=text1.length(); i++){
            for(int j = 0; j<=text2.length(); j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                // note that pointer in text is moving one ahead hence doing i-1 here. also note that dp's row 0 and col 0 is the base case when nothing's there.
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        // access last row and last coloumn
        return dp[text1.length()][text2.length()];
    }
}