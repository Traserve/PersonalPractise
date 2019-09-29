package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName NioTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/28 11:54
 */

public class StreamTest {

    public static void main(String[] args) {
        Apple a1 = new Apple("a1", 10, "aaa");
        Apple a2 = new Apple("a2", 15, "bbb");
        List<Apple> appleList = new ArrayList<>();
        appleList.add(a1);
        appleList.add(a2);
        List<Apple> appleList2 = appleList.stream().filter(s -> "a3".equals(s.getName())).collect(Collectors.toList());
        Integer sum = appleList.stream().mapToInt(Apple::getSize).sum();
        Integer sum2 = appleList2.stream().mapToInt(Apple::getSize).sum();
        System.err.println(sum);
        System.err.println(sum2);
    }
}
