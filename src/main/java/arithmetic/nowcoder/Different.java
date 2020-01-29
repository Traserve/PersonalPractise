package arithmetic.nowcoder;

/**
 * @Author: Martin
 * @Date: 2020/1/29 14:18
 * @Description:
 *
 * 链接：https://www.nowcoder.com/questionTerminal/9618c2a9e8a14c3e82954ee14168f592?orderByHotValue=1&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 *
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 */
public class Different {

    public static void main(String[] args) {
        System.out.println(checkDifferent("aeiou"));
        System.out.println(checkDifferent("BarackObama"));
    }

    public static boolean checkDifferent(String iniString) {
        return false;
    }

    private static void partition(String str, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }


    }

}
