
import java.util.List;
/**
 * 三角形最小路径和，22分钟, https://leetcode-cn.com/problems/triangle/
 * 思考：
 * 1. 自上向下传递，无需记录路径，图的算法，更新到达每个点消耗的值
 * 2. 完全二叉树的图结构，除了最左边和最右边，中间的节点有两个入度，判断大小即可
 * 优化：
 * 1. 自顶向下的解法
 * 2. 自底向上的解法
 * 3. 额外空间辅助
 */
public class Triangle_120 {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        // init
        int result = Integer.MAX_VALUE;
        int row = triangle.size();

        // solve
        List<Integer> curRow;
        List<Integer> preRow;
        for (int i = 1; i < row; ++i) {
            preRow = triangle.get(i-1);
            curRow = triangle.get(i);
            // first value
            curRow.set(0, curRow.get(0) + preRow.get(0));
            for (int j = 1; j < curRow.size()-1; ++j) {
                curRow.set(j, curRow.get(j) + Math.min(preRow.get(j), preRow.get(j-1)));
            }
            // last value
            curRow.set(curRow.size()-1, curRow.get(curRow.size()-1) + preRow.get(curRow.size()-2));
        }

        // result
        List<Integer> lastRow = triangle.get(row-1);
        for (int i = 0; i < lastRow.size(); ++i) {
            result = Math.min(result, lastRow.get(i));
        }

        return result;
    }
}
