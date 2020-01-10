package springLearning.aop.onlineShop;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/9 17:06
 */

public class TeaOnlineShop implements OnlineShop {

    @Override
    public void sellSomething(double money) {
        System.err.println("shop say    :you give me "+money +"$ and I sell you some tea");
    }
}
