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
    int k;
    int kthSmallest = -1;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root, 0);
        return kthSmallest;
    }

    private int dfs(TreeNode root, int count) {
        if(root == null) {
            return count;
        }
        count = dfs(root.left, count);
        count++;
        if(count == k) {
            kthSmallest = root.val;
            return count;
        }
        count = dfs(root.right, count);


        return count;
    }
}
