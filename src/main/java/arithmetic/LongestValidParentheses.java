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
        System.err.println(longestValidParentheses("(())(()"));
        System.err.println(longestValidParenthesesDp("(())(()"));
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