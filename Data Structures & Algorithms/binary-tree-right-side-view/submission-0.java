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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue q = new LinkedList<>();
        q.add(root);
        res.add(root.val);
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) res.add(node.right.val);
                else if(node.left != null) res.add(node.left.val);
            }
        }
        return res;''
    }
}
