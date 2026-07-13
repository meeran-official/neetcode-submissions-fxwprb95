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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root, null);
        return maxSum;
    }

    private int dfs(TreeNode root, TreeNode parent) {
        if(root == null) { 
            return 0;
        }
        int leftSum = dfs(root.left, root);
        int rightSum = dfs(root.right, root);
        leftSum = leftSum > 0 ? leftSum : 0;
        rightSum = rightSum > 0 ? rightSum : 0;

        int sum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, sum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
