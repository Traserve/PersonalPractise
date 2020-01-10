package springLearning.aop.onlineShop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/9 17:07
 */

public class TaobaoProxy implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object proxied;

    public TaobaoProxy(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("taobao say:    "+args[0]+"$ money temp save to taobao to increase my gmv");
        return method.invoke(proxied, args);
    }
}
