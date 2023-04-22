package test;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/12 03:11
 */

public class LC198_Rob {

    public static void main(String[] args) {
        rob(new int[]{2, 7, 9, 3, 1});
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        for (int i = 0; i <= nums.length; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[nums.length];
    }
}
