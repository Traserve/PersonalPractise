package thread;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/27 10:11
 */

public class OddEvenPrinter {

    private final Object monitor = new Object();
    private final int limit;
    private volatile int count;

    public OddEvenPrinter(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }

    public void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.err.println(1.0 / 0.0);
        OddEvenPrinter printer = new OddEvenPrinter(10, 0);
        Thread thread1 = new Thread(printer::print, "thread-1");
        Thread thread2 = new Thread(printer::print, "thread-2");
        thread1.start();
        thread2.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
