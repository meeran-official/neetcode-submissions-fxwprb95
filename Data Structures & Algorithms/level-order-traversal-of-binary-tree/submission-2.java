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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        rec(root, 0);
        return res;
    }
    
    private TreeNode rec(TreeNode root, int depth) {
        if(root == null) {
            return null;
        }
        if(res.size() == depth) {
            List<Integer> level = new ArrayList<>();
            res.add(level); // if in single line?
        }
        res.get(depth).add(root.val);
        rec(root.left, depth + 1);
        rec(root.right, depth + 1);
        return root; // if null?
    }
}
