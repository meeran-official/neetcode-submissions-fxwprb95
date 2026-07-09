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
    boolean isValid = true;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode minRight = minFromRight(root.right);
        TreeNode maxLeft = maxFromLeft(root.left);
        if(minRight != null && minRight.val <= root.val) {
            return false;
        }
        if(maxLeft != null && maxLeft.val >= root.val) {
            return false;
        }
        return true;
    }

    private TreeNode minFromRight(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = minFromRight(root.left);
        TreeNode right = minFromRight(root.right);
        if(left == null && right == null) {
            return root;
        }
        if(left != null && right != null) {
            return left.val < right.val? left : right;
        }
        if(left != null) {
            return left;
        }
        return right;
    }

    private TreeNode maxFromLeft(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = maxFromLeft(root.left);
        TreeNode right = maxFromLeft(root.right);
        if(left == null && right == null) {
            return root;
        }
        if(left != null && right != null) {
            return left.val > right.val ? left : right;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
}
