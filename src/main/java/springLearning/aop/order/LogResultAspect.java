package springLearning.aop.order;

import org.aspectj.lang.annotation.AfterReturning;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 15:43
 */

public class LogResultAspect {

    @AfterReturning(pointcut = "springLearning.aop.order.SystemArchitecture.businessService()", returning = "result")
    public void logResult(Object result){
        System.err.println(result);
    }
}
