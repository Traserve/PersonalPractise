package arithmetic;

/**
 * Description: https://leetcode.com/problems/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @author Cao.Zhuang
 * @date 2019/12/5 16:00
 */

public class EditDistance {

    public static void main(String[] args) {
        System.err.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 1; i < p.length() + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //insert，delete，replace
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
