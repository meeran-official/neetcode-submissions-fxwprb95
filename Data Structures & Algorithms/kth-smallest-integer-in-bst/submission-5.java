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
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    private TreeNode dfs(TreeNode root, int k) {
        if(root == null || k == 0) return null;
        dfs(root.left);
        k--;
        if(k == 0) res = root.val;
        dfs(root.right);
    }
}
