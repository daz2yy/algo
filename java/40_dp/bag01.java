/**
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 * 物品重量：weight[n]
 * 物品个数：n
 * 最大重量：targetWeight
 *
 * 问题：重量如果太中了，会造成数组很大
 */

public class bag01 {
    private int maxWeigh = Integer.MIN_VALUE;
    private int n = 5;
    private int targetWeight = 9;
    private int[] weight = {2, 2, 4, 6, 3};
    //init

    // 回溯法
    public void func(int i, int cw) {
        if (cw == targetWeight || i == n) {
            if (cw > maxWeigh) {
                maxWeigh = cw;
            }
            return;
        }
        // 不选择第 i 个物品
        func(i+1, cw);
        // 选择第 i 个物品
        if (cw + weight[i+1] <= cw) {
            func(i+1, cw + weight[i+1]);
        }
    }

    // 01 背包
    public int solve() {
        int[][] states = new int[n][targetWeight+1];
        // 1. 初始化
        states[0][0] = 0;
        if (weight[0] <= targetWeight) {
            states[0][weight[0]] = 1;
        }
        // 2. dp
        for (int i = 1; i < n; ++i) {
            // 不选 product[i];
            for (int j = targetWeight-1; j >= 1; --j) {
                states[i][j] = states[i-1][j];
            }
            // 选 product[i];
            for (int j = targetWeight-weight[i]-1; j >= 1; --j) {
                if (states[i-1][j] == 1) {
                    states[i][j+weight[i]] = 1;
                }
            }
        }
        for (int i = targetWeight; i >= 0; --i) {
            if (states[n-1][i] != 0) {
                return i;
            }
        }
        return 0;
    }

    // 一维数组解法
    public int solve2() {
        int[] states = new int[targetWeight+1];
        // 1. 初始化
        states[0] = 0;
        if (weight[0] <= targetWeight) {
            states[weight[0]] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = targetWeight-weight[i]; j >= 1; --j) {
                if (states[j] == 1) {
                    states[j+weight[i]] = 1;
                }
            }
        }
        for (int i = targetWeight; i >= 0; --i) {
            if (states[i] == 1) {
                return i;
            }
        }
        return 0;
    }
}
