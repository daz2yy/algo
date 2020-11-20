
/**
 * 二叉树路径和 https://leetcode-cn.com/problems/path-sum/, 7分钟
 * 总结：
 * 1. 树节点的 value 有可能为负值
 */
public class TreeSums_112 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        if (root.val == sum && root.left == null && root.right == null) { return true; }
        boolean ans = false;
        if (root.left != null) {
            root.left.val += root.val;
            ans = hasPathSum(root.left, sum);
        }
        if (!ans && root.right != null) {
            root.right.val += root.val;
            ans = ans || hasPathSum(root.right, sum);
        }
        return ans;
    }
}
