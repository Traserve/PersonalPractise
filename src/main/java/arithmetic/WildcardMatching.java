package arithmetic;

/**
 * Description:Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * @author Cao.Zhuang
 * @date 2019/12/4 9:56
 */

public class WildcardMatching {

    public static void main(String[] args){
        System.err.println(isMatch("adceb", "*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }

        //打印数组
        System.err.print("    ");
        for (int i = 0; i < p.length(); i++) {
            System.err.print(p.charAt(i) + " ");
        }
        System.err.print("\n");
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                System.err.print("  ");
            } else {
                System.err.print(s.charAt(i - 1) + " ");
            }
            for (int j = 0; j < dp[0].length; j++) {
                System.err.print(dp[i][j] ? "T" : "F");
                System.err.print(" ");
            }
            System.err.print("\n");
        }
        return dp[s.length()][p.length()];
    }
}
