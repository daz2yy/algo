/**
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，
 * 背包中可装入物品的总价值最大是多少呢？
 * 物品列表：weight[n]
 * 物品数量：n
 * 重量显示：targetWeight
 */
public class bag01_upgrate {
    private int[] weight = {2, 2, 4, 6, 3};
    private int[] value = {1, 3, 2, 5, 4};
    private int n;
    private int targetWeight;
    private int maxWeight = Integer.MIN_VALUE;
    private int maxValue = Integer.MIN_VALUE;

    // 回溯解决
    public void func(int i, int cw, int cv) {
        if (cw == targetWeight || i == n) {
            if (cw > maxWeight) {
                maxWeight = cw;
            }
            if (cv > maxValue) {
                maxValue = cv;
            }
            return;
        }
        // 不选择产品i
        func(i+1, cw, cv);
        // 选择产品i
        if (cw + weight[i] <= targetWeight) {
            func(i+1, cw + weight[i], cv + value[i]);
        }
    }

    // 去除重复子问题，DP
    public int solve() {
        // 1. 初始化
        int[][] state = new int[n][targetWeight+1];
        state[0][0] = 0;
        if (weight[0] <= targetWeight) {
            state[0][weight[0]] = value[0];
        }
        // 2. 状态转换公式
        for (int i = 1; i < n; ++i) {
            // 不选择物品i
            for (int j = targetWeight; j >= 0; --j) {
                state[i][j] = state[i-1][j];
            }
            // 选择物品i
            for (int j = targetWeight - weight[i]; j >= 0; --j) {
                if (state[i-1][j] > 0) {
                    int v = state[i-1][j] + value[i];
                    if (v > state[i][j+weight[i]]) {    // 在重量 j 的地方不选择物品 与 选择物品的大小比较
                        state[i][j+weight[i]] = v;
                    }
                }
//                if (state[i][j] > 0) {        // 这里写错了，没考虑到价值更新，和01背包的区别
//                    state[i][j] = state[i-1][j] + value[i];
//                }
//                if (state[i-1][j] > 0) { // 这样应该也行，因为重量和价值都是大于0的
//                    state[i][j+weight[i]] = state[i-1][j+weight[i]] + value[i];
//                }
            }
        }
        // 3. 获取结果
        int maxValue = -1;
        for (int i = targetWeight; i >= 0; --i) {
//            if (state[n-1][i] != 0) {       // 这里也错了，不是有值就是最大的价值
//                return state[n-1][i];
//            }
            if (state[n-1][i] > maxValue) {
                maxValue = state[n-1][i];
            }
        }
        return maxValue;
    }

    // 一维数组DP
    public int solve2() {
        // 1. 初始化
        int[] state = new int[targetWeight+1];
        state[0] = 0;
        if (weight[0] <= targetWeight) {
            state[weight[0]] = value[0];
        }
        // 2. 状态转移公式
        for (int i = 1; i < n; ++i) {
            for (int j = targetWeight-weight[i]; j >=0; --j) {
                if (state[j] > 0) {
                    state[j+weight[i]] = state[j+weight[i]] + value[i];
                }
            }
        }
        // 3. 获取结果
        int maxValue = -1;
        for (int i = targetWeight; i >= 0; --i) {
            if (state[i] > maxValue) {
                maxValue = state[i];
            }
        }
        return maxValue;
    }
}
