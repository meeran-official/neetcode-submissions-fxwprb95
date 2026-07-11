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
        dfs(root, "MAIN");
        return isValid;
    }

    private TreeNode dfs(TreeNode root, String branch) {
        if(root == null || !isValid) {
            return null;
        }
        if((root.left != null && root.val <= root.left.val) || (root.right != null && root.val >= root.right.val)) {
            isValid = false;
            return null;
        }

        TreeNode left = dfs(root.left, "LEFT");
        TreeNode right = dfs(root.right, "RIGHT");
        if(!isValid) {
            return null;
        }
        if(left == null && right == null) {
            return root;
        }
        if((left != null && root.val <= left.val) || (right != null && root.val >= right.val)) {
            isValid = false;
            return null;
        }
        if(left == null) return right;
        if(right == null) return left;
        if(branch.equals("LEFT")) {
            return left.val > right.val ? left : right;
        } else if(branch.equals("RIGHT")) {
            return left.val < right.val ? left : right;
        }
        return null;
    }
}
