/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// ----------------------------------

// Based on the fact that inOrder traversal of BST is always increasing

// class Solution {
//     public void inOrder(TreeNode root, List<Integer> ans){
//         if (root==null){
//             return;
//         }
//         inOrder(root.left, ans);
//         ans.add(root.val);
//         inOrder(root.right, ans);
//     }   

//     public boolean isValidBST(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         inOrder(root, ans);
//         for (int i = 0; i<ans.size()-1; i++){
//             if(ans.get(i)>=ans.get(i+1)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// ------------------------------------

// Recursive approach

class Solution {
    public boolean check(TreeNode root, long low, long high){
        if (root==null){
            return true;
        }
        // Imp to understand
        System.out.println(low);
        System.out.println(root.val);
        System.out.println(high);
        System.out.println();
        if (root.val <= low || root.val >= high){

            return false;
        }
        return check(root.left, low, root.val) && check(root.right, root.val, high);

    }
    public boolean isValidBST(TreeNode root) {
        // Long is used for edge case, or else Integer also works!
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}