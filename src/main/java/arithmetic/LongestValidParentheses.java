package arithmetic;

import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * @author Cao.Zhuang
 * @date 2019/11/18 11:57
 */

public class LongestValidParentheses {

    public static void main(String[] args) {
//        System.err.println(longestValidParentheses("(())(()"));
//        System.err.println(longestValidParenthesesDp("(())(()"));
//        System.err.println(longestValidParenthesesDp2("(())(()"));
        System.err.println(longestValidParentheses2("(())(()"));
    }

    /**
     * 堆栈处理
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }
        return max;
    }

    /**
     * 两种情况：只检测右括号的前一位，()或))
     * if: s[i]==')' && s[i-1]=='('
     * then: dp[i] = dp[i-2] + 2
     *
     * if: s[i]==')' && s[i-1]==')'
     * 判断内括号是否成立 if: s[i-1-dp[i-1]] == '('  then: dp[i] = dp[i-2-dp[i-1]] + dp[i-1] + 2
     *
     * 补充： it is no need to consider the condition "s[i-1] == '('"
     * since "s[i-longest[i-1]-1] == '('" actually concludes this case.
     * We could just use "if (i-1>=0 && i-longest[i-1]-1 >=0 && s[i-longest[i-1]-1] == '(')"
     * @param s
     * @return
     */
    public static int longestValidParenthesesDp(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                } else {
                    int subLeft = i - 1 - dp[i];
                    if (subLeft >= 0 && s.charAt(subLeft) == '(') {
                        dp[i + 1] = dp[i - 1 - dp[i]] + dp[i] + 2;
                    }
                }
                max = Math.max(max, dp[i + 1]);
            }
        }
        return max;
    }

    /**
     * 结合堆栈和上面dp两种思路的解法
     */
    public static int longestValidParenthesesDp2(String s) {
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

    /**
     * 仅使用两个变量来存储
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}