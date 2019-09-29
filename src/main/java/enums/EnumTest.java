package enums;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName EnumTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/9/3 17:57
 */

public class EnumTest {

    public static void main(String[] args) {
        List<ConfigureStatusEnum> a = Arrays.asList(ConfigureStatusEnum.values());
        System.err.println(a.get(0).getKey());
    }
}
