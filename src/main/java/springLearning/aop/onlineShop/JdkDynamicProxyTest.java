package springLearning.aop.onlineShop;

import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/9 17:10
 */

public class JdkDynamicProxyTest {

    @Test
    public void test() {
        //被代理的对象
        TeaOnlineShop teaShop = new TeaOnlineShop();
        OnlineShop shop = (OnlineShop) Proxy
                .newProxyInstance(OnlineShop.class.getClassLoader(), new Class[]{OnlineShop.class},
                        new TaobaoProxy(teaShop));
        shop.sellSomething(20D);
    }
}
