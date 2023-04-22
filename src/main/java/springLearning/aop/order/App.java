package springLearning.aop.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springLearning.aop.order.service.UserService;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/24 11:35
 */

public class App {

    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application2.xml");
//        UserService userService = (UserService) context.getBean("userServiceProxy");

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_aspectj.xml");
        UserService userService = context.getBean(UserService.class);

        userService.createUser("Tom", 55);
        userService.queryUser();
    }

}
