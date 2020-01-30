package arithmetic.nowcoder;

/**
 * Description:
 *
 * 链接：https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4?orderByHotValue=1&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 *
 * @author Martin
 * @date 2020/1/30 17:01
 */

public class Parenthesis {

    public static void main(String[] args) {
        String A = "()(()()";
        System.out.println(chkParenthesis(A, A.length()));

        String B = "()(()())";
        System.out.println(chkParenthesis(B, B.length()));
    }

    public static boolean chkParenthesis(String A, int n) {
        //左括号数
        int l = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return l == 0;
    }
}
