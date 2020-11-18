import java.util.*;

/**
 * 三数之和：https://leetcode-cn.com/problems/3sum/
 * 逻辑题
 *  双指针
 *  尽可能缩小范围
 * 错误：三数字和简化成两个数相加，但是很多细节没考虑到
 *  边界范围
 *  0的情况
 *  超过1小时，没解对
 * 改进：
 *  1. Java List，Set 的用法；通过抽象的方式写代码，而非面向底层
 *  2. 内置的数组排序，根据元素创建 List，内置的 List 排序
 */
public class threeNumbers {



    // 错误实现：
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Set<Integer> originSet = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            originSet.add(nums[i]);
        }
        Set result = new HashSet();
        int tmpValue = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                tmpValue = nums[i] + nums[j];
                if (nums[i] == 0 || nums[j] == 0) {
                    if (!originSet.contains(nums[i] * -1) || !originSet.contains(nums[j] * -1)) {
                        continue;
                    };
                }
                if (originSet.contains(tmpValue * -1)) {
                    // 找到三元组
                    List<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[j]);
                    array.add(-1*(nums[i]+nums[j]));
                    Collections.sort(array);
                    result.add(array);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0, 0, 0};
//        int[] nums = {1, 1, -2};
        threeNumbers solution = new threeNumbers();
        System.out.println(solution.threeSum(nums));
    }
}
