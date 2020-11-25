
/**
 * 返回x的平方根，只要整数部分；30分钟，https://leetcode-cn.com/problems/sqrtx/
 * 总结：
 *  对边界条件的处理太弱了，没有画图来理解，导致数字增大溢出
 * 改进：
 *  利用左右边界相差1的特性来解
 * 解法：
 * 1. 直接用函数
 * 2. 用二分法
 * 3. 牛顿迭代法
 */
public class Sqrt_69 {

    public int solve(int x) {
        if (x <= 1) return x;
        double dMid = x / 2;
        long mid;
        while (true) {
            mid = (long)dMid;
            if (mid*mid <= x && (mid+1)*(mid+1) > x) return (int)mid;
            else if (mid*mid > x) dMid = dMid / 2;
            else dMid = (dMid + 2*dMid) / 2;
        }
    }
    public static void main(String[] args) {
        int[] tester = {0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 100, 101, 2147395599};
        for (int value : tester) {
            System.out.println(new Sqrt_69().solve(value));
        }
    }
}
