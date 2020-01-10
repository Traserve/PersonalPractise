package springLearning.aop.order;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:20
 */

public class LogResultAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.err.println("方法返回: " + returnValue);
    }
}
