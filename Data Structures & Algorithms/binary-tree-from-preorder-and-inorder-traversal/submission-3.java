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
    private int bSearch(int left, int right, int[] inorder, int val) {
        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        if(inorder[mid] < val) {
            return bSearch(left, mid - 1, inorder, val);
        } else if(inorder[mid] > val) {
            return bSearch(mid + 1, right, inorder, val);
        } else {
            return mid;
        }
    }
    private TreeNode build(int left, int right, int[] preorder, int[] inorder) {
        if(left > right) return null;
        int val = preorder[pIdx++];
        int mid = bSearch(left, right, inorder, val);
        TreeNode node = new TreeNode(val);
        node.left = build(left, mid - 1, preorder, inorder);
        node.right = build(mid + 1, right, preorder, inorder);
        return node;
    }
}
