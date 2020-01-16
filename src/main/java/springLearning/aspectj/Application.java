package springLearning.aspectj;

import springLearning.aspectj.model.Account;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 17:06
 */

public class Application {

    public static void main(String[] args) {
        testCompileTime();
    }
    public static void testCompileTime() {
        Account account = new Account();
        System.out.println("==================");
        account.pay(10);
        account.pay(50);
        System.out.println("==================");
    }
}
