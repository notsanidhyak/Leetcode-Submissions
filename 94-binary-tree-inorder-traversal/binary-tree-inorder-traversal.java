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
    public void doTraversal(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        doTraversal(root.left, ans);
        ans.add(root.val);
        doTraversal(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doTraversal(root, ans);
        return ans;
    }
}