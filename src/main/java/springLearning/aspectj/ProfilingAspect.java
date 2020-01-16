package springLearning.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 16:47
 */

@Aspect
public class ProfilingAspect {

    @Pointcut("execution(* springLearning.aspectj.model.*.*(..))")
    public void modelLayer(){

    }

    @Around("modelLayer()")
    public Object logProfile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.err.println("[ProfilingAspect]方法: 【" + joinPoint.getSignature() + "】结束，用时: " + (System.currentTimeMillis() - start));
        return result;
    }
}
