package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Martin
 * @date: 2023/5/25 23:44
 * Description:
 */
public class Test {

    public static Integer Test() {
        return 1;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/e605ba77112b425889bee3f40481fe93?orderByHotValue=1&page=1&onlyReference=false
     * 来源：牛客网
     * <p>
     * 输入一个正整数的字符串，输出与它最接近的对称数字(不包括它自己)的字符串
     * <p>
     * 注1: 输入字符串的长度最多不会超过18
     * 注2: 当大于输入数字和小于输入数字的对称数字与输入数字距离相同时，取小的数字作为答案
     * <p>
     * 输入: 123
     * 输出: 121
     *
     * @param args
     */

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String num = scanner.next();
//        System.out.println(findSymmetricNum(num));
        System.out.println(findSymmetricNum("1291"));
        System.out.println(findSymmetricNum("129"));
        System.out.println(findSymmetricNum("777"));
        System.out.println(findSymmetricNum("1"));
    }

    /**
     * 长度为1，直接减一返回
     * 开头为 1，9~~9为一个候选答案 例：100001，答案为99999
     * 开头为9，10~~01为一个候选答案 例：99999，答案为100001
     * 如果本身对称，则把最中间的一个（或两个）位数减（如果0则加）一
     * 例：123321，答案为122221
     * 例：120021，答案为121121
     * 如果不对称：
     * -把前半部分逆序替换掉后半部分 例：1223，答案为1221
     * -把最中间的一个（或两个）位数加一 例：1291，答案为1331，而非1221
     * -把最中间的一个（或两个）位数减一 例：1800，答案为1771，而非1881
     *
     * @param num
     * @return
     */
    public static String findSymmetricNum(String num) {
        int len = num.length();
        if (len == 1) {
            return num;
        }
        int mid;
        char midChar;
        String pre = null;
        List<Integer> candidates = new ArrayList<>();
        StringBuilder half;
        if (len % 2 == 0) {
            mid = len / 2 - 1;
            pre = num.substring(0, mid);
            midChar = num.charAt(mid);
            // 直接镜像
            half = new StringBuilder(pre + midChar);
            candidates.add(Integer.valueOf(half.toString() + half.reverse()));
            // +1 再镜像
            midChar++;
            half = new StringBuilder(pre + midChar);
            candidates.add(Integer.valueOf(half.toString() + half.reverse()));
            // -1 再镜像
            midChar -= 2;
            half = new StringBuilder(pre + midChar);
            candidates.add(Integer.valueOf(half.toString() + half.reverse()));
        } else {
            mid = len / 2;
            pre = num.substring(0, mid);
            midChar = num.charAt(mid);
            // 直接镜像
            half = new StringBuilder(pre);
            candidates.add(Integer.valueOf(half.toString() + midChar + half.reverse()));
            // +1 再镜像
            midChar++;
            candidates.add(Integer.valueOf(half.toString() + midChar + half.reverse()));
            // -1 再镜像
            midChar -= 2;
            candidates.add(Integer.valueOf(half.toString() + midChar + half.reverse()));
        }

        return compare(Integer.parseInt(num), candidates);
    }

    public static String compare(Integer num, List<Integer> candidates) {
        int candidate = 0;
        int gap = Integer.MAX_VALUE;
        for (Integer i : candidates) {
            if (Math.abs(i - num) < gap) {
                candidate = i;
                gap = Math.abs(i - num);
            } else if (Math.abs(i - num) == gap && i < candidate) {
                candidate = i;
            }
        }
        return String.valueOf(candidate);
    }

    public boolean checkSymmetric(String num) {
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
