
/**
 * 二叉树翻转
 */
public class InverseTree_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void solve(TreeNode node) {
        if (node.left == null && node.right == null) {
            return ;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if (node.left != null) { solve(node.left); }
        if (node.right != null) { solve(node.right); }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        solve(root);
        return root;
    }
}
