package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConcurrentMapWithMap
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/12 14:31
 */

public class ConcurrentMapWithMap {

    public static int count = 0;
    private static Map<String, Long> mapWordCounts = new HashMap<>();
    private static ConcurrentMap<String, Long> concurrentMapWordCounts = new ConcurrentHashMap<>();

    public static long mapIncrease(String word) {
        Lock lock = new ReentrantLock();
        Long oldValue = mapWordCounts.get(word);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        lock.lock();
        try {
            mapWordCounts.put(word, newValue);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return newValue;
    }


    public static long ConcurrentMapIncrease(String word) {
        Long oldValue, newValue;
        while (true) {
            oldValue = concurrentMapWordCounts.get(word);
            if (oldValue == null) {
                newValue = 1L;
                //已经有key了就返回放入的值，否则返回空
                if (concurrentMapWordCounts.putIfAbsent(word, newValue) == null) {
                    break;
                }
            } else {
                newValue = oldValue + 1;
                //值替换，每次替换时都会比较上面拿到oldValue是否就是当前map里面的值，是才替换，否则继续获取
                if (concurrentMapWordCounts.replace(word, oldValue, newValue)) {
                    break;
                }
            }
        }
        return newValue;
    }

    public static void mapWordCount() throws InterruptedException, ExecutionException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.mapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.mapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.mapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.mapIncrease("work");
                }
            }
        }).start();
    }

    public static void concurrentWordCount() throws InterruptedException, ExecutionException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.ConcurrentMapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.ConcurrentMapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.ConcurrentMapIncrease("work");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10000) {
                    ConcurrentMapWithMap.ConcurrentMapIncrease("work");
                }
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ConcurrentMapWithMap.mapWordCount();
        Thread.sleep(10000);
        //多线程累加，每次都少于40000，故线程不安全
        System.out.println("final count map" + ConcurrentMapWithMap.mapWordCounts.get("work"));
        ConcurrentMapWithMap.concurrentWordCount();
        Thread.sleep(10000);
        //多线程累加，每次都是40000
        System.out.println("final count concurrentMap" + ConcurrentMapWithMap.concurrentMapWordCounts.get("work"));
    }

}
