package springLearning.aop.order;

import test.User;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:08
 */

public interface UserService {
    User createUser(String name, int age);
    User queryUser();
}
