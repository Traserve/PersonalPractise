package arithmetic;

/**
 * @ClassName PartitionEqualSubsetSum
 * @Description 相同子集和分割
 * @Author Cao.Zhuang
 * @Date 2019/10/16 17:44
 */

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such
 * that the sum of elements in both subsets is equal. Note: Both the array size and each of the array element will not
 * exceed 100.
 *
 * Example 1: Input: [1, 5, 11, 5] Output: true Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2: Input: [1, 2, 3, 5] Output: false Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
    }

    private static Boolean partition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int halfSum = sum / 2;
        if (halfSum * 2 < sum) {
            return false;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

            }
        }
        return false;
    }
}
