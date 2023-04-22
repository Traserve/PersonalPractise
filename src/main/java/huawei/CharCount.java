package huawei;

import java.util.*;

/**
 * Description:给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，
 * 并按照字母出现次数从大到小排序输出各个字母及其出现的次数信息，如果次数相同，按照自然顺序进行排序
 *
 * 思路：1.以字母作为key出现次数作为val构造两个TreeMap
 *
 * @author Martin
 * @date 2020/1/30 19:08
 */

public class CharCount {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(countChar(scanner.next()));

        System.out.println(countChar("basgamfbAABMSC"));
//        System.out.println((int)'a');
//        System.out.println((int)'b');
//        System.out.println((int)'A');
//        System.out.println(countChar("BefshdCgacbkA"));
        System.out.println(countChar("abAcBD"));
    }

    public static String countChar(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        Map<Character, Integer> upperMap = new TreeMap<>();
        Map<Character, Integer> lowerMap = new TreeMap<>();
        System.out.println("A: " + (int) 'A');
        System.out.println("a: " + (int) 'a');
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= 'Z') {
                int cnt = upperMap.getOrDefault(ch, 0);
                upperMap.put(ch, cnt + 1);
            } else {
                int cnt = lowerMap.getOrDefault(ch, 0);
                lowerMap.put(ch, cnt + 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : upperMap.entrySet()){
            builder.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        for(Map.Entry<Character, Integer> entry : lowerMap.entrySet()){
            builder.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        return builder.toString();
    }
}
