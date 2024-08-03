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
class Customarr{
    TreeNode node;
    int idx;
    Customarr(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int width = 0;
        Queue<Customarr> q = new LinkedList<>();
        q.add(new Customarr(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().idx;
            int first = 0;
            int last = 0;
            for(int i = 0; i<size; i++){
                int curridx = q.peek().idx - mmin;
                TreeNode currnode = q.peek().node;
                q.poll();
                if (i==0) first = curridx;
                if (i==size-1) last = curridx;
                if(currnode.left!=null) q.add(new Customarr(currnode.left, curridx*2+1));
                if(currnode.right!=null) q.add(new Customarr(currnode.right, curridx*2+2));
            }
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}