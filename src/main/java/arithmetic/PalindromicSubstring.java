package arithmetic;

import static java.lang.Math.min;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName PalindromicSubstring
 * @Description 回文串问题
 * @Author Cao.Zhuang
 * @Date 2019/10/14 17:13
 */

public class PalindromicSubstring {

    public static void main(String[] args) {
        System.err.println(longestPalindrome("abccba"));
        System.err.println(manacher("abccba"));
    }

    /**
     * 动态规划：利用dp数组即可轻松求解
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //保存最长回文子串长度
        int maxlen = 1;
        //保存最长回文子串起点
        int start = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i - j < 2) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[j][i] = (s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1]);
                }

                if (dp[j][i] && maxlen < i - j + 1) {
                    maxlen = i - j + 1;
                    start = j;
                }
//                System.err.print(dp[j][i] + " ");
            }
//            System.err.print("\n");
        }
        System.err.println("start: " + start + "  maxlen: " + maxlen);
        return (StringUtils.substring(s, start, start + maxlen));
    }

    /**
     * 马拉车算法 https://www.cnblogs.com/grandyang/p/4475985.html
     * @param s
     * @return
     */
    private static String manacher(String s) {
        // Insert '#'
        StringBuilder t = new StringBuilder();
        t.append("$#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i)).append("#");
        }
        t.append('@');
        int[] p = new int[t.length()];
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
        // id 为能延伸到最右端的位置的那个回文子串的中心点位置，mx 是回文串能延伸到的最右端的位置
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length() - 1; ++i) {

        }
        return StringUtils.substring(s, (resCenter - resLen) / 2, resLen - 1 + (resCenter - resLen) / 2);
    }
}
