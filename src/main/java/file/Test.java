package file;

import org.springframework.util.StringUtils;

/**
 * @author: Martin
 * @date: 2023/5/27 23:57
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        String str = "[147. 对链表进行插入排序](algorithm/147. 对链表进行插入排序.md)\n" +
                "[88. 合并两个有序数组](algorithm/88. 合并两个有序数组.md)\n" +
                "\n" +
                "[148. 排序链表](algorithm/148. 排序链表.md)";
        String[] arr = str.split("\n");
        for (String s : arr) {
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            String s1 = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
            String s2 = s.substring(s.indexOf("](") + 2, s.indexOf(".md"));
            System.out.println("- title: " + s1);
            System.out.println("  url: /" + s2.replaceAll(" ", "-") + "/");
        }
    }

}
