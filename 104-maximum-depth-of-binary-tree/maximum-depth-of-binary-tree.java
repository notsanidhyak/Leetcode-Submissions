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
class Solution {
    public int rec(TreeNode root, int height){
        if(root == null) return height;
        height++;
        int leftmax = rec(root.left, height);
        int rightmax = rec(root.right, height);
        return Math.max(leftmax, rightmax);
    }
    public int maxDepth(TreeNode root) {
        return rec(root, 0);        
    }
}