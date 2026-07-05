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
    boolean isSubRootFound = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        root = findSubRootInRoot(root, subRoot);
        if(root == null) {
            return false;
        }
        return rec(root, subRoot);
    }

    private boolean rec(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val) {
            return rec(root.right, subRoot.right) && rec(root.left, subRoot.left);
        } else {
            return false;
        }
    }
    
    private TreeNode findSubRootInRoot(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) {
                continue;
            }
            if(node.val == subRoot.val) {
                return node;
            }
            stack.push(node.left);
            stack.push(node.right);
        }
        return null;
    }
}
