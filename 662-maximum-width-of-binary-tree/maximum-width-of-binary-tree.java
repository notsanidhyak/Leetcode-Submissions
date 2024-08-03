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

// Custom class to store(TreeNode, idx)
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
            int thisLevelMinidx = q.peek().idx; // leftmost guy's idx which would be subtracted from all right ones later on

            int first = 0;
            int last = 0;
            for(int i = 0; i<size; i++){
                int curridx = q.peek().idx - thisLevelMinidx; // Sets idx starting from 0 always (dad is always idx 0)
                // Resetting the index to zero is imp because int overflow may occur in skewed trees hence better reset to 0
                TreeNode currnode = q.peek().node;
                q.poll();
                if (i==0) first = curridx; // leftmost possible
                if (i==size-1) last = curridx; // rightmost possible

                // Adding next level guys
                if(currnode.left!=null) q.add(new Customarr(currnode.left, curridx*2+1));
                if(currnode.right!=null) q.add(new Customarr(currnode.right, curridx*2+2));
            }

            // Once, a level is done, evaluate for new Max Width obtained
            width = Math.max(width, last-first+1);
        }

        // Return overall max width
        return width;
    }
}