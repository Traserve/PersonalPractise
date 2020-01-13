package springLearning.aop.order;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 14:36
 */

@Aspect
public class LogArgsAspect {

    @Before("springLearning.aop.order.SystemArchitecture.businessService()")
    public void logArgs(JoinPoint joinPoint){
        System.err.println("Aspect 方法执行前，打印入参: " + Arrays.toString(joinPoint.getArgs()) + "   " + joinPoint.getSignature());
    }
}
