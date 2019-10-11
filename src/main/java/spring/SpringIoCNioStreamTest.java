package spring;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCNioStreamTest {

    @Test
    public void test1() {

        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        SayService sayService = (SayService) applicationContext.getBean("test");
        sayService.say();
    }

}