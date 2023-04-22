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
//        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(lengthOfLongestSubstring2("pwwkew"));
//        System.out.println(lengthOfLongestSubstring2("a"));
//        System.out.println(lengthOfLongestSubstring2(" "));
//        System.out.println(lengthOfLongestSubstring2("au"));
//        System.out.println(lengthOfLongestSubstring2("abba"));
//        System.out.println(lengthOfLongestSubstring2("dvdf"));
//        System.out.println(lengthOfLongestSubstring4("fccefg"));
//        System.out.println(lengthOfLongestSubstring4("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring4("aab"));
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();


        return 0;
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
            Map<Character, Integer> map = new HashMap<>();
            int n = i;
            //向右开始遍历
            while (n < s.length()) {
                char c = s.charAt(n);
                //判断是否有重复字符
                if (map.containsKey(c)) {
                    break;
                }
                map.put(c, n);
                n++;
            }
            //保存最大子串长度
            maxLen = Math.max(maxLen, n - i);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int n = i;
            int startNext = i;
            //向右开始遍历
            while (n < s.length()) {
                char c = s.charAt(n);
                //判断是否有重复字符
                if (map.containsKey(c)) {
                    startNext = map.get(c);
                    break;
                }
                map.put(c, n);
                n++;
            }
            //保存最大子串长度
            maxLen = Math.max(maxLen, n - i);
            //扫描到最后确定无重复字符，后续无需再进行扫描
            if(startNext == i && n == s.length()){
                break;
            }
            i = startNext;
        }
        return maxLen;
    }

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
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
