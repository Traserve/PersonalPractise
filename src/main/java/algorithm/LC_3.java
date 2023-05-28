package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Martin
 * @date: 2023/5/25 22:43
 * Description: 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                dp[right] = right == 0 ? 1 : dp[right - 1] + 1;
            } else {
                while (s.charAt(left) != ch) {
                    set.remove(s.charAt(left));
                    left++;
                }
                dp[right] = right - left;
                left++;
            }
            max = Math.max(max, dp[right]);
            right++;
        }
        System.out.println(JSON.toJSONString(dp));
        return max;
    }

}
