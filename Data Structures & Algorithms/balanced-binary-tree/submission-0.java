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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }
    private int getHeight(TreeNode root) {
        if(root == null || !isBalanced) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
            isBalanced = false;
        }
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
}
