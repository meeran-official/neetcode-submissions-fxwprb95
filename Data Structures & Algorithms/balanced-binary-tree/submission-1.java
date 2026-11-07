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
    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root, true);
        return res >= 0 ? true : false;
    }
    private int getHeight(TreeNode root, boolean isBalanced) {
        if(!isBalanced) return -1;
        if(root == null) return 0;
        int leftHeight = getHeight(root.left, isBalanced);
        int rightHeight = getHeight(root.right, isBalanced);
        if(leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
            isBalanced = false;
            return -1;
        }
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
}
