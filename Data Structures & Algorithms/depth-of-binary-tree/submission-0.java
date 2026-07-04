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
    int maxCount = 0;

    public int maxDepth(TreeNode root) {
        depth(root, 0);
        return maxCount;
    }

    private int depth(TreeNode root, int count) {
        if(root == null) {
            if(count > maxCount) {
                maxCount = count;
            }
            return 0;
        }

        depth(root.left, count + 1);
        depth(root.right, count + 1);

        return 0;
    }
}
