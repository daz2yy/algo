
/**
 * 乘积最大子数组，8：21，https://leetcode-cn.com/problems/maximum-product-subarray/
 * 第一次没做出来
 * 思考：
 *      f(i) = f(i-1), a[i] == 0, cur = 1
 *      f(i) = max(a[i] * cur, f(i-1))
 * 第二次：
 *      1. f(i), 以元素 i 结尾的最大乘积子序列
 *      2. 因为是以 i 结尾的连续子序列，所以不用考虑前面的子序列
 *      3. 因为有负数，所以有可能最小值 * a[i] 之后最大值
 *      4. 遇到 0 的时候就相当于是清零了。
 *      f(i) = max(lastValueMax * a[i], lastValueMin * a[i], a[i])
 * [2, 3, -2, 4, -1]
 * [2, 3, -2, 4, -1, 5, 7, -2]
 * [2, 3, -2, 4, 11, 3, 0, -2, 5, 7, -5, 3, 6, -2]
 * 总结：
 * 1. 非常重要的一点：状态定义，一旦定义错了，逻辑就会很复杂
 * 2. 数据之间的逻辑关系理清楚，这个严格起来有可能需要数学上的证明。
 */
public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        // init
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        // solve
        for (int i = 1; i < nums.length; ++i) {
            int valueMax = max*nums[i];
            int valueMin = min*nums[i];
            max = Math.max(nums[i], Math.max(valueMin, valueMax));
            min = Math.min(nums[i], Math.min(valueMax, valueMin));
            result = Math.max(max, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] testCase = {
            {2,3,-2,4},     // 6
            {-2,0,-1},      // 0
            {2, 3, -2, 4, -1, 5, 7, -2}, //
            {2, 3, -2, 4, 11, 3, 0, -2, 5, 7, -5, 3, 6, -2}, //
            {-9},
        };
        
        for (int[] nums : testCase) {
            System.out.println(new MaxProduct_152().maxProduct(nums));
        }
    }
}