package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Martin
 * @date 2020/2/11 21:29
 */

public class TestMain {

    //声明缓存对象
    private static final Map map = new HashMap();

    public static void main(String args[]) {
        try {
            Thread.sleep(10000);//给打开visualvm时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //循环添加对象到缓存
        for (int i = 0; i < 4000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("qqqq");
    }

}

class TestMemory {
    public String name = "huangzs";
    public String address = "huangzs_jiujiangshi_jiangxisheng";
}
