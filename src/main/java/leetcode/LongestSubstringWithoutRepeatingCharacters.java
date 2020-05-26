package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Martin
 * @date 2020/3/27 16:47
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println(lengthOfLongestSubstring2("au"));
        System.out.println(lengthOfLongestSubstring2("abba"));
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }

    /**
     * 暴力检测
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            //以当前字符作为子串首字符
            char start = s.charAt(i);
            //逐渐延长子串直到重复字符出现
            Map<Character, Integer> map = new HashMap<>();
            map.put(start, i);
            int n = i + 1;
            while (n < s.length()) {
                char next = s.charAt(n);
                //判断是否有重复字符
                if (map.containsKey(next)) {
                    break;
                }
                map.put(next, n);
                n++;
            }
            //保存最大子串长度
            maxLen = Math.max(maxLen, n - i);
        }
        return maxLen;
    }

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}
