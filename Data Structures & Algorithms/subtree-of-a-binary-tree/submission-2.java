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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSame(root, subRoot)) {
            return true;
        }
        if(root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val) {
            return isSame(root.right, subRoot.right) && isSame(root.left, subRoot.left);
        } else {
            return false;
        }
    }

}
