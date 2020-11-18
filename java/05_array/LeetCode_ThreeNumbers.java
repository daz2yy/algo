import java.util.*;

/**
 * Accept，用时：30分钟，https://leetcode-cn.com/problems/3sum/
 * 问题：
 *  边界处理不够仔细
 */
public class LeetCode_ThreeNumbers {
    public List<List<Integer>> solve(int[] nums) {
        Arrays.sort(nums);

        Set result = new HashSet();
        int length = nums.length;
        for (int i = 0; i < length-2; ++i) {
//            if (nums[i] == nums[i+1]) continue;
            int k = length-1;
            for (int j = i+1; j < length-1; ++j) {
//                if (nums[j] == nums[j+1] && j+1 < k) continue;
//                while (nums[k] == nums[k-1] && j+1 < k) k--;
                while (nums[i] + nums[j] + nums[k] > 0 && j+1 < k) k--;
                if (j >= k) break;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    // find it
                    List res = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(res);
                    result.add(res);
                }
            }
        }
        return new ArrayList(result);
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0, 0, 0};
//        int[] nums = {1, 1, -2};
        int[] nums = {0, 1, 1};
        LeetCode_ThreeNumbers solution = new LeetCode_ThreeNumbers();
        System.out.println(solution.solve(nums));
    }
}
