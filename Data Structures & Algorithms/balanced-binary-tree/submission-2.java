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
        boolean[] isBalanced = new boolean[]{true};
        getHeight(root, isBalanced);
        return isBalanced[0];
    }
    private int getHeight(TreeNode root, boolean[] isBalanced) {
        if(root == null || !isBalanced[0]) return 0;
        int left = getHeight(root.left, isBalanced);
        int right = getHeight(root.right, isBalanced);
        if(Math.abs(left - right) > 1) {
            isBalanced[0] = false;
        }
        return 1 + Math.max(left, right);
    }
}
