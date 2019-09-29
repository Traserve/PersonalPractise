package arithmetic;

/**
 * @ClassName LongestSequence
 * @Description 输入一串数字，找出最长序列长度
 * @Author Cao.Zhuang
 * @Date 2019/9/26 9:34
 */

public class LongestSequence {

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 3, 9, 10};
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        System.err.println(longestLen(nums, dp));
    }

    private static int longestLen(int[] nums, int[] dp) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 0) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        max = Math.max(max, dp[j] + 1);
                    }
                }
                max = max == 0 ? 1 : max;
                maxLen = Math.max(maxLen, max);
                dp[i] = max;
            }
        }
        for (int i : dp) {
            System.err.print(i + " ");
        }
        System.err.print("\n");
        return maxLen;
    }
}
