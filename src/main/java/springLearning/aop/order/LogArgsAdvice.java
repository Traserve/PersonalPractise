package springLearning.aop.order;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:18
 */

public class LogArgsAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.err.println("准备执行方法: " + method.getName() + ", 参数列表: " + Arrays.asList(args));
    }
}
