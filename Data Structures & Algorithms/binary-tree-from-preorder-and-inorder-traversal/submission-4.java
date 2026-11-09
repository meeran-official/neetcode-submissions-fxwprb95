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
        Map<Integer, Integer> indices = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, preorder, indices);
    }
    private TreeNode build(int left, int right, int[] preorder, Map<Integer, Integer> indices) {
        if(left > right) return null;
        int val = preorder[pIdx++];
        int mid = indices.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(left, mid - 1, preorder, indices);
        node.right = build(mid + 1, right, preorder, indices);
        return node;
    }

}
