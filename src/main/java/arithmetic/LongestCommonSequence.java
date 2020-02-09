package arithmetic;

/**
 * @ClassName LongestSequence
 * @Description 最长公共子序列
 * *****************************************************************
 * 输入: str1 = "babcde", str2 =
 * "ace" 输出: 3 解释: 最长公共子序列是 "ace"，它的长度是 3
 * *****************************************************************
 * @Author Cao.Zhuang
 * @Date 2019/9/26 9:34
 */

public class LongestCommonSequence {

    private static String str1 = "babcde";
    private static String str2 = "ace";

    public static void main(String[] args) {
        int[][] dp = new int[str2.length()][str1.length()];
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                dp[i][j] = 0;
            }
        }
//        System.err.println(longestLen(str1, str2, dp));
        System.err.println(longestLen(str1.length() - 1, str2.length() - 1));
    }

    /**
     * 递归
     * 用两个指针i和j从后往前遍历s1和s2，如果s1[i]==s2[j]，那么这个字符一定在lcs中；否则的话，s1[i]和s2[j]这两个字符至少有一个不在lcs中，需要丢弃一个
     */
    private static int longestLen(int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return longestLen(i - 1, j - 1) + 1;
        } else {
            return Math.max(longestLen(i - 1, j), longestLen(i, j - 1));
        }
    }


    /**
     * dp数组暴力枚举
     */
    private static int longestLen(String str1, String str2, int[][] dp) {
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == str2.charAt(i)) {
                    dp[i][j] = (i == 0 ? 1 : dp[i - 1][j] + 1);
                } else {
                    int preColumn = (j == 0 ? 0 : dp[i][j - 1]);
                    int preLine = (i == 0 ? 0 : dp[i - 1][j]);
                    dp[i][j] = Math.max(preColumn, preLine);
                }
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                System.err.print(dp[i][j] + " ");
            }
            System.err.print("\n");
        }
        return dp[str2.length() - 1][str1.length() - 1];
    }
}
