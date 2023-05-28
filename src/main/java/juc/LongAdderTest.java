package juc;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: Martin
 * @date: 2023/5/11 18:09
 * Description:
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.add(5);
        System.out.println(longAdder.longValue()); // 6

        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 2);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.longValue()); // 6


    }
}
