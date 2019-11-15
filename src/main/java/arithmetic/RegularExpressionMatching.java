package arithmetic;

/**
 * Description: https://leetcode.com/problems/regular-expression-matching/
 *
 * @author Cao.Zhuang
 * @date 2019/11/15 16:37
 */

public class RegularExpressionMatching {

    public static void main(String[] args) {
//        System.err.println(isMatch("mississippi", "mis*is*ip*.")); // true
//        System.err.println(isMatch("aab", "c*a*b")); // true
//        System.err.println(isMatch("abcd","d*")); //false
//        System.err.println(isMatch("aa", "a*a"));//true
//        System.err.println(isMatch("aa", "a*b"));//false
//        System.err.println(isMatch("aaa", "a*aa"));//true
//        System.err.println(isMatch("aa", "a*"));//true
//        System.err.println(isMatch("aa", "aaa"));//false
//        System.err.println(isMatch("aaa","ab*a"));//false
//        System.err.println(isMatch("abc",".*"));//true
        System.err.println(isMatch("aaa","ab*ac*a"));//true
    }

    public static boolean isMatch(String s, String p) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.err.print(i + " " + j + "\n");
//            char a = s.charAt(i);
//            char b = p.charAt(j);
//            char c;
//            char d;
//            System.err.print("a:[" + a + "] b:[" + b + "] ");
//            if (j - 1 >= 0) {
//                c = p.charAt(j - 1);
//                System.err.print("c:[" + c + "] ");
//            }
//            if (j + 1 < p.length()) {
//                d = p.charAt(j + 1);
//                System.err.print("d:[" + d + "] ");
//            }
//            System.err.print("\n");
            if (j >= p.length()) {
                return false;
            }
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                j++;
                continue;
            }
            if (p.charAt(j) == '*') {
                if (j == 0) {
                    return false;
                } else {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        continue;
                    }
                }
                if (j + 1 < p.length()) {
                    if (p.charAt(j + 1) == s.charAt(i) || p.charAt(j + 1) == '.') {
                        j += 2;
                        continue;
                    }
                }
                return false;
            }
            if(j == 0){
                while (j + 1 < p.length() && p.charAt(j + 1) != s.charAt(i)) {
                    j++;
                }
                if (j == p.length()) {
                    return false;
                } else {
                    j++;
                    continue;
                }
            }
            return false;
        }
        if (j < p.length()) {
            if (p.charAt(j) == '*') {
                if (s.length() - (p.length() - j) < 0) {
                    return false;
                }
                System.err.println(s.substring(s.length() - (p.length() - j) + 1));
                System.err.println(p.substring(j + 1));
                if (!s.substring(s.length() - (p.length() - j) + 1).endsWith(p.substring(j + 1))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
