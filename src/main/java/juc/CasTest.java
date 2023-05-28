package juc;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Martin
 * @date: 2023/5/11 17:38
 * Description:
 */
public class CasTest implements Serializable {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 10));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 100));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.get());

        AtomicReference atomicReference = new AtomicReference();
    }
}
