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
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        arr[0] = k;
        dfs(root, arr);
        return arr[1];
    }

    private void dfs(TreeNode root, int[] arr) {
        if(root == null) {
            return;
        }
        dfs(root.left, arr);
        if(arr[0] == 0) {
            return;
        }
        arr[0]--;
        if(arr[0] == 0) {
            arr[1] = root.val;
        }
        dfs(root.right, arr);
    }
}
