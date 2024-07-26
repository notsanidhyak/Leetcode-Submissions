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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false; // if both are null then above must have already returned true, if it is coming here, it means one of them is not null, hence return false.
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // this node equal, left equal, right equal
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // these two lines for edge cases! Think.
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false; // if both are null then above must have already returned true, if it is coming here, it means one of them is not null, hence return false.
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}