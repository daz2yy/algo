import java.util.ArrayList;
import java.util.List;

/**
 * 判断一棵树是否是二叉搜索树，15分钟
 * 1. 中序遍历
 * 2. 上下限遍历判断
 */
public class IsValidBST_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<Integer> list = new ArrayList<>();
    public void midTravel(TreeNode node) {
        if (node == null) return;
        midTravel(node.left);
        list.add(node.val);
        midTravel(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        midTravel(root);
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) <= list.get(i-1)) { return false; }
        }
        return true;
    }
}
