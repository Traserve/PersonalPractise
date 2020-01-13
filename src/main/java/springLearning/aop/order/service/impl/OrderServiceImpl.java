package springLearning.aop.order.service.impl;

import springLearning.aop.order.service.OrderService;
import test.Order;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:16
 */

public class OrderServiceImpl implements OrderService {

    private static Order order = null;

    @Override
    public Order createOrder(String userName, String product) {
        order = new Order();
        order.setUserName(userName).setProduct(product);
        return order;
    }

    @Override
    public Order queryOrder(String userName) {
        return order;
    }
}
