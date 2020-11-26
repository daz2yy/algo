/**
 * 买卖股票的最佳时机，18分钟，https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * f(i) : 第i的最大收益
 * f(i) = max(f(i-1) + a[i] - max[i-1], a[i] - min(i-1)); a[i] > max[i]
 * f(i) = f(i-1); a[i] <= max[i]
 * min(i)
 * max(i)
 * f(0) = 0; max[0] = a[0]; min[0] = a[0]
 * 
 * 总结：
 * 1. 按照dp思路解题，稍微有一点卡住：如果 a[i] < a[j], a[k] - a[j] < a[k] - a[i]，这点想明白就可以了
 * 2. 贪心的思想，拿最小的来计算
 * 优化：
 * 1. 空间不需要用这么多，只要最大最小，和结果
 * 
 */
public class MaxProfix_121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) { return 0; }
        // init
        int[] max = new int[prices.length];
        int[] min = new int[prices.length];
        int[] state = new int[prices.length];
        state[0] = 0;
        max[0] = prices[0];
        min[0] = prices[0];

        // solve
        for (int i = 1; i < prices.length; ++i) {
            state[i] = Math.max(state[i-1], state[i-1] + prices[i] - max[i-1]);
            state[i] = Math.max(state[i], prices[i] - min[i-1]);
            max[i] = Math.max(max[i-1], prices[i]);
            min[i] = Math.min(min[i-1], prices[i]);
        }

        return state[prices.length-1];
    }

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices = {7,6,4,3,1};
        int[] prices = {1, 7, 2, 3, 4, 6};
        System.out.println(new MaxProfix_121().maxProfit(prices));
    }
}
