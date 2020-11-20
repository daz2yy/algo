
/**
 * 查询树的最大深度
 * 改进：depth 的传递要注意，不要累加了
 */
public class MaxDepth_104 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int solve(TreeNode node, int depth) {
        if (node == null) return depth-1;
        int tmp = depth;
        depth = Math.max(depth, solve(node.left, tmp+1));
        depth = Math.max(depth, solve(node.right, tmp+1));
        return depth;
    }

    public int maxDepth(TreeNode root) {
        return solve(root, 1);
    }
}
