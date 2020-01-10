package springLearning.aop.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/24 11:35
 */

public class App {

    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.createUser("Tom", 55);
        userService.queryUser();
    }

}
