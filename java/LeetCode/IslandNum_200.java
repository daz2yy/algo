import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图搜索算法，1个多小时 https://leetcode-cn.com/problems/number-of-islands/
 * 总结：
 * 1. 基础数据使用太弱的，数组列表的列表，List 与 Queue 的关系
 * 2. 数组的初始化操作
 */
public class IslandNum_200 {

    public int solve2(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j) {
                if (DFS(grid, i, j)) {
                    ans++;
                }
            }
        return ans;
    }
    public boolean DFS(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '2';
            DFS(grid, i+1, j);
            DFS(grid, i-1, j);
            DFS(grid, i, j+1);
            DFS(grid, i, j-1);
            return true;
        }
        return false;
    }

    private List<List<Integer>> dirList = Arrays.asList(
        Arrays.asList(1, 0),
        Arrays.asList(0, -1),
        Arrays.asList(0, 1),
        Arrays.asList(-1, 0)
    );

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int num = 0;
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1' && visit[i][j] == false) {
                   ++num;
                   queue.add(Arrays.asList(i, j));
                   while (!queue.isEmpty()) {
                        List<Integer> curList = queue.poll();
                        for (List<Integer> dir : dirList) {
                            int index_i = curList.get(0) + dir.get(0);
                            int index_j = curList.get(1) + dir.get(1);
                            if (index_i >= 0 && index_i < grid.length && index_j >=0 && index_j < grid[i].length) {
                                if (grid[index_i][index_j] == '1' && visit[index_i][index_j] == false) { 
                                    queue.add(Arrays.asList(index_i, index_j)); 
                                    visit[index_i][index_j] = true;
                                }
                            }
                        }
                   }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}
        };
        System.out.println(new IslandNum_200().solve2(grid));
    }
}
