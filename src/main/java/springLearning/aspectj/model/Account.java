package springLearning.aspectj.model;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/13 16:36
 */

public class Account {

    public int balance = 20;

    public boolean pay(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
