package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import test.User;

/**
 * @ClassName FixedThreadPool
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/8/30 12:00
 */

public class FixedThreadPool {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        final FixedThreadPool fixedThreadPool = new FixedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int j = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    fixedThreadPool.test(user, j);
                }
            });
        }
        executorService.shutdown();
        System.err.println("结束" + (System.currentTimeMillis() - start));
    }

    private void test(User user, int j) {
        lock.lock();
        try {
            System.out.println("name: " + Thread.currentThread().getName());
            user.setAge(j);
            Thread.sleep(1000);
            System.out.println("test " + j + " user " + user.getAge());
            if (j == 3) {
                throw new IllegalArgumentException("ahahah");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
