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
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    private TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if(isValid && left != null && root.val <= left.val) {
            isValid = false;
        }
        if(isValid && right != null && root.val >= right.val) {
            isValid = false;
        }
        return root;
    }
}
