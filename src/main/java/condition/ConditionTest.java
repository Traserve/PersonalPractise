package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/7/10 10:38
 */

public class ConditionTest {

    private static volatile int condition = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition lockCondition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("--1-- " + condition);
                lock.lock();
                try {
                    System.err.println("--2-- " + condition);
                    while (!(condition == 1)) {
                        lockCondition.await();
                        System.err.println("--3-- " + condition);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                System.out.println("a executed by condition");
            }
        });
        A.start();
        Thread.sleep(2000);
        condition = 1;
        lock.lock();
        try {
            lockCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
