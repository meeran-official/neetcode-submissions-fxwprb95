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
        int sum = dfs(root, 0);
        return Math.max(maxSum, sum);
    }
    
    private int dfs(TreeNode root, int sum) {
        if(root == null) return 0;

        sum += dfs(root.left, 0);
        sum += dfs(root.right, 0);
        
        sum += root.val;

        maxSum = Math.max(maxSum, sum);

        return sum > 0 ? sum : 0;
    }
}
