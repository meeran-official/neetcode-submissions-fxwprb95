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

public class Codec {

    private List<Integer> getPreorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        System.out.println("preorder result: " + list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
        return;
    }

    private List<Integer> getInorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<Integer> preorder = getPreorder(root);
        List<Integer> inorder = getInorder(root);
        return encode(inorder) + "|" + encode(preorder);
    }

    private String encode(List<Integer> list) {
        return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining("#"));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data: " + data);
        if(data.isBlank()) return null;
        String[] both = data.split("\\|");
        System.out.println("both[0]: " + both[0] + ", both[1]: " + both[1]);
        List<Integer> inorder = decode(both[0]);
        List<Integer> preorder = decode(both[1]);

        return build(inorder, preorder);
    }

    private List<Integer> decode(String str) {
        return Arrays.stream(str.split("#"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    Map<Integer, Integer> indices;

    private TreeNode build(List<Integer> inorder, List<Integer> preorder) {
        System.out.println("preorder: " + preorder + ", inorder: " + inorder);
        indices = IntStream.range(0, inorder.size())
            .boxed()
            .collect(Collectors.toMap(
                inorder::get,
                v -> v
            ));
        return build(preorder, 0, inorder.size() - 1);
    }

    int preIdx = 0;

    private TreeNode build(List<Integer> preorder, int left, int right) {
        if(left > right) return null;
        int val = preorder.get(preIdx++);
        int mid = indices.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, left, mid - 1);
        node.right = build(preorder, mid + 1, right);
        return node;
    }
}










































