package springLearning.aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 15:13
 */

@Aspect
public class SystemArchitecture {

    @Pointcut("within(springLearning.aop.order.web..*)")
    public void inWebLayer(){

    }

    @Pointcut("within(springLearning.aop.order.service..*)")
    public void inServiceLayer(){

    }

    @Pointcut("within(springLearning.aop.order.dao..*)")
    public void inDataAccessLayer(){

    }

    @Pointcut("execution(* springLearning.aop.order.service.*.*(..))")
    public void businessService(){}

    @Pointcut("execution(* springLearning.aop.order.dao.*.*(..))")
    public void dataAccessOperation(){}

}
