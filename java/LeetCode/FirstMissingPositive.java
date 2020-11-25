import java.util.Arrays;

/**
 * 位图
 * 总结：需要深入理解哈希结构代表的意义
 *  数组即为哈希
 *  大于数组长度的数据是无效数据
 */
public class FirstMissingPositive {
    class BitMap {
        char[] byteArray = new char[1_000_0000];
        final int SIZE = Character.SIZE;
        int max;
        public void set(int value) {
            byteArray[value / SIZE] |= 1 << (value % SIZE);
        }
        public int get(int value) {
            return byteArray[value / SIZE] & (1 << value % SIZE);
        }
    }
    public int solve(int[] nums) {
        BitMap check = new BitMap();
        int maxValue = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0) { continue; }
            if (nums[i] > nums.length) { continue; }
            check.set(nums[i]);
            if (nums[i] > maxValue) { maxValue = nums[i]; }
        }
        for (int i = 1; i <= maxValue; ++i) {
            if (check.get(i) == 0) {
                return i;
            }
        }
        return maxValue+1;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, -1, 1},
                {1, 2, 0},
                {7, 8, 9, 11, 12},
                {-1, -2, -3, -4}
        };
        FirstMissingPositive object = new FirstMissingPositive();
        for (int[] testNums : nums) {
            System.out.println("\nInput: " + Arrays.toString(testNums));
            System.out.println("Output:" + object.solve(testNums));
        }
    }
}
