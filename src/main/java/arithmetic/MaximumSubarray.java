package arithmetic;

/**
 * Description:Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * @author Cao.Zhuang
 * @date 2019/12/4 11:52
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.err.println(maxSubArray2(nums));
    }

    /**
     * 暴力枚举
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;
            int curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum = nums[j] + preSum;
                preSum = curSum;
                max = Math.max(max, curSum);
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int curMax = max;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            max = Math.max(max, curMax);
        }
        return max;
    }

}
