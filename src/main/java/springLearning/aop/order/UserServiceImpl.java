package springLearning.aop.order;

import test.User;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:09
 */

public class UserServiceImpl implements UserService {
    private static User user = null;

    @Override
    public User createUser(String name, int age) {
        user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @Override
    public User queryUser() {
        return user;
    }
}
