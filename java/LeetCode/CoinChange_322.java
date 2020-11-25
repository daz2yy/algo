import java.util.Arrays;

/**
 * 零钱兑换，https://leetcode-cn.com/problems/coin-change/
 * 第一次 30分钟没做出来
 * 第二次 40分钟 AC
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 总结：
 * 1. dp其实也是逻辑题，只是这个逻辑被总结成了套路
 * 2. 套路：定义好状态集合，找出所有的状态，建立状态转移方程
 * 3. 找状态的技巧：回溯、递归树、填二维表
 * 4. 代码逻辑：初始化，解决问题，结果处理
 * 优化：
 * 1. 自上而下的解法
 * 2. 自下而上的解法
 * 3. 回溯
 */
public class CoinChange_322 {
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // init
        // means: reach amount need dp[amount] 
        int[] dp = new int[10001];
        for (int i = 0; i < 10001; ++i) { dp[i] = Integer.MAX_VALUE; }
        dp[0] = 0;

        // solve
        for (int i = 0; i < coins.length; ++i) {
            for (int k = 0; k <= amount-coins[i]; ++k) {
                if (dp[k+coins[i]] - 1 > dp[k]) {
                    dp[k+coins[i]] = dp[k] + 1;
                }
                // dp[k+value] = Math.min(dp[k+value], dp[k] + j);
            }

            // 错误做法，想多了，还去做了乘法再遍历
            // for (int j = 1; j <= amount / coins[i]; ++j) {
            //     // choice j * coins[i]
            //     int value = coins[i]*j;
            //     // dp[value] = Math.min(dp[value], j);
            //     for (int k = 0; k <= amount-value; ++k) {
            //         if (dp[k+value] - 1 > dp[k]) {
            //             dp[k+value] = dp[k] + 1;
            //         }
            //         // dp[k+value] = Math.min(dp[k+value], dp[k] + j);
            //     }
            // }
        }

        // result handle
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408}; // 6249, 20
        int amount = 6249;
        // int[] coins = {2}; // -1
        // int amount = 3;
        System.out.println(new CoinChange_322().coinChange(coins, amount));
    }
}
