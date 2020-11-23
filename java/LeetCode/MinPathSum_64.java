import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最下路径和，40分钟，https://leetcode-cn.com/problems/minimum-path-sum/
 * 1. Queue 队列操作，new 元素要对应
 * 2. 优先队列减少排序消耗
 * 3. 入队列的时候要记录路径值传递
 * 特殊要求：
 *      每次只能向下或向右移动一步：直接遍历就解决了，7分钟
 */
public class MinPathSum_64 {

    // 解法2
    public int solve(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < row; ++i) {
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < column; ++j) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < column; ++j) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][column-1];
    }

    boolean validPos(int x, int y, int row, int column) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }
    
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        Queue<List<Integer>> queue = new PriorityQueue<List<Integer>>((a, b) -> {
            return a.get(2) < b.get(2) ? -1 : 1;
        });
        queue.add(Arrays.asList(0, 0, grid[0][0]));
        boolean[][] visit = new boolean[row][column];
        visit[0][0] = true;
        while(true) {
            List<Integer> list = queue.poll();
            int i = list.get(0);
            int j = list.get(1);
            int value = list.get(2);
            // find the answer
            if (i == row-1 && j == column-1) { return value; }
            if (validPos(i+1, j, row, column) && !visit[i+1][j] ) {
                visit[i+1][j] = true;
                queue.add(Arrays.asList(i+1, j, value+grid[i+1][j]));
            }
            if (validPos(i, j+1, row, column) && !visit[i][j+1] ) {
                visit[i][j+1] = true;
                queue.add(Arrays.asList(i, j+1, value+grid[i][j+1]));
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},{3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},{6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},{4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},{7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},{8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},{8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},{5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},{0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},{4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},{5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},{0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},{1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},{1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},{8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},{9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},{3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},{1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},{3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}};
        System.out.println(new MinPathSum_64().minPathSum(grid));
        System.out.println(new MinPathSum_64().solve(grid));
    }
}
