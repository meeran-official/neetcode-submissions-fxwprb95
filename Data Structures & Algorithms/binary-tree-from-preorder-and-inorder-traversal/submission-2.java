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
    int pIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, inorder.length - 1, preorder, inorder);
    }
    private TreeNode build(int left, int right, int[] preorder, int[] inorder) {
        if(left > right) return null;
        int val = preorder[pIdx++];
        int mid = left;
        while(inorder[mid] != val) { // use binary search
            mid++;
        }
        TreeNode node = new TreeNode(val);
        node.left = build(left, mid - 1, preorder, inorder);
        node.right = build(mid + 1, right, preorder, inorder);
        return node;
    }
}
