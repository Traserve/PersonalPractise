package huawei;

import java.util.*;

/**
 * Description:输入一个字符串，区分大小写，按自然顺序打印每个字母出现顺序
 *
 * 思路：1.以字母作为key出现次数作为val构造一个map
 * 2.新建两个链表，一个只存小写字母，一个只存大写字母，并分别进行排序，最后利用归并算法的思路进行输出
 *
 * @author Martin
 * @date 2020/1/30 19:08
 */

public class Huawei {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countChar(scanner.next()));

        System.out.println(countChar("efshdgeacbbk"));
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
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        LinkedList<Character> list = new LinkedList<>();
        boolean minFlag = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (list.isEmpty()) {
                list.add(key);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (val > map.get(list.get(i))) {
                        list.add(i, key);
                        minFlag = false;
                        break;
                    } else if (val == map.get(list.get(i))) {
                        int j = i;
                        while (j < list.size() && val == map.get(list.get(j)) && key > list.get(j)){
                            j++;
                        }
                        list.add(j, key);
                        minFlag = false;
                        break;
                    }
                }
                if (minFlag) {
                    list.add(key);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(":").append(map.get(list.get(i))).append(";");
        }
        return sb.toString();
    }
}
