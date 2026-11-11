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
    int runSum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        runSum += root.val;
        if(hasPathSum(root.left, targetSum)) return true;
        if(hasPathSum(root.right, targetSum)) return true;
        if(root.left == null && root.right == null) {
            if(runSum == targetSum) return true;
        }
        runSum -= root.val;
        return false;
    }
}