package test;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName SubListTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/7/22 14:16
 */

public class SubListTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayListWithCapacity(100);
        for (int i = 0; i < 102; i++) {
            list.add(i);
        }
        List<List<Integer>> listList = splitList(list, 20);
//        List<List<Integer>> listList = splitList2(list, 20);

        listList.forEach(s -> System.err.println(s.get(0) + " " + s.get(s.size() - 1)));
    }

    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {

        if (list == null || list.isEmpty() || len < 1) {
            return Collections.emptyList();
        }

        List<List<T>> result = new ArrayList<>();

        int size = list.size();
        int count = (size + len - 1) / len;

        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }

        return result;
    }

    public static <T> List<List<T>> splitList2(List<T> list, int len) {

        if (list == null || list.isEmpty() || len < 1) {
            return Collections.emptyList();
        }

        List<List<T>> result = new ArrayList<>();

        int size = list.size();

        for (int i = 0; i < list.size(); ) {
            int n = Math.min(len, size);
            List<T> subList = list.subList(i, i + n);
            i += n;
            result.add(subList);
        }

        return result;
    }
}
