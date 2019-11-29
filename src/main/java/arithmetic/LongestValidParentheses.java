package arithmetic;

import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/longest-valid-parentheses/
 *
 * @author Cao.Zhuang
 * @date 2019/11/18 11:57
 */

public class LongestValidParentheses {

    public static void main(String[] args) {
//        System.err.println(longestValidParentheses("(())(()"));
//        System.err.println(longestValidParenthesesDp("(())(()"));
        System.err.println(longestValidParentheses2("(())(()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public static int longestValidParentheses2(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                System.err.println(s.substring(i, j));
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    left = j;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    /**
     * dp[i] represents number of valid parentheses matches from S[j to i] (j<i) dp[i] = V[i-1] + 2 + previous matches
     * V[i- (V[i-1] + 2) ] if S[i] = ')' and '(' count > 0
     */
    public static int longestValidParenthesesDp(String s) {
        int[] dp = new int[s.length()];
        int open = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            if (s.charAt(i) == ')' && open > 0) {
                // matches found
                dp[i] = 2 + dp[i - 1];
                // add matches from previous
                if (i - dp[i] > 0) {
                    //Consider the case "((()))". When i == 5, V[i] is 6. i - V[i] won't always be non-negative.
                    dp[i] += dp[i - dp[i]];
                }
                open--;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}