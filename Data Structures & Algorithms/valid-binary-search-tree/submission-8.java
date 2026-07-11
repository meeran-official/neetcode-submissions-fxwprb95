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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValid(root.left, root.val, "LEFT") 
            || !isValid(root.right, root.val, "RIGHT")) {
                return false;
            }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValid(TreeNode root, int limit, String branch) {
        if(root == null) return true;
        if(branch.equals("LEFT") && !(root.val < limit)) {
            return false;
        } else if(branch.equals("RIGHT") && !(root.val > limit)) {
            return false;
        }
        return isValid(root.left, limit, branch) && isValid(root.right, limit, branch);
    }
}
