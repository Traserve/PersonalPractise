package springLearning.aop.order.service;

import test.Order;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/10 14:13
 */

public interface OrderService {

    Order createOrder(String userName, String product);

    Order queryOrder(String userName);
}
