package arithmetic;

import java.util.HashSet;

/**
 * Description: https://www.geeksforgeeks.org/find-distinct-subset-subsequence-sums-array/
 *
 * Find all distinct subset (or subsequence) sums of an array
 * Given a set of integers, find distinct sum that can be generated from the subsets of the given sets and print them in an increasing order. It is given that sum of array elements is small.
 *
 * Examples:
 *
 * Input  : arr[] = {1, 2, 3}
 * Output : 0 1 2 3 4 5 6
 * Distinct subsets of given set are {}, {1}, {2}, {3}, {1,2}, {2,3}, {1,3} and {1,2,3}.
 * Sums of these subsets are 0, 1, 2, 3, 3, 5, 4, 6
 * After removing duplicates, we get 0, 1, 2, 3, 4, 5, 6
 *
 * Input : arr[] = {2, 3, 4, 5, 6}
 * Output : 0 2 3 4 5 6 7 8 9 10 11 12
 *          13 14 15 16 17 18 20
 *
 * Input : arr[] = {20, 30, 50}
 * Output : 0 20 30 50 70 80 100
 *
 * @author Cao.Zhuang
 * @date 2019/12/13 10:30
 */

public class DistSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        int n = arr.length;
        printDistSum(arr, n);
    }

    private static void printDistSum(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        distSumRec(arr, n, 0, 0, set);

        // Print the result
        for (int i : set) {
            System.out.print(i + " ");
        }
    }

    /**
     * 递归
     * @param arr
     * @param n
     * @param sum
     * @param currindex
     * @param set
     */
    private static void distSumRec(int[] arr, int n, int sum,
            int currindex, HashSet<Integer> set) {
        if (currindex > n) {
            return;
        }

        if (currindex == n) {
            set.add(sum);
            return;
        }

        distSumRec(arr, n, sum + arr[currindex],
                currindex + 1, set);
        distSumRec(arr, n, sum, currindex + 1, set);
    }

    /**
     * 动态规划
     * @param arr
     * @param n
     */
    private static void printDistSumDp(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // dp[i][j] would be true if arr[0..i-1]
        // has a subset with sum equal to j.
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // There is always a subset with 0 sum
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill dp[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            dp[i][arr[i - 1]] = true;
            for (int j = 1; j <= sum; j++) {
                // Sums that were achievable
                // without current array element
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + arr[i - 1]] = true;
                }
            }
        }

        // Print last row elements
        for (int j = 0; j <= sum; j++) {
            if (dp[n][j]) {
                System.out.print(j + " ");
            }
        }
    }
}
