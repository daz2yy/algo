import java.util.Arrays;

/**
 * Accept，5分钟，https://leetcode-cn.com/problems/majority-element/
 * 找规律题
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
//        int len = nums.length/2;
//        if (nums[len] == nums[len-1]) return nums
        return nums[(int)nums.length/2];
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
