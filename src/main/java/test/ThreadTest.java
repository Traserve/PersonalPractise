package test;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/12/24 11:09
 */

public class ThreadTest {

    private static int num = 0;

    private static void addNum(){
        num++;
        System.out.println(num);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(ThreadTest::addNum);
        Thread thread2 = new Thread(ThreadTest::addNum);
        for (int i = 0; i < 10; i++) {
            thread1.start();
        }
    }
}
